package org.calculater.currencyService.bean;

public class CurrencyServiceBean {


	private static final long serialVersionUID = -9011608001063813281L;
	
	private int id;
	private String from;
	private String to;
	private double exchangeRate;
	private double exchangeAmount;
	private double total;
	private String port;
	
	
	public CurrencyServiceBean() {
		
	}

	
	public CurrencyServiceBean(int id, String from, String to, double exchangeRate, double exchangeAmount) {
	
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
		this.exchangeAmount = exchangeAmount;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	
	
	
	public double getExchangeAmount() {
		return exchangeAmount;
	}


	public void setExchangeAmount(double exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}


	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "CurrencyServiceBean [id=" + id + ", from=" + from + ", to=" + to + ", exchangeRate=" + exchangeRate
				+ ", exchangeAmount=" + exchangeAmount + ", total=" + total + ", port=" + port + "]";
	}
	
}
