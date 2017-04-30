package org.tut.spring;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.tut.spring.biz.TickersDTO;

@Component
public class ManageEmitters {

	public SseEmitter generateEmitter(List<TickersDTO> tickers){
		SseEmitter sseEmitter = new SseEmitter(3600 * 1000L);
		tickers.forEach(ticker -> {
			ticker.getEmitter().add(sseEmitter);
		});
		return sseEmitter;
		
	}
	
	public void updateClient(TickersDTO ticker){
		ticker.getEmitter().forEach(emitter->{
			try{
				emitter.send("{\"live-price\":"+ticker.getLivePrice()+"}"
//				TODO: check why strig to json conversion is not working  
						, MediaType.APPLICATION_JSON);
				
			}catch(IOException io){
				io.printStackTrace();
				try{
				ticker.getEmitter().remove(emitter);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
