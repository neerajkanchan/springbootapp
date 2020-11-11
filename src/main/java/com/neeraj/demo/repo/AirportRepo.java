package com.neeraj.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.demo.model.Airport;

public interface AirportRepo extends JpaRepository<Airport, String>{
	@Query(value = "select a.* from airport a where a.iata = ?1", nativeQuery = true)
	public Airport findAirportByIata(String iata);
}