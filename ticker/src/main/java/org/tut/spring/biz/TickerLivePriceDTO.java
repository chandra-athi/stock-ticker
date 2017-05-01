package org.tut.spring.biz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value=Include.NON_NULL)
public class TickerLivePriceDTO {
	
	public TickerLivePriceDTO(TickersDTO ticker){
		if(ticker != null){
			this.symbol = ticker.getSymbol();
			this.livePrice = ticker.getLivePrice();
		}
	}

	private String symbol;
	
	@JsonProperty(value="live-price")
	private float livePrice;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getLivePrice() {
		return livePrice;
	}

	public void setLivePrice(float livePrice) {
		this.livePrice = livePrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TickerLivePriceDTO [symbol=");
		builder.append(symbol);
		builder.append(", livePrice=");
		builder.append(livePrice);
		builder.append("]");
		return builder.toString();
	}
}
