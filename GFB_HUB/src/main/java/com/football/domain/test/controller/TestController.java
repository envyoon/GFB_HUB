package com.football.domain.test.controller;

import com.football.common.dto.CommonResponse;
import com.football.domain.test.dto.TestRequestDto;
import com.football.domain.test.dto.TestResponseDto;
import com.football.domain.test.service.TestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Test API", description = "테스트 관련 API")
@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    
    
    // Get 요청 테스트(전체) - http://localhost:8080/api/tests
    @Operation(summary = "모든 테스트 데이터 조회", description = "DB에 저장된 모든 테스트 데이터를 조회합니다.")
    @GetMapping
    public CommonResponse<List<TestResponseDto>> getAllTests() {
        return CommonResponse.success(testService.getAllTests());
    }
    
    // Get 요청 테스트(단건) - http://localhost:8080/api/tests/{id}
    @Operation(summary = "특정 테스트 데이터 조회", description = "ID를 이용하여 특정 테스트 데이터를 조회합니다.")
    @GetMapping("/{id}")
    public CommonResponse<TestResponseDto> getTestById(@PathVariable("id") Long id) {
        return CommonResponse.success(testService.getTestById(id));
    }
    
    // Get 요청 테스트 - http://localhost:8080/api/tests
    // Body (JSON) { "name" : "테스트 데이터 "}
    @Operation(summary = "테스트 데이터 추가", description = "새로운 테스트 데이터를 DB에 추가합니다.")
    @PostMapping
    public CommonResponse<Long> createTest(@RequestBody TestRequestDto testDto) {
        testService.createTest(testDto);
        return CommonResponse.success(null);
    }
    
    // Delete 요청 테스트 - http://localhost:8080/api/tests/{id}
    @Operation(summary = "테스트 데이터 삭제", description = "ID를 이용하여 특정 테스트 데이터를 삭제합니다.")
    @DeleteMapping("/{id}")
    public CommonResponse<Void> deleteTest(@PathVariable("id") Long id) {
        testService.deleteTest(id);
        return CommonResponse.success(null);
    }
    
    // Put 요청 테스트 - http://localhost:8080/api/tests/{id}
    // Body (JSON) { "name" : "변경된 테스트 데이터 "}
    @Operation(summary = "테스트 데이터 수정", description = "ID를 이용하여 특정 테스트 데이터를 수정합니다.")
    @PutMapping("/{id}")
    public CommonResponse<Void> updateTest(@PathVariable("id") Long id, @RequestBody TestRequestDto testDto) {
        testService.updateTest(id, testDto);
        return CommonResponse.success(null);
    }
}
