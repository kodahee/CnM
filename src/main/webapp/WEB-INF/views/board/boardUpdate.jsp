<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">

<!-- summernote  -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<style type="text/css">
	#sample {
		display: none;
	}
</style>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h2>${board} Update Page</h2>

		<form id="frm" action="./${board}Update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${param.num}">
			<div class="form-group">
				<label for="nickName">NickName</label> 
				<input class="form-control form-control-lg" type="text" value="${dto.nickName}" id="nickName" name="nickName" readonly="readonly">
			</div>
			<c:if test="${board eq 'community'}">
				<div class="form-group">
					<label for="genre">Genre</label> 
					<input class="form-control form-control-lg" type="text" value="${dto.genre}" name="genre" id="genre">
				</div>
			</c:if>
			<div class="form-group">
				<label for="title">Title</label> 
				<input class="form-control form-control-lg" type="text" value="${dto.title}" name="title" id="title">
			</div>
			<div class="form-group">
				<label for="contents">Contents</label>
				<textarea class="form-control" id="contents" rows="10" name="contents">${dto.contents}</textarea>
			</div>
			
			<c:forEach items="${dto.boardFiles}" var="file">
				<div>
					<span>${file.originName}</span><span class="fileDelete" title="${file.fileNum}">X</span>
				</div>
			</c:forEach>
			
			<input type="button" value="Add" id="add" class="btn btn-danger">
			
			<div id="files" title="${dto.boardFiles.size()}"></div>
			
			<input type="submit" value="Update" id="btn" class="btn btn-primary">

		</form>
	</div>
	
	<div id="sample">
		<div class="input-group">
			<div class="custom-file">
				<input type="file"  id="inputGroupFile04" class="form-control-file border" name="files">
			</div>
			<div class="input-group-append delete">
				<input class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" value="Delete">
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="../resources/jquery/boardUpdate.js"></script>
	<script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>
	<script type="text/javascript" src="../resources/jquery/summerFile.js"></script>
	<!-- <script type="text/javascript" src="../resources/js/insertCheck.js"></script> -->
</body>
</html>