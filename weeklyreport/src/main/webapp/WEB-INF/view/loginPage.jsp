<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
</head>
<body>
	<form action="/auth" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<!--
		CSRF 토큰은 실제 서버에서 요청이 맞는지 확인하기 위한 토큰
		사용자의 세션에 임의의 값을 저장해서 요청마다 그 값을 포함해서 전송하면
		서버에서 세션에 저장된 값과 요청이 온 값이 일치하는지 확인해서 CSRF 공격을 방어함 
		 -->
		<h2>로그인</h2>
			<div>
				<input type="text" name="userId" placeholder="Id" />
			</div>
			<div>
				<input type="password" name="userPwd" placeholder="Password" />
			</div>
			
			<button type="submit">로그인</button>
			<button type="button" onclick="location.href='signup'">회원가입</button>
	</form>
</body>
</html>