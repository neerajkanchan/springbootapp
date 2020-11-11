package com.neeraj.demo.client.model;

import javax.persistence.Column;

public class CountryResponse {
	private String iso;
	private String name;

	public CountryResponse(String iso, String name) {
		this.iso = iso;
		this.name = name;
	}
	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
