package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_1")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productName;
	private String productColor;
	private String productWeight;
	private double productCost;
	private String productNo;
	private String productPaymentMode;
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productColor=" + productColor
				+ ", productWeight=" + productWeight + ", productCost=" + productCost + ", productNo=" + productNo
				+ ", productPaymentMode=" + productPaymentMode + "]";
	}
	public Product() {
		
	}
	public Product(int id, String productName, String productColor, String productWeight, double productCost,
			String productNo, String productPaymentMode) {
		super();
		this.id = id;
		this.productName = productName;
		this.productColor = productColor;
		this.productWeight = productWeight;
		this.productCost = productCost;
		this.productNo = productNo;
		this.productPaymentMode = productPaymentMode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductPaymentMode() {
		return productPaymentMode;
	}
	public void setProductPaymentMode(String productPaymentMode) {
		this.productPaymentMode = productPaymentMode;
	}
	
	
	
	

}
