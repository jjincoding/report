<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 목록</title>
</head>
<form action="regist" method="get">
<body>
	<%-- <table border="1" width="880">
		<tr>
		<td width="77">
			<p align="center">글 번호</p>
		</td>
		<td width="327">
			<p align="center">제목</p>
		</td>
		<td width="197">
			<p align="center">작성자</p>
		</td>
		<td width="155">
			<p align="center">작성일</p>
		</td>
		<td width="90">
			<p align="center">수정일</p>
		</td>
		</tr>
		
		<c:forEach items="${list }" var="boardVO">
		<tr>
			<td>${boardVO.bno }</td>
			<td><a href='/read?bno=${boardVO.bno }'>${boardVO.title }</a></td>
			<td>${boardVO.writer }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${boardVO.regdate }" /></td>
			<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
			</tr>
		</c:forEach>
	</table>
	<button type="submit">글쓰기</button> --%>
	
	<div class="content">
		<section>
			<!-- 검색 -->
			<div class="search_box">
				<form id="searchForm" autocomplete="off">
					<div class="sch_group fl">
						<select title="검색 유형 선택">
							<option value="">전체 검색</option>
							<option value="">내용</option>
							<option value="">소속 부서</option>
							<option value="">작성자</option>
						</select>
						<input type="text" placeholder="검색 항목을 입력해 주세요" title="키워드 입력" />
						<button type="button" class="bt_search"><i class="fas fa-search"></i><span class="skip_info">검색</span></button>
					</div>
				</form>
			</div>
			
			<!-- 리스트 -->
			<table class="tb tb_col">
				<colgroup>
					<col style="width:50px;"/><col style="width:7.5%;"/><col style="width:auto;"/><col style="width:10%;"/><col style="width:15%;"/><col style="width:7.5%;"/>
				</colgroup>
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">소속 부서</th>
						<th scope="col">등록일</th>
						<th scope="col">수정일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty posts }" 
					<c:forEach var="posts" items="${posts}">
					<td class="tl"><a href="/post/view.do( id= ${posts.listId})}" th:text="${posts.listId}"></a></td>
					<td th:text="${post.listTitle }"></td>
				</tbody>
			</table>
		</section>
	</div>
</body>
</form>
</body>
</html>