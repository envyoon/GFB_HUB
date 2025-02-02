package com.football.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * DatabaseConfig (데이터베이스 설정 클래스)
 * 
 * 역할:
 * - MyBatis의 Mapper 인터페이스를 자동으로 스캔하여 빈(Bean)으로 등록
 * - `com.football.domain.mapper` 패키지 내의 모든 MyBatis Mapper를 감지
 * 
 * 사용 방법:
 * - 프로젝트 내에서 `@Mapper`를 붙여 MyBatis Mapper를 생성하면 자동으로 빈으로 등록됨
 * - 추가적인 설정 없이도 MyBatis 매퍼가 정상적으로 동작하도록 보장함
 */


@Configuration
@MapperScan(basePackages = "com.football.domain.mapper") // MyBatis Mapper 스캔
//@EnableJpaRepositories(basePackages = "com.football.domain") // JPA 설정
public class DatabaseConfig {
	
}
