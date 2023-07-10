package com.raresoft.weeklyreport.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	void insertUser(UserVo userVo); // 회원가입
	UserVo getUserByUserId(String userId); // 사용자 정보
	UserVo getUserById(Long id);
}