package com.football.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    private static final Logger Log = LoggerFactory.getLogger(LoggingConfig.class);

    public LoggingConfig() {
        Log.info("✅ LoggingConfig Initialized! (로깅 설정 초기화 완료)");
        Log.debug("🔍 DEBUG: LoggingConfig 로드됨");
        Log.warn("⚠ WARNING: 로그 설정 확인 필요");
    }
}