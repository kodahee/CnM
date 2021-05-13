/**
 * 
 */
$('.i1').removeClass('on');
$('.i2').addClass('on');


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
	return year+month+day;
}


searchAPI()
function searchAPI(){
	/*alert('date'+getDate(date))
	alert('select'+getDate(selectDay))*/
	if(getDate(date)==getDate(selectDay)){
		date = new Date(Date.parse(date));
	}else{
		movieCdList=[];
		date= selectDay;		
	}
	if(date.getDay()!=0){
		date=date-86400000*6;
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
		
		for(index in result){
			let one=result[index];
			
			let rank = '<h3 id="rank">'+one.rank+'</h3>';
			let movieNm = '<h3 class="movieNm">'+one.movieNm+'</h3>';
			let movieCd = one.movieCd;
			
			$.ajax({//DB에 코드 저장하기 위한 용도
					url: './boxOffice',
					type: 'POST',
					dataType: 'text',
					data: {movieCd: one.movieCd, movieNm: one.movieNm},
					success: function(result){
						console.log(one.movieCd)
						console.log(one.movieNm)
					}
				});
			
			$('.subInfo'+index).append(rank+movieNm);
			
			movieCdList.push(movieCd);
			
		};

				
	}
})//ajax

console.log(movieCdList)
commonList(movieCdList);
}//function


setWeek()
function setWeek(){
	selectDay = new Date(Date.parse(selectDay));
	
	if(selectDay.getDay()!=0){
			
			selectDay=selectDay.getTime()-(86400000*selectDay.getDay());
		}
	selectDay = new Date(selectDay);
	
	let str2 = selectDay.toLocaleDateString();
	
	selectDay = new Date(selectDay.getTime()-(86400000*6));
	let str = selectDay.toLocaleDateString();
	
	$('.selectDate_item').text(str+'~'+str2);

}
