<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<h1>Review Page</h1>
	
	<div>
		<div class="form-group">
		  <label for="usr">NickName:</label>
		  <input type="text" class="form-control" id="nickName" value="${member.nickName}" readonly="readonly">
		</div>
		<div class="form-group">
			<div class="btn-group">
				<c:forEach var="i" begin="1" end="10">
					<button type="button" class="btn btn-primary">${i}</button>
				</c:forEach>
			</div>
		</div>
		<div class="form-group">
		  <label for="comment">Comment:</label>
		  <textarea class="form-control" rows="5" id="contents"></textarea>
		</div>
		<button type="button" class="btn btn-success" id="write">Write</button>
	</div>
	
	<table class="table table-hober">
		<c:forEach items="${list}" var="review">
			<tr>
				<td>${review.nickName}</td>
				<td>${review.contents}</td>
				<td>${review.regDate}</td>
				<td><input type="checkbox" class="del" value="${review.reviewNum}"></td>
			</tr>
		</c:forEach>
	</table>
	<button type="button" class="btn btn-danger" id="remove">Delete</button>

</body>
</html> 