<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<style type="text/css">
	*{margin:0; padding:0;}
	.star{
	  display:inline-block;
	  width: 30px;
	  height: 60px;
	  cursor: pointer;
	}
	.star_left{
	  background: url(../resources/img/emptyStar.png) no-repeat 0 0; 
	  background-size: 60px; 
	  margin-right: -3px;
	}
	.star_right{
	  background: url(../resources/img/emptyStar.png) no-repeat -30px 0; 
	  background-size: 60px; 
	  margin-left: -3px;
	}
	.star.on{
	  background-image: url(../resources/img/star.png);
	}
</style>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<h1>Review Page</h1>

    <div class="col-sm-4">
      <hr class="d-sm-none">
    </div>

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

	<table class="table table-hober">
		<c:forEach items="${list}" var="review">
			<tr>
				<td class="reviewNum" hidden="hidden">${review.reviewNum}</td>
				<td>${review.star}</td>
				<td>${review.nickName}</td>
				<td>${review.contents}</td>
				<td>${review.regDate}</td>
				<td><input type="button" class="good" value="Good"></td>
				<td class="goodNum">${review.goodNum}</td>
				<td><input type="button" class="bad" value="Bad"></td>
				<td>${review.badNum}</td>
				<c:if test="${review.id eq member.id}">
					<td><button class="remove2" value="${review.reviewNum}">Delete</button></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<script type="text/javascript" src="../resources/jquery/review.js"></script>

</body>
</html>