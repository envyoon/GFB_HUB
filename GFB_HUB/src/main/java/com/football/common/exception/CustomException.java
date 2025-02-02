package com.football.common.exception;

import lombok.Getter;

/**
 * CustomException (사용자 정의 예외 클래스)
 * 
 * 역할:
 * - 프로젝트 내에서 공통적으로 사용할 **커스텀 예외**를 정의
 * - `ErrorCode`를 통해 **일관된 예외 메시지를 반환**
 * 
 * 사용 방법:
 * 특정 조건에서 예외 발생시키기
 * ```java
 * if (data == null) {
 *     throw new CustomException(ErrorCode.ENTITY_NOT_FOUND);
 * }
 * ```
 */

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() { 
        return errorCode;
    }
    
    // 테스트 코드
    public static void main(String[] args) {
        try {
            throw new CustomException(ErrorCode.INVALID_INPUT_VALUE);
        } catch (CustomException e) {
            System.out.println("🚨 예외 발생: " + e.getMessage());
            System.out.println("🚨 에러 코드: " + e.getErrorCode());
        }
    }
}
