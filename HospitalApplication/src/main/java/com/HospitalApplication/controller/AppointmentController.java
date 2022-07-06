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

import com.HospitalApplication.entity.Appointment;
import com.HospitalApplication.service.AppointmentService;
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping
	public ResponseEntity<Appointment> saveAppointment(@Valid @RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(appointmentService.saveAppointment(appointment),HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Appointment> getAppointmentList(){
		return appointmentService.getAppointmentList();
		
	}
	@GetMapping("/{id}")
	public Appointment getAppointmentById(@PathVariable("id") long id) {
		return appointmentService.getAppointmentById(id);
		
	}
	
	@PutMapping("/{id}")
	public Appointment updateAppointment(@Valid @PathVariable("id")long id,@RequestBody Appointment appointment) {
		return appointmentService.updateAppointment(id,appointment);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteAppointment(@PathVariable("id")long id) {
		return appointmentService.deleteAppointment(id);
		
	}
}
