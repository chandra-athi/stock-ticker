package org.tut.spring;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.tut.spring.biz.TickerBiz;
import org.tut.spring.biz.TickersDTO;

@RestController
public class TickerController {

	@Autowired
	TickerBiz tickerBiz;
	
	
	@GetMapping(path="users/{user-id}/stocks")
	public List<TickersDTO> fetchStocks(@PathVariable(name="user-id") String userId){
		return tickerBiz.fetchTickersForUser(userId);
	}
	
	@GetMapping(path="users/{user-id}/updates")
	public SseEmitter emitter(
			@PathVariable(name="user-id") String userId
			) throws IOException{
		return tickerBiz.fetchUpdates();
	}
	
}
