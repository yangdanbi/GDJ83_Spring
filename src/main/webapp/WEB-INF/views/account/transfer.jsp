<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account transfer</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<div class="container" style="width: 50%;">
		<div class="row justify-content-center" style="margin-top: 30px;">
			<h2 style="text-align: center;">account transfer</h2>
			
			<form action="./transfer" method="post">
				<div class="mb-3">
					<label for="" class="form-label">나의 계좌</label> 
					
					<input	type="text" class="form-control" id="" name="account_sender" value="${requestScope.dto.account_number}" readonly="readonly">
					<label for="" class="form-label">잔액</label> 
					
					<input	type="text" class="form-control" id="" name="" value="${requestScope.dto.balance}" readonly="readonly">
				</div>
			
				<div class="mb-3">
					<label for="" class="form-label">이체금액</label> 
					<input	type="text" class="form-control" id="" name="amount">
				</div>
				<div class="mb-3">
					<label for="" class="form-label">계좌번호</label> 
					<input	type="text" class="form-control" id="" name="account_number">
				</div>


				<div class="d-grid gap-2 d-md-flex justify-content-end"	style="margin-top: 30px">
					<button type="submit" class="btn btn-secondary">이체하기</button>
				</div>
			 </form> 

		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>