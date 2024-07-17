<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product add</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<h2 style="text-align: center; margin-top: 30px">product add</h2>
	<div class="container justify-content-center" style="width: 50%">
		<div class="row ">

			<form action="./add" method="post" >
				<div class="mb-3">
					<label for="product_type" class="form-label">상품종류</label> 
					<input type="text" class="form-control" id="product_type" name="product_type">
				</div>
				<div class="mb-3">
					<label for="product_rate" class="form-label">이자율</label> 
					<input type="text" class="form-control" id="product_rate" name="product_rate">
				</div>
					<div class="mb-3">
					<label for="product_detail" class="form-label">상품설명</label> 
					<input type="text" class="form-control" id="product_detail" name="product_detail">
				</div>
						
						
				<div class="d-grid gap-2 d-md-flex justify-content-end">
					<button type="submit" class="btn btn-secondary">등록</button>
				</div>
							
			</form>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>