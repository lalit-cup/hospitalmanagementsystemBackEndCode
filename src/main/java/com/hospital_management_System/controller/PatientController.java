package com.hospital_management_System.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_management_System.doclogin.entity.Appoiment;
import com.hospital_management_System.entity.Patient;
import com.hospital_management_System.repository.PatientsRepository;

@CrossOrigin(origins ="http://localhost:4200/")
@RequestMapping("/api/v1")
@RestController
public class PatientController {
	
	private PatientsRepository patientsRepository;

	public PatientController(PatientsRepository patientsRepository) {
		super();
		this.patientsRepository = patientsRepository;
	}
	
	@PostMapping("/insert")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientsRepository.save(patient);
	}
	
	@GetMapping
	public List<Patient>getAllPatient(){
		return patientsRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws AttributeNotFoundException{
		Patient patient = patientsRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found by Id : "+id));
		return ResponseEntity.ok(patient);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>>deletePatient(@PathVariable Long id) throws AttributeNotFoundException{
		Patient patient = patientsRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found by the given id"+id));
		patientsRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<String,Boolean>();
		response.put("Deleted Successfully", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatientById(@PathVariable long id, @RequestBody Patient patientDetails) throws AttributeNotFoundException{
		Patient patient = patientsRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found by the given id"+id));
		patient.setPatientName(patientDetails.getPatientName());
		patient.setPatientAge(patientDetails.getPatientAge());
		patient.setPatient_Blood_Group(patientDetails.getPatient_Blood_Group());
		patient.setPatientDose(patientDetails.getPatientDose());
		patient.setPatient_Prescription(patientDetails.getPatient_Prescription());
		patient.setPatientUrgency(patientDetails.getPatientUrgency());
		patient.setDoctorFee(patientDetails.getDoctorFee());
		patient.setId(patientDetails.getId());
		
		Patient updatedPatient = patientsRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}

}
