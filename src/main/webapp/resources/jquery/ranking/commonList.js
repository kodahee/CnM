/**
 * 
 */
//컨트롤러에 넘기고
$('.linkDetail').click(function(){
	let index = $('.rank_num').text()-1;
	let movieInfo = $('.link_story').text();
	let poster = $('.poster').attr('src');

	$.ajax({
		url:"../movieDetail/detailedInfo",
		type:"POST",
		data:{movieCd:movieCdList[index], movieInfo: movieInfo, poster: poster},
		success: function(result){
			
		}
	});
	
});
//api다시 불러오기



//=======================랭킹===============================

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
			
			let adits = '<img class="ico_movie ico_see" alt="result.audits[0].watchGradeNm" src="${../resources/img/'+result.audits[0].watchGradeNm+'.png">';
			$('.icon'+i).append(adits);		
			
			let openDt = '<span class="txt_num">'+result.openDt+'</span>';
			$('.openNum'+i).append(openDt);
			
			//$('.linkDetail').attr('href','movieDetail/detailedInfo?movieCd='+movieCdList[index]);
			
		
		}
		
	});//ajax
			i++;
	
};

}


