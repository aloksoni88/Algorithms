package com.clicbrics.locality;

public class Locality {
	private Integer id;
	private Double latitude;
	private Double longitude;
	private String localityName;
	private String city;
	private String type;
	private String suburbName;
	
	public Locality(){
		
	}
	
	public Locality(String localityName,String type,String city,String suburbName) {
		this.localityName = localityName;
		this.type = type;
		this.city = city;
		this.suburbName = suburbName;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getLocalityName() {
		return localityName;
	}
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSuburbName() {
		return suburbName;
	}

	public void setSuburbName(String suburbName) {
		this.suburbName = suburbName;
	}

	@Override
	public String toString() {
		return "City:" + city + ", Locality Name:" + localityName + ", Loc Type:"+ type+ ", Suburb Name:"+ suburbName
				+ ", Lat:" + latitude + ", Lng:" + longitude + "\n";
	}
	
}
