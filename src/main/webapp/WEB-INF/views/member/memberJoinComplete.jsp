<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<h1> ${member.name}님 환영합니다.</h1>
	
	<a href="../" role="button" class="btn btn-info">Home</a>
	<a href="./memberMyPage" role="button" class="btn btn-info">My Page</a>

</body>
</html>