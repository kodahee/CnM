/**
 * 
 */
let dateWeeklyList = [];
let dateMonthlyList = [];
let dateYearlyList=[];

function getDateList(){
	
}
$('button').click(function(){
	getWeaklyBO();
});


//매개값으로 targetDT(주간이면 7개 월간이면 30~31), key
//이름movieNm 코드movieCd, 점유율salesShare
function getWeaklyBO(){
	ajax({
		type:"GET",
		url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json",
		data:{
			key:"88c812405e947836cbbee3be8daa5603",
			targatDt:"20210425"
		},
		success:function(result){
			$('#monthlyResult').val(result);
			$('#test').val('hi');
			consol.log(result)
			//하면은 월간을보낸다
			$("#monthly").submit(); 
		}
	});//ajax
}//getDailyBO()

//년간이면 월간을 12번해서 통계 내자.