package com.football.common.config;

import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

import com.football.common.utils.LoggerUtil;

@Configuration
public class LoggingConfig {
	
	private static final Logger Log = LoggerUtil.getLogger(LoggingConfig.class);

    public LoggingConfig() {
        Log.info("✅ LoggingConfig Initialized! (로깅 설정 초기화 완료)");
        Log.debug("🔍 DEBUG: LoggingConfig 로드됨");
        Log.warn("⚠ WARNING: 로그 설정 확인 필요");
    }
}