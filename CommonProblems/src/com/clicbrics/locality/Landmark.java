package com.clicbrics.locality;

public class Landmark {
	private String name;
	private String formattedAddress;
	private String address;
	private Double latitude;
	private Double longitude;
	private String placeId;
	private String city;
	private String dType;
	private String rating;
	private Double northeast_lat;
	private Double northeast_lng;
	private Double southwest_lat;
	private Double southwest_lng;
	private Integer pincode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormattedAddress() {
		return formattedAddress;
	}
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getdType() {
		return dType;
	}
	public void setdType(String dType) {
		this.dType = dType;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Double getNortheast_lat() {
		return northeast_lat;
	}
	public void setNortheast_lat(Double northeast_lat) {
		this.northeast_lat = northeast_lat;
	}
	public Double getNortheast_lng() {
		return northeast_lng;
	}
	public void setNortheast_lng(Double northeast_lng) {
		this.northeast_lng = northeast_lng;
	}
	
	
	public Double getSouthwest_lat() {
		return southwest_lat;
	}
	public void setSouthwest_lat(Double southwest_lat) {
		this.southwest_lat = southwest_lat;
	}
	public Double getSouthwest_lng() {
		return southwest_lng;
	}
	public void setSouthwest_lng(Double southwest_lng) {
		this.southwest_lng = southwest_lng;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		//return "City :" + city +", formatted_address:" + formattedAddress + ", address:" + address +  ", pincode:" + pincode;
		return "City :" + city +", formatted_address:" + formattedAddress +  ", pincode:" + pincode;
	}
}
