package com.football.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger를 공통으로 제공하는 유틸리티 클래스
 */
public class LoggerUtil {

    /**
     * 모든 클래스에서 공통으로 사용할 Logger를 반환하는 메서드
     *
     * @param clazz 로그를 사용하려는 클래스
     * @return Logger 인스턴스
     */
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
