<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>location detail</h1>

	<h3>location_id : ${dto.location_id}</h3>
	<h3>city : ${dto.city}</h3>
	<h3>street_address : ${dto.street_address}</h3>
	<h3>country_id : ${dto.country_id}</h3>
	
		<a href="./delete?location_id=${dto.location_id}">삭제</a>
		<a href="./update?location_id=${dto.location_id}">수정</a>
</body>
</html>