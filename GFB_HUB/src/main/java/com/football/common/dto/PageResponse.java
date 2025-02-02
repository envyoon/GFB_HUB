package com.football.common.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * PageResponse (페이징 응답 DTO)
 * 
 * 역할:
 * - Spring Data JPA의 `Page<T>` 객체를 기반으로 페이징 응답을 생성하는 DTO
 * - `content`: 현재 페이지의 데이터 리스트
 * - `page`: 현재 페이지 번호 (0부터 시작)
 * - `size`: 한 페이지에 포함된 데이터 개수
 * - `totalElements`: 전체 데이터 개수
 * - `totalPages`: 전체 페이지 수
 * 
 * 사용 방법:
 * 컨트롤러에서 페이징된 데이터를 응답으로 반환
 * ```java
 * Page<TestEntity> testPage = testRepository.findAll(PageRequest.of(0, 10));
 * return new PageResponse<>(testPage);
 * ```
 * 
 * 프론트엔드에서 API 응답 예시:
 * ```json
 * {
 *   "content": [...],
 *   "page": 0,
 *   "size": 10,
 *   "totalElements": 100,
 *   "totalPages": 10
 * }
 * ```
 */
@Getter
public class PageResponse<T> {
    private final List<T> content; // 현재 페이지의 데이터 목록
    private final int page; // 현재 페이지 번호 (0부터 시작)
    private final int size; // 한 페이지의 데이터 개수
    private final long totalElements; // 전체 데이터 개수
    private final int totalPages; // 전체 페이지 수

    // Page 객체를 받아서 PageResponse 객체로 변환하는 생성자
    public PageResponse(Page<T> page) {
        this.content = page.getContent();
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
    
}
