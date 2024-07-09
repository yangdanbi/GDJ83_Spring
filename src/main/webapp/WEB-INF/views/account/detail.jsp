<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account detail</title>
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
						<th scope="col">계좌번호</th>
						<th scope="col">설명</th>
						<th scope="col">가입일</th>
						<th scope="col">잔액</th>
							<th scope="col">이자율</th>
					
					</tr>
				</thead>
				<tbody>
				<tbody>
					<tr>
						<td>${dto.productDTO.product_type}</td>
						<td>${dto.account_number}</td>
						<td>${dto.productDTO.product_detail}</td>
						<td>${dto.join_date}</td>
						<td>${dto.balance}</td>
						<td>${dto.productDTO.product_rate}</td>	
					</tr>
				</tbody>
				</tbody>
			</table>
				<div class="d-grid gap-2 d-md-flex justify-content-end" >
			<a href="./transfer?account_number=${dto.account_number}" class="btn btn-secondary" style=" margin: 30px;  margin-right: 250px;">이체</a>

		</div>
		</div> 
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>