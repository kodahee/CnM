/**
 * 
 */
//========전역 변수========
let selectDay=new Date();
let nowDate = new Date();
let date = new Date();
let movieCdList=[];
//=======================

function getDate(date){
	date = new Date(date);
	
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


searchAPI()
function searchAPI(){
	/*alert('date'+getDate(date))
	alert('select'+getDate(selectDay))*/
	if(getDate(date)==getDate(selectDay)){
		date=date.getTime()-86400000;
	}else{
		movieCdList=[];
		date= selectDay;		
	}
	
	
	
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
		
		result=result.boxOfficeResult.weeklyBoxOfficeList;
		
		console.log(test)
		for(index in result){
			let one=result[index];
			
			let rank = '<h3 id="rank">'+one.rank+'</h3>';
			let movieNm = '<h3 class="movieNm">'+one.movieNm+'</h3>';
			let movieCd = one.movieCd;
			
			$('.subInfo'+index).append(rank+movieNm);
			
			movieCdList.push(movieCd);
			
		};

				
	}
})//ajax
console.log(movieCdList)
commonList(movieCdList);
}//function