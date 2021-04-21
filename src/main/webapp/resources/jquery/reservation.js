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
	let test ='';
	$.ajax({
		url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json",
		type:"GET",
		data: {
			key:"88c812405e947836cbbee3be8daa5603",
			movieNm : movieNmList[index]
		},
		async: false,//========ajax를 동기식으로 바꾸기========리턴 가능!!========로딩바 필요해짐,,
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
			movieCdList.push(movieCd);
		},//success end
		
	});//ajax end
});//each end 
	
//console.log(movieCdList.length)	//리턴 받아서 20개 됨	

commonList(movieCdList);