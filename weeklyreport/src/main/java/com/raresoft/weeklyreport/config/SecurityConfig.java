package com.raresoft.weeklyreport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 권한에 따라 허용하는 url 설정
		// /login, /signup 페이지는 모두 허용, 다른 페이지는 인증된 사용자만 허용
		http
			.authorizeRequests() // 인가 요청 받기
			.antMatchers("/login", "/signup").permitAll()
			.anyRequest().authenticated();
		
	// login 설정
		http
			.formLogin() // Form 로그인 인증 기능이 작동
			// .loginPage("/login") // GET 요청 (login form을 보여줌) // 사용자 정의 로그인 페이지
			.loginProcessingUrl("/auth") // POST 요청 (login 창에 입력한 데이터 처리)
			.usernameParameter("userId") // login에 필요한 id 값을 userId로 설정 (default는 username)
			.passwordParameter("userPwd") // login에 필요한 password 값을 userPwd로 설정 (default는 password)
			.defaultSuccessUrl("/"); // login에 성공하면 /로 redirect
	
	// logout 설정
		http
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/"); // logout에 성공하면 /로 redirect
		
		return http.build();
	}

}