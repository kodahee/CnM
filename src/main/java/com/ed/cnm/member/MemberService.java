package com.ed.cnm.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	// 회원정보수정
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	
	// 회원탈퇴
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberDelete(memberDTO);
	}
	
	// 아이디 중복 확인
	public MemberDTO checkID(MemberDTO memberDTO) throws Exception {
		return memberDAO.checkID(memberDTO);
	}
	
	// 회원가입
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	// 로그인
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		int result = memberDAO.memberJoin(memberDTO);
		return result;
	}
	
}
