/**
 * 
 */

$('#iconCalendar').click(function(){
	$('#calendarOpen').toggle();
	calendarMaker($('#calendar'), new Date());
});



let nowDate = new Date();
function calendarMaker(target, date){
	
	nowDate=date;
	//if($(target).length>0){//요소의 갯수가 0보다 크냐,, 아니요,,? 
		let year = nowDate.getFullYear();//YYYY
		let month = nowDate.getMonth()+1;//MM
		//새로 선언할거니까 일단 비우고 다시 값을 집어 넣자
		$(target).empty().append(assembly(year, month));//밑에 함수 설정 있음
	//}
	
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
		
		tag = tag+"<td>"+i+"</td>";
		
		cnt++;
		if(cnt%7==0){
			tag=tag+"</tr>";
		}
	}
	
	
	$(target).find('#setDate').append(tag);
	calendarEvent(target);
	
	
};//function

function calendarEvent(target){
	//==저번 달==
	$('.calendarTable').on('click', '.prev', function(){
		if(nowDate.getMonth()==0){
			nowDate = new Date(nowDate.getFullYear()-1, 11, nowDate.getDate());
		}else{
			nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() -1, nowDate.getDate());
		}
		calendarMaker($(target), nowDate);
	});
	//다음 달	
	$('.calendarTable').on('click', '.next', function(){
		if(nowDate.getMonth==11){
			nowDate = new Date(nowDate.getFullYear()+1, 0, nowDate.getDate());
		}else{
			nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() +1, nowDate.getDate());
				
		}
		calendarMaker($(target), nowDate);
	});
	//날짜 선택 
	$('.calendarTable').on('click', 'td', function(){
		$(".custom_calendar_table .select_day").removeClass("select_day");
		$(this).addClass('select_day');
	});
}

function assembly(year, month) {
        let calendar_html_code ='<table class = "calendarTable">'+
			//==테이블 설정==
			'<colgroup>'+
			'<col style = "width:30px"/>'+
			'<col style = "width:30px"/>'+
			'<col style = "width:30px"/>'+
			'<col style = "width:30px"/>'+
			'<col style = "width:30px"/>'+
			'<col style = "width:30px"/>'+
			'<col style = "width:30px"/>'+
			'</colgroup>'+
			//==테이블 헤드==
			'<thead>'+
			'<tr>'+
			'<th><img src="../../resources/img/smallPrev.png" class="prev"></th>'+
			'<th calspan="5" align="center">'+year+' . '+month+'</th>'+
			'<th><img src="../../resources/img/smallNext.png" class="next"></th>'+
			'</tr>'+
			'<tr>'+
			'<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>'+
			'</tr>'+
			'</thead>'+
			//==테이블 바디(함수적용)==
			'<tbody id="setDate">'+
			'</tbody>'+
			'</table>';
        return calendar_html_code;
    }