<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product list</title>
<style type="text/css"></style>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>

<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container">

		<div class="row justify-content-center">
			<!-- <h1 style="text-align: center">product list</h1> -->
			<table class="table table-striped table-hover"
				style="text-align: center; margin-top: 30px; width: 60%;">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">상품명</th>
						<th scope="col">이자율</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="product">
						<tbody>
							<tr>
								<td>${product.product_id}</td>
								<td><a href="./detail?product_id=${product.product_id}">${product.product_type}</a></td>
								<td>${product.product_rate}</td>
							</tr>
						</tbody>

					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<a href="./add" class="btn btn-secondary" style="margin: 10px;">상품등록</a>

		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>