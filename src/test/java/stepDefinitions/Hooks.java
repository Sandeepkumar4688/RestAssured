package stepDefinitions;

import io.cucumber.java.Before;



public class Hooks {
	
	
	
	@Before("@DeletePlace")
	
	public void veforeScenario() throws Throwable {
		
		StepDefinition m = new StepDefinition();
		
		if (StepDefinition.place_id==null) 
		{
		m.add_place_payload_with_something_something_something("sandy", "hindi", "wakad");
		m.user_calls_with_http_requests("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("sandy", "getPlaceAPI");
		}
	}
}
