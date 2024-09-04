package com.hospital_management_System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Patient Name")
	private String patientName;
	@Column(name="Patient Age")
	private int patientAge;
	@Column(name="Patient Blood Group")
	private String patient_Blood_Group;
	@Column(name="Patient Prescription")
	private String patient_Prescription;
	@Column(name="Patient Dose")
	private int patientDose;
	@Column(name="Doctor Fee")
	private int doctorFee;
	@Column(name="Patient Urgency")
	private String patientUrgency;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(long id, String patientName, int patientAge, String patient_Blood_Group, String patient_Prescription,
			int patientDose, int doctorFee, String patientUrgency) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patient_Blood_Group = patient_Blood_Group;
		this.patient_Prescription = patient_Prescription;
		this.patientDose = patientDose;
		this.doctorFee = doctorFee;
		this.patientUrgency = patientUrgency;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patient_Blood_Group=" + patient_Blood_Group + ", patient_Prescription=" + patient_Prescription
				+ ", patientDose=" + patientDose + ", doctorFee=" + doctorFee + ", patientUrgency=" + patientUrgency
				+ "]";
	
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
	public String getPatient_Blood_Group() {
		return patient_Blood_Group;
	}
	public void setPatient_Blood_Group(String patient_Blood_Group) {
		this.patient_Blood_Group = patient_Blood_Group;
	}
	public String getPatient_Prescription() {
		return patient_Prescription;
	}
	public void setPatient_Prescription(String patient_Prescription) {
		this.patient_Prescription = patient_Prescription;
	}
	public int getPatientDose() {
		return patientDose;
	}
	public void setPatientDose(int patientDose) {
		this.patientDose = patientDose;
	}
	public int getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(int doctorFee) {
		this.doctorFee = doctorFee;
	}
	public String getPatientUrgency() {
		return patientUrgency;
	}
	public void setPatientUrgency(String patientUrgency) {
		this.patientUrgency = patientUrgency;
	}
	
}
