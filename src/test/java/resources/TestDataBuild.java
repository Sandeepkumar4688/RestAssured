package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace AddPlacePayload(String name,String language, String address ) {
		
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setName(name);
		p.setPhone_number(112244365);
		p.setWebsite("ssa.com");
		
		List<String> myList = new ArrayList<String>();
		myList.add("frfefecfv");
		myList.add("frfefredccdvffecfv");
		p.setTypes(myList);
		
		
		Location l  = new Location();
		l.setLat(22.22);
		l.setLng(33.33);
		p.setLocation(l);
		
	return p;
		
	}

	
	public  String deletePlacePayload(String placeId) {
		
		return "{\r\n\"place_id\": \""+placeId+"\"\r\n}";
	}
}
