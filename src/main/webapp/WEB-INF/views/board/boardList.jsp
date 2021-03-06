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
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<!-- 커뮤니티 카테고리 -->
		<c:if test="${board eq 'community'}">
		     <%--  <ul class="nav justify-content-center">
		        <li class="nav-item">
		          <a class="nav-link" href="./${board}List">All</a>
		        </li>
		      <!-- 국내 해외 액션 SF 코미디 스릴러 멜로 판타지 스포츠 음악 -->  
		      <c:forEach items="${genre}" var="dto">
		        <li class="nav-item">
		          <a class="nav-link" href="./${board}List?kind=Genre&search=${dto.genre}">${dto.genre}</a>
		        </li>
		      </c:forEach>
		      
		      </ul> --%>
		      <hr class="d-sm-none">
	    </c:if>

		<table class="table">
			<thead>
				<tr>
					<th>NUM</th>
					<c:choose>
						<c:when test="${board eq 'community'}">
							<th>GENRE</th>
						</c:when>
						<c:when test="${board eq 'qna'}">
							<th>CATEGORY</th>
						</c:when>
					</c:choose>
					<th>TITLE</th>
					<c:choose>
						<c:when test="${board eq 'qna'}">
							<th>ID</th>
						</c:when>
						<c:otherwise>
							<th>NICKNAME</th>
						</c:otherwise>
					</c:choose>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<c:choose>
							<c:when test="${board eq 'community'}">
								<td>${dto.genre}</td>
							</c:when>
							<c:when test="${board eq 'qna'}">
								<td>${dto.category}</td>
							</c:when>
						</c:choose>
						<td>
							<c:choose>
								<c:when test="${board eq 'qna'}">
									<c:choose>
										<c:when test="${dto.onOff eq 'N'}">
											<a href="./${board}Select?num=${dto.num}">${dto.title}</a>
										</c:when>
										<c:when test="${dto.onOff eq 'Y' && dto.id eq member.id}">
											<a href="./${board}Select?num=${dto.num}">${dto.title}</a>
										</c:when>
										<c:otherwise>
											${dto.title}
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<a href="./${board}Select?num=${dto.num}">${dto.title}</a>
								</c:otherwise>
							</c:choose>
						</td>
						<c:choose>
							<c:when test="${board eq 'qna'}">
								<td>${dto.id}</td>
							</c:when>
							<c:otherwise>
								<td>${dto.nickName}</td>
							</c:otherwise>
						</c:choose>
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>


	<!-- 페이징 -->
	<div class="container">
		<ul class="pagination">

			<c:if test="${pager.pre}">
				<li class="page-item"><a class="page-link p" href="#" title="${pager.startNum-1}">Previous</a></li>
			</c:if>

			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link p" href="#" title="${i}">${i}</a></li>
			</c:forEach>

			<c:if test="${pager.next}">
				<li class="page-item"><a class="page-link p" href="#" title="${pager.lastNum+1}">Next</a></li>
			</c:if>
		</ul>

		<div class="input-group mt-3 mb-3">
			<form action="./${board}List" class="form-inline" id="frm">
				<input type="hidden" name="curPage" value="1" id="curPage">
				<div class="input-group-prepend">
					<select class="form-control" name="kind" id="kind">
						<!-- select에 value는 없고 option에 있음 -->
						<option class="sel">Title</option>
						<option class="sel">Contents</option>
						<option class="sel">NickName</option>
						<c:if test="${board eq 'community'}">
							<option class="sel">Genre</option>
						</c:if>
					</select>
				</div>
				<input type="text" class="form-control" name="search" id="search" value="${pager.search}" placeholder="">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div>

		<c:choose>
			<c:when test="${board eq 'community'}">
				<a href="./${board}Insert" class="btn  btn-primary" role="button">Write</a>
			</c:when>
			<c:when test="${board eq 'notice' && member.id eq 'admin'}">
				<a href="./${board}Insert" class="btn  btn-primary" role="button">Write</a>
			</c:when>
			<c:when test="${board eq 'faq' && member.id eq 'admin'}">
				<a href="./${board}Insert" class="btn  btn-primary" role="button">Write</a>
			</c:when>
			<c:when test="${board eq 'qna' && member.id ne 'admin'}">
				<a href="./${board}Insert" class="btn  btn-primary" role="button">Write</a>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		
		<script type="text/javascript">
			let kind = '${pager.kind}';
			$(".sel").each(function() {
				let t = $(this).text();
				if(t == kind) {
					$(this).prop("selected", true);
				}
			});
			
			$(".p").click(function () {
				let curPage = $(this).attr("title");
				$("#curPage").val(curPage);
				let search = '${pager.search}';
				
				$("#frm").submit();
			});
		</script>
	</div>
</body>
</html>