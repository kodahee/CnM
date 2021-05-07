<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	  <textarea class="form-control" rows="2" id="contents" placeholder="후기 작성"></textarea>
	</div>
	<button type="button" class="btn btn-success" id="write">확인</button>
</div>

<table class="table table-hober">
	<c:forEach items="${list}" var="review">
		<tr>
			<td class="reviewNum">${review.reviewNum}</td>
			<td>${review.star}</td>
			<td>${review.nickName}</td>
			<td>${review.contents}</td>
			<td>${review.regDate}</td>
			<td><input type="button" class="good" value="좋아요"></td>
			<td class="goodNum">${review.goodNum}</td>
			<td><input type="button" class="bad" value="싫어요"></td>
			<td>${review.badNum}</td>
			<c:if test="${review.id eq member.id}">
				<td><button class="remove2" value="${review.reviewNum}">삭제</button></td>
			</c:if>
		</tr>
	</c:forEach>
</table>
