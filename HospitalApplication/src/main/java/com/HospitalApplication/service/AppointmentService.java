package com.HospitalApplication.service;



import java.util.List;

import com.HospitalApplication.entity.Appointment;


public interface AppointmentService {

	Appointment saveAppointment(Appointment appointment);

	List<Appointment> getAppointmentList();

	Appointment updateAppointment(long id, Appointment appointment);

	String deleteAppointment(long id);

	Appointment getAppointmentById(long id);

	



}
