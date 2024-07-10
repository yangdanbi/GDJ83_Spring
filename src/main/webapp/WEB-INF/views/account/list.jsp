<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>history list</title>

<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>

	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="justify-content-center" style="text-align: center;">
		<div class="btn-group btn-group-sm" role="group" aria-label="Small button group" style="margin-top: 30px; text-align: center;">
	 		<a href="list?account_number=${param.account_number}&order=0" class = "btn btn-outline-warning">최신순으로 </a>
	 		<a href="list?account_number=${param.account_number}&order=1" class = "btn btn-outline-warning">과거순으로 </a>
	 		<a href="list?account_number=${param.account_number}&io=I" class = "btn btn-outline-success">입금내역조회 </a>
	 		<a href="list?account_number=${param.account_number}&io=O" class = "btn btn-outline-success"> 출금내역조회 </a>
	 		<a href="list?account_number=${param.account_number}&order=0" class = "btn btn-outline-primary">모든내역조회 </a>
	 	</div>
	 	</div>
	<div class="container justify-content-center">
	 	<div class="row justify-content-center">
	 
			<table class="table" style="text-align: center; margin-top: 30px; width: 60%;">
				<thead>
					<tr>
						<th scope="col">거래일</th>
						<th scope="col">입/출금액</th>
						<th scope="col">거래구분</th>
						<th scope="col">잔액</th>
					</tr>
				</thead>				
			
				    <c:forEach items="${list}" var="history">
                     <tbody>
                        <tr>
                           <td>${history.history_time}</td>
                           <td class="${history.type=='I'?'text-primary':'text-danger'}">${history.amount}</td>
                           <td class="${history.type=='I'?'text-primary':'text-danger'}">
                              <c:choose>
                                 <c:when test="${history.type=='I'}"> 입금</c:when>
                                 <c:otherwise>출금</c:otherwise>
                              </c:choose>   
                           <td>${history.balance}</td>                                           
                        </tr>
                     </tbody>
               </c:forEach>

			</table>
		</div> 
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</body>
</html>