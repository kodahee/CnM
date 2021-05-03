/**
 * 
 */
let movieTitle = $("#review").attr("movieTitle");
getList();

$("#remove").on("click", function() {
	
	console.log($(".del").val());
	let reviewNum = $(".del").val();
	
	$.ajax({
		type: "POST",
		url: "../ranking/reviewDelete",
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
	//let reviewNum = $(".del").val();
	$(".del").each(function() {
		console.log($(this).val());
		goodNum = $(this).val();
		goodNum = goodNum + 1;
	});
	
	$.post("../ranking/reviewUpdate",
	{
		reviewNum:reviewNum,
		goodNum:goodNum
	},
	function(data) {
		data = data.trim();
		alert(data);
		
		if(data == 1) {
			alert("update");
			// 리스트 다시 호출
			getList();
		} else {
			alert("xxxxxx");
		}
	});
	
	console.log(goodNum);
});

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