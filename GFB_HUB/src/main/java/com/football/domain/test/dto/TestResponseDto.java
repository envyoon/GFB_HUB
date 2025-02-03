package com.football.domain.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TestResponseDto {
    private Long id;
    private String name;
    private LocalDateTime createdAt;  
}
