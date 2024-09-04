package com.hospital_management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_management_System.entity.Patient;

@Repository
public interface PatientsRepository extends JpaRepository<Patient, Long>{

}
