/**
 * 
 */

$('#iconCalendar').click(function(){
	$('#calendar').toggle();
	calendarMaker($('#calendarTable'), new Date());
});



let nowDate = new Date();
function calendarMaker(target, date){
	/*if(date == null||date==undefined){//null은 초기화가 되긴 했는 사용할 수 없는 값이고 undifined는 초기화 조차 안된거
		date=new Date();//이거 왜 필요하냐 근데,, 선언하면서 들어오는데,,?
	}*/
	nowDate=date;
	if($(target).length>0){//이미 선택자에게 값이 있을 때
		let year = nowDate.getFullYear();//YYYY
		let month = nowDate.getMonth()+1;//MM
		//새로 선언할거니까 일단 비우고 다시 값을 집어 넣자
		$(target).empty().append(assembly(year, month));//밑에 함수 설정 있음
	}
	//내가 여기서 착각한게 달은 0~11인데 이걸 우리가 보기 편하게 할때 +1하는거지 얘네 자체는 그냥 해도 알아먹음 
	let thisMonth = new Date(nowDate.getFullYear(), nowDate.getMonth(), 1); //20210401 처음날
	let thisLastDay = new Date(nowDate.getFullYear(), nowDate.getMonth()+1, 0); //20210430 마지막날
	//공백 만들기,,
	let tag = "<tr>";
	let cnt=0;
	for(i=0; i<thisMonth.getDay(); i++){//getDay=요일0~6
		tag = tag+"<td></td>";
		cnt++;
	}
	
	//날짜 채우기
	for(i =1; i<=thisLastDay.getDate(); i++){
		if(i==nowDate.getDate()){
			tag = tag+'<td class="select_day">'+i+"</td>";	
		}else{
			
			tag = tag+"<td>"+i+"</td>";
		}
		cnt++;
		if(cnt%7==0){
			tag=tag+"</tr>";
		}
	}
	
	$(target).find('#custom_set_date').append(tag);
	calMoveEvtFn();
	
	
	
	
	function calMoveEvtFn(){
		//저번 달
		$('.custom_calendar_table').on('click', '.prev', function(){
			if(nowDate.getMonth()==0){
				nowDate = new Date(nowDate.getFullYear()-1, 11, nowDate.getDate());
			}else{
			nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() -1, nowDate.getDate());
			}
			calendarMaker($(target), nowDate);
		});
		//다음 달
		$('.custom_calendar_table').on('click', '.next', function(){
			if(nowDate.getMonth==11){
				nowDate = new Date(nowDate.getFullYear()+1, 0, nowDate.getDate());
			}else{
				nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() +1, nowDate.getDate());
				
			}
			calendarMaker($(target), nowDate);
		});
		//날자 선택 
		$('.custom_calendar_table').on('click', 'td', function(){
			$(".custom_calendar_table .select_day").removeClass("select_day");
			$(this).addClass('select_day');
		});
	}
	
	return 
};//function

function assembly(year, month) {
        var calendar_html_code =
            "<table class='custom_calendar_table'>" +
            "<colgroup>" +
            "<col style='width:30px'/>" +
            "<col style='width:30px'/>" +
            "<col style='width:30px'/>" +
            "<col style='width:30px'/>" +
            "<col style='width:30px'/>" +
            "<col style='width:30px'/>" +
            "<col style='width:30px'/>" +
            "</colgroup>" +
            "<thead class='cal_date'>" +
            "<th><button type='button' class='prev'><</button></th>" +
            "<th colspan='5'><p><span>" + year + "</span>년 <span>" + month + "</span>월</p></th>" +
            "<th><button type='button' class='next'>></button></th>" +
            "</thead>" +
            "<thead  class='cal_week'>" +
            "<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>" +
            "</thead>" +
            "<tbody id='custom_set_date'>" +
            "</tbody>" +
            "</table>";
        return calendar_html_code;
    }