package com.HospitalApplication.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
//@JsonIgnoreProperties("hibernateLazyInitializer")

public class Appointment implements Serializable
{

	@Id
	@GeneratedValue(generator="seque", strategy = GenerationType.AUTO)
	@SequenceGenerator(name= "seque", initialValue = 1001)
	
	private long id;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String firstName;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String lastName;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String doctorName;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String deceased;
	@Column(nullable=false)
	private LocalDate date;

	
	@OneToOne(mappedBy="appointment",cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"appointment","userName","password"})
	private Patient patient;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties("appointment")
	private Doctor doctor;
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@PrePersist
	public void adddate() {
		this.date=LocalDate.now();
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDeceased() {
		return deceased;
	}

	public void setDeceased(String deceased) {
		this.deceased = deceased;
	}

	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}



	

	public void setId(long id) {
		this.id = id;
	}


	

	
	public Appointment(long id, @NotNull(message = "this field is manditory") String firstName,
			@NotNull(message = "this field is manditory") String lastName,
			@NotNull(message = "this field is manditory") String doctorName,
			@NotNull(message = "this field is manditory") String deceased, LocalDate date, Patient patient,
			Doctor doctor) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doctorName = doctorName;
		this.deceased = deceased;
		this.date = date;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", doctorName="
				+ doctorName + ", deceased=" + deceased + ", date=" + date + ", patient=" + patient + ", doctor="
				+ doctor + "]";
	}

	public Appointment(long id, @NotNull(message = "this field is manditory") String firstName,
			@NotNull(message = "this field is manditory") String lastName,
			@NotNull(message = "this field is manditory") String deceased) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deceased = deceased;
	}


	
	
	
	
	
}

