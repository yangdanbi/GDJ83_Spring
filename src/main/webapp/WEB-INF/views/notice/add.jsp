<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice add</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<h2 style="text-align: center; margin-top: 30px">notice add</h2>
	<div class="container justify-content-center" style="width: 50%">
		<div class="row ">

			<form action="./add" method="post" >
				
		
			<div class="mb-3">
					<label for="board_writer" class="form-label">  작성자</label> 
					<input type="text" class="form-control" id="board_writer" name="board_writer" value="${member.member_id}">
				</div>
			
				<div class="mb-3">
					<label for="board_title" class="form-label">게시글제목</label> 
					<input type="text" class="form-control" id="board_title" name="board_title">
				</div>
				<div class="mb-3">
					<label for="board_contents" class="form-label">게시글내용</label> 
					<input type="text" class="form-control" id="board_contents" name="board_contents">
				</div>
					<div class="mb-3">
					<label for="board_category" class="form-label">분류</label> 
					<input type="text" class="form-control" id="board_category" name="board_category">
				</div>
						
						
				<div class="d-grid gap-2 d-md-flex justify-content-end">
					<button type="submit" class="btn btn-secondary">등록</button>
				</div>
							
			</form>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>