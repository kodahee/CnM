/**
 * 
 */



$('dt').click(function(){
	$('.location').find('dt.select').removeClass('select')
	$(this).addClass('select');
	let theaterName=$(this).attr('title');
	
	calendarMaker($('.calendar'), new Date());
	getList(theaterName);
})

function getList(theaterName){
	$.ajax({
		url:"../locationTheater/"+theaterName,
		type:"GET",
		data:{
			scheduleDate:selectDay
		},
		success:function(result){
			$('.schedule').append(result);
		}
		
	});
}