package com.HospitalApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalApplication.entity.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
