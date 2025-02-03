package com.football.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * DatabaseConfig (데이터베이스 설정 클래스)
 * 
 * 역할:
 * - MyBatis의 Mapper 인터페이스를 자동으로 스캔하여 빈(Bean)으로 등록
 * - `com.football.domain` 패키지 내의 모든 MyBatis Mapper를 감지
 * - SqlSessionFactory 및 SqlSessionTemplate을 설정하여 MyBatis가 정상 동작하도록 보장
 */

@Configuration
@MapperScan(basePackages = "com.football.domain") // MyBatis Mapper 스캔
public class DatabaseConfig {

    // MyBatis의 SqlSessionFactory 설정
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        
        factoryBean.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml")
        );
        
        return factoryBean.getObject();
    }

    // MyBatis의 SqlSessionTemplate 설정 (필수)
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
