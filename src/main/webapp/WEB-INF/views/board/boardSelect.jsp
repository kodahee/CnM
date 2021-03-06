<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<title>Insert title here</title>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h1>${board} Select Page</h1>
		<h3>Title : ${dto.title}</h3>
		<c:choose>
			<c:when test="${board eq 'community'}">
				<h3>Genre : ${dto.genre}</h3>
			</c:when>
			<c:when test="${board eq 'qna'}">
				<h3>Genre : ${dto.category}</h3>
			</c:when>
		</c:choose>
		<h3>NickName : ${dto.nickName}</h3>
		<h3>Contents : ${dto.contents}</h3>
		
		<div>
		<c:forEach items="${dto.boardFiles}" var="file">
			<a href="../resources/upload/${board}/${file.fileName}">${file.originName}</a>
		</c:forEach>
		</div>
		
		<!-- 댓글 리스트 -->
		<c:if test="${board eq 'community'}">
			<div id="comments" title="${dto.num}">
				
			</div>
		
			<div>
				<div class="form-group" hidden="hidden">
				  <label for="usr">NickName:</label>
				  <input type="text" class="form-control" id="nickName" value="${member.nickName}">
				</div>
				<div class="form-group">
				  <label for="comment">Comment:</label>
				  <textarea class="form-control" rows="5" id="contents"></textarea>
				</div>
				<button type="button" class="btn btn-success" id="write">Write</button>
			</div>
		</c:if>
		
		<c:choose>
			<c:when test="${board eq 'community' && dto.nickName eq member.nickName}">
				<a href="./${board}Update?num=${dto.num}" class="btn btn-danger">Update</a>
				<a href="#" id="del" class="btn btn-info">Delete</a>
			</c:when>
			<c:when test="${board eq 'notice' && member.nickName eq 'admin'}">
				<a href="./${board}Update?num=${dto.num}" class="btn btn-danger">Update</a>
				<a href="#" id="del" class="btn btn-info">Delete</a>
			</c:when>
			<c:when test="${board eq 'faq' && member.nickName eq 'admin'}">
				<a href="./${board}Update?num=${dto.num}" class="btn btn-danger">Update</a>
				<a href="#" id="del" class="btn btn-info">Delete</a>
			</c:when>
			<c:when test="${board eq 'qna' && dto.nickName eq member.nickName}">
				<a href="#" id="del" class="btn btn-info">Delete</a>
			</c:when>
		</c:choose>
		
		<c:if test="${board eq 'qna' && member.id eq 'admin'}">
			<a href="./${board}Reply?num=${dto.num}" class="btn btn-primary">Reply</a>
		</c:if>
		
		<form action="./${board}Delete" id="frm" method="get">
			<input type="hidden" name="num" value="${dto.num}">
		</form>
		
	</div>
	
	<script type="text/javascript" src="../resources/jquery/comments.js"></script>
	
	<!-- <script type="text/javascript">
	
		//const del = document.getElementById("del");
		const frm = document.getElementById("frm");
	
		/* callback 함수 */
		$(".del").on("click", function() {
			let result = confirm("삭제 하시겠습니까?");
			console.log(result);
			
			if(result) {
				frm.setAttribute("method", "post");
				frm.submit();
			}
		});
	
	</script> -->


</body>
</html>