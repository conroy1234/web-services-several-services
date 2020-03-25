package org.customer.service.bean;

import java.util.Date;

public class CustomerExceptionBean {

	private String message;
	private Date date;
	
	
	public CustomerExceptionBean(String message, Date date) {		
		this.message = message;
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CustomerExceptionBean [message=" + message + ", date=" + date + "]";
	}
	
	
}
