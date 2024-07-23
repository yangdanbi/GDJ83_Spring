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
			       <div class="text-center mb-5">
                        	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">
	                        	<c:if test="${boardDTO eq null}">
	                        		${board} 글작성
	                        	</c:if>
	                        	<c:if test="${boardDTO ne null}">
	                        		${board} 글수정
	                        	</c:if>
                        	</span></h1>
                    	</div>
		<form id="contactForm" method="post" enctype="multipart/form-data" data-sb-form-api-token="API_TOKEN">
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
				 <div>
                                    	<button type="button" class="btn btn-outline-primary" id="add_btn">첨부파일추가</button>
                                    	<div id="result"></div>
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
	<script type="text/javascript" src="/resources/js/commons/files.js"></script>
		<script type="text/javascript">
			setMax(5);
		</script>
</body>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>