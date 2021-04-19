/**
 * 
 */

//영화목록 API에서 영화코드 응답받겠다.
let movieNmList = [];
let movieCdList=[];

$('.movieNm').each(function(index, li){
	//console.log(this);//엘리먼트 전부 뜸(태그까지)
	//console.log($(this).text());//제목만 뜸
	//console.log(index+' : '+movieNmList[index]);
	movieNmList.push($(this).text());
	
	$.ajax({
		url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json",
		type:"GET",
		data: {
			key:"88c812405e947836cbbee3be8daa5603",
			movieNm : movieNmList[index]
		},
		success: function(data) {
			data = data.movieListResult.movieList//데이터가 여러개 올 가능성 있음
			//1. 이름이 완전히 같아야 하고, 2. movieCd가 제일 큰수 일때 배열로 추가하겟다.
			let equalNmToCd=[];
			for(movie of data){//데이터(배열)을 반복하면서 
				if(movieNmList[index]==movie.movieNm){//이름이 같은걸 찾고 같다면
					equalNmToCd.push(movie.movieCd);//영화코드를 배열에 담는다.
				}
			}
			//이름이 같은 것들 중에서 제일 큰수를 뽑겠다.
			let movieCd=Math.max.apply(null,equalNmToCd);
			//console.log('이름'+index+': ' +movie.movieNm+' 코드: '+movieCd)//성공!
			//movieCdList.push(movieCd);
			searchMovieInfo(movieCd);
			//저 코드를 가지고 다시 함수를 호출해야함,,
		}//success end
	});//ajax end
});//each end 
			
function searchMovieInfo(movieCd){
	$.ajax({
		url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
		type:"GET",
		data:{
			key:"88c812405e947836cbbee3be8daa5603",
			movieCd:movieCd
		},
		success:function(result){
			//alert('hi')	//확인완료
			result=result.movieInfoResult.movieInfo
			console.log(result)
			console.log(result.openDt)
			console.log(result.audits.watchGradeNm)
			console.log(movieCd);
			console.log(result.movieNm)
			
			//append를 사용할거임,,
			
		}
		
	});
	
};