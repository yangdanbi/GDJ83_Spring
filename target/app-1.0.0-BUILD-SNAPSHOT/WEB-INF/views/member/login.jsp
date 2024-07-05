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

	<div class="container" style="width: 50%;">
		<div class="row justify-content-center" style="margin-top: 30px;">
			<h2 style="text-align: center;">login page</h2>
			<form action="./login" method="post">
				<div class="mb-3">
					<label for="member_id" class="form-label">아이디</label> 
					<input	type="text" class="form-control" id="member_id" name="member_id" value="${id}">
				</div>
				<div class="mb-3">
					<label for="member_pwd" class="form-label">비밀번호</label> 
					<input	type="password" class="form-control" id="member_pwd"
						name="member_pwd">
				</div>

				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
					<label class="form-check-label" for="exampleCheck1" >아이디 저장</label>
				</div>

				<div class="d-grid gap-2 d-md-flex justify-content-end"	style="margin-top: 30px">
					<button type="submit" class="btn btn-secondary">로그인</button>
				</div>
			</form>

		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>