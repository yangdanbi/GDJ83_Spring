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
				 <form method="post" enctype="multipart/form-data">
					<div class="mb-2">
						<label for="product_type" class="form-label">상품 이름</label>
						<input type="text" class="form-control" id="product_type" name="product_type">
					</div>
					<div class="mb-2">
						<label for="product_detail" class="form-label">상품 설명</label>
						<input type="text" class="form-control" id="product_detail" name="product_detail">
					</div>
					<div class="mb-4">
						<label for="product_rate" class="form-label">이자율</label>
						<input type="text" class="form-control" id="product_rate" name="product_rate">
					</div>
				
					<div class="row mb-2 mt-4 mx-0 px-0">
	                	<button type="button" id="add_btn" class="btn btn-secondary mb-2">사진파일 추가</button>
	                </div>
	                <div id="result">
	                </div>
				
					<button type="submit" class="btn btn-primary">등록</button>
					<div id="result"></div>
				</form>
			</div>		
		
	
		
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
	<script type="text/javascript" src="../resources/js/commons/files.js"></script>
	<script>setMax(5);</script>
</body>
</html>