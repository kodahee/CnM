<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>랭킹</title>

<link rel="stylesheet" type="text/css" href="../resources/css/common.css">

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="box_ranking">
	<ul>
		<c:forEach items="${list }" var="dto">
			<li>
				<h3><img class="poster" alt="" src="${dto.poster }"></h3>
				<h3 id="movieNm">${dto.movieNm }</h3>
				<h3>${dto.rankNum }</h3>
				<h6>${dto.movieInfo }</h6>
				<h3>${dto.reservation }</h3>
			</li>
		</c:forEach>
	</ul>
</div>

<script type="text/javascript" src="../resources/jquery/reservation.js"> </script>
</body>
</html>