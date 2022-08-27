package com.adhar.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adhar.demo.entity.AdharEntity;

public interface AdharRepository extends JpaRepository<AdharEntity, Long> {

	Optional<AdharEntity> findByAdharNumber(int adharNumber);
	
	List<AdharEntity> findByName(String name);
}
