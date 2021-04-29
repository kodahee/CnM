/**
 * 
 */
//let movieTitle = $("#review").attr("movieTitle");
getList();

$("#review").on("click", "#remove", function() {
	console.log(review.reviewNum);
		
	$.ajax({
		type: "POST",
		url: "../review/reviewDelete",
		data: {reviewNum:reviewNum},
		success: function(data) {
			alert(data);
		}
	});
	
});


// review List
function getList() {
	$.get("../ranking/review", function(data) {
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

let goodNum = 0;
$("#good").on("click", function() {
	goodNum = goodNum + 1;
	console.log(goodNum);
});

// review Write
$("#write").click(function() {
	let id = $("#id").val();
	let nickName = $("#nickName").val();
	let contents = $("#contents").val();
	
	$.post("../ranking/reviewInsert", 
	{
		movieTitle:movieTitle,
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
			
			// 리스트 다시 호출
			getList();
			
		} else {
			alert('등록 실패');
		}
	});
	
});
