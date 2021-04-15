package com.ed.cnm.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	private JavaMailSender javaMailSender;
	
	
	@PostMapping("emailCheck")
	@ResponseBody
    public void sendEmail(String email) throws Exception {
		
		Random r = new Random();
        int code = r.nextInt(4589362) + 49311;				//이메일로 받는 인증코드 부분 (난수)
        
        String title = "CnM 회원가입 인증 이메일 입니다.";			// 제목
        String content =
	        System.getProperty("line.separator")+ 			//한줄씩 줄간격을 두기위해 작성
	        System.getProperty("line.separator")+
	        "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
	        
	        +System.getProperty("line.separator")+
	        System.getProperty("line.separator")+
	        " 인증번호는 " + code + " 입니다. ";
	        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(title);
		message.setText(content);
		javaMailSender.send(message);
        
        
    }

	

	//------------- 마이페이지 -------------
	@GetMapping("memberMyPage")
	public void memberMyPage() throws Exception {}

	//------------- 회원탈퇴 -------------
	@GetMapping("memberDelete")
	public String memberDelete(HttpSession session) throws Exception {
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		int result = memberService.memberDelete(memberDTO);
		session.invalidate();
		return "redirect:../";
	}

	//------------- 회원가입 -------------
	@GetMapping("memberJoinCheck")
	public void memberJoinCheck() throws Exception {}

	@GetMapping("memberJoin")
	public void memberJoin() throws Exception {}

	@PostMapping("memberJoin")
	public String memberJoin(MemberDTO memberDTO, HttpSession session, Model model) throws Exception {

		int result = memberService.memberJoin(memberDTO);

		String message = "회원가입 실패";
		String path="./memberJoin";

		if(result>0) {
			message ="회원 가입 성공";
			path="./memberJoinComplete";

			System.out.println(memberDTO.getName());
			session.setAttribute("member", memberDTO);
		}

		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		return "common/commonResult";
	}

	@GetMapping("memberJoinComplete")
	public void memberJoinComplete() throws Exception {}

	// 아이디 중복 확인
	@PostMapping("memberIdCheck")
	public String checkID(MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		System.out.println(request.getParameter("id"));
		memberDTO.setId(request.getParameter("id"));
		memberDTO = memberService.checkID(memberDTO);
		String idCheck = "N";
		if(memberDTO == null) {
			idCheck = "Y";
		}
		System.out.println(idCheck);
		return idCheck;
	}

	//------------- 로그인 -------------
	@GetMapping("memberLogin")
	public void memberLogin() throws Exception{}

	@PostMapping("memberLogin")
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		System.out.println(memberDTO);

		session.setAttribute("member", memberDTO);

		return "redirect:../";
	}

	//------------- 로그아웃 -------------
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

}
