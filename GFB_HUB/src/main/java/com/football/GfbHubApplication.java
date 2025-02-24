package com.football;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.football.common.utils.MailService;


@SpringBootApplication
public class GfbHubApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(MailService.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GfbHubApplication.class, args);
	}

}
