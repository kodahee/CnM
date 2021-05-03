<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/ranking.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<main class="content">
	<div class="article">
		<div class="rankingBox">
			 
			<div class="title">
				<span class="titleName">박스오피스</span>
				<div class="itemDate">
					<div class="innerDate">
						<img src="../resources/img/mPrev.png" class="week_prev">
						<span class="selectDate_item">21.04.19~21.04.25</span>
						<img src="../resources/img/mNext.png" class="week_next">
					</div>
				</div>
				<div class="headCal">
					
					<div class="iconCalendar" id="iconCalendar" >
						<img alt="calendar" src="../resources/img/calendar.png">
						<div class="calendarOpen" id="calendarOpen">
							<div class="calendarInner" id="calendarInner">
								<div class="calendar" id="calendar"></div>
							</div>
						</div>	
					</div>
				</div>
			</div>

			<div class="box_ranking" >
				<ol class="list_movieranking" >
					<c:forEach items="${list }" var="dto" varStatus="i"><!-- i.index -->
						<li>
						<div class="item_poster">
							<div class="thumb_item">
								<div class="poster_movie">
									<img class="item_thumb poster" alt="${dto.movieNm }" src="${dto.poster }">
									<span class="rank_num" title="${i.index }">${dto.rankNum }</span>
									<span class="txt_tag${i.index }"><!-- ico_movie ico_see --></span>
								</div>
								<!-- hidden -->
								<div class="poster_info">
									<a href="#" class="link_story linkDetail" title="poster">${dto.movieInfo }</a>
									<span class="info_btn">
										<a href="#" class= "link_info linkDetail" target="_blank">예매하기</a>
									</span>
								</div>
							</div>
							
							<div class="thumb_cont">
								<strong class="tit_item movieNm"><a href="#" class="link_txt linkDetail" title="moviename">${dto.movieNm }</a></strong>
								<span class="txt_info">
									<span class="info_txt openNum${i.index }">개봉
										<!-- <span class="txt_num">개봉일</span> -->
									</span>
									<span class="info_txt">
										<span class="screen_out">관객수</span>
										<!-- 그냥 숫자 삽입인데,,, audiAcc -->
									</span>
								</span>
							</div>
						</div>
						</li>
					</c:forEach>
				</ol>
			</div>
			
		
		</div>
	</div>
</main>
 

<!-- commonList 함수를 가지고 있는 js, 무비코드를 이용하여 상세목록 조회(개봉일, 관람등급) -->
<script type="text/javascript" src="../resources/jquery/ranking/commonList.js"></script>
<!--  selectDay를 받아서 오픈API 소환, 영화 코드를 받아서 commonList함수 소환-->
<script type="text/javascript" src="../resources/jquery/ranking/boxOffice.js"></script>
<!-- 달력 소환, 날짜 선택시 selectDay에 담고, Date타입으로 존재함 -->  
<script type="text/javascript" src="../resources/jquery/ranking/weekCalendar.js"></script>

</body>
</html>