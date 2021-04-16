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
		$("#idResult1").text("아이디는 6자리 이상이어야 합니다.");
		idResult = false;
	} else {
		$("#idResult1").text("");
		idResult = true;
	}
});

// id 중복 확인
$("#idCheck").on('click', function() {
	console.log("click");
	$.ajax({
		type: 'POST',
		url: './memberIdCheck',
		data: {"id":$("#id").val()},
		success: function(data) {
			console.log($.trim(data));
			
			if($.trim(data) == "Y") {
				$("#idResult2").text("사용 가능한 아이디 입니다.");
			} else {
				$("#idResult2").text("이미 존재하는 아이디 입니다.");
			}
		}
	});
	
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


// email 인증 메일 전송
$("#sendCode").click(function() {
	if ($("#email").val() == "") {
		alert("이메일 주소를 입력하세요.");
	} else {
		$.ajax({
			type : 'POST',
			url : './emailCheck',
			data : {"email": $("#email").val()}
		});
		alert("인증코드가 전송되었습니다.") 
		isCertification=true; 				//추후 인증 여부를 알기위한 값
	}
});

// email 인증코드 확인
$("#emailCheck").blur(function(code) {
	if ($("#emailCheck").val() == code) {   //인증 키 값을 비교를 위해 텍스트인풋과 벨류를 비교
		$("#emailResult").text("인증 성공!");
		isCertification = true;  			//인증 성공여부 check
	} else {
		$("#emailResult").text("불일치!");
		isCertification = false; 			//인증 실패
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
