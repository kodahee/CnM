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
<h4>1</h4>
<div class="box_ranking" data-tiara-layer="list">
	<ol class="list_movieranking" >
		<c:forEach items="${list }" var="dto" varStatus="i"><!-- i.index -->
			<li>
			<div class="item_poster">
				<div class="thumb_item">
					<div class="poster_movie">
						<img class="item_thumb" alt="${dto.movieNm }" src="${dto.poster }">
						<span class="rank_num">${dto.rankNum }</span>
						<span class="txt_tag${i.index }">
						</span>
					</div>
					<div class="poster_info">
						<a href="" class="link_story" data-tiara-layer="poster">${dto.movieInfo }</a>
						<span class="info_btn">
							<a href="" class= "link_info" target="_blank">예매하기</a>
						</span>
					</div>
				</div>
				<div class="thumb_cont">
					<h3 class="movieNm">${dto.movieNm }</h3>
					<h3>${dto.reservation }</h3>
					<div class="subInfo${i.index }"></div>
				
				</div>
			</div>
			</li>
		</c:forEach>
	</ol>
</div>
<!-- 
<script type="text/javascript" src="../resources/jquery/ranking/commonList.js"></script>
<script type="text/javascript" src="../resources/jquery/ranking/reservation.js"> </script>
 -->
</body>
</html>