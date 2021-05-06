/**
 * 
 */

$('dt').click(function(){
	$('.location').find('dt.select').removeClass('select')
	$(this).addClass('select');
	theaterNum=$(this).attr('title');
	
	//영화관번호(지역번호) 조회해서 하위테이블(영화관)찾아가야함
	
	
})