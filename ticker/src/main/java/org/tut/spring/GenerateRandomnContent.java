package org.tut.spring;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.tut.spring.biz.TickerBiz;
import org.tut.spring.biz.TickersDTO;

@EnableScheduling
@Configuration
public class GenerateRandomnContent {
	
	@Autowired
	TickerBiz tickerBiz;
	
	@Autowired
	ManageEmitters manageEmitters;
	
	Random random = new Random();
	
	@Scheduled(fixedRate=1000)
	public void scheduler() throws IOException{
		float randomnFloat = 0;
		List<TickersDTO> tickers = tickerBiz.fetchTickersForUser("chandru");
		TickersDTO randomnTicker = tickers.get(random.nextInt(tickers.size()));
		randomnFloat = random.nextInt(2)>0 ? random.nextInt(100)+random.nextFloat()
				: -(random.nextInt(100)+random.nextFloat());
		randomnTicker.setLivePrice(randomnTicker.getLivePrice()+randomnFloat);
		manageEmitters.updateClient(randomnTicker);
	}
}
