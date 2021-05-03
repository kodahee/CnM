<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">
				<div>
					<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
				</div>
				<h5>${member.nickName}</h5>
				<p>${member.grade}</p>
				<a href="./memberUpdate" class="btn btn-primary" role="button">Edit Profile</a>

				<hr class="d-sm-none">
			</div>
			<div class="col-sm-8">
				<ul class="nav nav-tabs nav-justified">
					<li class="nav-item"><a class="nav-link active" href="./memberMyPage">예매내역</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">포인트/쿠폰</a></li>
					<li class="nav-item"><a class="nav-link" href="#">문의내역</a></li>
					<li class="nav-item"><a class="nav-link" href="#">게시글</a></li>
				</ul>
			</div>
			<div class="col-sm-8">
				<c:choose>
					<c:when test="${myPage eq 'bookedList'}">
						<c:forEach items="${movie}" var="movie">
							<div class="card" style="width:400px">
							<img class="card-img-top" src="shinbi.jpg" alt="Card image" style="width:100%">
							  <div class="card-body">
							    <h4 class="card-title">영화제목</h4>
							    <p class="card-text">상영관</p>
							    <p class="card-text">날짜</p>
							    <a href="#" class="btn btn-primary">자세히 보기</a>
							  </div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${myPage eq 'pc'}">
						<h5>포인트</h5>
						<ul class="list-group">
						  <li class="list-group-item">${member.point}</li>
						</ul>
						<h5>쿠폰</h5>
						<ul class="list-group">
						  <li class="list-group-item">${member.couponName}</li>
						  <li class="list-group-item">남은 기간</li>
						</ul>
					</c:when>
					<c:when test="${myPage eq 'qna'}">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">
								<a href="./${board}Select?num=${dto.num}">${dto.title}</a>
							</li>
						</ul>
					</c:when>
					<c:when test="${myPage eq 'community'}">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">
								<a href="./${board}Select?num=${dto.num}">${dto.title}</a>
							</li>
						</ul>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>


</body>
</html>