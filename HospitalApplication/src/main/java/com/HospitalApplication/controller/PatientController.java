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

import com.HospitalApplication.entity.Patient;
import com.HospitalApplication.service.PatientService;



@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	@PostMapping
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient)
	{
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Patient> getPatientList(){
		return patientService.getPatientList();
	}
	
	@GetMapping("/{Id}")
	public Patient getPatientById(@PathVariable("Id")long id) {
		return patientService.getPatientById(id);
		
	}
	
	@PutMapping("/{Id}")
	public Patient updatePatient(@Valid @PathVariable("Id") long id, @RequestBody Patient patient) {
	
		return patientService.updatePatient(id,patient);
	}
	
	@DeleteMapping("/{Id}")
	public String deletePatient(@PathVariable("Id") long id) {
		return patientService.deletePatient(id);
		
	}
	
	@GetMapping("/byfname/{firstName}")
	public Patient getPatientByFirstName(@PathVariable("firstName") String firstName){
		return patientService.getPatientByFirstName(firstName);
		
	}
	
	@GetMapping("/bylname/{lastName}")
	public Patient getPatientByLastName(@PathVariable("lastName") String lastName){
		return patientService.getPatientByLastName(lastName);
		
	}
	@GetMapping("/bygender/{gender}")
	public Patient getPatientByGender(@PathVariable("gender") String gender){
		return patientService.getPatientByGender(gender);
		
	}
	
}
