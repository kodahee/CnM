/**
 * 
 */
//전역 변수 
let date = new Date();
date.setTime(date.getTime()-86400000);//하루전으로 돌림
//날짜 지정 메서드(하루 전을 파라미터로 넘겨야 함)
//주간으로 할때 월~일로 해야하는데 오늘이 몇요일인지 확인해서 하는게 필요할까,,?
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
	return year+month+day;

}


let movieCdList=[];
$.ajax({
	type:"GET",
	url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
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

commonList(movieCdList);