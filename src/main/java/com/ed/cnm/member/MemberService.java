package com.ed.cnm.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ed.cnm.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;

	// 회원정보수정
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public int setFileUpdate(MemberDTO memberDTO, MultipartFile profilePic, HttpSession session) throws Exception {
		// 기존 사진 삭제
		String fileName = memberDTO.getMemberFileDTO().getFileName();
		boolean result = fileManager.delete("member", fileName, session);
		
		// 새로운 사진 저장
		int result2 = 0;
		
		if(result) {
			System.out.println("delete success");
			
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setOriginName(profilePic.getOriginalFilename());
			memberFileDTO.setFileName(fileName);
			
			result2 = memberDAO.setFileInsert(memberFileDTO);
			
		} else {
			System.out.println("delete fail");
		}
		
		return result2;
	}
	
	// 회원탈퇴
	public int memberDelete(MemberDTO memberDTO, HttpSession session) throws Exception {
		MemberFileDTO memberFileDTO = memberDAO.getMemberFile(memberDTO);	
		boolean check = fileManager.delete("member", memberFileDTO.getFileName(), session);
		return memberDAO.memberDelete(memberDTO);
	}
	
	// 아이디 중복 확인
	public MemberDTO checkID(MemberDTO memberDTO) throws Exception {
		return memberDAO.checkID(memberDTO);
	}
	
	// 로그인
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberLogin(memberDTO);
	}
	
	// 회원가입
	public int memberJoin(MemberDTO memberDTO, MultipartFile profilePic, HttpSession session) throws Exception {
		String fileName= fileManager.save("member", profilePic, session);
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setOriginName(profilePic.getOriginalFilename());
		memberFileDTO.setFileName(fileName);
		
		int result = memberDAO.memberJoin(memberDTO);
		result = memberDAO.setFileInsert(memberFileDTO);
		
		return result;
	}
	
}
