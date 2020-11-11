package com.neeraj.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.neeraj.demo.client.model.AirportResponse;
import com.neeraj.demo.client.model.CountriesResponse;
import com.neeraj.demo.client.model.StatesResponse;
import com.neeraj.demo.service.DemoService;
import com.neeraj.demo.util.JsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Rest API")
public class DemoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
	private static final Gson GSON = JsonUtil.GSON;

	@Autowired
	DemoService demoService;

	@GetMapping(value = "/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("App is up and running", HttpStatus.OK);
	}

//	@PreAuthorize("getStates")
	@GetMapping(value = "/countries")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully processed request"),
			@ApiResponse(code = 401, message = "You are not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<String> getAllcountries(@RequestParam(value = "field_name") String startsWith) {
		ResponseEntity<String> response = null;
		String stateJson = null;
		try {			
				CountriesResponse countries = demoService.getAllCountriesStartsWith(startsWith
						);
				stateJson = GSON.toJson(countries, CountriesResponse.class);
				response = ResponseEntity.ok(stateJson);
		} catch (Exception e) {
			LOGGER.error("Error",e);
			response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
//	@PreAuthorize("getStates")
	@GetMapping(value = "/states")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully processed request"),
			@ApiResponse(code = 401, message = "You are not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<String> getStatesByCountry(@RequestParam(value = "country") String country) {
		ResponseEntity<String> response = null;
		String stateJson = null;
		try {			
				StatesResponse states = demoService.getStatesByCountry(country);
				stateJson = GSON.toJson(states, StatesResponse.class);
				response = ResponseEntity.ok(stateJson);
		} catch (Exception e) {
			LOGGER.error("Error",e);
			response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

//	@PreAuthorize("getAirportByIata")
	@GetMapping(value = "/single")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully processed request"),
			@ApiResponse(code = 401, message = "You are not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<String> getAirportByIata(@RequestParam(value = "iata") String iataCode) {
		ResponseEntity<String> response = null;
		String stateJson = null;
		try {			
				AirportResponse states = demoService.getAirportByIATA(iataCode);
				stateJson = GSON.toJson(states, AirportResponse.class);
				response = ResponseEntity.ok(stateJson);
		} catch (Exception e) {
			LOGGER.error("Error",e);
			response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
