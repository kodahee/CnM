package com.ed.cnm.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ed.cnm.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void memberJoint() throws Exception {
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
		memberDTO.setProfilePic("pic4");
		
		int result = memberDAO.memberJoin(memberDTO);
		
		assertNotEquals(0, result);
	}

	
	public void memberLogin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		memberDTO = memberDAO.memberLogin(memberDTO);
		
		assertNotNull(memberDTO);
	}

}
