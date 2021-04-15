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
			//http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=88c812405e947836cbbee3be8daa5603&targetDt=20210414
			traditional: true,
			success:function(result){
				
				console.log(result);//데이터를 받아왔고,,, 이걸 출력하는데,,벨류로 줘서 다시 컨트롤러에서 받기,,
				let result2=result.boxOfficeResult.dailyBoxOfficeList;
				//$('#result').val(result2);
				for(index in result2){
					let result3=result2[index];
					$('#result').val(JSON.stringify(result3));
					console.log(result3)//Object타입,,?Json자체,,
					console.log(JSON.stringify(result3))//String타입,,
				};
				//$("#result").val(JSON.stringify(result.boxOfficeResult.dailyBoxOfficeList));//가능은한데,, 
				console.log(result.boxOfficeResult.dailyBoxOfficeList);
				
			}
		})//ajax
});

