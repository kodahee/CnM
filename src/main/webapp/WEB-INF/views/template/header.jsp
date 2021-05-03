<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="headerBox">
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
		<li class="nav-item"><a class="nav-link active" href="#">상영/예정작</a></li>		
		<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/community/communityList">커뮤니티</a></li>
		<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/notice/noticeList">고객센터</a></li>
			
				
				
		<li class="nav-item" href="#">
			<form class="form-inline">
			    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			    <img alt="search" src="${pageContext.request.contextPath }/resources/img/search.png" id="submit">
			</form>	
		</li>
	</ul>
</nav> 

<div class="subNav">
	<c:choose>
		<c:when test="${nav eq 'ranking'}">
			<div class="subNav_name">랭킹</div>
			<div>
				<span><a class="subNav_item" href="${pageContext.request.contextPath }/ranking/reservation">예매율</a></span>
				<span><a class="subNav_item" href="${pageContext.request.contextPath }/ranking/boxOffice/weekly">박스오피스</a></span>
			</div>
		</c:when>
		
		<c:when test="${nav eq 'preMovie'}">
			<div class="subNav_name">상영/예정작</div>
		</c:when>
		
		<%-- <c:when test="${nav eq 'contents' }">
			<div class="subNav_name">커뮤니티</div>
			<span ><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList">커뮤니티</a></span>
		</c:when> --%>
		
		<c:when test="${nav eq 'serviceCenter'}">
			<div class="subNav_name">고객센터</div>
			<span><a class="subNav_item" href="${pageContext.request.contextPath}/notice/noticeList">Notice</a></span>
			<span><a class="subNav_item" href="${pageContext.request.contextPath}/faq/faqList">Faq</a></span>
			<span><a class="subNav_item" href="${pageContext.request.contextPath}/qna/qnaList">QnA</a></span>
		</c:when>
	</c:choose>
</div>

</div>