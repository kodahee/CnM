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
			
				$.ajax({//DB에 코드 저장하기 위한 용도
					url: './reservation',
					type: 'POST',
					dataType: 'text',
					data: {movieCd: movieCdList[index], movieNm: movieNmList[index]},
					success: function(result){
						console.log(movieNmList[index])
						console.log(movieCdList[index])
					}
				});
			
		},//success end
		
	});//ajax end
});//each end 

//코드를 기반으로 영화 상세 정보 불러와서 뷰에 장식하는 함수
commonList(movieCdList);

//클릭한 경우 실행 될 상세페이지 

