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

<!-- summernote -->
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

		<form id="frm" action="./${board}Insert" method="post" enctype="multipart/form-data">
			<c:choose>
				<c:when test="${board ne 'qna'}">
					<div class="form-group">
						<label for="nickName">NickName</label> 
						<input class="form-control form-control-lg myCheck" type="text" value="${member.nickName}" id="nickName" name="nickName" readonly="readonly">
					</div>
				</c:when>
				<c:when test="${board eq 'qna'}">
					<div class="form-group">
						<label for="id">Id</label> 
						<input class="form-control form-control-lg myCheck" type="hidden" value="${member.id}" id="id" name="id">
					</div>
				</c:when>
			</c:choose>
			
			
			<c:choose>
				<c:when test="${board eq 'community'}">
					<div class="form-group">
						<label for="genre">Genre</label>
						<select class="form-control myCheck" name="genre" id="genre">
							<option>국내</option>
							<option>해외</option>
							<option>액션</option>
							<option>SF</option>
							<option>코미디</option>
							<option>스릴러</option>
							<option>멜로</option>
							<option>판타지</option>
							<option>스포츠</option>
							<option>음악</option>
						</select>
					</div>
				</c:when>
				<c:when test="${board eq 'qna'}">
					<div class="form-group">
						<label for="category">Category</label>
						<select class="form-control myCheck" name="category" id="category">
							<option selected="selected">티켓예매</option>
							<option>분실물</option>
							<option>단체/대관문의</option>
							<option>기타문의</option>
						</select>
					</div>
				</c:when>
			</c:choose>
			
			<div class="form-group">
				<label for="title">Title</label> 
				<input class="form-control form-control-lg myCheck" type="text" name="title" id="title">
			</div>
			<div class="form-group">
				<label for="contents">Contents</label>
				<textarea class="form-control myCheck" id="contents" rows="10" name="contents"></textarea>
			</div>
			
			<input type="button" value="Add" id="add" class="btn btn-danger">
			<div id="files" title="0">
				<!-- add button을 클릭하면 sample 안에 있는 div 태그가 복사돼서 여기 들어옴
				최대 5개까지만 -->
			</div>
			
			<div class="form-group">
				<label for="private">공개 여부</label>
				<select class="form-control myCheck" name="onOff" id="onOff">
					<option value="N" selected="selected">공개</option>
					<option value="Y">비공개</option>
				</select>
			</div>
			<!-- <input class="form-control form-control-lg myCheck" type="text" name="onOff" id="onOff"> -->
			
			<input type="button" value="Write" id="btn" class="btn btn-primary">

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
	
	
	<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
	<script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>
	<script type="text/javascript" src="../resources/jquery/summerFile.js"></script>
</body>
</html>