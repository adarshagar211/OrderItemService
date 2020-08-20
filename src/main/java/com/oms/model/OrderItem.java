package com.oms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ORDERITEM")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = -8473788002197900400L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_CODE")
	private Integer productCode;

	@NotEmpty(message = "Product Name cannot be null or blank")
	private String productName;

	private int quantity;
	
	private Integer orderId;

	public OrderItem(String productName, int quantity) {
		super();
		this.productName = productName;
		this.quantity = quantity;
	}

	public OrderItem(String productName, int quantity,Integer orderId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public OrderItem() {
		super();
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ "]";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
