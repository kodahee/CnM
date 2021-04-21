<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../../resources/css/common.css">

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<span id="iconCalendar">
	<img alt="calendar" src="../../resources/img/calendar.png">
</span>
<div id="calendar">
	<div id="calendarTable"><h1>ho!</h1></div>
</div>

<div class="box_ranking">
	<ul >
		<c:forEach items="${list }" var="dto" varStatus="i"><!-- i.index -->
			<li>
				<h3><img class="poster" alt="" src="${dto.poster }"></h3>
				<h6>${dto.movieInfo }</h6><h3>${dto.reservation }</h3>
				
			
				<div class="test${i.index }">
				
				</div>
			</li>
		</c:forEach>
	</ul>
</div>

<script type="text/javascript" src="../../resources/jquery/calendar.js"></script>
<!-- 
<script type="text/javascript" src="../../resources/jquery/commonList.js"></script>
<script type="text/javascript" src="../../resources/jquery/boxOffice.js"></script>
 -->
</body>
</html>