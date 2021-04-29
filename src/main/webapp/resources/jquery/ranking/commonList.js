/**
 * 
 */

$('.item_poster').mouseenter(function(){
	$('.poster_info').show();
});


function commonList(movieCdList){
	
let i=0;
for(index in movieCdList){
	$.ajax({
		url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
		type:"GET",
		data:{
			key:"88c812405e947836cbbee3be8daa5603",
			movieCd:movieCdList[index]
		},
		async: false,
		success:function(result){
			result=result.movieInfoResult.movieInfo;
			
			let adits = '<span class="ico_movie ico_see">'+result.audits[0].watchGradeNm+'</span>';
			$('.txt_tag'+i).append(adits);		
			
			let openDt = '<span class="txt_num">'+result.openDt+'</span>';
			$('.openNum'+i).append(openDt);
			
			$('.linkDetail').attr('href',/*여기에 링크+cd하면 될듯*/+movieCdList[index]);
			
		
		}
		
	});//ajax
			i++;
	
};

}