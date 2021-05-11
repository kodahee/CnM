<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<table class="table table-hober">
		<c:forEach items="${list}" var="review">
			<tr>
				<td class="reviewNum" hidden="hidden">${review.reviewNum}</td>
				<td>${review.star}</td>
				<td>${review.nickName}</td>
				<td>${review.contents}</td>
				<td>${review.regDate}</td>
				<td><button class="good btn btn-primary">Good</button></td>
				<td class="goodNum">${review.goodNum}</td>
				<td><button class="bad btn btn-primary">Bad</button></td>
				<td>${review.badNum}</td>
				<c:if test="${review.id eq member.id}">
					<td><button class="remove2 btn btn-danger" value="${review.reviewNum}">Delete</button></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
