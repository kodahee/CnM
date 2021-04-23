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
		<h2>${board} Reply Page</h2>

		<form id="frm" action="./${board}Reply" method="post">
			<input type="hidden" name="num" value="${param.num}">
			<div class="form-group">
				<label for="exampleFormControlInput1">Id</label> 
				<input class="form-control form-control-lg" type="text" value="${member.id}" id="id" name="id" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Title</label> 
				<input class="form-control form-control-lg" type="text" name="title"id="title">
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Contents</label>
				<textarea class="form-control" id="contents" rows="10" name="contents"></textarea>
			</div>
			
			<input type="submit" value="Write" id="btn" class="btn btn-primary">

		</form>
	</div>
	
	<!-- <script type="text/javascript" src="../resources/js/insertCheck.js"></script> -->
</body>
</html>