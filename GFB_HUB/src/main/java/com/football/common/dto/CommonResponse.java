package com.football.common.dto;

import lombok.Getter;

/**
 * CommonResponse (공통 응답 DTO)
 * 
 * 역할:
 * - API의 응답을 일관된 형식으로 제공
 * - `success`: 요청 성공 여부
 * - `message`: 응답 메시지
 * - `data`: 응답 데이터 (제네릭 타입)
 * 
 * 사용 방법:
 * 성공 응답
 * ```java
 * return CommonResponse.success(new TestDto("테스트 데이터"));
 * ```
 * 실패 응답
 * ```java
 * return CommonResponse.failure("잘못된 요청입니다.");
 * ```
 */

@Getter
public class CommonResponse<T> {
    private final boolean success;
    private final String message;
    private final T data;

    private CommonResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    
    // 성공 응답을 반환하는 정적 메서드
    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(true, "요청이 성공했습니다.", data);
    }
    
    // 실패 응답을 반환하는 정적 메서드
    public static <T> CommonResponse<T> failure(String message) {
        return new CommonResponse<>(false, message, null);
    }
    
    // 테스트 코드
    public static void main(String[] args) {
        CommonResponse<String> successResponse = CommonResponse.success("테스트 성공!");
        CommonResponse<String> failureResponse = CommonResponse.failure("테스트 실패");

        System.out.println("✅ 성공 응답: " + successResponse);
        System.out.println("❌ 실패 응답: " + failureResponse);
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
