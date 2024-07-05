<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
<h2 style="text-align: center;">mypage</h2>

<div class="container justify-content-center">
		<div class="row justify-content-center">
			<!-- <h1 style="text-align: center">product list</h1> -->
<%-- 	<c:if test="${not empty member}"> --%>
			<table class="table"
				style="text-align: center; margin-top: 30px; width: 60%;">
				<thead>
					<tr>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>
						<th scope="col">휴대번호</th>
						<th scope="col">이메일</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<tr>
						<td>${member.member_id}</td>
						<td>${member.member_name}</td>
						<td>${member.phone}</td>
						<td>${member.email}</td>			
					</tr>
				</tbody>
				</tbody>
			</table>
			<%-- </c:if>  --%>
			
		</div>
		<div class="d-grid gap-2 d-md-flex justify-content-end"	style="margin-top: 30px; width: 80%;">
			<button type="button" onclick="location.href='./update?m_id=${member.m_id}'" 
				class="btn btn-secondary me-md-2" style="width: 90px;">회원수정</button>
	
		
			<form action="./delete?m_id=${member.m_id}" method="post">
					<button type="submit" class="btn btn-danger  ">회원탈퇴</button>
			</form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>