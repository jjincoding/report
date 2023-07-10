<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
	<h2>${user.userName}님 환영합니다</h2>
	
	<p>name: ${user.userName}</p>
	<p>id: ${user.userId}</p>
	
	<form action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit">로그아웃</button>
		<button type="button" onclick="location.href='listPage'">목록으로</button>
	</form>
</body>
</html>