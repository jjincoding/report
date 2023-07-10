package com.raresoft.weeklyreport.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	// BCryptPasswordEncoder : BCrypt 해시 함수를 이용하여 패스워드를 암호화하는 구현체
	
	public UserVo getUserById(Long id) {
		return userMapper.getUserById(id);
	}
	
	public UserVo getUserByUserId(String userId) {
		return userMapper.getUserByUserId(userId);
	}
	
	public void signup(UserVo userVo) { // 회원가입
		if (!userVo.getUserName().equals("") && !userVo.getUserId().equals("")) {
			// password는 암호화해서 DB 저장
			userVo.setUserPwd(passwordEncoder.encode(userVo.getUserPwd()));
			userMapper.insertUser(userVo);
		}
	}
	
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}
}