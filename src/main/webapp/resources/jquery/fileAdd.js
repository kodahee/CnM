/**
 * 
 */

let count = $("#files").attr("title");


$("#add").click(function() {
	alert(count);
	
	if(count < 5) {
		$("#files").append($("#sample").html());
		count++;
	} else {
		alert("파일은 최대 5개까지 첨부 가능합니다.");
	}
	
});

$("#files").on("click", ".delete", function() {
	$(this).parent().remove();
	count--;
});