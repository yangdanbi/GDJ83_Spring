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
		
		
		
		
			<div class="container col-md-6 mt-5 justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<th>상품명</th>
							<th>계좌번호</th>
							<th>상품 상세 정보</th>
							<th>계좌 개설일</th>
							<th>잔액</th>
							<th>이자율</th>
						</tr>
					</thead>
					
					
					<tbody class="table-group-divider">
						<tr>
							<td>${dto.productDTO.product_type}</td>
							<td>${dto.account_number}</td>
							<td>${dto.productDTO.product_detail}</td>
							<td>${dto.join_date}</td>
							<td>${dto.balance}</td>
							<td>${dto.productDTO.product_rate}</td>	
						</tr>
		
					</tbody>
				</table>
				
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<button type = "submit" class="btn btn-primary"
						onclick="location.href='./transfer?account_number=${dto.account_number}'">
						계좌 이체
					</button>
					
					<button type = "submit" class="btn btn-outline-primary"
						onclick="location.href='./list?account_number=${dto.account_number}&order=0'">
						이체 내역
					</button>
				</div>

			
			
			
			
			
		</div>	
		
		
		
		
		
		
		
		
		
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>