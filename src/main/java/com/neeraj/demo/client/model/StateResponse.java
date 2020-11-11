package com.neeraj.demo.client.model;

public class StateResponse {
	private String abbr;
	private String name;
	private String region;
	
	
	public StateResponse(String abbr, String name, String region) {
		super();
		this.abbr = abbr;
		this.name = name;
		this.region = region;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "StateResponse [abbr=" + abbr + ", name=" + name + ", region=" + region + "]";
	}
}
