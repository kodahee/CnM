<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<ul class="nav justify-content-end">
		<li class="nav-item">
			<a class="nav-link active" href="${pageContext.request.contextPath }/">홈</a></li>
		<li class="nav-item">
			<a class="nav-link active" href="${pageContext.request.contextPath }/ranking/reservation">랭킹</a></li>
		<li class="nav-item">
			<a class="nav-link" href="#">상영/예정작</a></li>
		<li class="nav-item">
			<a class="nav-link" href="#">콘텐츠</a></li>
		<li class="nav-item">
			<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">고객센터</a></li>
		<li class="nav-item" href="#">
			<form class="form-inline">
			    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			    <img alt="search" src="${pageContext.request.contextPath }/resources/img/search.png" id="submit">
			</form>	
		</li>
	</ul>
</div>
<div>
<c:if test="${ranking !=null}">
<form action="./${ranking}" method="get">
<button class="btn btn-sm btn-outline-secondary" type="button" >reservation</button>
<button class="btn btn-sm btn-outline-secondary" type="button">boxOffice</button>
</form>
</c:if>
</div>