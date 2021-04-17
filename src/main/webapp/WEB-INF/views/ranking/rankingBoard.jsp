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

<c:forEach items="${list }" var="dto">
	<h3><img alt="" src="${dto.poster }"></h3>
	<h3 id="movieNm">${dto.movieNm }</h3>
	<h3>${dto.rankNum }</h3>
	<h3>${dto.movieInfo }</h3>
	<h3>${dto.reservation }</h3>
</c:forEach>

<script type="text/javascript" src="../resources/jquery/reservation.js"> </script>
</body>
</html>