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
		<c:when test="${nav eq 'ranking' }">
			<div class="subNav_name">랭킹</div>
			<div>
				<span><a class="subNav_item i1 on" href="${pageContext.request.contextPath }/ranking/reservation">예매율</a></span>
				<span><a class="subNav_item i2 " href="${pageContext.request.contextPath }/ranking/boxOffice">박스오피스</a></span>
			</div>
		</c:when>
		
		<c:when test="${nav eq 'preMovie'}">
			<div class="subNav_name">상영/예정작</div>
		</c:when>
		
		<c:when test="${nav eq 'community'}">
			<div class="subNav_name">커뮤니티</div>
			<div>
				<span><a class="subNav_item on" href="${pageContext.request.contextPath}/community/communityList">All</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=국내">국내</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=해외">해외</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=액션">액션</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=SF">SF</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=코미디">코미디</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=스릴러">스릴러</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=멜로">멜로</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=판타지">판타지</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=스포츠">스포츠</a></span>
	        	<span><a class="subNav_item" href="${pageContext.request.contextPath}/community/communityList?kind=Genre&search=음악">음악</a></span>
			</div>
		</c:when>
		
		<c:when test="${nav eq 'serviceCenter'}">
			<div class="subNav_name">고객센터</div>
			<div>
				<span><a class="subNav_item on" href="${pageContext.request.contextPath}/notice/noticeList">Notice</a></span>
				<span><a class="subNav_item" href="${pageContext.request.contextPath}/faq/faqList">Faq</a></span>
				<span><a class="subNav_item" href="${pageContext.request.contextPath}/qna/qnaList">QnA</a></span>
			</div>
		</c:when>
	</c:choose>
</div>

</div>

