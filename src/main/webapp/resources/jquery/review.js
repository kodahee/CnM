/**
 * 
 */

getList();

$("#review").on("click", "#remove", function() {
	
	$.ajax({
		type: "POST",
		url: "../review/reviewDelete",
		traditional: true,		// 배열 전송
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

$("#good").on("click", function() {
	
});

// review Write
$("#write").click(function() {
	let movieTitle = 'movie1';
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
