/**
 * 
 */

$("#btn").click(function() {
	
	let result = true;
	
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
