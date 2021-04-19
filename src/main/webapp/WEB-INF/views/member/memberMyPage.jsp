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
			<c:if test="${memberFile == null}">
				<li><img alt="" src="../resources/images/default.jpeg"></li>
			</c:if>
			<li><img alt="" src="../resources/upload/member/${member.memberFile.fileName}"></li>
			<li class="list-group-item">${member.nickName}</li>
			<li class="list-group-item">${member.grade}</li>
		</ul>


		<a href="./memberUpdate" class="btn btn-primary" role="button">Edit Profile</a>
		
	</div>


</body>
</html>