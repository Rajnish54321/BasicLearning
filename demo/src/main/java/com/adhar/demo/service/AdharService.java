package com.adhar.demo.service;

import java.util.Collection;

import com.adhar.demo.dto.Adhar;

/**
 * This interface provide specification of adhar service.
 * 
 * @author Ankur
 * @version 1.0
 * @since 25-August-2022
 *
 */
public interface AdharService {

	/**
	 * This method is used to create new adhar object.
	 * 
	 * @param adhar
	 * @return Status of adhar
	 */
	public String createAdhar(Adhar adhar);

	/**
	 * This method is used to update new adhar object.
	 * 
	 * @param adhar
	 * @return Status of adhar
	 */
	public String updateAdhar(Adhar adhar);

	/**
	 * This method is used to update new adhar object.
	 * 
	 * @param adhar
	 * @return Status of adhar
	 */
	public String disableAdhar(Long adharNumber);

	/**
	 * This method is used to update new adhar object.
	 * 
	 * @return List<Adhar>
	 */
	public Collection<Adhar> getAllAdhar();

	/**
	 * This method is used to update new adhar object.
	 * 
	 * @param adharNumber
	 * @return Adhar
	 */
	public Adhar getAdharByAdharNumber(Long adharNumber);
}
