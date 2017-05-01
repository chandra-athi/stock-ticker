package org.tut.spring.biz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value=Include.NON_NULL)
public class TickersDTO implements Serializable{

	private static final long serialVersionUID = 2029042474118763272L;

	private String symbol;
	
	private String company;
	
	@JsonProperty(value="live-price")
	private float livePrice;
	
	@JsonProperty(value="closing-price")
	private float closingPrice;
	
	@JsonIgnore(value=true)
	private List<SseEmitter> emitter = new ArrayList<SseEmitter>();

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
	
	public List<SseEmitter> getEmitter() {
		return emitter;
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
