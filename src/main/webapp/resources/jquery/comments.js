/**
 * 
 */
let num = $("#comments").attr("title");

getList();

$("#comments").on("click", "#remove", function() {
	const ar = [];		// 빈 배열
	$(".del").each(function() {
		let ch = $(this).prop("checked");
		if(ch) {
			ar.push($(this).val());
		}
	});
	$.ajax({
		type: "POST",
		url: "../comments/commentsDelete",
		traditional: true,		// 배열 전송
		data: {commentsNum:ar},
		success: function(data) {
			alert(data);
		}
	});
});

function getList() {
	$.get("../commentsList?num="+num, function(data) {
		console.log(data);
		$("#comments").html(data.trim());
	});
}

$("#write").click(function() {
	let nickName = $("#nickName").val();
	let contents = $("#contents").val();
	
	$.post("../comments/commentsInsert", 
	{
		num:num,
		nickName:nickName,
		contents:contents
	},
	function(data) {
		data = data.trim();
		if(data == 1) {
			alert('등록 성공');
			
			// 칸 비우기
			$("#nickName").val('');
			$("#contents").val('');
			
			// 리스트 다시 호출
			getList();
			
		} else {
			alert('등록 실패');
		}
	});
	
});
