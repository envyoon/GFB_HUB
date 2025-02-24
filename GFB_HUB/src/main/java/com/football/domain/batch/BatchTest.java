package com.football.domain.batch;

import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.football.common.config.LoggingConfig;
import com.football.common.utils.LoggerUtil;

import java.time.*;
import java.time.format.DateTimeFormatter;

@SpringBootApplication(scanBasePackages = "com.football")
@EnableScheduling // 스케쥴링 기능 활성화
public class BatchTest {
	
	private static final Logger Log = LoggerUtil.getLogger(LoggingConfig.class);
    
	/**
	 *	Spring 에 내장되어 있는 @Scheduled 을 사용하여 cron 시간 설정으로 스케줄링진행
	 *	사용법 : public void 테스크명() {}
	 *	{} 내부에 실행시켜야 할 작업을 명시 해 준다.
	 */
    @Scheduled(cron = "0 * * * * *")
    public void testTask() {
    	
    	LocalTime now = LocalTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
    	String formatedNow = now.format(formatter);
    		
    	Log.info("1분마다 자동 실행됨. 현재 시각 : "+formatedNow);
    	
    	
    }
    
    
    // 최종 정보를 메일로 전송해 주는 로직
    public void sendMail() {
    	
    }
    
    // 팀 순위를 가져와서 DB에 저장하는 로직
    public void getMatchRank() {
    	
    }
    
    // 팀 정보를 가져와서 DB에 저장하는 로직
    public void getTeamInfo() {
    	
    }
    
}
