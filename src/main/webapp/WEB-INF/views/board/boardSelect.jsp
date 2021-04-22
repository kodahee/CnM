<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h1>${board} Select Page</h1>
		<h3>Title : ${dto.title}</h3>
		<c:if test="${board eq 'community'}">
			<h3>Genre : ${dto.genre}</h3>
		</c:if>
		<h3>Writer : ${dto.nickName}</h3>
		<h3>Contents : ${dto.contents}</h3>
		
		<div>
		<c:forEach items="${dto.boardFiles}" var="file">
			<a href="../resources/upload/${board}/${file.fileName}">${file.originName}</a>
		</c:forEach>
		</div>
		
		<!-- 댓글 리스트 -->
		<div id="comments" title="${dto.num}">
			
		</div>
		
		<div>
			<div class="form-group">
			  <label for="usr">NickName:</label>
			  <input type="text" class="form-control" id="nickName" value="${member.nickName}" readonly="readonly">
			</div>
			<div class="form-group">
			  <label for="comment">Comment:</label>
			  <textarea class="form-control" rows="5" id="contents"></textarea>
			</div>
			<button type="button" class="btn btn-success" id="write">Write</button>
		</div>
		
		
		<a href="./${board}Update?num=${dto.num}" class="btn btn-danger">Update</a>
		<a href="#" id="del" class="btn btn-info">Delete</a>

		
		<form action="./${board}Delete" id="frm">
			<input type="hidden" name="num" value="${dto.num}">
		</form>
		
	</div>
	
	<script type="text/javascript" src="../resources/jquery/comments.js"></script>
	
	<script type="text/javascript">
	
		const del = document.getElementById("del");
		const frm = document.getElementById("frm");
	
		/* callback 함수 */
		del.addEventListener("click", function del() {
			let result = confirm("Delete");
			console.log(result);
			
			if(result) {
				frm.setAttribute("method", "post");
				frm.submit();
			}
		});
	
	</script>


</body>
</html>