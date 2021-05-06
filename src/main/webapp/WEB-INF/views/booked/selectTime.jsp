<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/selectTime.css">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	
<main class="content">
	<div class="article">
	
	<div class="box_select">
		<div class="info_poster">
			<img class="posterItem"alt="" src="${dto.poster }">
		</div>
		<div class="movieNm">
			<h3>${dto.movieNm }임시제목</h3>
		</div>
		
		<div class="txt">극장</div>
		<div class="layer_body">
			<div class="set_body">
				<div class="inner_cont location">
					<dl class="list_cont">
						<dt class="select" title="seoul">서울특별시</dt>
					</dl>
					<dl class="list_cont">
						<dt title="busan">부산광역시</dt>
					</dl>
					<dl class="list_cont">
						<dt title="gwangju">광주광역시</dt>
					</dl>
					<dl class="list_cont">
						<dt title="incheon">인천광역시</dt>
					</dl>
					<dl class="list_cont">
						<dt title="sejong">세종광역시</dt>
					</dl>
					<dl class="list_cont">
						<dt title="daejeon">대전광역시</dt>
					</dl>
					<dl class="list_cont">
						<dt title="daegu">대구광역시</dt>
					</dl>
					<dl class="list_cont">
						<dt title="ulsan">울산광역시</dt>
					</dl>
				</div><!-- location -->
			</div>
		
			<div class="time">
				<div class="schedule"><!-- selectTimeBoard --></div>
			</div>
		
		</div>

	</div>
	</div>
</main>
<script type="text/javascript" src="../resources/jquery/selectTime.js"></script>

</body>
</html>