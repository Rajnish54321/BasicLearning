package com.adhar.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhar.demo.dto.Adhar;
import com.adhar.demo.service.AdharService;

@RestController
@RequestMapping("/adhar")
public class AdharController {

	@Autowired
	private AdharService adharService;

	@GetMapping("/get-all-adhar")
	public ResponseEntity<Object> getValue() {
		Collection<Adhar> adharlist = adharService.getAllAdhar();
		if (adharlist.isEmpty()) {
			return new ResponseEntity<Object>("Record Not availble ", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(adharlist, HttpStatus.OK);
	}

	@PostMapping("/create-adhar")
	public ResponseEntity<Object> storeNewValue(@RequestBody Adhar data) {
		String response = adharService.createAdhar(data);
		if (response == null) {
			return new ResponseEntity<Object>("Failed Create Adhar ", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@PutMapping("/update-adhar")
	public ResponseEntity<Object> updateAdhar(@RequestBody Adhar data) {
		String response = adharService.updateAdhar(data);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@DeleteMapping("/remove-adhar")
	public ResponseEntity<Object> deleteAdhar(@RequestParam Long adharNumber) {
		String response = adharService.disableAdhar(adharNumber);
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

	@GetMapping("/getAdharByAdharNumber/{adharNumber}")
	public ResponseEntity<Object> getAdharByAdharNumber(@PathVariable Long adharNumber) {
		Adhar adhar = adharService.getAdharByAdharNumber(adharNumber);
		if (adhar == null) {
			return new ResponseEntity<Object>("Adhar details not present with this adhar number " + adharNumber,
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(adhar, HttpStatus.OK);
	}

}
