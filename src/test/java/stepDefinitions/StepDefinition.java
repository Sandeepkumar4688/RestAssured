package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();
	Utils requestSpecificatoin = new Utils();
	
	
	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload_with_something_something_something(String name, String language, String address) throws Throwable  {
		
			res= given().spec(requestSpecification())
			.body(data.AddPlacePayload(name, address, language));
		
	
	}

	@When("^User calls \"([^\"]*)\" with \"([^\"]*)\" http requests$")
    public void user_calls_with_http_requests(String resource, String method) throws Throwable {
	        
	      APIResources resourceAPI =APIResources.valueOf(resource);
	      resourceAPI.getResource();
	      System.out.println(resourceAPI.getResource());
	      
	            
	resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	if(method.equalsIgnoreCase("POST")) 
 response = res.when().post(resourceAPI.getResource());
	else if (method.equalsIgnoreCase("GET"))
		response = res.when().get(resourceAPI.getResource());
	
	}
	
	@Then("^the API call is success with status code \"([^\"]*)\"$")
public void the_api_call_is_success_with_status_code_something(Integer int1) throws Throwable { 
    assertEquals( response.getStatusCode(),200);
  
}

@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
public void something_in_response_body_is_something(String keyValue, String ExpectedValue) throws Throwable {
	
	assertEquals(getJsonPath(response, keyValue),ExpectedValue);
	
}


@And ("verify place_id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws Throwable  {
    //get req spec
	place_id = getJsonPath(response, "place_id");
	res= given().spec(requestSpecification()).queryParam("place_id", place_id);
	user_calls_with_http_requests(resource, "GET");
	String actualName = getJsonPath(response, "name");
	assertEquals(actualName,expectedName);
}

@Given("^DeletePlace Payload$")
public void deleteplace_payload() throws Throwable {
    res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
}




}