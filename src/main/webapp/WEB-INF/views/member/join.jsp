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
		
		
		<form action="./join" method="post" id="frm">
			<div id="layoutAuthentication">
	            <div id="layoutAuthentication_content">
	                <main>
	                    <div class="container">
	                        <div class="row justify-content-center">
	                            <div class="col-lg-7">
	                                <div class="card shadow-lg border-0 rounded-lg mt-5">
	                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">회원가입</h3></div>
	                                    <div class="card-body">
	                                        <form>
	                                        	<div class="form-floating mb-3">
	                                            	<input class="form-control join_info" id="member_id" type="text" placeholder="ID" name="member_id" />
	                                            	<label for="member_id">ID</label>
	                                            </div>
	                                            <div class="row mb-3">
	                                                <div class="col-md-6">
	                                                    <div class="form-floating">
	                                                        <input class="form-control join_info" id="member_pwd" type="password" placeholder="Password" name="member_pwd" />
	                                                        <label for="member_pwd">Password</label>
	                                                        <div id="password-error" class="text-danger"></div>
	                                                    </div>
	                                                </div>
	                                                <div class="col-md-6">
	                                                    <div class="form-floating">
	                                                        <input class="form-control join_info" id="member_pwd_check" type="password" placeholder="Password_Check"/>
	                                                        <label for="member_pwd_check">Password_Check</label>
	                                                        <div id="password-eqError" class="text-danger"></div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                            <div class="form-floating mb-3">
	                                                <input class="form-control join_info" id="email" type="email" placeholder="email@example.com" name="email"/>
	                                                <label for="email">Email 주소</label>
	                                            </div>
	                                            <div class="row mb-3">
	                                                <div class="col-md-6">
	                                                    <div class="form-floating mb-3 mb-md-0">
	                                                        <input class="form-control join_info" id="member_name" type="text" placeholder="Name" name="member_name"/>
	                                                        <label for="member_name">이름</label>
	                                                    </div>
	                                                </div>
	                                                <div class="col-md-6">
	                                                    <div class="form-floating mb-3 mb-md-0">
	                                                        <input class="form-control join_info" id="member_number" type="text" placeholder="Resident registration number" name="member_number"/>
	                                                        <label for="member_number">주민번호</label>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                            <div class="form-floating mb-3">
	                                                <input class="form-control join_info" id="phone" type="text" placeholder="010-XXXX-XXXX" name="phone"/>
	                                                <label for="phone">전화번호</label>
	                                            </div>
	                                            
	                                            <div class="row mb-2 mt-4 mx-0 px-0">
	                                                <button type="button" id="add_btn" class="btn btn-secondary mb-2">사진파일추가</button>
	                                            </div>
	                                            <div id="result">
	                                            </div>
	                                            
	                                            <div class="row mb-2 mt-4 mx-0 px-0">
	                                                <button type="button" id="btn" class="btn btn-primary">회원가입</button>
	                                            </div>
	                                        </form>
	                                    </div>
	                                    <div class="card-footer text-center py-3">
	                                        <div class="small"><a href="/member/login">로그인</a></div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </main>
	            </div>
	            
	        </div>
		</form>
		
		
		
		
		
		
		
		
		
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
	<script type="text/javascript" src="../resources/js/member/memberJoinCheck.js"></script>
	<script type="text/javascript" src="../resources/js/commons/files.js"></script>
</body>
</html>