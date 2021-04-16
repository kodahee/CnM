/**
 * 
 */
//전역 변수 
let date = new Date();
	
//날짜 지정 메서드(하루 전을 파라미터로 넘겨야 함)
function getDate(date){
	let year = date.getFullYear();
	let month = (1+date.getMonth());
	if(month>=10){
		month=month
	}else{
		month='0'+month;
	};
	let day = date.getDate();
	if(day>=10){
		day=day;
	}else{
		day='0'+day;
	}
	return year+month+day;

}

$("#btn").click(function(){
		$.ajax({
			type:"GET",
			url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
			data:{
				key:"88c812405e947836cbbee3be8daa5603",
				targetDt:getDate(date)-1,//하루 전날 
			},
			
			traditional: true,
			success:function(result){
				
			//	console.log(result);//데이터를 받아왔고,,, 이걸 출력하는데,,벨류로 줘서 다시 컨트롤러에서 받기,,
				let result2=result.boxOfficeResult.dailyBoxOfficeList;

				for(index in result2){
					let result3=result2[index];
					//console.log(JSON.stringify(result3));스트링타입이라서 ""때문에 에러아닌 에러가 생김 인식이 안되는 것.
					console.log("rank:"+result3.rank);
					console.log("name:"+result3.movieNm);
					//랭킹rank, 이름movieNm, 평점, 예매율, 개봉일openDt
					//직접 쳐서 옮겨라 ㅜ
					//$('#rank').text(result3.rank);
					//$('#movieNm').text(result3.movieNm);
					let rank = '<h3 id="rank">'+result3.rank+'</h3>';
					let movieNm = '<h3 id="movieNm">'+result3.movieNm+'</h3>';
					
					let list='<div><div id="TT">'+rank+movieNm+'</div></div>';
					$('#result').append(list);
					//$('#result').append(movieNm);
					/*let test = '<input type="text" name="jsonString" >';
					console.log(test)
					$('#result').append(test);*/
					
				};

				
			}
		})//ajax
});

$('#btn2').click(function(){
	

	$.ajax({
	
	url : "./bookingRanking",
	type:"POST",
	data: {CSRFToken: "W4V7cEw7nkifuib9SdxFnkNmmdK5xYGBzORfxHG-BxU"}
	
	}).done(function(data) {
	console.log("hi");

	});


	
});