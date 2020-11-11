package com.neeraj.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neeraj.demo.client.model.AirportDetails;
import com.neeraj.demo.client.model.AirportResponse;
import com.neeraj.demo.client.model.ContinentResponse;
import com.neeraj.demo.client.model.CountriesResponse;
import com.neeraj.demo.client.model.CountryResponse;
import com.neeraj.demo.client.model.StateResponse;
import com.neeraj.demo.client.model.StatesResponse;
import com.neeraj.demo.model.Airport;
import com.neeraj.demo.model.Continent;
import com.neeraj.demo.model.Country;
import com.neeraj.demo.model.State;
import com.neeraj.demo.repo.AirportRepo;
import com.neeraj.demo.repo.ContinentRepo;
import com.neeraj.demo.repo.CountryRepo;
import com.neeraj.demo.repo.StateRepo;

@Service
public class DemoService {
	
	private static final String STATE = "State";

	@Autowired
	StateRepo stateRepo;

	@Autowired
	CountryRepo countryRepo;

	@Autowired
	ContinentRepo continentRepo;
	
	@Autowired
	AirportRepo airportRepo;
	
	public CountriesResponse getAllCountries() {
		CountriesResponse response = null;
		List<Country> countries = countryRepo.findAll();
		response = prepareCountryResponse(countries);
		return response;
	}
	
	public CountriesResponse getAllCountriesStartsWith(String startChars) {
		CountriesResponse response = null;
		try {
			List<Country> countries = countryRepo.findByNameStartsWith(startChars);
			response = prepareCountryResponse(countries);
		} catch (Exception e) {
			e.printStackTrace();
			response = new CountriesResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return response;
	}
	
	private CountriesResponse prepareCountryResponse(List<Country> countries) {
		CountriesResponse response = new CountriesResponse(true, HttpStatus.OK.value());
		if (countries != null && !countries.isEmpty()) {
			ArrayList<CountryResponse> countriesResp = new ArrayList<CountryResponse>();
			for (Country c : countries) {
				CountryResponse r = new CountryResponse(c.getIso(), c.getName());
				countriesResp.add(r);
			}
			response.setCountries(countriesResp);
		}
		return response;
	}
	
	public StatesResponse getStatesByCountry(String countryCode) {
		StatesResponse response = null;
		try {
			if (countryCode == null || countryCode.isEmpty()) 
				response = new StatesResponse(false, HttpStatus.BAD_REQUEST.value());
			else { 
				ArrayList<State> states = stateRepo.getStatesByCountry(countryCode);
				response = prepareStateResponse(states);
			}
		} catch (Exception e) {
			response = new StatesResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return response;
	}
	
	
	private StatesResponse prepareStateResponse(ArrayList<State> states) {
		StatesResponse response = new StatesResponse(true, HttpStatus.OK.value());
		if (states != null &&  !states.isEmpty()) {
			ArrayList<StateResponse> stateResponse = new ArrayList<StateResponse>();
			for (State s: states) {
				StateResponse state = new StateResponse(s.getAbbr(), s.getName(), s.getRegion());
				stateResponse.add(state);
			}
			response.setStates(stateResponse);
			response.setDistrictType(STATE);
		}
		return response;
	}

	public AirportResponse getAirportByIATA(String iataCode) {
		AirportResponse response = null;
		try {
			Airport airport = airportRepo.findAirportByIata(iataCode);
			if (airport != null) {
				State state = stateRepo.getStatesByName(airport.getState());
				Country country = countryRepo.findCountriesByISO(airport.getCountry());
				Continent continent = continentRepo.findContinentByAbbr(airport.getContinent());
				if (state != null && country != null && continent != null) {
					response = prepareAirportResponse(airport, state, country, continent);
				} else {
					response = new AirportResponse(false, HttpStatus.BAD_REQUEST.value());
				}				
			} else {
				response = new AirportResponse(false, HttpStatus.BAD_REQUEST.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new AirportResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return response;
	}

	private AirportResponse prepareAirportResponse(Airport airport, State state, Country country, Continent continent) {
		
		AirportDetails details = new AirportDetails();
		
		details.setCity(airport.getCity());
		details.setContinent(new ContinentResponse(continent.getAbbr(), continent.getName()));
		details.setCountry(new CountryResponse(country.getIso(), country.getName()));
		details.setElevation(airport.getElevation());
		details.setFull_location(airport.getLocation());
		details.setIata(airport.getIata());
		details.setLatitude(airport.getLatitude());
		details.setLongitude(airport.getLongitude());
		details.setName(airport.getName());
		details.setState(new StateResponse(state.getAbbr(), state.getName(), state.getRegion()));
		details.setType(airport.getType());
		details.setWebsite(airport.getWebsite());
	
		AirportResponse airportResponse = new AirportResponse(true, HttpStatus.OK.value());
		airportResponse.setAirport(details);
		airportResponse.setTerm(airport.getIata());
		return airportResponse;
		
	}
}
