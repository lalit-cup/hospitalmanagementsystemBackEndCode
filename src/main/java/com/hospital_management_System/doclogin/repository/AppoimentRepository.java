package com.hospital_management_System.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_management_System.doclogin.entity.Appoiment;

@Repository
public interface AppoimentRepository extends JpaRepository<Appoiment, Long>{

}
