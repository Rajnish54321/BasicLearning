package com.adhar.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Adhar implements Serializable {

	private static final long serialVersionUID = 2581539018206785713L;

	private int adharNumber;
	private String name;
	private LocalDate dob;
	private String gender;

	public Adhar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adhar(int adharNumber, String name) {
		super();
		this.adharNumber = adharNumber;
		this.name = name;
	}

	public Adhar(int adharNumber, String name, LocalDate dob, String gender) {
		super();
		this.adharNumber = adharNumber;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
