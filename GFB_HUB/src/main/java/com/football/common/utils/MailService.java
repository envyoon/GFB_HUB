package com.football.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	private static final Logger Log = LoggerFactory.getLogger(MailService.class);
    private final JavaMailSender mailSender;
    
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 이메일 전송 메서드
     */
    public void sendEmail(String to, String subject, String text) {
        try {
        	Log.info("/-------------------------/");
        	Log.info("✅ 이메일 전송 시작: " + to);
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(new InternetAddress(AES256Util.decrypt("C85J4aGpp2uYft7PI5vsem2HrUOXyDA6HHVVy3cuxeA="), "Global Football Hub", "UTF-8"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);

            mailSender.send(message);
            Log.info("✅ 이메일 전송 완료: " + to);
            Log.info("/-------------------------/");
        } catch (Exception e) {
        	Log.error("❌ 이메일 전송 실패 : " +e);
            throw new RuntimeException("❌ 이메일 전송 실패", e);
        }
    }
}
