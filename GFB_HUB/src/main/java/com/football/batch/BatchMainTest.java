package com.football.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.football")
public class BatchMainTest {

    private static final Logger Log = LoggerFactory.getLogger(BatchMainTest.class);

    public static void main(String[] args) {
        // 1️⃣ Spring Boot 컨텍스트 실행
    	Log.info("main 문 시작");
        ApplicationContext context = SpringApplication.run(BatchMainTest.class, args);
        Log.info("🚀 [BatchMainTest] Spring Boot Context 초기화 완료");

        // 2️⃣ 필요한 Bean 가져오기
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job testJob = context.getBean("testJob", Job.class);  // testJob은 TestJobConfig의 Job 이름

        try {
            // 3️⃣ 배치 파라미터 설정 (재실행 시 중복 방지용 시간 추가)
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            // 4️⃣ 배치 실행
            Log.info("✅ [BatchMainTest] testJob 실행 시작");
            JobExecution jobExecution = jobLauncher.run(testJob, jobParameters);
            Log.info("✅ [BatchMainTest] testJob 실행 종료: 상태 = {}", jobExecution.getStatus());
        } catch (Exception e) {
            Log.error("❌ [BatchMainTest] 배치 실행 중 오류 발생: {}", e.getMessage(), e);
        } finally {
            // 5️⃣ 컨텍스트 종료
            if (context instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) context).close();
                    Log.info("🛑 Spring Boot 컨텍스트 종료 완료");
                } catch (Exception e) {
                    Log.error("🚨 Spring Boot 컨텍스트 종료 실패", e);
                }
            }
        }

        // 6️⃣ 프로그램 종료
        System.exit(0);
    }
}
