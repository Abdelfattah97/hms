package com.hospital.management.model.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.Shift;
import com.hospital.management.model.repository.ShiftRepo;

@Service
public class ShiftService implements ServiceInterface<Shift, Long>{

	@Autowired
	ShiftRepo shiftRepo;
	
	@Override
	public List<Shift> findAll() {
		
		return shiftRepo.findAll();
	}
	
	public List<Shift> findByDoctorId(Long doctorId) {
		
		return shiftRepo.findByDoctor_DoctorId(doctorId);
		
	}

	@Override
	public Shift findById(Long id) {
		return shiftRepo.findById(id).orElse(null);
	}
	

	@Override
	public Shift save(Shift shift) {
		if(!isShiftOverLapping(shift)) {
		return shiftRepo.save(shift);
		}else {
			return null;
		}
		
	}

	@Override
	public void deleteById(Long id) {
		shiftRepo.deleteById(id);
	}

	@Override
	public void delete(Shift shift) {
		shiftRepo.delete(shift);
	}
	
	private Boolean isShiftOverLapping(Shift shift) {
		
		if(shift!=null) {
			
		
			if(isCheckable(shift)) {
				
				List<Shift> shifts = shiftRepo.findByDoctor_DoctorIdAndDayOfWeek(shift.getDoctor().getDoctorId(), 
						shift.getDayOfWeek());
				
				shifts.forEach(s->{
					if(isCheckable(s)) {
					LocalTime start_new = shift.getShiftStart();
					LocalTime end_new = shift.getShiftEnd();
					
					LocalTime start_old = s.getShiftStart();
					LocalTime end_old = s.getShiftEnd();
					boolean start_overlap = (start_new.compareTo(start_old)>=0 && start_new.compareTo(end_old)<=0);
					boolean end_overlap = (end_new.compareTo(start_old)>=0 && end_new.compareTo(end_old)<=0);
					
						if(start_overlap||end_overlap ) {
							System.out.println();
							throw new RuntimeException("this shift overlaps another shift on the same day");
							
						}
						
					}
					
				});
				return false;
				
				
				
				
			}else {
				
				throw new RuntimeException("missing shift property can't check overlap");
			}
			
		}else {
			
			throw new RuntimeException("Can't check overlap on a null shift!");
			
		}
		
	}
	
	private Boolean isCheckable(Shift shift) {
		
		return shift!=null&&
				shift.getDayOfWeek()!=null&&
				shift.getDoctor()!=null&&
				shift.getDoctor().getDoctorId()!=null&&
				shift.getShiftStart()!=null&&
				shift.getShiftEnd()!=null;
		
	}

}
