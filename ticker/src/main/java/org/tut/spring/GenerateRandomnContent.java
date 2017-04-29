package org.tut.spring;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class GenerateRandomnContent {
	
	@Autowired
	TickerController tickerController;

	@Scheduled(fixedRate=50)
	public void scheduler() throws IOException{
		tickerController.sendMessage();
	}
}
