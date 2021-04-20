package com.ed.cnm.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ed.cnm.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	// 회원정보수정
	//@Test
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
	@Test
	public void memberJoin() throws Exception {
		for(int i=0; i<100; i++) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId("testid"+i);
			memberDTO.setPw("testpw"+i);
			memberDTO.setNickName("test NickName"+i);
			memberDTO.setName("testname"+i);
			memberDTO.setPhone("01000000"+i);
			memberDTO.setEmail("testid"+i+"@gmail.com");
			memberDTO.setCouponCheck("Y");
			memberDTO.setPoint(0);
			memberDTO.setGrade("1");
			
			int result = memberDAO.memberJoin(memberDTO);
			System.out.println(result);
		}

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
