<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<c:import url="./template/bootStrap.jsp"></c:import>

	<title>Home</title>
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
	
</head>
<body>

<c:import url="./template/header.jsp"></c:import>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./reservation/selectSeat">Select Seat</a>


</body>
</html>