<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Member Update Page</h1>
	
	<form class="form-horizontal" action="./memberUpdate" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					placeholder="Enter Name" name="name" value="${member.name}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="phone">Phone</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="phone"
					placeholder="Enter Phone" name="phone" value="${member.phone}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="email"
					placeholder="Enter Email" name="email" value="${member.email}">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="profilePic">Profile Pic</label>
			<div class="col-sm-10">
				<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="nickName">NickName</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nickName"
					placeholder="Enter NickName" name="nickName" value="${member.nickName}">
			</div>
		</div>		
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Edit</button>
			</div>
		</div>
	</form>
	
	<a href="./memberDelete" class="btn btn-danger" role="button">탈퇴</a>

</body>
</html>