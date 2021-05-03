<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${list }" var="dto" varStatus="i">
	<li>
		<div class="item_poster">
			<div class="thumb_item">
				<div class="poster_movie">
					<img class="item_thumb" alt="${dto.movieNm }" src="${dto.poster }">
					<span class="rank_num">${dto.rankNum }</span> <span
						class="txt_tag${i.index }">
						<!-- ico_movie ico_see -->
					</span>
				</div>
				<!-- hidden -->
				<div class="poster_info">
					<a href="" class="link_story linkDetail" title="poster">${dto.movieInfo }</a>
					<span class="info_btn"> 
						<a href="" class="link_info linkDetail" target="_blank">예매하기</a>
					</span>
				</div>
			</div>

			<div class="thumb_cont">
				<strong class="tit_item movieNm">
					<a href="" class="link_txt linkDetail" title="moviename">${dto.movieNm }</a>
				</strong> 
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