package com.ed.cnm.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.ed.cnm.member.MemberDAO.";
	
	// 회원정보수정
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"memberUpdate", memberDTO);
	}
	
	// 회원탈퇴
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"memberDelete", memberDTO);
	}
	
	// 아이디 중복 확인
	public MemberDTO checkID(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"checkID", memberDTO);
	}
	
	// 회원가입
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}
	
	// 로그인
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	// 로그인 - 프로필사진 불러옴
	public MemberFileDTO memberLoginFile(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLoginFile", memberDTO);
	}
	
	public MemberFileDTO getMemberFile(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMemberFile", memberDTO);
	}
	
	

}
