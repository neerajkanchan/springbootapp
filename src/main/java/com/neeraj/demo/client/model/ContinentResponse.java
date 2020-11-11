package com.neeraj.demo.client.model;

import javax.persistence.Column;

public class ContinentResponse {
	private String abbr;
	private String name;

	public ContinentResponse(String abbr, String name) {
		this.abbr = abbr;
		this.name = name;
	}
	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
