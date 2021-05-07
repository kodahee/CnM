<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<c:import url="./template/bootStrap.jsp"></c:import>

	<title>Home</title>
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
	
</head>
<body>



	<div class="kkao_wrap home_type">
		<header class="kakao_head">
			<div class="kakaohead_menu">
				<div class="inner_head">
					<c:import url="./template/header.jsp"></c:import>
				</div>
			</div>
		</header>
		<main class="kakao_centent">
			<article id="mainContent" class="kakao_article">
				<section class="feature_home">
					<div class="movieisual_list">
						<ul class="list_movieisual">
							<li></li>
							
						</ul>
					</div>
					<div class="slide_ranking">
						<ol class="slide_wrap topmovie-slide topmovie-slide-initialized topmovie-slide-horizontal">
							<li style="margin-left: 0px; width: 204px; margin-right: 20px;" class="swiper-slide swiper-slide-active">
								<div class="item_poster"> 
									<div class="thumb_item">
										<div class="poster_movie">
											<img src="">
											<span class="rank_num"></span>
										</div>
									</div>
									<div class="thumb_cont">
										<strong class="tit_item"></strong>
									</div>
								</div>
							</li>
						</ol>
					</div>
				</section>
				
				<div ></div>
				
				
				
			</article>
		
		</main>
	
	</div>


</body>
</html>