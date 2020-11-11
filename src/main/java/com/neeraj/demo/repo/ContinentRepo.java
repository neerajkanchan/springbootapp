package com.neeraj.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.demo.model.Continent;

public interface ContinentRepo extends JpaRepository<Continent, String>{
	@Query(value = "select c.* from continent c where c.abbr like  ?1", nativeQuery = true)
	public Continent findContinentByAbbr(String abbr);
}