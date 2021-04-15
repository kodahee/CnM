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
	
	<div id="whole">
		<div id="TT">
			<h3 id="rank"></h3>
			<h3 id="movieNm"></h3>
		</div>
	</div>
	 
	

<script type="text/javascript" src="../resources/jquery/bookingRanking.js"> </script>
</body>
</html>