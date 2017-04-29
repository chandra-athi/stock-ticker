package org.tut.spring.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TickerBiz {

	public List<TickersDTO> fetchTickersForUser(String userId){
		return generateHardcodedTickers();
	}
	
	
	List<TickersDTO> generateHardcodedTickers(){
		List<TickersDTO> tickers = new ArrayList<TickersDTO>();
		TickersDTO ticker = new TickersDTO();
		ticker.setSymbol("CTSH");
		ticker.setCompany("Cognizant Technology Solutions");
		ticker.setLivePrice(1100.2f);
		ticker.setClosingPrice(1000);
		tickers.add(ticker);
		return tickers;
	}

	
}
