/**
 * 
 */

$("#btn").click(function(){
		$.ajax({
			type:"GET",
			url:"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
			data:{
				key:"88c812405e947836cbbee3be8daa5603",
				targetDt:"20210413"
			},
			success:function(result){
			
				console.log(result);
				alert('hihi')	
			}
		})//ajax
});