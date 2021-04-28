<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav>	
	<ul class="nav justify-content-end memberNav">
		<c:if test="${empty member}">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogin">Login</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberJoinCheck">Join</a></li>
		</c:if>
				
		<c:if test="${not empty member}">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberMyPage">MyPage</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogout">Logout</a></li>
		</c:if>
	</ul>
	
		
	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath }/">홈</a></li>
		<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath }/ranking/reservation">랭킹</a></li>
		<li class="nav-item"><a class="nav-link" href="#">상영/예정작</a></li>		
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown"> 커뮤니티 </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/community/communityList">Community</a>
			</div>
		</li>
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown"> 고객센터 </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/notice/noticeList">Notice</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/faq/faqList">Faq</a> 
				<a class="dropdown-item" href="${pageContext.request.contextPath}/qna/qnaList">QnA</a> 
			</div>
		</li>	
		<li class="nav-item" href="#">
			<form class="form-inline">
			    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			    <img alt="search" src="${pageContext.request.contextPath }/resources/img/search.png" id="submit">
			</form>	
		</li>
	</ul>
</nav> 