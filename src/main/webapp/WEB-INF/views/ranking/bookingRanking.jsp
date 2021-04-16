<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>랭킹</title>

<style type="text/css">
#TT{
	width:200px;
	height: 100px;
	background-color: yellow;
	margin: 10px;
}
</style>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<button id="btn">button</button>

	<div id="result"></div>
	<h3>${test }</h3>
	
<button id="btn2">button2</button>
	

<script type="text/javascript" src="../resources/jquery/bookingRanking.js"> </script>
</body>
</html>