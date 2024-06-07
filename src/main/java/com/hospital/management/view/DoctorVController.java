package com.hospital.management.view;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.management.model.entity.Doctor;
import com.hospital.management.model.entity.Shift;
import com.hospital.management.model.service.DoctorService;


@Controller
@RequestMapping("/doctor")
public class DoctorVController {
	@Autowired
	DoctorService doctorService;

	@GetMapping("/{doctorId}")
	public String getMethodName(Model model,@PathVariable Long doctorId) {
		
		Doctor doctor = doctorService.findById(doctorId);
		List<Shift> shifts = doctor.getShifts();
		if(shifts!=null) {
			Collections.sort(shifts, new Comparator<Shift>() {

				@Override
				public int compare(Shift o1, Shift o2) {
					int comparator = o1.getDayOfWeek().compareTo(o2.getDayOfWeek());
					if(comparator==0) {
						comparator=o1.getShiftStart().compareTo(o2.getShiftStart());
					if(comparator==0) {
						comparator=o1.getShiftEnd().compareTo(o2.getShiftEnd());
					}
					}
					return comparator;
				}
				
				
			});
		}
		List<Doctor> doctors = doctorService.findAll();
		
		model.addAttribute("doc", doctor);
		model.addAttribute("doctors", doctors);
		
		return "doctor";
		
		
	}
	
	@GetMapping("/{doctorId}/fragment")
	public String getMethodName(@PathVariable Long doctorId,Model model) {
		
		Doctor doctor = doctorService.findById(doctorId);
		List<Shift> shifts = doctor.getShifts();
		if(shifts!=null) {
			Collections.sort(shifts, new Comparator<Shift>() {

				@Override
				public int compare(Shift o1, Shift o2) {
					int comparator = o1.getDayOfWeek().compareTo(o2.getDayOfWeek());
					if(comparator==0) {
						comparator=o1.getShiftStart().compareTo(o2.getShiftStart());
					if(comparator==0) {
						comparator=o1.getShiftEnd().compareTo(o2.getShiftEnd());
					}
					}
					return comparator;
				}
				
				
			});
		}
		List<Doctor> doctors = doctorService.findAll();
		
		model.addAttribute("doc", doctor);
		return "selected-card";
	}
	
	@GetMapping()
	public String getMethodName(Model model) {
		
		List<Doctor> doctors = doctorService.findAll();
		
		model.addAttribute("doctors", doctors);
		
		
		
		return "doctor";
		
		
	}
	
	
	
}
