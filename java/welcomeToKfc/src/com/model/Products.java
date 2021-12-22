package com.model;

import java.util.Objects;

public class Products {
	private int productId;
	private String productName;
	private String description;
	private double price;
	private String productType;
	private String productStatus;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public Products(int productId, String productName, String description, double price, String productType,
			String productStatus) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.productType = productType;
		this.productStatus = productStatus;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", productType=" + productType + ", productStatus=" + productStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, price, productId, productName, productStatus, productType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& productId == other.productId && Objects.equals(productName, other.productName)
				&& Objects.equals(productStatus, other.productStatus) && Objects.equals(productType, other.productType);
	}

}
