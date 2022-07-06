package com.HospitalApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalApplication.entity.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor,Long> {

	Optional<Doctor> findByFirstName(String firstName);

	List<Doctor> findByLastName(String lastName);

	List<Doctor> findByQualification(String qualification);

	List<Doctor> findByGender(String gender);

}
