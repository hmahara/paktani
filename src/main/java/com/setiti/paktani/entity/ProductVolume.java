package com.setiti.paktani.entity;

import java.io.Serializable;

public class ProductVolume implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private double quantity;
	
	
	public ProductVolume(Product product, double quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
}
