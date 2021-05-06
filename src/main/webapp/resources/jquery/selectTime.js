/**
 * 
 */

$('dt').click(function(){
	$('.location').find('dt.select').removeClass('select')
	$(this).addClass('select');
	let theaterName=$(this).attr('title');

	getList(theaterName);
})

function getList(theaterName){
	$.ajax({
		url:"../locationTheater/"+theaterName,
		type:"GET",
		success:function(result){
			alert('hi')
			$('.test').append(result);
		}
		
	});
}