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
			//alert('hi')	//확인완료
			result=result.movieInfoResult.movieInfo;
			/*console.log(result.movieNm)//된다!
			console.log(result.openDt)
			console.log(movieCd);
			console.log(result.audits[0].watchGradeNm)*/
		
			//로딩을 완전히 받아올때까지 기다려주는 그런거
			//append를 사용할거임,,
			let test = '<h3 class="movieCd" name="movieCd" val="'+movieCdList[index]+'">'+movieCdList[index]+'</h3>';
			try{
				test=test+'<h3>'+result.openDt+'</h3>';
			}catch(e){
				test=test+'<h3>해당정보가 없습니다.</h3>'
			}
			try{
				test=test+'<h3>'+result.audits[0].watchGradeNm+'</h3>';			
			}catch(e){
				test=test+'<h3>해당정보가 없습니다.</h3>'			
			}
			console.log(i)
			$('.test'+i).append(test);
			i++;
			
		}
		
	});
	
};

}