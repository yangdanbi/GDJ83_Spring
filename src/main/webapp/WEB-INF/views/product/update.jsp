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
		
			<div class="container col-md-4 mt-5 justify-content-center">
				<form action="./update" method="post">
		
					<input type="hidden" name="product_id"
						value="${dto.product_id}">
		
					<div class="mb-3">
						<label for="product_type" class="form-label">상품 이름</label> <input
							type="text" value="${dto.product_type}" class="form-control"
							id="product_type" name="product_type">
					</div>
					<div class="mb-3">
						<label for="product_detail" class="form-label">상품 설명</label> <input
							type="text" value="${dto.product_detail}" class="form-control"
							id="product_detail" name="product_detail">
					</div>
					<div class="mb-3">
						<label for="product_rate" class="form-label">이자율</label> <input
							type="text" value="${dto.product_rate}" class="form-control"
							id="product_rate" name="product_rate">
					</div>
		
					<button type="submit" class="btn btn-primary">수정</button>
						
				</form>
			</div>
		
		
		
		
		
		
		
		
		
		
		
		
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>