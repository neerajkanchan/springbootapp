package com.neeraj.demo.client.model;

import com.neeraj.demo.model.Airport;

public class AirportResponse extends DemoResponse{

	public AirportResponse(boolean status, int statusCode) {
		super(status, statusCode);
	}
	private String term;
	AirportDetails airportDetails;
	public AirportDetails getAirport() {
		return airportDetails;
	}
	public void setAirport(AirportDetails airportDetails) {
		this.airportDetails = airportDetails;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
}
