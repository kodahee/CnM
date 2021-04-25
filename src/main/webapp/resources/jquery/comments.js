/**
 * 
 */
let num = $("#comments").attr("title");
console.log(num);

getList();

// boardSelect에 comments 안에서 remove 버튼을 누르면
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


// comments List
function getList() {
	$.get("../comments/commentsList?num="+num, function(data) {
		console.log(data);
		$("#comments").html(data.trim());
	});
}


// comments Write
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
			$("#contents").val('');
			
			// 리스트 다시 호출
			getList();
			
		} else {
			alert('등록 실패');
		}
	});
	
});
