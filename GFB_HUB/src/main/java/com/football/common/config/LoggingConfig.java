//package com.football.common.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class LoggingConfig {
//
//    // 기본 로거 생성 (SLF4J + Logback 사용)
//    private static final Logger Log = LoggerFactory.getLogger(LoggingConfig.class);
//
//    @Bean
//    public Logger logger() {
//        Log.info("✅ LoggingConfig Initialized!");  // 초기화 로그
//        return Log;
//    }
//}

package com.football.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    private static final Logger Log = LoggerFactory.getLogger(LoggingConfig.class);

    public LoggingConfig() {
        Log.info("✅ LoggingConfig Initialized!");
    }
}
