/**
 * 
 */

$("#all").click(function() {
	
	let all = $("#all").prop("checked");
	// let all = $("#all").attr("checked");		// undefined, 안됨
	console.log(all);

	$(".ch1").prop("checked", all);
	$(".ch2").prop("checked", all);

});

$(".ch").click(function() {
	let result = true;

	$(".ch").each(function() {
		let check = $(this).prop("checked");
		if(!check) {
			result = false;
		}
	});

	$("#all").prop("checked", result);
	
});


$("#btn").click(function() {
	
	let check = true;
	
	$(".ch1").each(function() {
		check = $(this).prop("checked");
		if(!check) {
			result = false;
		}
	});
	
	if($("#all").prop("checked") || check) {	// 모두동의, 필수약관에 동의한 경우 memberJoin으로 넘어감
		location.href="./memberJoin";
	} else {
		alert("필수 약관에 모두 동의하세요.");
	}
});