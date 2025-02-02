package com.football.common.utils;

/**
 * StringUtils (문자열 유틸리티)
 * 
 * 역할:
 * - 문자열 관련 공통 유틸리티 메서드 제공
 * - `isEmpty`: 문자열이 `null`이거나 빈 문자열인지 확인
 * - `isNotEmpty`: 문자열이 `null`이 아니고 빈 문자열이 아닌지 확인
 * - `capitalize`: 첫 글자를 대문자로 변환
 * 
 * 사용 방법:
 * 문자열이 비어 있는지 확인
 * ```java
 * boolean emptyCheck = StringUtils.isEmpty(null);  // true
 * boolean notEmptyCheck = StringUtils.isNotEmpty("hello");  // true
 * ```
 * 첫 글자를 대문자로 변환
 * ```java
 * String capitalized = StringUtils.capitalize("hello");  // "Hello"
 * ```
 */
public class StringUtils {

    // 문자열이 null이거나 빈 문자열인지 확인
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // 문자열이 null이 아니고 빈 문자열이 아닌지 확인
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    // 문자열의 첫 글자를 대문자로 변환
    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    // 테스트 코드
    public static void main(String[] args) {
        System.out.println("✅ isEmpty(\"\"): " + isEmpty(""));
        System.out.println("✅ isEmpty(\" \"): " + isEmpty(" "));
        System.out.println("✅ isNotEmpty(\"Hello\"): " + isNotEmpty("Hello"));
    }
}