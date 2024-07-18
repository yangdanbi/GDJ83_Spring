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
		
		
		
			<form action="./transfer" method="post">
				<div class="container col-md-3 mt-5 justify-content-center">
					
					<input type="hidden" name="account_sender"
					value="${dto.account_number}">
					
					<div class="mb-3">
						<label for="account_sender" class="form-label">출금하실 계좌</label>
						<input class="form-control" id="account_sender" type="text"
						value="${dto.account_number}" disabled>
					</div>
					
					<div class="mb-3">
						<label for="balance" class="form-label">잔액</label>
						<input class="form-control" id="balance" type="text"
						value="${dto.balance}" readonly="readonly">
					</div>
				
					<div class="mb-3">
						<label for="account_number" class="form-label">입금하실 계좌번호</label>
						<input type="text" class="form-control" id="account_number"
						name="account_number">
					</div>
					
					<div class="mb-3">
						<label for="amount" class="form-label">입금하실 금액</label>
						<input type="text" class="form-control" id="amount"
						name="amount">
					</div>
					
					<div class="justify-content-md-end">
						<button type="submit" class="btn btn-primary">계좌 이체</button>
					</div>
				</div>
				
			</form>
		
		
		
		
		
		
		
		
		
		
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>