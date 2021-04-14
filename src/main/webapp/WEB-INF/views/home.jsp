<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="./template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<button id="btn3">btn3</button>
<h3 id="krw"></h3>
<h3 id = "usd"></h3>

<button id="btn">button</button>
<h3 id="test"> </h3>

<script type="text/javascript">
	$("#btn").click(function(){
		$.ajax({
			type:"GET",
			uri:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleList.json",
			data:{
				key:"88c812405e947836cbbee3be8daa5603",
				peopleNm:"김희애"
			},
			success:function(result){
				console.log(result);
				alert('hihi')	
			}
		})//ajax
	});
	
	$("#btn3").click(function(){
		let money=$("#exchange").val();
		$.ajax({
			type:"GET",
			url:"https://api.manana.kr/exchange/price.json",
			data:{
				base:"KRW",
				price: money,
				code:"KRW,USD,JPY"
			},
			success: function(data){
				console.log(data)
				$("#krw").html(data.KRW);
				$("#usd").html(data.USD)
			}
		})
				
	});
</script>
</body>
</html>