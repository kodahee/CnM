/**
 * 
 */
let date ='';

$('dt').click(function(){
	$('.location').find('dt.select').removeClass('select')
	$(this).addClass('select');
	let theaterName=$(this).attr('title');
	$('.setDate').empty();
	makeCal(theaterName);
	
})
//날짜
	let nowDate = new Date();
function makeCal(theaterName){
	let year = nowDate.getFullYear();//YYYY
	let month = nowDate.getMonth()+1;//MM
	setCalendar(year, month);
	
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
	$('.setDate').append(tag);
	$('.tableDate_item').text(year+'년'+month+'월');
	calendarEvent(theaterName);
}
function calendarEvent(theaterName){
	$('.calendarTable').on('click', 'td', function(){
			
		$('.calendarTable').find('td.selected').removeClass('selected');
		$(this).addClass('selected');
		selectDay = new Date(nowDate.getFullYear(), nowDate.getMonth(), $('td.selected').text().trim());
		
		selectDay = new Date(Date.parse(selectDay));
		let year = selectDay.getFullYear();
		let month = selectDay.getMonth()+1;
		if(month<10){
			month = '0'+month;
		}
		let day = selectDay.getDate();
		if(day<10){
			day= '0'+day;
		}
		date=year+'.'+month+'.'+day;
		//선택하면 ajax 소환
		getList(theaterName, date);
	});
}


function getList(theaterName, day){
	let url = "../locationTheater/"+theaterName;
	console.log(theaterName)
	$.ajax({
		url:url,
		type:"GET",
		data:{
			scheduleDate:day
		},
		success:function(result){
			$('.schedule').append(result);
		}
		
	});
}

$('.time').on('click', '.t', function(){
	$('.time').find('div.select').removeClass('select');
	$(this).addClass('select');
	let check=confirm('얘매 하시겠습니까?');
	let poster= $('.posterItem').attr('src');
	let movieTitle=$('.movieTitle').text();
	let totalSeat=$('.totalSeat').text();
	let t=$('.time').find('div.select');
	let scheduleTime=$(t).find('dt.scheduleTime').text();
		if(check){
			$.ajax({
			url:'./selectSeat',
			type:'GET',
			data:{
				movieTitle:movieTitle,
				totalSeat:totalSeat,
				scheduleTime:scheduleTime,
				
			},
			success: function(result){
				$('body').html(result);
			}
			
		});
	}
	
})
