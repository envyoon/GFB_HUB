package com.football.domain.test.mapper;

import com.football.domain.test.dto.TestRequestDto;
import com.football.domain.test.dto.TestResponseDto;

import java.util.List;

public interface TestMapper {
    List<TestResponseDto> findAll();
    TestResponseDto findById(Long id);
    void insertTest(TestRequestDto testDto);
    void deleteTest(Long id);
    void updateTest(TestRequestDto testDto);
}
