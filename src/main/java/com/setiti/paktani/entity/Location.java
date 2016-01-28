package com.setiti.paktani.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="location")

public class Location {
	@Id
	private String locationId;
	private String locationName;
	private int locationLevel;
	private String locationLevelString;
	//private Location parentLocation;
	private String parentLocationId;
	
	private String latitude;
	private String longitude;
	private String locationType;
	
	
	public Location() {
	}

	@PersistenceConstructor
	public Location(String locationId, String locationName, int locationLevel, String locationLevelString,
			String parentLocationId) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationLevel = locationLevel;
		this.locationLevelString = locationLevelString;
		this.parentLocationId = parentLocationId;
	}
	
	public Location(String locationId, String locationName, int locationLevel, String locationLevelString,
			String parentLocationId, String latitude, String longitude) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationLevel = locationLevel;
		this.locationLevelString = locationLevelString;
		this.parentLocationId = parentLocationId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getLocationLevel() {
		return locationLevel;
	}
	public void setLocationLevel(int locationLevel) {
		this.locationLevel = locationLevel;
	}
//	public Location getParentLocation() {
//		return parentLocation;
//	}
//	public void setParentLocation(Location parentLocation) {
//		this.parentLocation = parentLocation;
//	}
	public String getLocationLevelString() {
		return locationLevelString;
	}
	public void setLocationLevelString(String locationLevelString) {
		this.locationLevelString = locationLevelString;
	}
	public String getParentLocationId() {
		return parentLocationId;
	}
	public void setParentLocationId(String parentLocationId) {
		this.parentLocationId = parentLocationId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	
	

}
