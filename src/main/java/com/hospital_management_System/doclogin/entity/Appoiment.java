package com.hospital_management_System.doclogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appoiment")
public class Appoiment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String patientName;
	private int patientAge;
	private String patientSymptom;
	private String patientMobileNumber;
	public Appoiment(long id, String patientName, int patientAge, String patientSymptom, String patientMobileNumber) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientSymptom = patientSymptom;
		this.patientMobileNumber = patientMobileNumber;
	}
	public Appoiment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Appoiment [id=" + id + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientSymptom=" + patientSymptom + ", patientMobileNumber=" + patientMobileNumber + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientSymptom() {
		return patientSymptom;
	}
	public void setPatientSymptom(String patientSymptom) {
		this.patientSymptom = patientSymptom;
	}
	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}
	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

}
