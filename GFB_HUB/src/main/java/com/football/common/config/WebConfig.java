package com.football.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * WebConfig (웹 설정 클래스)
 * 
 * 역할:
 * - CORS(Cross-Origin Resource Sharing) 설정
 * - 다른 도메인의 프론트엔드에서 백엔드 API를 호출할 수 있도록 허용
 * 
 * 사용 방법:
 * - 모든 경로에서 CORS 요청을 허용 (`*` 설정을 변경하면 특정 도메인만 허용 가능)
 * - 예제:
 * ```java
 * @RestController
 * public class TestController {
 *     @GetMapping("/test")
 *     public String test() {
 *         return "CORS 테스트 성공!";
 *     }
 * }
 * ```
 * - 클라이언트에서 `fetch('http://localhost:8080/test')` 요청 가능
 */


@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
