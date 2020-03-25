package org.calculater.currencyService.bean;

import java.util.UUID;

public class CustomerServiceBean {
	private int id;
	private String name;
	private String address;
	private String port;
	private String uuid;
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String string) {
		this.uuid = string;
	}

	public CustomerServiceBean() {

	}

	public CustomerServiceBean(int id, String name, String address,String uuid) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.uuid= uuid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CustomerServiceBean [id=" + id + ", name=" + name + ", address=" + address + ", port=" + port
				+ ", uuid=" + uuid + "]";
	}

}

