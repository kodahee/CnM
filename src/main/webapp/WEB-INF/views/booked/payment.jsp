<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<title>Insert title here</title>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container">
		<h1>Payment Page</h1>
	
		<div class="price_wrap">
			<input type="text" id="price" name="price" readonly="readonly">원
		</div>
		<div id="btnSelect"></div>
		<div id="next_button">
			<a href="#" class="btn btn-primary" id="btn">결제하기</a>
		</div>
	</div>
	

</body>
</html>