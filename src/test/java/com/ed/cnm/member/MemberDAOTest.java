package com.ed.cnm.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ed.cnm.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	// 회원정보수정
	@Test
	public void memberUpdate() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id4_1");
		memberDTO.setPw("pw4_1");
		memberDTO.setNickName("nick4_1");
		memberDTO.setName("name4_1");
		memberDTO.setPhone("01000000004");
		memberDTO.setEmail("id4@gmail.com");
		memberDTO.setCouponCheck("Y");
		memberDTO.setPoint(1414);
		memberDTO.setGrade("1");
		
		int result = memberDAO.memberJoin(memberDTO);
		
		assertNotEquals(0, result);
	}
	
	// 회원탈퇴
	//@Test
	public void memberDelete() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id4");
		
		int result = memberDAO.memberDelete(memberDTO);
		
		assertNotEquals(0, result);
	}
	
	// 회원가입
	//@Test
	public void memberJoin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id4");
		memberDTO.setPw("pw4");
		memberDTO.setNickName("nick4");
		memberDTO.setName("name4");
		memberDTO.setPhone("01000000004");
		memberDTO.setEmail("id4@gmail.com");
		memberDTO.setCouponCheck("Y");
		memberDTO.setPoint(1414);
		memberDTO.setGrade("1");
		
		int result = memberDAO.memberJoin(memberDTO);
		
		assertNotEquals(0, result);
	}

	// 로그인
//	@Test
	public void memberLogin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		memberDTO = memberDAO.memberLogin(memberDTO);
		
		assertNotNull(memberDTO);
	}

}
