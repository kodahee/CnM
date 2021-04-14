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
	
	<div class="container mt-2">
		<h2 class="mt-4">Member Join Page</h2>

		<form id="frm" action="./memberJoin" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="id">ID</label> 
				<input type="text" class="form-control"	id="id" name="id">
				<button type="button" class="btn btn-secondary" id="idCheck">중복검사</button>
				<h6 id="idResult"></h6>
				<!-- ID 는 6글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password"	class="form-control" id="pw" name="pw">
				<h6 id="pwResult"></h6>
				<!-- PW는 8글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password Check</label> 
				<input type="password" class="form-control" id="pwCheck" name="pwCheck">
				<h6 id="pwCheckResult"></h6>
				<!-- PW 두개는 일치 -->	
			</div>			
			<div class="form-group">
				<label for="name">Name</label> 
				<input type="text" class="form-control etc"	id="name" name="name">
				<!-- 비어 있으면 X -->
			</div>	
			
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="text" class="form-control etc"	id="email" name="email">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> 
				<input type="text" class="form-control etc"	id="phone" name="phone">
				<!-- 비어 있으면 X -->
			</div>
			
			<input type="submit" id="btn" value="JOIN" class="btn btn-primary">
			
		</form>
	</div>

	<script type="text/javascript" src="../resources/jquery/memberJoin.js"></script>

</body>
</html>