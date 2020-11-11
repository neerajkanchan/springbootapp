package com.neeraj.demo.client.model;

import java.util.ArrayList;

import com.neeraj.demo.model.State;

public class StatesResponse extends DemoResponse{

	private String districtType;
	ArrayList<StateResponse> states;
	
	public StatesResponse(boolean status, int statusCode) {
		super(status, statusCode);
	}

	public String getDistrictType() {
		return districtType;
	}
	public void setDistrictType(String districtType) {
		this.districtType = districtType;
	}
	public ArrayList<StateResponse> getStates() {
		return states;
	}
	public void setStates(ArrayList<StateResponse> states) {
		this.states = states;
	}
	@Override
	public String toString() {
		return "StateResponse [status=" + status + ", statusCode=" + statusCode + ", districtType=" + districtType
				+ ", states=" + states + "]";
	}
}
