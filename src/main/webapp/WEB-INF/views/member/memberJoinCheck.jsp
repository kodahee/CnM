<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>Member Join Check Page</h1>
		
		<div class="form-check">
			<label class="form-check-label"> 
				<input type="checkbox" class="form-check-input" value="" id="all"> 전체동의 <br>
				<p>CnM 이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 정보 수신(선택)에 모두 동의합니다.</p>
			</label>
		</div>

		<!---------------------- 1 ------------------------->
		<div class="form-check">
			<label class="form-check-label"> 
				<input type="checkbox" class="form-check-input ch ch1" value=""> CnM 이용약관 동의(필수)
			</label>
		</div>
		<div class="jumbotron">
			<p>
		        CnM 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다.
		        본 약관은 다양한 CnM 서비스의 이용과 관련하여 CnM 서비스를 제공하는 CnM 주식회사(이하 ‘CnM’)와
		        이를 이용하는 CnM 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며,
		        아울러 여러분의 CnM 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
    		</p>
		</div>
		
		<!---------------------- 2 ------------------------->
		<div class="form-check">
			<label class="form-check-label"> 
				<input type="checkbox" class="form-check-input ch ch1" value=""> 개인정보 수집 및 이용 동의(필수)
			</label>
		</div>
		<div class="jumbotron">
		  <p class="contents">개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.</p>
		  <p class="title">1. 수집하는 개인정보</p>
		  <p class="contents">이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 네이버 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 네이버는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.</p>
		</div>
		
		<!---------------------- 3 ------------------------->
		<div class="form-check">
			<label class="form-check-label"> 
				<input type="checkbox" class="form-check-input ch ch2" value=""> 위치정보 이용약관 동의(선택)
			</label>
		</div>
		<div class="jumbotron">
		  <p class="contents">위치정보 이용약관에 동의하시면, <strong>위치를 활용한 광고 정보 수신</strong>  등을 포함하는 네이버 위치기반 서비스를 이용할 수 있습니다.</p>
		  <p class="title">제 1 조 목적</p>
		  <p class="contents">이 약관은 네이버 주식회사 (이하 “회사”)가 제공하는 위치정보사업 또는 위치기반서비스사업과 관련하여 회사와 개인위치정보주체와의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.</p>
		</div>
		
		<!---------------------- 4 ------------------------->
		<div class="form-check">
			<label class="form-check-label"> 
				<input type="checkbox" class="form-check-input ch ch2" value=""> 프로모션 정보 수신 동의(선택)
			</label>
		</div>
		<div class="jumbotron">
		  <p>네이버에서 제공하는 이벤트/혜택 등 다양한 정보를 휴대전화(네이버앱 알림 또는 문자), 이메일로 받아보실 수 있습니다. 일부 서비스(별도 회원 체계로 운영하거나 네이버 가입 이후 추가 가입하여 이용하는 서비스 등)의 경우, 개별 서비스에 대해 별도 수신 동의를 받을 수 있으며, 이때에도 수신 동의에 대해 별도로 안내하고 동의를 받습니다.</p>
		</div>
		
		
		<button class="btn btn-danger" id="btn">JOIN</button>
		<!-- <input type="button" id="btn" value="JOIN" class="btn btn-danger"> -->
		
		<script type="text/javascript" src="../resources/jquery/memberJoinCheck.js"></script>
		
	</div>

</body>
</html>