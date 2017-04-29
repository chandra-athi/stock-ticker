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
	
	SseEmitter sse = new SseEmitter(60 * 1000L);
	
	public void sendMessage() throws IOException{
		sse.send("new message"+Math.random());
	}
	
	@GetMapping(path="users/{user-id}/stocks")
	public List<TickersDTO> fetchStocks(@PathVariable(name="user-id") String userId){
		return tickerBiz.fetchTickersForUser(userId);
	}
	
//	@PostMapping(path="sse")
//	public SseEmitter emitter(@RequestBody List<String> tickerSymbols) throws IOException{
//		sse = new SseEmitter(60 * 1000L);
//		sse.send(new String("dude"));
//		return sse;
//	}
	
	@GetMapping(path="sse")
	public SseEmitter emitter() throws IOException{
		sse = new SseEmitter(60 * 1000L);
		sse.send(new String("dude"));
		return sse;
	}
	
}
