package org.tut.spring.biz;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TickersDTO {

	private String symbol;
	
	private String company;
	
	@JsonProperty(value="live-price")
	private float livePrice;
	
	@JsonProperty(value="closing-price")
	private float closingPrice;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public float getLivePrice() {
		return livePrice;
	}

	public void setLivePrice(float livePrice) {
		this.livePrice = livePrice;
	}

	public float getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(float closingPrice) {
		this.closingPrice = closingPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TickersDTO [symbol=");
		builder.append(symbol);
		builder.append(", company=");
		builder.append(company);
		builder.append(", livePrice=");
		builder.append(livePrice);
		builder.append(", closingPrice=");
		builder.append(closingPrice);
		builder.append("]");
		return builder.toString();
	}
	
}
