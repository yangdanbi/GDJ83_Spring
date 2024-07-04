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
			<div class="mb-3">
				<input type="hidden" class="form-control" id="product_id"
					value="${dto.product_id}" name="product_id">
			</div>
			<div class="mb-3">
				<label for="product_type" class="form-label"><strong>상품종류</strong></label> 
				<input	type="text" class="form-control" id="product_type"
					value="${dto.product_type}" name="product_type">
			</div>
			
			<div class="mb-3">
				<label for="product_rate" class="form-label"><strong>이자율</strong></label> 
				<input	type="text" class="form-control" id="product_rate"
					value="${dto.product_rate}" name="product_rate">
			</div>
			
			<div class="mb-3">
				<label for="product_detail" class="form-label"><strong>상품설명</strong></label>
				 <input	type="text" class="form-control" id="product_detail"
					value="${dto.product_detail}" name="product_detail">
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