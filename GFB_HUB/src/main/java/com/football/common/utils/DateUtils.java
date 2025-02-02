package com.football.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateUtil (날짜 관련 유틸리티)
 * 
 * 역할:
 * - 날짜 및 시간과 관련된 공통 기능 제공
 * - 현재 날짜/시간 가져오기, 포맷 변환 등 지원
 * 
 * 사용 방법:
 * 현재 날짜/시간 가져오기
 * ```java
 * String now = DateUtil.getCurrentDateTime();
 * System.out.println(now);  // "2025-02-02 23:05:30"
 * ```
 */

public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }

    public static LocalDateTime parse(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, FORMATTER);
    }
    
    // 현재 날짜 및 시간을 포맷된 문자열로 반환
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(FORMATTER);
    }
    
    public static void main(String[] args) {
    	String now = DateUtils.getCurrentDateTime();
    	
    	System.out.println(now);
    }
}
