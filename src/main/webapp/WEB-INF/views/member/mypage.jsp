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
			<div>
                  	<c:if test="${not empty member.memberFileDTO}">
                  	<img alt="" src="/resources/upload/members/${member.memberFileDTO.file_name}">
                  	</c:if>

                  	<c:if test="${empty member.memberFileDTO}">
                  	<img alt="" src="/resources/upload/members/">
                  	</c:if>
                  </div>
	
				<table class="table">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
						</tr>
					</thead>
					
					<tbody class="table-group-divider">
						<tr>
							<td>${member.member_id}</td>
							<td>${member.member_name}</td>
							<td>${member.phone}</td>
							<td>${member.email}</td>
						</tr>
					</tbody>
				</table>
				
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<button type = "submit" class="btn btn-primary"
						onclick="location.href ='./update?member_id=${member.member_id}' ">
						회원정보 수정
					</button>
					
					<form action="./delete?member_id=${member.member_id}" method="post">
						<button type="submit" class="btn btn-danger">회원 탈퇴</button>
					</form>		
				</div>
				
				<div class="mt-5">
					<table class="table">
						<thead>
							<tr>
								<th>상품 번호</th>
								<th>계좌번호</th>
								<th>계좌 개설일</th>
								<th>잔액</th>
							</tr>
						</thead>
						
						
						<tbody class="table-group-divider">
							<c:forEach items="${member.dtos}" var="ac">	
								<tr>
									<td>${ac.product_id}</td>
									<td><a href="/account/detail?account_number=${ac.account_number}"> ${ac.account_number}</a></td>
									<td>${ac.join_date}</td>
									<td>${ac.balance}</td>
								</tr>
							</c:forEach>	
						</tbody>
					</table>
					
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
						<button type = "submit" class="btn btn-primary"
							onclick="location.href ='/product/list' ">
							계좌 개설
						</button>
						
					</div>
				</div>
				
			</div>
		
			<div class="container col-md-6 mt-3 justify-content-center">
				
		</div>
			
		</div>	
	</div>
	
 <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>