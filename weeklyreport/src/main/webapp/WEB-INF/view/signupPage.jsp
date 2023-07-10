<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sign Up</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="/signup" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		<div>
			<input type="text" name="userName" placeholder="이름을 입력해주세요" />
		</div>
		<div>
			<input type="text" name="userId" placeholder="아이디를 입력해주세요" />
		</div>
		<div>
			<input type="password" name="userPwd" placeholder="비밀번호를 입력해주세요" />
		</div>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>