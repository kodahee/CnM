/**
 * 
 */

$("#btn").click(function() {
	
	let result = true;
	
	// 배열, each반복문(foreach와 비슷)
	$(".myCheck").each(function(s1, s2) {
		
		console.log($(s2).val());
		
		if($(this).val() == "") {
			result = false;
		}
	});
	
	if(result) {
		$("#frm").submit();
	} else {
		alert("등록 실패");
	}

});
