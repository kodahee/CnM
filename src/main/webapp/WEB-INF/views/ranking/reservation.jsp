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
<link rel="stylesheet" type="text/css" href="../resources/css/ranking.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>




<main class="content">
	<div class="article">
		<div class="rankingBox">
			<div class="title">
				<span class="titleName">예매율</span>
			</div>

<div class="box_ranking" title="list">
	<ol class="list_movieranking" >
		<c:forEach items="${list }" var="dto" varStatus="i"><!-- i.index -->
			<li>
			<div class="item_poster">
				<div class="thumb_item">
					<div class="poster_movie">
						<img class="item_thumb poster" alt="${dto.movieNm }" src="${dto.poster }">
						<span class="rank_num" title="${i.index }">${dto.rankNum }</span>
						<span class="txt_tag">
						<span class="icon${i.index }"><!-- ico_movie ico_see --></span>
						</span>
					</div>
					<!-- hidden -->
					<div class="poster_info">
						<a href="#" class="link_story linkDetail" title="poster">${dto.movieInfo }</a>
						<span class="info_btn">
							<a href="#" class= "link_info linkDetail" >예매하기</a>
						</span>
					</div>
				</div>
				
				<div class="thumb_cont">
					<strong class="tit_item movieNm"><a href="" class="link_txt linkDetail" title="moviename">${dto.movieNm }</a></strong>
					<span class="txt_append">
						<span class="info_txt grade${i.index }">평점
							<!-- <span class="txt_grade>평점</span>" -->
						</span>
						<span class="info_txt">예매율
							<span class="txt_num">${dto.reservation }</span>
						</span>
					</span>
					<span class="txt_info openNum${i.index }">개봉
						<!-- <span class="txt_num">개봉일</span> -->
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

<script type="text/javascript" src="../resources/jquery/ranking/commonList.js"></script>
<script type="text/javascript" src="../resources/jquery/ranking/reservation.js"> </script>

</body>
</html>