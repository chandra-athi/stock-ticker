package org.tut.spring;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.tut.spring.biz.TickerLivePriceDTO;
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
		for(int i=0;i< ticker.getEmitter().size(); i++){
			SseEmitter emitter = ticker.getEmitter().get(i);
			try{
				emitter.send(new TickerLivePriceDTO(ticker)
				, MediaType.APPLICATION_JSON);
			}catch(IOException io){
				io.printStackTrace();
				synchronized (ticker.getEmitter()) {
					try{
						ticker.getEmitter().remove(emitter);
						--i;
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}catch(Exception e){
				synchronized (ticker.getEmitter()) {
					ticker.getEmitter().remove(emitter);
				}
				e.printStackTrace();
				--i;
			}
		}
	}
	
}
