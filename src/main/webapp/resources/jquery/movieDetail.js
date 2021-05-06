/**
 * 
 */


let movieCd = $('.movieCd').text();

$.ajax({
			url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
			type:"GET",
			data:{
				key:"88c812405e947836cbbee3be8daa5603",
				movieCd:movieCd
			},
			success:function(result){
				result=result.movieInfoResult.movieInfo;
				let originNm = result.movieNmOg;
				let engNm = result.movieNmEn;
				let openDt = result.openDt;
				let genreNm = "";
				for(i in result.genres){
					let a = result.genres[i].genreNm;
					genreNm = genreNm + a+ " ";
				}
				let nationNm = result.nations[0].nationNm;
				let watchGradeNm = result.audits[0].watchGradeNm;
				let showTm = result.showTm+" 분";
				//평점, 누적관객수, 박스오피스 순위는 일별박스오피스에서 조회
				
				$('.originNm').text(originNm+','+engNm);//오리지널이름
				$('.openDt').text(openDt);//개봉일
				$('.genreNm').text(genreNm);//장르
				$('.nationNm').text(nationNm);//국가
				$('.watchGradeNm').text(watchGradeNm);
				$('.showTm').text(showTm);//러닝타임
				
				let directorNm = result.directors[0].peopleNm;
				$('.list_crewall').append(li(directorNm, '감독'));
				for(let i=0; i<5; i++){
					let actorNm = result.actors[i].peopleNm;
					$('.list_crewall').append(li(actorNm, '배우'));
				}
			}
});

function li(peopleNm, nmInfo){
	let li = '<li>'+
		'<div class="item_crewall">'+
			'<div class="thumb_item">'+						
				'<img src="../resources/img/people.png" class="img_thumb">'+								
			'</div>'+					
			'<div class="thumb_cont">'+					
				'<div class="tit_item">'+			
					'<div class="link_tit">'+peopleNm+'</div>'+
				'</div>'+					
				'<span class="txt_info">'+nmInfo+'</span>'+
			'</div>'+
		'</div>'+				
		'</li>';
	
	return li;
}

let i2 = $('.detail_crewinfo').offset();
$('#i2').click(function(){
	window.scrollTo(i2)
});