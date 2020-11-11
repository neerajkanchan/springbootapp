package com.neeraj.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.demo.model.State;

public interface StateRepo extends JpaRepository<State, String>{

	@Query(value = "select s.* from state s where s.country = ?1", nativeQuery = true)
	public ArrayList<State> getStatesByCountry(String country);
	
	@Query(value = "select s.* from state s where s.abbr = ?1", nativeQuery = true)
	public State getStatesByName(String name);
}