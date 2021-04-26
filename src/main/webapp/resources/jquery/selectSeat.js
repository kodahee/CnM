/**
 * 
 */

let adult = 0;
let kids = 0;

let cnt = 0;

$(".adult").on("click", function() {
	adult = $(this).val();
	console.log(adult);
});

$(".kids").on("click", function() {
	kids = $(this).val();
	console.log(kids);
});

$(".seatName").on("click", function() {
	let row = $(".row").html();
	console.log(row + $(this).val());
	
	let count = adult + kids;
	console.log(count);
	
	if(cnt < count) {
		$(".seats").append($("#seatList").html());
		cnt++;
		console.log(cnt);
	} else {
		alert("다른 좌석을 취소한 후에 선택해주세요.");
	}
	
});



