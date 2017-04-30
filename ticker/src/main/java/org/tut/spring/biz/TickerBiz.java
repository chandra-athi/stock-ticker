package org.tut.spring.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.tut.spring.ManageEmitters;

@Component
public class TickerBiz {
	
	@Autowired
	ManageEmitters manageEmitters;
	
	List<TickersDTO> tickers = new ArrayList<TickersDTO>();
	
	public TickerBiz(){
		generateHardcodedTickers();	
	}

	public List<TickersDTO> fetchTickersForUser(String userId){
//		TODO: to be managed via users
		return tickers;
	}
	
	public SseEmitter fetchUpdates(){
		return manageEmitters.generateEmitter(tickers);
	}
	
	
	void generateHardcodedTickers(){
		
		TickersDTO ticker = new TickersDTO();
		ticker.setSymbol("CTSH");
		ticker.setCompany("Cognizant Technology Solutions");
		ticker.setLivePrice(1100.2f);
		ticker.setClosingPrice(1000);
		tickers.add(ticker);
		
		ticker = new TickersDTO();
		ticker.setSymbol("RNRL");
		ticker.setCompany("Reliance Natural Resources Limited");
		ticker.setLivePrice(2500.0f);
		ticker.setClosingPrice(2200);
		tickers.add(ticker);
		
	}

	
}
