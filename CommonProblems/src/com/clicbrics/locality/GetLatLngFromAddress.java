package com.clicbrics.locality;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;




public class GetLatLngFromAddress {
	private static final String API_KEY = "AIzaSyAGhN2O_rniQsXnAlZEfchQYCen4ScWzcE";
	public static enum LocalityType{
    	locality, suburb//sub-urb
    }

	public static void main(String[] args) {
		//readLocalityAreaFromFile();
		readAllCityJsonFile();

	}
	
	private static void readAllCityJsonFile(){
		try {
			LinkedHashMap<String, List<Locality>> map = new LinkedHashMap<>();
			Object obj = new JSONParser().parse(new FileReader("all_city.json"));
			JSONArray jsonArr = (JSONArray) obj;
			if(jsonArr != null && !jsonArr.isEmpty()){
				int start = 0;
				int end = jsonArr.size();
				for(int i=0; i<end; i++){
					JSONObject jsonObj = (JSONObject) jsonArr.get(i);
					String city = (String) jsonObj.get("city");
					//System.out.println(city);
					List<Locality> list = new ArrayList();
					Object locObj = jsonObj.get("data");
					if(locObj != null){
						JSONArray locArr = (JSONArray)locObj;
						if(locArr != null && !locArr.isEmpty()){
							for(int k=0; k<locArr.size(); k++){
								JSONObject suburbObj = (JSONObject) locArr.get(k);
								String suburb = (String) suburbObj.get("suburb");
								//System.out.println(suburb);
								Object locListObj = suburbObj.get("localities");
								if(locListObj != null){
									list.add(new Locality(suburb, LocalityType.suburb.toString(),city,null));
									JSONArray locListArr = (JSONArray) locListObj;
									if(locListArr != null && !locListArr.isEmpty()){
										for(int x=0; x<locListArr.size(); x++){
											String localityStr = (String) locListArr.get(x);
											list.add(new Locality(localityStr,LocalityType.locality.toString(),city,suburb));
										}
									}
								}	
							}							
						}
					}
					if(map.containsKey(city)){
						List<Locality> lList = map.get(city);
						lList.addAll(list);
						map.put(city, lList);
					}else{
						map.put(city, list);
					}
				}			
				//System.out.println(map);
				System.out.println(map.size());
			}
			readLocalityAreaFromFile(map);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void readLocalityAreaFromFile(LinkedHashMap<String, List<Locality>> map){
		
		for(Map.Entry<String, List<Locality>> entry : map.entrySet()){
			String city = entry.getKey();
			List<Locality> localityList = entry.getValue();
			ArrayList<Locality> locList = new ArrayList<>();
			for(int i=0; i<localityList.size(); i++){
				Locality locality = searchLocalityByName(localityList.get(i));
				locList.add(locality);	
			}
			writeToCSV(city,locList);
		}
		
		/*File file = new File("dera_bassi.txt");
		String cityName = "Dera Bassi";
		//String stateName = "Bihar";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String area;
			ArrayList<Locality> localityList = new ArrayList<>();
			while ((area = br.readLine()) != null) {
				Locality locality = searchLocalityByName(area,cityName);
				localityList.add(locality);
			}
			System.out.println(localityList);
			writeToCSV(cityName,localityList);
			
			//Locality locality = searchLocalityByName("Sector 69" + ",+"+ cityName+ " " + ",+IN" ,cityName);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	private static Locality searchLocalityByName(Locality locality) {
		try {
			String area = locality.getLocalityName();
			/*if(area != null && locality.getSuburbName() != null && !locality.getSuburbName().trim().isEmpty() 
					&& area.toLowerCase().contains(locality.getSuburbName().toLowerCase())){
				System.out.println("Before : " + area + ", " + locality.getSuburbName());
				area = area.toLowerCase().replaceAll(locality.getSuburbName().toLowerCase(), "").trim();
				area = area +" " + locality.getSuburbName().toLowerCase();
				System.out.println("After " + area);
			}*/
			String cityName = locality.getCity();
			String name = area + ",+"+ cityName+ " " + ",+IN";
			String googleURL = "https://maps.googleapis.com/maps/api/geocode/json?key="
							+API_KEY+"&address="+URLEncoder.encode(name, "UTF-8")+"&components=country:in&sensor=true";
			URL url = new URL(googleURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setDoOutput(true);
		    conn.setRequestMethod("GET");
		    
		    int responseCode = conn.getResponseCode();
	        //System.out.println("Response Code : " + responseCode);
		    
	        if(responseCode == conn.HTTP_OK) {
	        	try (BufferedReader in = new BufferedReader(
    	                new InputStreamReader(conn.getInputStream()))) {

    	            StringBuilder response = new StringBuilder();
    	            String line;

    	            while ((line = in.readLine()) != null) {
    	                response.append(line);
    	            }
    	            //System.out.println(response.toString());
    	            Object obj = new JSONParser().parse(response.toString());
    	            JSONObject jsonObj = (JSONObject) obj;
    	            JSONArray jsonArr = (JSONArray) jsonObj.get("results");
    	            
    	            if(jsonArr != null && !jsonArr.isEmpty()){
    	            	for(int i=0; i<jsonArr.size(); i++){
    	            		jsonObj = (JSONObject) jsonArr.get(i);
    	            		String address = (String) jsonObj.get("formatted_address");
    	            		jsonObj= (JSONObject) jsonObj.get("geometry");
    	            		jsonObj = (JSONObject) jsonObj.get("location");
    	            		double lat = (double) jsonObj.get("lat");
    	            		double lng = (double) jsonObj.get("lng");
    	            		locality.setLatitude(lat);
    	            		locality.setLongitude(lng);
    	            		/*String localityName = formatAddress(address, cityName,stateName);
    	            		if(localityName.isEmpty()){
    	            			locality.setLocalityName(area);	
    	            		}else{
    	            			locality.setLocalityName(localityName);
    	            		}*/
    	            		
    	            		
    	            		//System.out.println(locality);
    	            		return locality;
    	            	}
    	            }
	        	}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static boolean writeToCSV(String cityName,ArrayList<Locality> list) {
		boolean status = false;
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("LocalityFile.csv",true);
			/*fileWriter.append("City");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Area");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Lat");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Lng");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(NEW_LINE_SEPARATOR.toString()
					.replaceAll(",", "-"));*/
			for (int i = 0; i < list.size(); i++) {
				
				fileWriter.append(list.get(i).getCity());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(list.get(i).getLatitude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(list.get(i).getLongitude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(list.get(i).getLocalityName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(list.get(i).getType());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(list.get(i).getSuburbName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR.toString().replaceAll(",","-"));
			}
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	private static String formatAddress(String address,String city,String stateName){
		//System.out.println(address);
		//System.out.println(city);
		if(address == null || address.isEmpty()){
			return "";
		}
		if(address.contains(city)){
			String[] arr = address.split(city);
			return arr[0].replace(",", "").trim();	
		}else if(address.contains(stateName)){
			String[] arr = address.split(stateName);
			return arr[0].replace(",", "").trim();
		}else{
			return "";
		}
	}

}
