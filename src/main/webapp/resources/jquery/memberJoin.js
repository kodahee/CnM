/**
 * 
 */

// id 글자수 확인
$("#id").blur(function() {
	let id = $("#id").val().length;
	console.log(id);
	
	if(id < 7) {
		$("#idResult").text("아이디는 6자리 이상이어야 합니다.");
	} else {
		$("#idResult").text("");
	}
});

// id 중복 확인
$("#idCheck").click(function() {
	
	
});

// pw 글자수 확인
$("#pw").blur(function() {
	let pw = $("#pw").val().length;
	console.log(pw);
	
	if(pw < 9) {
		$("#pwResult").text("비밀번호는 8자리 이상이어야 합니다.");
	} else {
		$("#pwResult").text("");
	}
});

// pw 확인
$("#pwCheck").blur(function() {
	if($("#pw").val() == $("#pwCheck").val()){
		$("#pwCheckResult").text("비밀번호가 일치합니다.");
	} else {
		$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");
	}
});



//--------------------------------------------------------------

$("#btn").click(function(){
	for(let e of etc){
		if(e.value == ""){
			etcResult=false;
			break;
		}
	}
	
	//조건이 만족하면
	if(idCheckResult && pwCheckResult && pwEqualResult && etcResult){
		let frm = document.getElementById("frm");
		//frm.submit();
		alert("회원가입 진행");
	}else {
		alert("필수 항목을 입력하세요");
	}
});
