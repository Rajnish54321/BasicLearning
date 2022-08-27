package com.adhar.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adhar")
public class AdharEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int adharNumber;
	private String name;

	public AdharEntity(Long id, int adharNumber, String name) {
		super();
		this.id = id;
		this.adharNumber = adharNumber;
		this.name = name;
	}

	public AdharEntity(int adharNumber, String name) {
		super();
		this.adharNumber = adharNumber;
		this.name = name;
	}

	public AdharEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(int adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
