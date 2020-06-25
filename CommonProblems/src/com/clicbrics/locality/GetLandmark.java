package com.clicbrics.locality;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetLandmark {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("no_process_row.txt"));
			int count = 0;
			String line = "";
			while ((line = br.readLine()) != null) {
				int i = Integer.parseInt(line);
				System.out.println(i);
			}
			
			
			if(true){
				return;
			}
			ArrayList<String> stateList = getStateList();
			Object obj = new JSONParser().parse(new FileReader("all.json"));
			JSONArray jsonArr = (JSONArray) obj;
			if(jsonArr != null && !jsonArr.isEmpty()){
				ArrayList<Landmark> landmarkList = new ArrayList<>();
				int start = 0, end = jsonArr.size();
				for(int i=start; i<end; i++){
					JSONObject jsonObj = (JSONObject) jsonArr.get(i);
					//System.out.println(jsonObj);
					Landmark landmark = new Landmark();
					
					String name = (String) jsonObj.get("name");
					String formattedAddress = (String) jsonObj.get("formatted_address");
					double latitude = (Double) jsonObj.get("lat");
					double longitude = (Double) jsonObj.get("lng");
					String placeId = (String) jsonObj.get("place_id");
					String city = (String) jsonObj.get("city");
					String dType = (String) jsonObj.get("dtype");
					Object ratingObj = jsonObj.get("rating");
					
					double northeast_lat = jsonObj.get("northeast_lat")!= null ? (Double) jsonObj.get("northeast_lat"):0;
					double northeast_lng = jsonObj.get("northeast_lng") != null ? (Double) jsonObj.get("northeast_lng"):0;
					double southwest_lat = jsonObj.get("southwest_lat") != null ? (Double) jsonObj.get("southwest_lat") : 0;
					double southwest_lng = jsonObj.get("southwest_lng") != null ? (Double) jsonObj.get("southwest_lng") : 0;
					
					
					int pincode = 0;
					String address = "";
					for(int k=0; k<stateList.size(); k++){
						String state = stateList.get(k);
						if(formattedAddress.toLowerCase().contains(state.toLowerCase())){
							address = formatAddress(formattedAddress, city, state);
							String pin = getPincode(formattedAddress, city, state);
							if(!pin.isEmpty()){
								pincode = Integer.parseInt(pin.trim());
							}
							landmark.setAddress(address.replaceAll(",", "#"));
							landmark.setPincode(pincode);
							break;
						}
					}
					
					if(name != null){
						landmark.setName(name.replaceAll(",", "#"));
					}
					if(formattedAddress != null){
						landmark.setFormattedAddress(formattedAddress.replaceAll(",", "#"));
					}
					landmark.setLatitude(latitude);
					landmark.setLongitude(longitude);
					landmark.setPlaceId(placeId);
					landmark.setCity(city);
					landmark.setdType(dType);
					landmark.setRating(""+ratingObj);
					landmark.setNortheast_lat(northeast_lat);
					landmark.setNortheast_lng(northeast_lng);
					landmark.setSouthwest_lat(southwest_lat);
					landmark.setSouthwest_lng(southwest_lng);
					landmarkList.add(landmark);
					System.out.println(landmark);
				}
				//System.out.println(landmarkList);
				writeToCSV(landmarkList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String formatAddress(String address,String city,String stateName){
		//System.out.println(address);
		//System.out.println(city);
		if(address == null || address.isEmpty()){
			return "";
		}
		String[] arr = address.split(city +", " + stateName);
		if(arr == null){
			//System.out.println(address);
			return "";
		}
		int lastIndex = arr[0].lastIndexOf(",");
		String add = lastIndex != -1 ? arr[0].substring(0, lastIndex) : arr[0];
		if(add == null || add.isEmpty()){
			//System.out.println(add);
			return "";
		}
		add = add.trim();
		return add;
	}
	
	private static String getPincode(String address,String city,String stateName){
		//System.out.println(address);
		//System.out.println(city);
		if(address == null || address.isEmpty()){
			return "";
		}
		String[] arr = address.split(city +", " + stateName);
		if(arr == null && city.equalsIgnoreCase("Gurugram")){
			arr = address.split("Gurgaon" +", " + stateName);
		}
		if(arr == null){
			//System.out.println(address);
			return "";
		}
		if(arr.length > 1){
			//System.out.println(arr[1]);
			//int lastIndex = arr[1].split("India")[0].lastIndexOf(",");
			String pincode = arr[1].replaceAll("[^0-9]+", "");
			if(pincode.length() > 6){
				pincode = pincode.substring(0,6);
			}
			return pincode;
		}else{
			//System.out.println(arr[0]);
		}
		
		return "";
	}
	
	private static ArrayList<String> getStateList(){
		ArrayList<String> cityList = new ArrayList<>();
		cityList.add("Andhra Pradesh");
		cityList.add("Arunachal Pradesh");
		cityList.add("Assam");
		cityList.add("Bihar");
		cityList.add("Chhattisgarh");
		cityList.add("Goa");
		cityList.add("Gujarat");
		cityList.add("Haryana");
		cityList.add("Himachal Pradesh");
		cityList.add("Jharkhand");
		cityList.add("Karnataka");
		cityList.add("Kerala");
		cityList.add("Madhya Pradesh");
		cityList.add("Maharashtra");
		cityList.add("Manipur");
		cityList.add("Meghalaya");
		cityList.add("Mizoram");
		cityList.add("Nagaland");
		cityList.add("Odisha");
		cityList.add("Punjab");
		cityList.add("Rajasthan");
		cityList.add("Sikkim");
		cityList.add("Tamil Nadu");
		cityList.add("Telangana");
		cityList.add("Tripura");
		cityList.add("Uttar Pradesh");
		cityList.add("Uttarakhand");
		cityList.add("West Bengal");
		cityList.add("Delhi");
		return cityList;
	}
	
	private static boolean writeToCSV(ArrayList<Landmark> list) {
		boolean status = false;
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("Landmark.csv",true);
			for (int i = 0; i < list.size(); i++) {
				if(i==0){
					fileWriter.append("City");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Pincode");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Latitude");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Longitude");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Place_Id");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("dType");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Rating");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Northeast_lat");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Northeast_lng");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Southwest_lat");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Southwest_lng");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Name");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Address");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append("Formatted_Address");
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(NEW_LINE_SEPARATOR.toString().replaceAll(",","-"));
				}
				if(list.get(i).getCity() != null){
					fileWriter.append(String.valueOf(list.get(i).getCity()));
				}
				fileWriter.append(COMMA_DELIMITER);
				if(list.get(i).getPincode() != null){
					fileWriter.append(String.valueOf(list.get(i).getPincode()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getLatitude() != null){
					fileWriter.append(String.valueOf(list.get(i).getLatitude()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getLongitude() != null){
					fileWriter.append(String.valueOf(list.get(i).getLongitude()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getPlaceId() != null){
					fileWriter.append(String.valueOf(list.get(i).getPlaceId()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getdType() != null){
					fileWriter.append(String.valueOf(list.get(i).getdType()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getRating() != null){
					fileWriter.append(String.valueOf(list.get(i).getRating()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getNortheast_lat() != null){
					fileWriter.append(String.valueOf(list.get(i).getNortheast_lat()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getNortheast_lng() != null){
					fileWriter.append(String.valueOf(list.get(i).getNortheast_lng()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getSouthwest_lat() != null){
					fileWriter.append(String.valueOf(list.get(i).getSouthwest_lat()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
				if(list.get(i).getSouthwest_lng() != null){
					fileWriter.append(String.valueOf(list.get(i).getSouthwest_lng()));
				}
				fileWriter.append(COMMA_DELIMITER);
				
			
				if(list.get(i).getName() != null){
					fileWriter.append(list.get(i).getName());
				}
				fileWriter.append(COMMA_DELIMITER);
				if(list.get(i).getAddress() != null){
					fileWriter.append(list.get(i).getAddress());	
				}
				fileWriter.append(COMMA_DELIMITER);
				if(list.get(i).getFormattedAddress() != null){
					fileWriter.append(list.get(i).getFormattedAddress());	
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
}
