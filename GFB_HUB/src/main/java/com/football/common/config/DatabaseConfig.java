package com.football.common.config;

import com.football.common.utils.AES256Util;
import com.football.common.utils.LoggerUtil;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.slf4j.Logger;

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
	
	private static final Logger Log = LoggerUtil.getLogger(LoggingConfig.class);

	// DB 접속 정보
	private final String tnsAdminPath;
    private static final String DB_URL = "jdbc:oracle:thin:@yoondb_high";
    private static final String DB_USERNAME = "Zpeaw8kaE+WJfJCPa+EMBA==";
    private static final String DB_PASSWORD = "7TDjKRak5Iggt9i5QijErg==";
	
    public DatabaseConfig(Environment env) {
    	/**
    	 * TNS_ADMIN_PATH를 STS에서 못읽어 들이는 문제가 있어서
    	 * .ini 파일에 아래 내용을 추가 해야함.
    	 * 
    	 * -Dspring-boot.run.arguments="--TNS_ADMIN_PATH=%TNS_ADMIN_PATH%"
    	 * 
    	 * 해당 내용은 sts가 실행될 때 OS의 TNS_ADMIN_PATH를 불러오는 설정이다. 
    	 */
        this.tnsAdminPath = env.getProperty("TNS_ADMIN_PATH");
        Log.info("*---------------------------------*");
        Log.info("TNS_ADMIN_PATH : "+env.getProperty("TNS_ADMIN_PATH"));
        Log.info("*---------------------------------*");
        
        if (this.tnsAdminPath == null || this.tnsAdminPath.isEmpty()) {
            throw new IllegalStateException("환경 변수 'TNS_ADMIN_PATH'가 설정되지 않았습니다.");
        }
    }
    
    //AES-256으로 복호화
    private String decrypt(String encryptedText) {
        try {
            return AES256Util.decrypt(encryptedText);
        } catch (Exception e) {
            throw new RuntimeException("암호화된 정보를 복호화하는데 실패했습니다.", e);
        }
    }
    
    
	// DataSource 설정 (TNS_ADMIN 적용)
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setUrl(DB_URL + "?TNS_ADMIN=" + tnsAdminPath);  // TNS_ADMIN 적용
        dataSource.setUsername(decrypt(DB_USERNAME));
        dataSource.setPassword(decrypt(DB_PASSWORD));
        return dataSource;
    }
	
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
