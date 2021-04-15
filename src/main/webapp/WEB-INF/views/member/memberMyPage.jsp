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
	<div class="container">
		<h1>My Page</h1>

		<ul class="list-group list-group-flush">
			<li class="list-group-item">NickName : ${member.nickName}</li>
			<li class="list-group-item">ID : ${member.id}</li>
			<li class="list-group-item">Name : ${member.name}</li>
			<li class="list-group-item">Phone : ${member.phone}</li>
			<li class="list-group-item">Email : ${member.email}</li>
			<li class="list-group-item">
			</li>
		</ul>


		<a href="./memberUpdate" class="btn btn-primary" role="button">수정</a>
		<a href="./memberDelete" class="btn btn-danger" role="button">탈퇴</a>
	</div>


</body>
</html>