<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h2>Member Login Page</h2>
		<form action="./memberLogin" method="post">
			<div class="form-group">
				<label for="id">ID</label> 
				<input type="text" class="form-control" id="id" aria-describedby="idHelp" name="id"> 
			</div>
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password"class="form-control" id="pw" name="pw">
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="rememberId" name="rememberId">
				<label class="form-check-label" for="rememberId">remember your id</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>