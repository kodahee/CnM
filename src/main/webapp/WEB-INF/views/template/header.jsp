<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Logo</a>

		<!-- Links -->
		<ul class="navbar-nav">
			<c:if test="${empty member}">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogin">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberJoinCheck">Join</a></li>
			</c:if>
			
			<c:if test="${not empty member}">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberMyPage">MyPage</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogout">Logout</a></li>
			</c:if>
			
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> Board </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/notice/noticeList">Notice</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/faq/faqList">Faq</a> 
					<a class="dropdown-item" href="${pageContext.request.contextPath}/qna/qnaList">QnA</a> 
					<a class="dropdown-item" href="${pageContext.request.contextPath}/community/communityList">Community</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/ranking/reviewList">Review</a>
				</div>
			</li>
		</ul>
	</nav>
