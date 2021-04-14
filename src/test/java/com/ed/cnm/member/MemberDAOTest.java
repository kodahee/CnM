package com.ed.cnm.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAOTest {
	
	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void memberLogin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		memberDTO = memberDAO.memberLogin(memberDTO);
		
		assertNotNull(memberDTO);
	}

}
