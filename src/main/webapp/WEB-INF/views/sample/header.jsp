<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar justify-content-center"
	style="background-color: cornsilk;">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- Navbar content -->
	<ul class="nav justify-content-center">
	
		<li class="nav-item">
				<a class="nav-link active"	aria-current="page" href="/">Home</a>
		</li>
		
		<li class="nav-item">
			<a class="nav-link active"aria-current="page" href="/product/list">상품정보</a>
		</li>

		<li class="nav-item">
			<a class="nav-link active"	aria-current="page" href="/notice/list">공지사항</a>
		</li>
		
		<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="/qna/list">QnA</a>
		</li>
			
		<c:choose>
			<c:when test="${not empty member}">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/member/mypage">마이페이지</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/member/logout">로그아웃</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/member/join">회원가입</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/member/login">로그인</a></li>

			</c:otherwise>


		</c:choose>

		<%-- 	
	<c:if test="${empty member}">
			<li class="nav-item">
				<a class="nav-link active"	aria-current="page" href="/member/join">회원가입</a>
			</li>
			<li class="nav-item">
				<a class="nav-link active"	aria-current="page" href="/member/login">로그인</a>
			</li>
		</c:if>

		<c:if test="${not empty member}">
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="/member/join">마이페이지</a>
			</li>
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="/member/login">로그아웃</a>
			</li>
		</c:if> 
		--%>
	</ul>
</nav>
