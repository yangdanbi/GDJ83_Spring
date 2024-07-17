<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product update</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<!-- <h2>product update</h2> -->
		<div class="row justify-content-center">
	<div class="row "
		style="text-align: center; margin-top: 30px; width: 60%;">

		<form action="./update" method="post">
			<%-- <div class="mb-3">
				<input type="hidden" class="form-control" id="m_id"
					value="${member.m_id}" name="m_id">
			</div> --%>
			<div class="mb-3">
				<label for="member_name" class="form-label"><strong>이름</strong></label> 
				<input	type="text" class="form-control" id="member_name"
					value="${member.member_name}" name="member_name">
			</div>
			
					
			<div class="mb-3">
				<label for="phone" class="form-label"><strong>휴대번호</strong></label>
				 <input	type="text" class="form-control" id="phone"
					value="${member.phone}" name="phone">
			</div>
						<div class="mb-3">
				<label for="email" class="form-label"><strong>이메일</strong></label>
				 <input	type="text" class="form-control" id="email"
					value="${member.email}" name="email">
			</div>

			<div class="d-grid gap-2 d-md-flex justify-content-md-end" style="margin-top: 25px;">
				<button type="submit" class="btn btn-secondary">수정</button>
			</div>
		</form>
	</div>
		</div>
</body>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>