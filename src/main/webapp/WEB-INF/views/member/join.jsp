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

	<div class="container justify-content-center"style="width: 50%;">
		<div class="row " style=" margin-top: 30px; ">
<h2 style="text-align: center;">join page</h2>
			<form action="./join" method="post" >
			
			<div class="mb-3">
					<label for="member_id" class="form-label">아이디</label> 
					<input type="text" class="form-control" id="member_id"
						name="member_id" >
				</div>
				<div class="mb-3">
					<label for="member_pwd" class="form-label">비밀번호</label> 
					<input	type="password" class="form-control" id="member_pwd"
						name="member_pwd" >
				</div>
				<div class="mb-3">
					<label for="member_name" class="form-label">이름</label>
					 <input	type="text" class="form-control" id="member_name"
						name="member_name" >
				</div>
				<div class="mb-3">
					<label for="member_number" class="form-label">주민번호</label> 
					<input type="text" class="form-control" id="member_number"
						name="member_number" >
				</div>
								
				<div class="mb-3">
					<label for="phone" class="form-label">번호</label> 
					<input type="text" class="form-control" id="phone"
						name="phone">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">이메일</label>
					 <input	type="email" class="form-control" id="email"
						name="email" >
				</div>
				
				<div class="d-grid gap-2 d-md-flex justify-content-end" >

				<button type="submit" class="btn btn-secondary" style="margin-top: 20px">입력</button>
				</div>
			</form>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>