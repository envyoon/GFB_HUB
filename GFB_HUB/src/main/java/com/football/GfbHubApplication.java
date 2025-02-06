package com.football;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GfbHubApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(GfbHubApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GfbHubApplication.class, args);
	}

}
