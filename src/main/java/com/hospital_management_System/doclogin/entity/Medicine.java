package com.hospital_management_System.doclogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Drug Name")
	private String drugName;
	private String drugStock;
	public Medicine(long id, String drugName, String drugStock) {
		super();
		this.id = id;
		this.drugName = drugName;
		this.drugStock = drugStock;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", drugName=" + drugName + ", drugStock=" + drugStock + "]";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugStock() {
		return drugStock;
	}
	public void setDrugStock(String drugStock) {
		this.drugStock = drugStock;
	}

}
