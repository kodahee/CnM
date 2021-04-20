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

	<div class="container">

		<h2>${board}List</h2>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>NUM</th>
					<th>GENRE</th>
					<th>TITLE</th>
					<th>NICKNAME</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td>${dto.genre}</td>
						<td>
							<a href="./${board}Select?num=${dto.num}">${dto.title}</a>
						</td>
						<td>${dto.nickName}</td>
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
						<option class="sel">Genre</option>
					</select>
				</div>
				<input type="text" class="form-control" name="search" id="search" value="${pager.search}" placeholder="">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div>

		
		<a href="./${board}Insert" class="btn  btn-primary" role="button">Write</a>
		
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