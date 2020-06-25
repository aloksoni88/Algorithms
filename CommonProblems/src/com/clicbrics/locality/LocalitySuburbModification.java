package com.clicbrics.locality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LocalitySuburbModification{
	
	private static final String API_KEY = "AIzaSyAGhN2O_rniQsXnAlZEfchQYCen4ScWzcE";
	public static enum LocalityType{
    	locality, suburb//sub-urb
    }
	
	public static void main(String[] args) {
		readLocalityFile();
	}
	
	private static void readLocalityFile(){
		String localityCSVFile = "LocalitySuburbFile.csv";
		String line = "";
		String cvsSplitBy = ",";
		
		try{
			
			BufferedReader br = new BufferedReader(new FileReader(localityCSVFile));
			int count = 0;
			ArrayList<UpdatedLocality> updatedLocList = new ArrayList<UpdatedLocality>();
			
			while ((line = br.readLine()) != null) {
				if (count < 14000) {
					count++;
					continue;
				}
				count++;
				
				/*if(count >= 14001){
					break;
				}*/
				// use comma as separator
				String[] localities = line.split(cvsSplitBy);
				if(localities == null || localities.length == 0){
					continue;
				}
				Locality locality = new Locality();
				UpdatedLocality updatedLocality = new UpdatedLocality();
				for(int i=0; i<localities.length; i++){
					if(i==0){
						String suburbId = localities[i];
						if(suburbId != null && !suburbId.isEmpty()){
							suburbId = suburbId.replace("\"", "");
							locality.setId(Integer.parseInt(suburbId.trim()));
							updatedLocality.setId(Integer.parseInt(suburbId.trim()));
						}
					}
					else if(i==1){
						String city = localities[i];
						if(city != null && !city.isEmpty()){
							city = city.replace("\"", "");
							locality.setCity(city);
							updatedLocality.setCity(city);
						}
					}
					else if(i==2){
						String latitude = localities[i];
						if(latitude != null && !latitude.isEmpty()){
							latitude = latitude.replace("\"", "");
							locality.setLatitude(Double.parseDouble(latitude));
							updatedLocality.setLatitude(Double.parseDouble(latitude));
						}
					}
					else if(i==3){
						String longitude = localities[i];
						if(longitude != null && !longitude.isEmpty()){
							longitude = longitude.replace("\"", "");
							locality.setLongitude(Double.parseDouble(longitude));
							updatedLocality.setLongitude(Double.parseDouble(longitude));
						}
					}
					else if(i==4){
						String localityName = localities[i];
						if(localityName != null && !localityName.isEmpty()){
							localityName = localityName.replace("\"", "");
							locality.setLocalityName(localityName);
							updatedLocality.setLocalityName(localityName);
						}
					}
					else if(i==5){
						String localityType = localities[i];
						if(localityType != null && !localityType.isEmpty()){
							localityType = localityType.replace("\"", "");
							locality.setType(localityType);
							updatedLocality.setType(localityType);
						}
					}
					else if(i==6){
						String suburbName = localities[i];
						if(suburbName != null && !suburbName.isEmpty()){
							suburbName = suburbName.replace("\"", "");
							locality.setSuburbName(suburbName);
							updatedLocality.setSuburbName(suburbName);
						}
					}
				}	
				if(!Utils.isEmpty(locality.getType()) && locality.getType().equalsIgnoreCase(LocalityType.locality.toString()) 
						&& !Utils.isEmpty(locality.getLocalityName()) && !Utils.isEmpty(locality.getSuburbName()) 
						&& locality.getLocalityName().toLowerCase().contains(locality.getSuburbName().toLowerCase())){
					locality = searchLocalityByName(locality);
					updatedLocality.setLatitueUpdated(locality.getLatitude());
					updatedLocality.setLongitudeUpdated(locality.getLongitude());
				}
				updatedLocList.add(updatedLocality);
			}
			writeToCSV(updatedLocList);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static boolean writeToCSV(ArrayList<UpdatedLocality> list) {
		boolean status = false;
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("LocalitySuburbFileUpdated.csv",true);
			
			for (int i = 0; i < list.size(); i++) {
				/*if(i==0){
					fileWriter.append("Suburb Id");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("City");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Latitude");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Longitude");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Locality Name");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Locality Type");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Suburb Name");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Updated Latitude");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Update Longitude");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(NEW_LINE_SEPARATOR.toString().replaceAll(",","-"));
				}*/
				
				UpdatedLocality locality = list.get(i);
				//Id
				if(locality.getId() != null){
					fileWriter.append(String.valueOf(locality.getId()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//City
				if(locality.getCity() != null){
					fileWriter.append(locality.getCity());
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//Latitude
				if(locality.getLatitude() != null){
					fileWriter.append(String.valueOf(locality.getLatitude()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//Longitude
				if(locality.getLongitude() != null){
					fileWriter.append(String.valueOf(locality.getLongitude()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//Locality Name
				if(locality.getLocalityName() != null){
					fileWriter.append(locality.getLocalityName());
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//Locality Type
				if(locality.getType() != null){
					fileWriter.append(locality.getType());
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//Suburb Name
				if(locality.getSuburbName() != null){
					fileWriter.append(locality.getSuburbName());
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//Updated Latitude
				if(locality.getLatitueUpdated() != null){
					fileWriter.append(String.valueOf(locality.getLatitueUpdated()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				//Updated Longitude
				if(locality.getLongitudeUpdated() != null){
					fileWriter.append(String.valueOf(locality.getLongitudeUpdated()));
				}
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
	
	private static Locality searchLocalityByName(Locality locality) {
		try {
			String area = locality.getLocalityName();
			System.out.println("Before : " + area + ", " + locality.getSuburbName());
			area = area.toLowerCase().replaceAll(locality.getSuburbName().toLowerCase(), "").trim();
			area = area +" " + locality.getSuburbName().toLowerCase();
			System.out.println("After " + area);
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
}
