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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_management_System.doclogin.entity.Medicine;
import com.hospital_management_System.doclogin.repository.MedicineRepository;
import com.hospital_management_System.entity.Patient;

@CrossOrigin(origins ="http://localhost:4200/")
@RestController
@RequestMapping("/api/v3")

public class MedicineController {
	
	MedicineRepository medicineRepository;

	public MedicineController(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}
	
	@PostMapping("/insert")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	
	@GetMapping
	public List<Medicine>getAllMedicine(){
		return medicineRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine Not Found Exception"+id));
		return ResponseEntity.ok(medicine);
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicine> updateMedicineById(@PathVariable long id,@RequestBody Medicine medicineDetails) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine Not Found Exception"+id));
		medicine.setDrugName(medicineDetails.getDrugName());
		medicine.setDrugStock(medicineDetails.getDrugStock());
		Medicine updatedMedicine = medicineRepository.save(medicine);
		return ResponseEntity.ok(updatedMedicine);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteMedicine(@PathVariable Long id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found by the given id"+id));
		medicineRepository.delete(medicine);
		Map<String, Boolean> response = new HashMap<String,Boolean>();
		response.put("Deleted Successfully", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
}
