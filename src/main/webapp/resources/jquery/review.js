/**
 * 
 */
//let movieCd = $("#review").attr("title");

$("#reviewBtn").on("click", function() {
	getList();

	$(".remove2").on("click", function() {
		
		let reviewNum = $(this).val();
		console.log(reviewNum);
		
		$.post("../movieDetail/reviewDelete", 
			{
				reviewNum:reviewNum
			},
			function(data) {
				data = data.trim();
				if(data == 1) {
					alert('삭제 완료');
					
					// 리스트 다시 호출
					getList();
				} else {
					alert('삭제 실패');
				}
			});
		
	});
	
	
	// review List
	function getList() {
		$.get("../movieDetail/reviewList?movieCd="+movieCd, function(data) {
			console.log(data);
			$("#review").html(data.trim());
		});
	}
	
	let star = 0;
	
	$(".star").on("click",function(){
	 	let idx = $(this).index();
		$(".star").removeClass("on");
		
		for(let i=0; i<=idx; i++){
			$(".star").eq(i).addClass("on");
		}
		star = idx + 1;
		console.log(star);
	});
	
	// 좋아요
	
	// 싫어요
	
	
	// review Write
	$("#write").click(function() {
		let id = $("#id").val();
		let nickName = $("#nickName").val();
		let contents = $("#contents").val();
		
		if(id == '') {
			alert('로그인이 필요한 서비스입니다.');
			// 칸 비우기
			$("#contents").val('');
			// 별점 지우기
			$(".star").removeClass("on");
			// 리스트 다시 호출
			getList();
			
		} else {
			$.post("../movieDetail/reviewInsert", 
			{
				movieTitle:movieNm,
				id:id,
				nickName:nickName,
				star:star,
				contents:contents
			},
			function(data) {
				data = data.trim();
				if(data == 1) {
					alert('등록 성공');
					
					// 칸 비우기
					$("#contents").val('');
					// 별점 지우기
					$(".star").removeClass("on");
					
					// 리스트 다시 호출
					getList();
					
				} else {
					alert('등록 실패');
				}
			});
		}
		
	});
});
