package com.model;

import java.sql.Date;
import java.util.Objects;

public class Invoice {
	private int invoiceId;
	private int productId;
	private int userId;
	private int quantity;
	private String deliveryAdress;
	private Date orderDate;
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDeliveryAdress() {
		return deliveryAdress;
	}
	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(int invoiceId, int productId, int userId, int quantity, String deliveryAdress,
			Date orderDate) {
		super();
		this.invoiceId = invoiceId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.deliveryAdress = deliveryAdress;
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "invoiceId=" + invoiceId + ", productId=" + productId + ", userId=" + userId + ", quantity="
				+ quantity + ", deliveryAdress=" + deliveryAdress + ", orderDate=" + orderDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(deliveryAdress, invoiceId, orderDate, productId, quantity, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(deliveryAdress, other.deliveryAdress) && invoiceId == other.invoiceId
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(productId, other.productId)
				&& quantity == other.quantity && Objects.equals(userId, other.userId);
	}

	
	
}
