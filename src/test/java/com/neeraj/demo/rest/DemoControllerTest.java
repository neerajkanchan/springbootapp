package com.neeraj.demo.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.neeraj.demo.client.model.CountriesResponse;
import com.neeraj.demo.client.model.CountryResponse;
import com.neeraj.demo.service.DemoService;
import com.neeraj.demo.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = DemoControllerTest.class)
@AutoConfigureMockMvc(addFilters = false)

public class DemoControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoControllerTest.class);
	private static final Gson GSON = JsonUtil.GSON;
	@MockBean
	DemoService demoService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void pingTest() {
		try {
			String s = "App is up and running";		
			assertEquals("App is up and running" , s);
		} catch (Exception e) {			
			LOGGER.error("Exception - " + e.getMessage());
		}
	}
	
	
	@Test
	public void getAllcountriesTest() {
		try {
			CountriesResponse response = new CountriesResponse(true, HttpStatus.OK.value());
			ArrayList<CountryResponse> countriesResp = new ArrayList<CountryResponse>();
			CountryResponse r = new CountryResponse("IN", "India");
			countriesResp.add(r);
			response.setCountries(countriesResp);

			int code = 400;
			 Mockito.when(demoService.getAllCountries()).thenReturn(response);
			 CountriesResponse countries = demoService.getAllCountries();
			 if (countries != null) {
				code = countries.getStatusCode();
				LOGGER.info(countries.getStatusCode() + " is the status code from countries");
			}
			else
				LOGGER.info("NULL countries");
			 assertEquals("200" , String.valueOf(code));
			 
		} catch (Exception e) {			
			LOGGER.error("Exception - " + e.getMessage());
		}
	}

	@Test
	public void getAllcountriesByISOTest() {
		try {
			CountriesResponse response = new CountriesResponse(true, HttpStatus.OK.value());
			ArrayList<CountryResponse> countriesResp = new ArrayList<CountryResponse>();
			CountryResponse r = new CountryResponse("IN", "India");
			countriesResp.add(r);
			response.setCountries(countriesResp);

			String startsWith = "IN";
			String stringResponse = GSON.toJson(response);
			LOGGER.info(stringResponse);
			Mockito.when(demoService.getAllCountriesStartsWith(startsWith)).thenReturn(response);
			LOGGER.info("Calling service now for " + startsWith);
			
			int code = 400;
			Mockito.when(demoService.getAllCountries()).thenReturn(response);
			CountriesResponse countries = demoService.getAllCountriesStartsWith(startsWith);
			if (countries != null) {
				code = countries.getStatusCode();
				LOGGER.info(countries.getStatusCode() + " is the status code from countries");
			}
			else
				LOGGER.info("NULL countries");
			
			assertEquals("200" , String.valueOf(code));
			 
		} catch (Exception e) {			
			LOGGER.error("Exception - " + e.getMessage());
		}
	}

	
}
