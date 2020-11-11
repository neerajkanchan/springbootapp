Assumptions:
	
	a. Java 8 is available
	
	b. You are able to run java programs without any environmental issues.


Steps to run:
	
	1. Clone Git repository
	
	2. Got to bin directory
	
	3. run start.bat file from bin folder. Once application is started, you should see a message similar to below:
	
	com.neeraj.demo.DemoApplication          : Started DemoApplication in 7.228 seconds (JVM running for 7.722)



Once app is up and running you can use the following End Points:

1.http://localhost:8080/api/v1/ping => This is to check that app us up and running.

2.http://localhost:8080/api/v1/states?country=IN => To get states for specified country code.

3.http://localhost:8080/api/v1/countries?field_name=A => To get countries starting with “A”

4.http://localhost:8080/api/v1/single?iata=LON => This returns Airport details

Currently all these follow HTTP GET so that we can run these from browser.

All these are implemented using RequestParam while these can also be done using PathVariable as well.

All these endpoints can be made secure using Spring Security and then entitlements can be used using "PreAuthorize" annotation which is mentioned (but commented) in the code.

Test case for Controller is added. It can be added for all the methods and classes likewise using Mockito and JUnit.
