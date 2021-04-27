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
<div>
<span id="iconCalendar" >
	<img alt="calendar" src="../../resources/img/calendar.png">
</span><p></p>

</div>
<div id="calendarOpen" >
	<div id="calendar" ></div>
</div>
 
<div class="box_ranking">
	<ul id="listBox">
		<c:forEach items="${list }" var="dto" varStatus="i">
			<li>
				<h3><img class="poster" alt="" src="${dto.poster }"></h3>
				<h6>${dto.movieInfo }</h6><h3>${dto.reservation }</h3>
				
			
				<div class="subInfo${i.index }">
				
				</div>
			</li>
		</c:forEach>
	</ul>
</div>


<form id="monthly" action="./monthly" method="post" >
	<input type="hidden" id="monthlyResult" name ="result" >
	<input type="text" id="test" name="hi">
	<button>월간</button>
</form>

 <!-- 

commonList 함수를 가지고 있는 js, 무비코드를 이용하여 상세목록 조회(개봉일, 관람등급)
<script type="text/javascript" src="../../resources/jquery/ranking/commonList.js"></script>
 selectDay를 받아서 오픈API 소환, 영화 코드를 받아서 commonList함수 소환
<script type="text/javascript" src="../../resources/jquery/ranking/boxOffice.js"></script>
  달력 소환, 날짜 선택시 selectDay에 담고, Date타입으로 존재함
 <script type="text/javascript" src="../../resources/jquery/ranking/weekCalendar.js"></script>
 -->
</body>
</html>