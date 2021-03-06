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
<link rel="stylesheet" type="text/css" href="../resources/css/movieInfo.css">
<link rel="stylesheet" type="text/css" href="../resources/css/review.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<main class="content">
	<div class="article">
	
		<div class="detailInfo">
		<!-- 상단 -->
			<div class="box_basic">
				<div class="info_poster">
					<img class="posterItem"alt="" src="${dto.poster }">
				</div>
				<div class="info_detail">
					<div class="detail_tit">
						<h3 class="txt_movie">
							<span class="txt_tit">${dto.movieNm }</span>
							<span class="txt_tag">
								<span class="txt_state state_dday day1"><!-- d-day --></span>
							</span>
						</h3>
						<div class="head_origin">
							<span class="txt_name originNm"><!-- 오리지널 이름 -->origin</span>
						</div>
					</div>
					<div class="detail_cont">
						<div class="inner_cont">
							<dl class="list_cont">
								<dt>개봉</dt>
								<dd class="openDt"><!-- js --></dd>
							</dl>
							<dl class="list_cont">
								<dt>장르</dt>
								<dd class="genreNm"><!-- js --></dd>
							</dl>
							<dl class="list_cont">
								<dt>러닝타임</dt>
								<dd class="showTm"><!-- js --></dd>
							</dl>
						</div>
						<div class="inner_cont">
							<dl class="list_cont">
								<dt>국가</dt>
								<dd class="nationNm"><!-- js --></dd>
							</dl>
							<dl class="list_cont">
								<dt>등급</dt>
								<dd class="watchGradeNm"><!-- js --></dd>
							</dl>
							<dl class="list_cont">
								<dt>평점</dt>
								<dd><!-- js --></dd>
							</dl>
						</div>
					</div>
					<div hidden="hidden" class="movieCd">${dto.movieCd }</div>
					<div class="detail_btn">
						<div class="group_btn">
							<a href="../booked/selectTime?movieCd=${dto.movieCd }" class="btn_g">예매하기</a>
						</div>
					</div>
				</div>
			</div>
		<!-- 하단 -->
			<div class="box_detailinfo">
			<!-- 탭메뉴 -->
				<div class="tabmenu_wrap">
					<ul class="list_tabmenu">
						<li id="i1">주요정보</li>
						<li id="i2">출연/제작</li>
						<li id="i3">평점</li>
					</ul>
				</div>
				<div class="contents">
					<!-- 출연제작,영상포토,평점은 js로 새로고침 없이 보여주기 -->
					<h4 class="screen_out">주요정보</h4>
					<h5 class="tit_section">줄거리</h5>
					<div class="detail_basicinfo">
						<div class="movie_summary">
							<div class="info_desc">
								<div class="desc_cont">${dto.movieInfo }</div>
							</div>
						</div>
					</div>
					
					<div class="detail_crewinfo">
						<h5 class="tit_section">출연진</h5>		
						<ul class="list_crewall">
							<!-- <li>출연진 수만큼 js작업 최대 7개
								<div class="item_crewall">
									<div class="thumb_item">
										<img src="" class="img_thumb">
									</div>
									<div class="thumb_cont">
										<div class="tit_item">
											<div class="link_tit"></div>
										</div>
										<span class="txt_info">감독이나 주연이냐</span>
									</div>
								</div>
							</li> -->
						</ul>
						<a href="#" class="link_more">더보기<!-- 출연제작으로 넘어가는 js --></a>
					</div>
					
					<div class="detail_boxofficeinfo">
						<h5 class="tit_section">박스오피스</h5>
						<ul class="list_thumbsub">
							<c:forEach items="${list }" var="list" varStatus="i">
								<li>
									<div class="item_thumbsub">
										<a href="./infoBoard?movieCd=${list.movieCd }" class="thumb_item">
											<span class="rank_num">${i.index +1}</span>
											<img alt="" src="${list.poster }" class="img_thumb">
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					
					<div>
						<h5 class="tit_section">평점</h5>
						<ul>
							<li>
								<div>
									<div class="form-group">
									  <input type="hidden" class="form-control" id="id" value="${member.id}">
									  <input type="hidden" class="form-control" id="nickName" value="${member.nickName}">
									</div>
									<div class="form-group">
										<div class="star-box">
											<span class="star star_left"></span>
											<span class="star star_right"></span>
							
											<span class="star star_left"></span>
											<span class="star star_right"></span>
							
											<span class="star star_left"></span>
											<span class="star star_right"></span>
							
											<span class="star star_left"></span>
											<span class="star star_right"></span>
							
											<span class="star star_left"></span>
											<span class="star star_right"></span>
										</div>
									</div>
									<div class="form-group">
									  <label for="comment">Comment:</label>
									  <textarea class="form-control" rows="5" id="contents"></textarea>
									</div>
									<button type="button" class="btn btn-success" id="write">Write</button>
								</div>
								<div id="review" title="movie1"></div>
							</li>
						</ul>
						
					</div>
					
				</div><!-- contents -->
			
			</div>
	
		
	
		<div></div>
	
		</div>
	
	</div>
</main>

<script type="text/javascript" src="../resources/jquery/movieDetail.js"></script>
<script type="text/javascript" src="../resources/jquery/review.js"></script>
<script type="text/javascript" src="../resources/jquery/review.js"></script>

</body>
</html>