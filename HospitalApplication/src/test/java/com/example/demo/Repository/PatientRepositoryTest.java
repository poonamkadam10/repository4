package com.example.demo.Repository;



import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.HospitalApplication.entity.Patient;
import com.HospitalApplication.repository.PatientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class PatientRepositoryTest {

	@Autowired
	PatientRepository patientRepository;
	
	@Test
	public void savePatientTest() {
		Patient patient=patientRepository.save(new Patient(3,"Poonam","kadam"));
		Assertions.assertThat(patient.getId()).isGreaterThan(0);
	}
	@Test
	public void getPatientTest() {
		Patient patient=patientRepository.findById(2L).get();
		Assertions.assertThat(patient.getId()).isEqualTo(2L);
	}
	@Test
	public void getPatientListTest() {
		List<Patient> patient=patientRepository.findAll();
		Assertions.assertThat(patient.size()).isGreaterThan(0);
	}
	
	@Test
	public void updatePatientTest() {
		Patient patient=patientRepository.findById(2L).get();
		patient.setFirstName("");
		Patient updated=patientRepository.save(patient);
		Assertions.assertThat(updated.getFirstName()).isEqualTo("");
	}
	
	@Test
	public void deletePatientTest() {
		Patient patient=patientRepository.findById(2L).get();
		patientRepository.delete(patient);
		Patient patient1=null;
		
		Optional<Patient> patient2=patientRepository.findByLastName("");
		if(patient2.isPresent()) {
			patient1=patient2.get();
		}
		Assertions.assertThat(patient1).isNull();
	}
}
