package com.ed.cnm.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//------------- 회원가입 -------------
	@GetMapping("memberJoinCheck")
	public void memberJoinCheck()throws Exception{}
	
	@GetMapping("memberJoin")
	public void memberJoin()throws Exception{}
	
	@PostMapping("memberJoin")
	public String memberJoin(MemberDTO memberDTO, HttpSession session, Model model)throws Exception{
		int result = memberService.memberJoin(memberDTO);
		
		String message = "회원가입 실패";
		String path="./memberJoin";
		
		if(result>0) {
			message ="회원 가입 성공";
			path="../";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		return "common/commonResult";
	}
	
	//------------- 로그인 -------------
	@GetMapping("memberLogin")
	public void memberLogin() throws Exception{}
	
	@PostMapping("memberLogin")
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO = memberService.memberLogin(memberDTO);
		System.out.println(memberDTO);
		
		session.setAttribute("member", memberDTO);
		
		return "redirect:../";
	}
	
	//------------- 로그아웃 -------------
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}

}
