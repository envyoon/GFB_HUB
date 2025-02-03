package com.football.domain.test.controller;

import com.football.common.dto.CommonResponse;
import com.football.domain.test.dto.TestRequestDto;
import com.football.domain.test.dto.TestResponseDto;
import com.football.domain.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    
    
    // Get 요청 테스트(전체) - http://localhost:8080/api/tests
    @GetMapping
    public CommonResponse<List<TestResponseDto>> getAllTests() {
        return CommonResponse.success(testService.getAllTests());
    }
    
    // Get 요청 테스트(단건) - http://localhost:8080/api/tests/{id}
    @GetMapping("/{id}")
    public CommonResponse<TestResponseDto> getTestById(@PathVariable("id") Long id) {
        return CommonResponse.success(testService.getTestById(id));
    }
    
    // Get 요청 테스트 - http://localhost:8080/api/tests
    // Body (JSON) { "name" : "테스트 데이터 "}
    @PostMapping
    public CommonResponse<Long> createTest(@RequestBody TestRequestDto testDto) {
        testService.createTest(testDto);
        return CommonResponse.success(null);
    }
    
    // Delete 요청 테스트 - http://localhost:8080/api/tests/{id}
    @DeleteMapping("/{id}")
    public CommonResponse<Void> deleteTest(@PathVariable("id") Long id) {
        testService.deleteTest(id);
        return CommonResponse.success(null);
    }
    
    // Put 요청 테스트 - http://localhost:8080/api/tests/{id}
    // Body (JSON) { "name" : "변경된 테스트 데이터 "}
    @PutMapping("/{id}")
    public CommonResponse<Void> updateTest(@PathVariable("id") Long id, @RequestBody TestRequestDto testDto) {
        testService.updateTest(id, testDto);
        return CommonResponse.success(null);
    }
}
