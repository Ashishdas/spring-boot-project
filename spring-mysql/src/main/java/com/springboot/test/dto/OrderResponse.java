package com.springboot.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_DEFAULT)
public class OrderResponse {
	private String name;
	private String productName;
	private String quantity;

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public OrderResponse(String name, String productName) {
		super();
		this.name = name;
		this.productName = productName;
	}

	public OrderResponse() {
	}

	@Override
	public String toString() {
		return "OrderResponse [name=" + name + ", productName=" + productName + ", quantity=" + quantity + "]";
	}

}
