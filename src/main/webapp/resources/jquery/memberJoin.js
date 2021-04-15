/**
 * 
 */

let idResult = true;
let idCheckResult = true;
let pwResult = true;
let pwCheckResult = true;

// id 글자수 확인
$("#id").blur(function() {
	let id = $("#id").val().length;
	console.log(id);
	
	if(id < 6) {
		$("#idResult").text("아이디는 6자리 이상이어야 합니다.");
		idResult = false;
	} else {
		$("#idResult").text("");
		idResult = true;
	}
});

// id 중복 확인
$("#idCheck").click(function() {
	
	
});

// pw 글자수 확인
$("#pw").blur(function() {
	let pw = $("#pw").val().length;
	console.log(pw);
	
	if(pw < 8) {
		$("#pwResult").text("비밀번호는 8자리 이상이어야 합니다.");
		pwResult = false;
	} else {
		$("#pwResult").text("");
		idResult = true;
	}
});

// pw 확인
$("#pwCheck").blur(function() {
	if($("#pw").val() == $("#pwCheck").val()){
		$("#pwCheckResult").text("비밀번호가 일치합니다.");
		idResult = true;
	} else {
		$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");
		pwCheckResult = false;
	}
});



// email 인증
$("#sendCode").click(function() {
	if ($("#email").val() == "") {
		alert("이메일 주소를 입력하세요.");
	} else {
		$.ajax({
			type : 'POST',
			url : 'emailConfirm',
			data : {email: email},
			dataType :'json',
		});
		alert("인증코드가 전송되었습니다.") 
		isCertification=true; //추후 인증 여부를 알기위한 값
	}
});


//--------------------------------------------------------------

let etcResult = true;

$("#btn").click(function(){
	for(let e of $(".etc")){
		if(e.value == ""){
			etcResult=false;
			break;
		}
	}
	
	//조건이 만족하면
	if(idResult && idCheckResult && pwResult && pwCheckResult && etcResult){
		alert("회원가입 진행");
	}else {
		alert("필수 항목을 입력하세요");
	}
});
