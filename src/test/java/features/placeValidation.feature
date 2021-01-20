Feature: Validating place APIs


@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "post" http requests
Then the API call is success with status code "200"
And "status" in response body is "OK"
And verify place_id created maps to "<name>" using "getPlaceAPI"


Examples:
	|name   |language| address		  |
	|admin  |french  | Pune	 		  |
#	|david   |Hindi   | hinjewadi	  |


@DeletePlace
Scenario: Verify if Delete API fucntionality is working 

Given DeletePlace Payload
When User calls "deletePlaceAPI" with "POST" http requests
Then the API call is success with status code "200"
And "status" in response body is "OK"






