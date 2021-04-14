/**
 * 
 */
//랭크
$("#btn").click(function(){
		$.ajax({
			type:"GET",
			url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
			data:{
				key:"88c812405e947836cbbee3be8daa5603",
				targetDt:"20210413",//캘린더에서 하루 뺀 날자 받아와야할듯 
				itemPerPage:20
			},
			dataType:"json",
			traditional: true,
			success:function(result){
			
				console.log(result);//데이터를 받아왔고,,, 이걸 출력하는데,,벨류로 줘서 다시 컨트롤러로 뺏어올까,,? 가능? 
				let result2=result.boxOfficeResult.dailyBoxOfficeList;
				for(index in result2){
					let result3=result2[index];
					$('#result').val(JSON.stringify(result3));
					console.log(result3)
				};
				//$("#result").val(JSON.stringify(result.boxOfficeResult.dailyBoxOfficeList));//가능은한데,, 
				console.log(result.boxOfficeResult.dailyBoxOfficeList);
				
			}
		})//ajax
});

//주간
$.ajax({
	type:"GET",
	url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json",
	data:{
				key:"88c812405e947836cbbee3be8daa5603"
	},
	success:function(){
		
	}
})