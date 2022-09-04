package com.adhar.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adhar.demo.entity.AdharEntity;

public interface AdharRepository extends JpaRepository<AdharEntity, Long> {

	Optional<AdharEntity> findByAdharNumber(int adharNumber);
	
	List<AdharEntity> findByName(String name);

	@Query("select a from AdharEntity as a where CHAR_LENGTH(a.name) >:size and a.gender =:gender")
	List<AdharEntity> getAdharByGenderAndNameSize(@Param("size") Long  length,@Param("gender") String gender );
}
