<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container justify-content-center" style="width: 50%">
		<div class="row ">
			<h2 style="text-align: center; margin-top: 30px">${board} 작성</h2>
			<form method="post" >
				<input type="hidden" class="form-control" id="board_num" name="board_num" value="${dto.board_num}">
				<div class="mb-3">
					<label for="board_writer" class="form-label"> 작성자</label> 
					<input type="text" class="form-control" id="board_writer" name="board_writer" value="${member.member_id}" readonly="readonly">
				</div>
			
				<div class="mb-3">
					<label for="board_title" class="form-label">게시글제목</label> 
					<input type="text" class="form-control" id="board_title" name="board_title" value="${dto.board_title}">
				</div>
				<div class="mb-3">
					<label for="board_contents" class="form-label">게시글내용</label> 
					<textarea name="board_contents" class="form-control" id="board_contents" >${dto.board_contents}</textarea>
					
				</div>
				
				<!-- <div class="mb-3">
					<label for="board_category" class="form-label">분류</label> 
					<input type="text" class="form-control" id="board_category" name="board_category" placeholder="한글자만 입력해주세요.">
				</div> -->
						
						
				<div class="d-grid gap-2 d-md-flex justify-content-end">
					<button type="submit" class="btn btn-secondary">등록</button>
				</div>
							
			</form>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>