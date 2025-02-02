package com.football.common.exception;

import com.football.common.dto.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler (전역 예외 처리기)
 * 
 * 역할:
 * - 프로젝트 내에서 발생하는 **모든 예외를 통합적으로 처리**
 * - `@RestControllerAdvice`를 사용하여 모든 컨트롤러에서 발생한 예외를 자동 감지
 * 
 * 사용 방법:
 * - 예외 발생 시 일관된 형식의 응답을 반환하도록 설정
 * `CustomException` 처리 예시
 * ```json
 * {
 *     "success": false,
 *     "message": "잘못된 입력값입니다.",
 *     "data": null
 * }
 * ```
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    
	// CustomException 발생 시 공통 응답 처리
    @ExceptionHandler(CustomException.class)
    public CommonResponse<Void> handleCustomException(CustomException ex) {
        return CommonResponse.failure(ex.getErrorCode().getMessage());
    }
    
    // 알 수 없는 예외 처리
    @ExceptionHandler(Exception.class)
    public CommonResponse<Void> handleException(Exception ex) {
        return CommonResponse.failure("알 수 없는 오류가 발생했습니다.");
    }
}
