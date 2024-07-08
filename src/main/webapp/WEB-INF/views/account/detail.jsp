<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product detail</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container justify-content-center">
	 	<div class="row justify-content-center">
			<!-- <h1 style="text-align: center">product list</h1> -->

			<table class="table"
				style="text-align: center; margin-top: 30px; width: 60%;">
				<thead>
					<tr>
						<th scope="col">상품명</th>
						<th scope="col">이자율</th>
						<th scope="col">설명</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<tr>
						<td>${dto.account_number}</td>
						<td>${dto.balance}</td>
						<td>${dto.product_detail}</td>

					</tr>
				</tbody>
				</tbody>
			</table>
		</div> 
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>