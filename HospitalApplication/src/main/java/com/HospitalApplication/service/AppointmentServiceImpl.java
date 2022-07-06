package com.HospitalApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HospitalApplication.entity.Appointment;
import com.HospitalApplication.exception.GivenIdNotFoundException;
import com.HospitalApplication.exception.NoRecordFoundException;
import com.HospitalApplication.repository.AppointmentRepository;


@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAppointmentList() {
		// TODO Auto-generated method stub
		List <Appointment> appointment= appointmentRepository.findAll();
		if(appointment.isEmpty())
			throw new NoRecordFoundException();
		else
		return appointment;
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) {
		// TODO Auto-generated method stub
		
	 Appointment app=appointmentRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
	 
	 app.setFirstName(appointment.getFirstName());
	 app.setLastName(appointment.getLastName());
	 app.setDeceased(appointment.getDeceased());
	 app.setDoctorName(appointment.getDoctorName());
	 app.setDate(appointment.getDate());
	
	 appointmentRepository.save(app);
		return app;
	}

	@Override
	public String deleteAppointment(long id) {
		// TODO Auto-generated method stub
		
		Appointment appointment=appointmentRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		
		appointmentRepository.deleteById(id);
		return "Appointment Record Deleted Successfully";
	}

	@Override
	public Appointment getAppointmentById(long id) {
		// TODO Auto-generated method stub
		
		Optional<Appointment> app = appointmentRepository.findById(id);
		if(app.isPresent())
		return app.get();
		else
			throw new GivenIdNotFoundException();
	}

	
	
	
	
}
