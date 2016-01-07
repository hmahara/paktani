package com.setiti.paktani.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LocationCommodity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;
	private ProductVolume productVolume;
	private List<LocationCommodity> children;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public ProductVolume getProductVolume() {
		return productVolume;
	}
	public void setProductVolume(ProductVolume productVolume) {
		this.productVolume = productVolume;
	}
	public List<LocationCommodity> getChildren() {
		return children;
	}
	public void setChildren(List<LocationCommodity> children) {
		this.children = children;
	}
	public void addLocationCommodityChild(LocationCommodity child){
		if (children == null){
			children = new ArrayList<LocationCommodity>();
		}
		children.add(child);
	}
	
	
	
	

}
