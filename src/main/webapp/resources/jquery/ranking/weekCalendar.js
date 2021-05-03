
$('.calendarOpen').hide();

//====아이콘 클릭하면 달력을 보여주겠다.====
$('.iconCalendar').click(function(){
	$('.calendarOpen').toggle();
	//==달력 만드는 함수==
	calendarMaker($('.calendar'), new Date());

});




function calendarMaker(target, date){
	
	nowDate=date;

	let year = nowDate.getFullYear();//YYYY
	let month = nowDate.getMonth()+1;//MM
	//새로 선언할거니까 일단 비우고 다시 값을 집어 넣자, Html코드 만듬(헤드만 잇는 상태)
	$(target).empty().append(setCalendar(year, month));//밑에 함수 설정 있음
	
	
	//내가 여기서 착각한게 달은 0~11인데 이걸 우리가 보기 편하게 할때 +1하는거지 얘네 자체는 그냥 해도 알아먹음 
	let thisMonth = new Date(nowDate.getFullYear(), nowDate.getMonth(), 1); //20210401 처음날
	let thisLastDay = new Date(nowDate.getFullYear(), nowDate.getMonth()+1, 0); //20210430 마지막날
	
	//달력에 공백 만들기,,
	let tag = "<tr>";
	let cnt=0;
	for(i=0; i<thisMonth.getDay(); i++){//getDay=요일0~6
		tag = tag+"<td></td>";
		cnt++;
	}
	
	//달력에 날짜 채우기
	for(i =1; i<=thisLastDay.getDate(); i++){
		tag = tag+"<td>"+i+"</td>";
		if(nowDate.getDate()==i){
			selectDay=nowDate.getTime();
			
		}
		cnt++;
		if(cnt%7==0){
			tag=tag+"</tr>";
		}
	}
	
	//만들어둔 달력에 어펜드 
	$(target).find('.setDate').append(tag);
	calendarEvent(target);
	console.log('달력만들기: '+selectDay)
};//function


//====이벤트 함수, 실행x, 걸어둔 상태임을 기억 ====
function calendarEvent(target){
	
	$('.tableDate').on('click', '#prev', function(){
		alert('prev')
		if(nowDate.getMonth()==0){//1월이면 작년으로 가자
			nowDate = new Date(nowDate.getFullYear()-1, 11, nowDate.getDate());
		}else{
			nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() -1, nowDate.getDate());
		}
		calendarMaker($(target), nowDate);
	});
	//다음 달	
	$('.tableDate').on('click', '#next', function(){
		alert('next')
		if(nowDate.getMonth==11){//12월이면 내년으로 가자
			nowDate = new Date(nowDate.getFullYear()+1, 0, nowDate.getDate());
		}else{
			nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() +1, nowDate.getDate());			
		}
		calendarMaker($(target), nowDate);
	});
	//날짜 선택 
	$('.calendarTable').on('click', 'td', function(){
		alert('td')
		$('.calendarTable').find('td.selected').removeClass('selected');
		$(this).addClass('selected');
		selectDay = new Date(nowDate.getFullYear(), nowDate.getMonth(), $('td.selected').text().trim());
		console.log('===')
		console.log(selectDay)//왜 스트링타입,,? Fri Apr 16 2021 00:00:00 GMT+0900 (대한민국 표준시)
		//콘솔에 찍어보니까 그냥 자동 toString 된거처럼 된거,,, ,,,? .......
		selectDay = new Date(Date.parse(selectDay));
		console.log(selectDay.getTime());
		//선택하면 ajax 소환
		selectTime();
	});
}

function selectTime(){
$.ajax({
	url: './list',
	type: 'GET',
	data: {date: selectDay},
	success: function(result){
		$('.listBox').html(result);
		searchAPI();
	}
});
		
}

//===달력 만드는 HTML 코드 ==
function setCalendar(year, month) {
        let calHtmlCode =
				//==테이블 설정==
			//'<div class="setCal">'+
				'<div class="tableDate">'+
					'<img src="../../resources/img/smallPrev.png" class="prev" >'+
					'<div class="tableDate_item">'+year+'년 '+month+'월'+'</div>'+
					'<img src="../../resources/img/smallNext.png" class="next">'+
				'</div>'+
				'<table class = "calendarTable">'+
					'<colgroup>'+
					'<col >'+
					'<col style = "width:34px"/>'+
					'<col style = "width:34px"/>'+
					'<col style = "width:34px"/>'+
					'<col style = "width:34px"/>'+
					'<col style = "width:34px"/>'+
					'<col >'+
					'</colgroup>'+
					//==테이블 헤드==
					'<thead>'+
					'<tr>'+
						'<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>'+
					'</tr>'+
					'</thead>'+
					//==테이블 바디(함수적용)==
					'<tbody class="setDate">'+
					'</tbody>'+
				'</table>'
			//'</div>';
        return calHtmlCode;
    }

