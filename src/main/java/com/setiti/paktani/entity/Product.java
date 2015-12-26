package com.setiti.paktani.entity;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private String productCategory;
	private double quantityPerUnit;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getQuantityPerUnit() {
		return quantityPerUnit;
	}
	public void setQuantityPerUnit(double quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}
	
	
}
