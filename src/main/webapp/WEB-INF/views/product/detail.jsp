<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- c태그 사용 -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body class="sb-nav-fixed">
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div id="layoutSidenav">
		<c:import url="/WEB-INF/views/sample/sideBar.jsp"></c:import>
		<div id="layoutSidenav_content">
			
			
			
			
			<div class="container col-md-5 mt-5 justify-content-center">
			
			
				<table class="table">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">${dto.product_type} 상세 정보</th>
						</tr>
					</thead>
					<tbody class= "table-group-divider">
						<tr>
							<th scope="row">상품 번호</th>
							<td>${dto.product_id}</td>
						</tr>
						<tr>
							<th scope="row">상품 설명</th>
							<td>${dto.product_detail}</td>
						</tr>
						<tr>
							<th scope="row">이자율</th>
							<td>${dto.product_rate}</td>
						</tr>
						
						<tr>
							<c:forEach items="${dto.fileDTOs}" var="f">
							<a href="/resources/upload/products/${f.file_name}">${f.ori_name}</a>

							</c:forEach>
						</tr>
				
					</tbody>
				</table>
				
				
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<button type = "submit" class="btn btn-primary" onclick="location.href ='/account/add?product_id=${dto.product_id}' ">계좌 개설</button>
				</div>
				
				
				<div class="d-grid gap-2 d-md-flex">
					<button type = "submit" class="btn btn-primary" onclick="location.href ='./update?product_id=${dto.product_id}' ">상품 수정</button>
					<form action="./delete" method="post">
						<input type="hidden" value="${dto.product_id}" name="product_id">
						<button type="submit" class="btn btn-danger">상품 삭제</button>
					</form>
				</div>
				
			</div>
			
			
			
			
			
			
			
			
			
		
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>