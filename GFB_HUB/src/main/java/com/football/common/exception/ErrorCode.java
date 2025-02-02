package com.football.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ErrorCode (에러 코드 정의 클래스)
 * 
 * 역할:
 * - 프로젝트에서 발생할 수 있는 **공통적인 예외 코드**를 정의
 * - 예외 발생 시 **일관된 메시지를 제공**하여 관리가 용이함
 * 
 * 사용 방법:
 * 특정 에러 발생 시 예외 던지기
 * ```java
 * throw new CustomException(ErrorCode.INVALID_INPUT_VALUE);
 * ```
 */

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE("잘못된 입력값입니다."),
    ENTITY_NOT_FOUND("데이터를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR("서버 내부 오류입니다.");

	private final String message; // 필드 추가

    public String getMessage() {  // getter 추가
        return message;
    }

    // 생성자 추가
    ErrorCode(String message) {
        this.message = message;
    }
    
    // 테스트 코드
    public static void main(String[] args) {
        System.out.println("🔴 " + ErrorCode.INVALID_INPUT_VALUE.getMessage());
        System.out.println("🔴 " + ErrorCode.ENTITY_NOT_FOUND.getMessage());
        System.out.println("🔴 " + ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
    }
}
