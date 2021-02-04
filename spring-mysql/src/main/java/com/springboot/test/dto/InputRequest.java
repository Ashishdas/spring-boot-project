package com.springboot.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InputRequest<T> {

	@JsonProperty(value = "userId", required = true)
	private String loggedInUser;
	private String timeZone;
	private T product;

	public String getLoggedInUser() {
		return loggedInUser;
	}

	public T getProduct() {
		return product;
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public void setProduct(T product) {
		this.product = product;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String toString() {
		return "InputRequest [loggedInUser=" + loggedInUser + ", timeZone=" + timeZone + ", product=" + product + "]";
	}

	public InputRequest(String loggedInUser, String timeZone, T product) {
		super();
		this.loggedInUser = loggedInUser;
		this.timeZone = timeZone;
		this.product = product;
	}

	public InputRequest() {
		super();
	}
}
