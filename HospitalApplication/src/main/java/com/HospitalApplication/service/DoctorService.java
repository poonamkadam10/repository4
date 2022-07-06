package com.HospitalApplication.service;

import java.util.List;

import com.HospitalApplication.entity.Doctor;


public interface DoctorService {

	List<Doctor> getDoctorList();
	Doctor saveDoctor(Doctor doctor);
	Doctor getDoctorById(long id);
	Doctor updateDoctor(long id, Doctor doctor);
	String deleteDoctor(long id);
	Doctor getDoctorByFirstName(String firstName);
	List<Doctor> getDoctorByLastName(String lastName);
	List<Doctor> getDoctorByQualification(String qualification);
	List<Doctor> getDoctorByGender(String gender);

}
