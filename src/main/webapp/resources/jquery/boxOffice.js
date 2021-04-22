/**
 * 
 */
//전역 변수
//캘린더에 selectDay(date타입) 있고 몇요일인지 확인 할 필요 없이 json출력 되는 거 확인 
//캘런더 선택 함수가 실행될때 selectDay있고 아닐 땐 없음
let date = new Date();
if(selectDay != null){
	date= selectDay;
}else{
	date=date.getTime()-86400000;//하루전으로 돌림
}

function getDate(date){
	let year = date.getFullYear();//YYYY
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
	console.log(year+month+day)
	return year+month+day;

}

let movieCdList=[];
//function search(){
$.ajax({
	type:"GET",
	url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json",
	data:{
		key:"88c812405e947836cbbee3be8daa5603",
		targetDt:getDate(date),
		weekGb:0
		},
	async: false,
	success:function(result){
		
		result=result.boxOfficeResult.dailyBoxOfficeList;
	
		for(index in result){
			let one=result[index];
			
			let rank = '<h3 id="rank">'+one.rank+'</h3>';
			let movieNm = '<h3 class="movieNm">'+one.movieNm+'</h3>';
			let movieCd = one.movieCd;
			
			
			
			$('.test'+index).append(rank+movieNm);
			
			movieCdList.push(movieCd);
					
		};

				
	}
})//ajax
//}//function
commonList(movieCdList);