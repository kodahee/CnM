/**
 * 
 */



$('dt').click(function(){
	$('.location').find('dt.select').removeClass('select')
	$(this).addClass('select');
	let theaterName=$(this).attr('title');
	//scheduleDate 받아와야함(날자임)
	
	calendarMaker($('.calendar'), new Date());
	//getList(theaterName);
})

function getList(theaterName){
	$.ajax({
		url:"../locationTheater/"+theaterName,
		type:"GET",
		data:{
			scheduleDate:scheduleDate
		},
		success:function(result){
			$('.schedule').append(result);
		}
		
	});
}