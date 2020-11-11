package com.neeraj.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.demo.model.Country;

public interface CountryRepo extends JpaRepository<Country, String>{
	public List<Country> findByNameStartsWith(String startsWith);
	
	@Query(value = "select c.* from country c where c.iso = ?1", nativeQuery = true)
	public Country findCountriesByISO(String iso);
}