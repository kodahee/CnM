<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${list }" var="dto" varStatus="i">
	<li>
		<h3>
			<img class="poster" alt="" src="${dto.poster }">
		</h3>
		<h6>${dto.movieInfo }</h6>
		<h3>${dto.reservation }</h3>


		<div class="subInfo${i.index }"></div>
	</li>
</c:forEach>