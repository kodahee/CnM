/**
 * 
 */


//코드를 기반으로 영화 상세 정보 불러와서 뷰에 장식하는 함수
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
				
			}
			
		});//ajax
				i++;
	};
}//commonList()


//컨트롤러에 넘기는 함수
$('.linkDetail').click(function(){
	alert('hi');
	movieDetail();
	function movieDetail(){
		$.ajax({
			url:"../movieDetail/detailedInfo",
			type:"Get",
			data:{movieCd:movieCdList[index]},
			success: function(result){
				
			}
		});
	}
	
});
//api다시 불러오기

