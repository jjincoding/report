package com.raresoft.weeklyreport.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserVo {
	private Long id; //
	private String userId; //
	private String userName; //
	private String userPwd; //
	private Short teamCode; //
	private String roleCode; //
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Short getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(Short teamCode) {
		this.teamCode = teamCode;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", teamCode=" + teamCode + ", roleCode=" + roleCode + "]";
	}
	
}