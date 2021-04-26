<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h2>Select Seat Page</h2>

		<form id="frm" action="./selectSeat" method="post"
			enctype="multipart/form-data">

			<div class="form-group">
				<label for="adult">성인</label>
				<div class="btn-group">
					<c:forEach var="i" begin="0" end="5">
						<input type="button" class="btn btn-primary adult" value="${i}" name="adult">
					</c:forEach>
				</div>
			</div>
			<div class="form-group">
				<label for="kids">청소년</label>
				<div class="btn-group">
					<c:forEach var="i" begin="0" end="5">
						<input type="button" class="btn btn-primary kids" value="${i}" name="kids">
					</c:forEach>
				</div>
			</div>
			
			<div class="form-group">
				<label for="info">선택한 상영관 및 시간</label>
				<%-- <div>
					<p>${booked.region}</p>
					<p>${booked.room}</p>
					<p>${booked.movieTitle}</p>
					<p>${booked.time}</p>
				</div> --%>
			</div>
			<div class="form-group">
				<label for="info">선택한 좌석</label>
				<div class="seats">
					<%-- <p>선택한 좌석명</p> --%>
				</div>
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-light" id="reset">처음부터 다시 선택</button>				
			</div>
			

			<div class="seat-wrap">
				<div class="seat-screen"></div>
				
				<div class="seat-area">
					<c:forEach var="i" begin="1" end="20">
						<c:choose>
							<c:when test="${i eq 1}"><h6 class="row">A</h6></c:when>
							<c:when test="${i eq 2}"><h6 class="row">B</h6></c:when>
							<c:when test="${i eq 3}"><h6 class="row">C</h6></c:when>
							<c:when test="${i eq 4}"><h6 class="row">D</h6></c:when>
							<c:when test="${i eq 5}"><h6 class="row">E</h6></c:when>
							<c:when test="${i eq 6}"><h6 class="row">F</h6></c:when>
							<c:when test="${i eq 7}"><h6 class="row">G</h6></c:when>
							<c:when test="${i eq 8}"><h6 class="row">H</h6></c:when>
							<c:when test="${i eq 9}"><h6 class="row">I</h6></c:when>
							<c:when test="${i eq 10}"><h6 class="row">J</h6></c:when>
							<c:when test="${i eq 11}"><h6 class="row">K</h6></c:when>
							<c:when test="${i eq 12}"><h6 class="row">L</h6></c:when>
							<c:when test="${i eq 13}"><h6 class="row">M</h6></c:when>
							<c:when test="${i eq 14}"><h6 class="row">N</h6></c:when>
							<c:when test="${i eq 15}"><h6 class="row">O</h6></c:when>
							<c:when test="${i eq 16}"><h6 class="row">P</h6></c:when>
							<c:when test="${i eq 17}"><h6 class="row">Q</h6></c:when>
							<c:when test="${i eq 18}"><h6 class="row">R</h6></c:when>
							<c:when test="${i eq 19}"><h6 class="row">S</h6></c:when>
							<c:when test="${i eq 20}"><h6 class="row">T</h6></c:when>
						</c:choose>
						<c:forEach var="j" begin="1" end="18">
							<input type="button" class="btn btn-primary myCheck seatName" value="${j}" name="seatName">
						</c:forEach>
					</c:forEach>
				</div>
			</div>



			<input type="button" value="결제하기" id="btn" class="btn btn-primary">

		</form>
	</div>
	
	<div id="seatList">
		<p>${booked.region}</p>
	</div>

	<script type="text/javascript" src="../resources/jquery/selectSeat.js"></script>

</body>
</html>