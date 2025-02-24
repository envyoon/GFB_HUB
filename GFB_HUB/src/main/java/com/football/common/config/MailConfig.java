package com.football.common.config;

import com.football.common.utils.AES256Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@Configuration
public class MailConfig {
	
	private static final Logger Log = LoggerFactory.getLogger(MailConfig.class);
	
    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        
        try {
        	Log.info("/-------------------------/");
        	Log.info("✅ 이메일 설정 로드 시작");
	        mailSender.setHost("smtp.naver.com");
	        mailSender.setPort(465);
	        mailSender.setUsername(AES256Util.decrypt("C85J4aGpp2uYft7PI5vsem2HrUOXyDA6HHVVy3cuxeA=")); 
	        mailSender.setPassword(AES256Util.decrypt("ShwIdN8RIbIfHnwBbQJASg==")); 
	
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.starttls.required", "true");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.ssl.enable", "true");
        
	        Log.info("✅ 이메일 설정 로드 완료");
	        Log.info("/-------------------------/");
        }
        catch (Exception e) {
        	Log.error("❌ 메일 정보 가져오는 부분에서 오류 발생 : "+e);
		}
        
        return mailSender;
    }
    
}
