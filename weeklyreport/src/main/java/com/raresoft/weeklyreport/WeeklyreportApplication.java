package com.raresoft.weeklyreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// main 메소드를 가진 실행 파일

@SpringBootApplication
// 이 클래스가 스프링 부트로 만든 애플리케이션의 시작 클래스임을 의미
public class WeeklyreportApplication {

	public static void main(String[] args) { 
		SpringApplication.run(WeeklyreportApplication.class, args);
	}
}
