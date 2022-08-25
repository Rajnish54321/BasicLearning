package com.adhar.demo.dto;

import java.io.Serializable;

public class Adhar implements Serializable {

	private static final long serialVersionUID = 2581539018206785713L;

	private Long adharNumber;
	private String name;

	public Adhar(Long adharNumber, String name) {
		super();
		this.adharNumber = adharNumber;
		this.name = name;
	}

	public Long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
