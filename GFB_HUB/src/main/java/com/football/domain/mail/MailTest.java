package com.football.domain.mail;

import com.football.common.config.LoggingConfig;
import com.football.common.utils.LoggerUtil;
import com.football.common.utils.MailService;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.football")
public class MailTest {
	
	private static final Logger Log = LoggerUtil.getLogger(LoggingConfig.class);
	
    public static void main(String[] args) {
        // Spring Boot 컨텍스트 로드
        ApplicationContext context = SpringApplication.run(MailTest.class, args);
        MailService mailService = context.getBean(MailService.class);

        // 메일 전송 테스트
        String recipient = "krafftdj@daum.net";
        String subject = "테스트 이메일 전송";
        String content = "<h1>테스트 메일입니다.</h1><p>이메일이 잘 가나요?</p>";
        
        try {
        	
        	
        	Log.info("/-------------------------/");
            Log.info("✅ 메일 전송 시작");
            //mailService.sendEmail(recipient, subject, content);
            Log.info("✅ 메일 전송 완료");
            Log.info("/-------------------------/");
        }catch(Exception e) {
        	System.out.println("오류");
        	Log.error("오류 발생 : "+e);
        }finally {
            // 컨텍스트 종료
            if (context instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) context).close();
                    Log.info("🛑 Spring Boot 컨텍스트 종료 완료");
                } catch (Exception e) {
                    Log.error("🚨 Spring Boot 컨텍스트 종료 실패", e);
                }
            }
        }
        
        
        System.exit(0);
        
    }
}

