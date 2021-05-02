/**
 * 
 */

let adult = 0;
let kids = 0;
let cnt = 0;
let count = 0;

countPeople();


function countPeople() {
	$(".adult").on("click", function() {
		adult = $(this).val();
		console.log(adult);
	});
	
	$(".kids").on("click", function() {
		kids = $(this).val();
		console.log(kids);
	});
	
	selectSeat();
}

function selectSeat() {
		
	const ar = [];
	
	$(".seatName").on("click", function() {
		let row = $(".row").html();
		let seatName = row + $(this).val();
		
		console.log(seatName);
		count = Number(adult) + Number(kids);
		console.log(count);
		
		if(cnt < count) {
			ar.push(seatName);
			$(".seats").append($("#seatList").html(seatName));
			cnt++;
			console.log(cnt);
			
		} else {
			alert("다른 좌석을 취소한 후에 선택해주세요.");
		}
	});
		
	$.ajax({
		type: "POST",
		url: "../booked/selectSeat",
		traditional: true,
		data: {seatName:ar},
		success: function(data) {
			alert(data);
		}
	});
}

// 결제하기 버튼 클릭
$("#btn").click(function() {
	let seatCount = 0;				// 좌석 정보를 담는 배열의 크기
	let seatNum = new Array();		// 선택 된 좌석 번호를 담는 배열
	let seatLength = $("input:button[class='seat']:active").length // 선택된 좌석의 개수
	$("#seatCount").val(seatLength);

	if (seatLength == peopleCount && peopleCount != 0) {	// 관객 수와 선택 좌석 수가 같을 경우 (예매 가능)
		for (let i = 0; i < seatCount; i++) {
			$("input:checkbox[id=seat" + seatNum[i] + "]").attr('disabled', true);
		}
		
		let pay = teenCount * 8000 + adultCount * 10000;
		$("#price").val(pay);
		alert("금액 : " + pay + "원");
		$("#frm").submit();
		
	} else if (seatLength < count) {					// 선택 좌석 수가 관객 수 보다 적을 경우
		alert("좌석 수 보다 인원 수가 더 많습니다.");
	} else if (seatLength == 0 && count != 0) {		// 좌석을 선택하지 않은 경우
		alert("좌석을 선택 하세요.")
	} else if (count == 0) {
		alert("관객 수를 선택 하세요.")
	}
});



