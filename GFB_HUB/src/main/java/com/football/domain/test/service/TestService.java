package com.football.domain.test.service;

import com.football.domain.test.dto.TestRequestDto;
import com.football.domain.test.dto.TestResponseDto;
import com.football.domain.test.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestMapper testMapper;

    public List<TestResponseDto> getAllTests() {
        return testMapper.findAll();
    }

    public TestResponseDto getTestById(Long id) {
        return testMapper.findById(id);
    }

    public void createTest(TestRequestDto testDto) {
        testMapper.insertTest(testDto);
    }

    public void deleteTest(Long id) {
        testMapper.deleteTest(id);
    }
    
    public void updateTest(Long id, TestRequestDto testDto) {
        testDto.setId(id); 
        testMapper.updateTest(testDto);
    }
}
