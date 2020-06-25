import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ReadJson {
	public static void main(String[] args) {
		try {
    		Object obj = new JSONParser().parse(new FileReader("city.json"));
    		
    		if(obj != null && obj instanceof JSONObject){
    			JSONObject jsonObj = (JSONObject) obj;
	            JSONArray jsonArray = (JSONArray) jsonObj.get("items");
	            if(jsonArray != null && jsonArray.size() > 0) {
	            	List<City> cityList = new ArrayList<City>();
	            	for(int i=0; i<jsonArray.size(); i++) {
	            		JSONObject object = (JSONObject) jsonArray.get(i);
	            		String cityId = (String)object.get("id");
	            		String stateId = (String)object.get("stateId");
	            		String cityName = (String)object.get("name");
	            		String state = (String)object.get("state");
	            		String country = (String)object.get("country");
	            		
	            		City city = new City();
	            		city.setCityId(Long.parseLong(cityId));
	            		city.setCityName(cityName);
	            		city.setCountry(country);
	            		city.setStateId(Long.parseLong(stateId));
	            		city.setStateName(state);
	            		cityList.add(city);
	            	}
	            	System.out.println("City List : " + cityList);
	            }
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
