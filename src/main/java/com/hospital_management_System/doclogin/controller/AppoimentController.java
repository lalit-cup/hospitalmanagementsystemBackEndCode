package com.hospital_management_System.doclogin.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_management_System.doclogin.entity.Appoiment;
import com.hospital_management_System.doclogin.repository.AppoimentRepository;

@CrossOrigin(origins ="http://localhost:4200/")
@RestController
@RequestMapping("/api/v2")
public class AppoimentController {
	AppoimentRepository appoimentRepository;

	public AppoimentController(AppoimentRepository appoimentRepository) {
		super();
		this.appoimentRepository = appoimentRepository;
	}
	
	@PostMapping("/insert")
	public Appoiment createAppoiment(@RequestBody Appoiment appoiment) {
		return appoimentRepository.save(appoiment);	
	}
	
	@GetMapping
	public List<Appoiment>getAllAppoiment(){
		return appoimentRepository.findAll();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Boolean>>deleteAppoinments(@PathVariable Long id) throws AttributeNotFoundException{
		Appoiment appoinment = appoimentRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appoinments not found by the given id"+id));
		appoimentRepository.delete(appoinment);
		Map<String, Boolean> response = new HashMap<String,Boolean>();
		response.put("Deleted Successfully", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}

}
