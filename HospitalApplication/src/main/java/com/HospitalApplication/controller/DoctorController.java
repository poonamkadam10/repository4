package com.HospitalApplication.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalApplication.entity.Doctor;
import com.HospitalApplication.service.DoctorService;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor( @Valid @RequestBody Doctor doctor)
	{
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	@GetMapping
	public List<Doctor> getDoctorList()
	{
		return doctorService.getDoctorList();
	}
	
	@GetMapping("/{Id}")
	public Doctor getDoctorById(@PathVariable("Id")long id) {
		return doctorService.getDoctorById(id);
		
	}

	
	@PutMapping("/{Id}")
	public Doctor updateDoctor(@Valid @PathVariable("Id")long id, @RequestBody Doctor doctor) {
		return doctorService.updateDoctor(id, doctor);
		
	}
	
	@DeleteMapping("/{Id}")
	public String deleteDoctor(@PathVariable("Id")long id) {
		return doctorService.deleteDoctor(id);
	}
	
	@GetMapping("/byfname/{firstName}")
	public Doctor getDoctorByFirstName(@PathVariable("firstName") String firstName){
		return doctorService.getDoctorByFirstName(firstName);
		
	}
	
	@GetMapping("/bylname/{lastName}")
	public List<Doctor> getDoctorByLastName(@PathVariable("lastName") String lastName){
		return doctorService.getDoctorByLastName(lastName);
		
	}
	@GetMapping("/byqualification/{qualification}")
	public List<Doctor> getDoctorByQualification(@PathVariable("qualification") String qualification){
		return doctorService.getDoctorByQualification(qualification);
		
	}
	@GetMapping("/bygender/{gender}")
	public List<Doctor> getDoctorByGender(@PathVariable("gender") String gender){
		return doctorService.getDoctorByGender(gender);
		
	}
}
