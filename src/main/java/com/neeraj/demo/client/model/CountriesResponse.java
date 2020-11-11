package com.neeraj.demo.client.model;

import java.util.ArrayList;
import java.util.List;

public class CountriesResponse extends DemoResponse{

	List<CountryResponse> countries;
	
	public CountriesResponse(boolean status, int statusCode) {
		super(status, statusCode);
	}

	public List<CountryResponse> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryResponse> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "CountriesResponse [countries=" + countries + ", status=" + status + ", statusCode=" + statusCode + "]";
	}
}
