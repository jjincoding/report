package com.raresoft.weeklyreport.config;

import com.raresoft.weeklyreport.user.UserService;
import com.raresoft.weeklyreport.user.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = (String) authentication.getPrincipal(); // 로그인 창에 입력한 userId
		String password = (String) authentication.getCredentials(); // 로그인 창에 입력한 password
		
		PasswordEncoder passwordEncoder = userService.passwordEncoder();
		UsernamePasswordAuthenticationToken token;
		UserVo userVo = userService.getUserByUserId(userId);
		
		if (userVo != null && passwordEncoder.matches(password, userVo.getUserPwd())) { // 일치하는 user 정보가 있는지 확인
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여

			token = new UsernamePasswordAuthenticationToken(userVo.getId(), null, roles);
			// 인증된 user 정보를 담아 SecurityContextHolder에 저장되는 token
			return token;
		}
		throw new BadCredentialsException("No such user or wrong password");
	}
	
	@Override
	public boolean supports(Class<?> authentication) { // supports 메서드
		return true;
	}
}
