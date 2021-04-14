<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>랭킹</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>



<button id="btn">button</button>
<h3 id="test"> </h3>
	<form action="./ranking/bookingRanking" >
	<input id="result" name="result">
	<button>button</button>
	</form>
	
	

<script type="text/javascript" src="../resources/jquery/bookingRanking.js"> </script>
</body>
</html>