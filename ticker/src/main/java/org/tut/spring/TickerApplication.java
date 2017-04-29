package org.tut.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TickerApplication extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reourceHanderRegistry){
		if(!reourceHanderRegistry.hasMappingForPattern("/**")){
			reourceHanderRegistry.addResourceHandler("/**")
			.addResourceLocations("classpath:/static/");
		}
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TickerApplication.class, args);
		
	}
}
