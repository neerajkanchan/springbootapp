package com.neeraj.demo.client.model;

public class DemoResponse {
	protected boolean status;
	protected int statusCode;
	
	public DemoResponse(boolean status, int statusCode) {
		this.status = status;
		this.statusCode = statusCode;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
