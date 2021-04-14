package com.ed.cnm.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.ed.cnm.member.MemberDAO.";
	
	// 회원가입
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}
	
	// 로그인
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	

}
