/**
 * 
 */
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
			
			
			let subInfo = '<h3 class="movieCd" name="movieCd" val="'+movieCdList[index]+'">'+movieCdList[index]+'</h3>';
			try{
				subInfo=subInfo+'<h3>'+result.openDt+'</h3>';
			}catch(e){
				subInfo=subInfo+'<h3>해당정보가 없습니다.</h3>'
			}
			
			
			$('.subInfo'+i).append(subInfo);
			
		}
		
	});//ajax
			i++;
	
};

}