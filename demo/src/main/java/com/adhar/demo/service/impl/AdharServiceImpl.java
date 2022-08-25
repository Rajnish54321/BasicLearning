package com.adhar.demo.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.adhar.demo.dto.Adhar;
import com.adhar.demo.service.AdharService;

@Service
public class AdharServiceImpl implements AdharService {

	static final Map<Long, Adhar> localStore = new HashMap<>();

	@Override
	public String createAdhar(Adhar adhar) {
		localStore.put(adhar.getAdharNumber(), adhar);
		return "Created";
	}

	@Override
	public String updateAdhar(Adhar adhar) {
		if (localStore.containsKey(adhar.getAdharNumber())) {
			localStore.put(adhar.getAdharNumber(), adhar);
			return "Updated";
		}
		return "Adhar not available with this adhar number" + adhar.getAdharNumber();

	}

	@Override
	public String disableAdhar(Long adharNumber) {
		if (localStore.containsKey(adharNumber)) {
			localStore.remove(adharNumber);
			return "Deleted";

		}
		return "Adhar not available with this adhar number" + adharNumber;
	}

	@Override
	public Collection<Adhar> getAllAdhar() {

		return localStore.values();
	}

	@Override
	public Adhar getAdharByAdharNumber(Long adharNumber) {
		if (localStore.containsKey(adharNumber)) {
			return localStore.get(adharNumber);
		}
		return null;
	}

}
