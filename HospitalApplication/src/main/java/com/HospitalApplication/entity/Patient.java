package com.HospitalApplication.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")

public class Patient implements Serializable
 {


	@Id
	@GeneratedValue(generator="seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name= "seq", initialValue = 1)
	
	private long id;
	@Column(nullable=false)
	@NotNull
	@NotBlank(message="this field is manditory")
	private String firstName;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String lastName;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String gender;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String address;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String contactno;
	@Column(nullable=false)
	private LocalDate date;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String userName;
	@Column(nullable=false)
	@NotNull(message="this field is manditory")
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties({"patient","userName","password"})
	private Doctor doctor;
	
   @OneToOne(fetch = FetchType.LAZY)
   @JsonIgnoreProperties("doctor")
    private Appointment appointment;

   @PrePersist
	public void adddate() {
		this.date=LocalDate.now();
	}

   
public long getId() {
	return id;
}


public void setId(long id) {
	id = id;
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


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getContactno() {
	return contactno;
}


public void setContactno(String contactno) {
	this.contactno = contactno;
}


public LocalDate getDate() {
	return date;
}


public void setDate(LocalDate date) {
	this.date = date;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Doctor getDoctor() {
	return doctor;
}


public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}


public Appointment getAppointment() {
	return appointment;
}


public void setAppointment(Appointment appointment) {
	this.appointment = appointment;
}



public Patient(long id, @NotNull @NotBlank(message = "this field is manditory") String firstName,
		@NotNull(message = "this field is manditory") String lastName, int age,
		@NotNull(message = "this field is manditory") String gender,
		@NotNull(message = "this field is manditory") String address,
		@NotNull(message = "this field is manditory") String contactno, LocalDate date,
		@NotNull(message = "this field is manditory") String userName,
		@NotNull(message = "this field is manditory") String password, Doctor doctor, Appointment appointment) {
	super();
	id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.contactno = contactno;
	this.date = date;
	this.userName = userName;
	this.password = password;
	this.doctor = doctor;
	this.appointment = appointment;
}


public Patient(long id, @NotNull @NotBlank(message = "this field is manditory") String firstName,
		@NotNull(message = "this field is manditory") String lastName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
}




@Override
public String toString() {
	return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender="
			+ gender + ", address=" + address + ", contactno=" + contactno + ", date=" + date + ", userName=" + userName
			+ ", password=" + password + ", doctor=" + doctor + ", appointment=" + appointment + "]";
}


public Patient() {
	super();
	// TODO Auto-generated constructor stub
}





   
	
	
}
