/**
 * 
 */
//전역 변수 
let date = new Date();
	
//날짜 지정 메서드(하루 전을 파라미터로 넘겨야 함)
function getDate(date){
	let year = date.getFullYear();
	let month = (1+date.getMonth());
	if(month>=10){
		month=month
	}else{
		month='0'+month;
	};
	let day = date.getDate();
	if(day>=10){
		day=day;
	}else{
		day='0'+day;
	}
	return year+month+day;

}
//영화목록 API에서 영화코드 응답받겠다.
let movieNm=$('#movieNm').text();
let movieCd="";
//
let count = $('li').length;//li가 몇개 있는지,, 
//$('.box_ranking').each(function(index, li){
	//console.log(this);//제대로 20개가 나옴
	for(let i = 0; i<count; i++){
$.ajax({
	url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json",
	type:"GET",
	data: {
		key:"88c812405e947836cbbee3be8daa5603",
		movieNm : movieNm
	}
	
	}).done(function(data) {
		
		console.log(this);
		console.log(movieNm);
		
		
});
}
//});//each