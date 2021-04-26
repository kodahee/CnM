/**
 * 
 */
let num = $("#comments").attr("title");
console.log(num);

getList();

$("#review").on("click", "#remove", function() {
	const ar = [];		// 빈 배열
	
	$(".del").each(function() {
		let ch = $(this).prop("checked");
		if(ch) {
			ar.push($(this).val());
		}
	});
	
	$.ajax({
		type: "POST",
		url: "../review/reviewDelete",
		traditional: true,		// 배열 전송
		data: {commentsNum:ar},
		success: function(data) {
			alert(data);
		}
	});
	
});


// review List
function getList() {
	$.get("../ranking/review?movieTitle="+movieTitle, function(data) {
		console.log(data);
		$("#comments").html(data.trim());
	});
}


// review Write
$("#write").click(function() {
	let nickName = $("#nickName").val();
	let contents = $("#contents").val();
	
	$.post("../review/reviewInsert", 
	{
		movieTitle:movieTitle,
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
