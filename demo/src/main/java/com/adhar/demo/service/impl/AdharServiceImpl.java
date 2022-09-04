package com.adhar.demo.service.impl;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.adhar.demo.dto.Adhar;
import com.adhar.demo.entity.AdharEntity;
import com.adhar.demo.repository.AdharRepository;
import com.adhar.demo.service.AdharService;

@Service
public class AdharServiceImpl implements AdharService {

	static final Map<Integer, Adhar> localStore = new HashMap<>();

	@Autowired
	private AdharRepository adharRepository;

	@Override
	public String createAdhar(Adhar adhar) {
		System.err.println("dob"+adhar.getDob());
		// localStore.put(adhar.getAdharNumber(), adhar);
		storeInDatabase(adhar);
		return "Created";
	}

	private void storeInDatabase(Adhar adhar) {
		AdharEntity entity = new AdharEntity(adhar.getAdharNumber(), adhar.getName());// here we have just created
		entity.setDob(adhar.getDob());
		adharRepository.save(entity);// to save object in data base via ORM jpa hibernate
		entity = null;
	}

	@Override
	public String updateAdhar(Adhar adhar) {
		Optional<AdharEntity> entity = adharRepository.findByAdharNumber(adhar.getAdharNumber());
		if (entity.isPresent()) {
			AdharEntity en = entity.get();
			en.setName(adhar.getName());
			en.setDob(adhar.getDob());			
			adharRepository.save(en);
			return "Updated";
		}
		return "Adhar not available with this adhar number" + adhar.getAdharNumber();

	}

	@Override
	@Modifying
	@Transactional
	public String disableAdhar(int adharNumber) {
		Optional<AdharEntity> entity = adharRepository.findByAdharNumber(adharNumber);
		if (entity.isPresent()) {
			adharRepository.delete(entity.get());
			return "Deleted";
		}
		return "Adhar not available with this adhar number" + adharNumber;
	}

	@Override
	public Collection<Adhar> getAllAdhar() {
		List<Adhar> adhars = new ArrayList<>();
		List<AdharEntity> listOfAdhar = adharRepository.findAll();
		for (AdharEntity adharEntity : listOfAdhar) {
			Adhar adhar = new Adhar();
			adhar.setAdharNumber(adharEntity.getAdharNumber());
			adhar.setName(adharEntity.getName());
			adhar.setDob(adharEntity.getDob());
			adhars.add(adhar);
		}
		return adhars;
	}

	@Override
	public Adhar getAdharByAdharNumber(int adharNumber) {
		Optional<AdharEntity> entity = adharRepository.findByAdharNumber(adharNumber);
		if (entity.isPresent()) {
			Adhar adhar = new Adhar();
			adhar.setAdharNumber(entity.get().getAdharNumber());
			adhar.setName(entity.get().getName());
			adhar.setDob(entity.get().getDob());
			return adhar;
		}
		return null;
	}

	/**
	 * This adhar on behalf of adhar name
	 * 
	 * @param adharName
	 * @return Adhar
	 */
	@Override
	public List<Adhar> getByAdharName(String adharName) {
		List<Adhar> adhars = new ArrayList<>();
		List<AdharEntity> entitys = adharRepository.findByName(adharName);
		if (entitys.isEmpty()) {
			return adhars;
		} else {
			for (AdharEntity adharEntity : entitys) {
				Adhar adhar = new Adhar();
				adhar.setAdharNumber(adharEntity.getAdharNumber());
				adhar.setName(adharEntity.getName());
				adhar.setDob(adharEntity.getDob());
				adhars.add(adhar);
			}
		}
		return adhars;
		/*
		 * if (localStore.isEmpty()) { return null; } else { for (Map.Entry<Integer,
		 * Adhar> entry : localStore.entrySet()) { Adhar adhar = entry.getValue(); if
		 * (adhar.getName().equals(adharName)) { return adhar; } } } return null;
		 */
	}

	@Override
	public List<Adhar> getAdharByGenderAndNameSize(Long length) {
		List<Adhar> adhars = new ArrayList<>();
		System.err.println("lll"+length);
		List<AdharEntity> entitys = adharRepository.getAdharByGenderAndNameSize(length,"FEMALE");
		if (entitys.isEmpty()) {
			return adhars;
		} else {
			for (AdharEntity adharEntity : entitys) {
				Adhar adhar = new Adhar();
				adhar.setAdharNumber(adharEntity.getAdharNumber());
				adhar.setName(adharEntity.getName());
				adhar.setDob(adharEntity.getDob());
				adhars.add(adhar);
			}
		}
		return adhars;
	}
}
