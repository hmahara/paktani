package com.setiti.paktani.entity;

public class Location {
	private String locationName;
	private int locationLevel;
	private String locationLevelString;
	private Location parentLocation;
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
	public Location getParentLocation() {
		return parentLocation;
	}
	public void setParentLocation(Location parentLocation) {
		this.parentLocation = parentLocation;
	}
	public String getLocationLevelString() {
		return locationLevelString;
	}
	public void setLocationLevelString(String locationLevelString) {
		this.locationLevelString = locationLevelString;
	}
	
	

}
