/**
 * 
 */

//영화목록 API에서 영화코드 응답받겠다.
let movieNmList = [];
let movieCdList=[];

$('.movieNm').each(function(index, li){
	movieNmList.push($(this).text());
	$.ajax({
		url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json",
		type:"GET",
		data: {
			key:"88c812405e947836cbbee3be8daa5603",
			movieNm : movieNmList[index]
		},
		async: false,
		success: function(data) {
			data = data.movieListResult.movieList
			let equalNmToCd=[];
			for(movie of data){//데이터(배열)을 반복하면서 
				if(movieNmList[index]==movie.movieNm){//이름이 같은걸 찾고 같다면
					equalNmToCd.push(movie.movieCd);//영화코드를 배열에 담는다.
				}
			}
			//이름이 같은 것들 중에서 제일 큰수를 뽑겠다.
			let movieCd=Math.max.apply(null,equalNmToCd);
			movieCdList.push(movieCd);
		},//success end
		
	});//ajax end
});//each end 

commonList(movieCdList);


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
				
				let adits = '<img class="ico_movie ico_see" alt="result.audits[0].watchGradeNm" src="../resources/img/'+result.audits[0].watchGradeNm+'.png">';
				$('.icon'+i).append(adits);		
				
				let openDt = '<span class="txt_num">'+result.openDt+'</span>';
				$('.openNum'+i).append(openDt);
			
			}
			
		});//ajax
	i++;
		
	};

}
