package com.HospitalApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HospitalApplication.entity.Patient;
import com.HospitalApplication.exception.GivenIdNotFoundException;
import com.HospitalApplication.exception.NoRecordFoundException;
import com.HospitalApplication.exception.NoSuchDataFoundException;
import com.HospitalApplication.repository.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getPatientList() {
		// TODO Auto-generated method stub
		List<Patient> patient= patientRepository.findAll();
		if(patient.isEmpty())
			throw new NoRecordFoundException();
		else
			return patient;
	}


	@Override
	public Patient getPatientById(long id) {
		// TODO Auto-generated method stub
Patient patient=patientRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		
		return patient;
		
	}

	@Override
	public String deletePatient(long id) {
		// TODO Auto-generated method stub
		Patient patient=patientRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		patientRepository.deleteById(id);
		return "Patient record deleted successfully..";
	}

	@Override
	public Patient updatePatient(long id, Patient patient) {
		// TODO Auto-generated method stub
		
		Patient patient1=patientRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
         patient1.setFirstName(patient.getFirstName());
         patient1.setLastName(patient.getLastName());
         patient1.setAge(patient.getAge());
         patient1.setGender(patient.getGender());
         patient1.setAddress(patient.getAddress());
         patient1.setContactno(patient.getContactno());
         patient1.setDate(patient.getDate());
         patient1.setUserName(patient.getUserName());
         patient1.setPassword(patient.getPassword());
        
         patientRepository.save(patient1);
		return patient1;
	}

	@Override
	public Patient getPatientByFirstName(String firstName) {
		// TODO Auto-generated method stub
		Optional<Patient> patient=patientRepository.findByFirstName(firstName);
		if(patient.isPresent())
		{
			return patient.get();
			
		}
		else {
			throw new NoSuchDataFoundException();
		}
	}

	@Override
	public Patient getPatientByLastName(String lastName) {
		// TODO Auto-generated method stub
		Optional<Patient> patient=patientRepository.findByLastName(lastName);
		if(patient.isPresent())
		{
			return patient.get();
			
		}
		else {
			throw new NoSuchDataFoundException();
		}
	}

	@Override
	public Patient getPatientByGender(String gender) {
		// TODO Auto-generated method stub
		
		Optional<Patient> patient=patientRepository.findByGender(gender);
		if(patient.isPresent())
		{
			return patient.get();
			
		}
		else {
			throw new NoSuchDataFoundException();
		}
	}


}
