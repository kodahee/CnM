package com.ed.cnm.board.community;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ed.cnm.MyAbstractTest;

public class CommunityDAOTest extends MyAbstractTest {
	
	@Autowired
	private CommunityDAO communityDAO;
	
	//@Test
	/*
	 * public void setInsertTest() throws Exception {
	 * 
	 * CommunityDTO communityDTO = new CommunityDTO();
	 * communityDTO.setNickName("test nickName");
	 * communityDTO.setGenre("test Genre"); communityDTO.setTitle("test Title");
	 * communityDTO.setContents("test Contents"); int result =
	 * communityDAO.setInsert(communityDTO); System.out.println(result);
	 */
//		for(int i=0;i<100;i++) {
//			for(int j=0; j<5; j++) {
//				CommunityDTO communityDTO = new CommunityDTO();
//				communityDTO.setNickName("testname"+i);
//				communityDTO.setGenre("test Genre"+j);
//				communityDTO.setTitle("test Title"+i);
//				communityDTO.setContents("test Contents"+i);
//				int result = communityDAO.setInsert(communityDTO);
//				System.out.println(result);
//				if(i%10==0) {
//					Thread.sleep(500);
//				}
//			}
//		}
//	}
	
	@Test
	public void setInsertTest() throws Exception {
		
		for(int i=0;i<100;i++) {
			for(int j=0; j<10; j++) {
				CommunityDTO communityDTO = new CommunityDTO();
				communityDTO.setNickName("testname"+i);
				communityDTO.setGenre("test Genre"+j);
				communityDTO.setTitle("test Title"+i);
				communityDTO.setContents("test Contents"+i);
				int result = communityDAO.setInsert(communityDTO);
				System.out.println(result);
				if(i%10==0) {
					Thread.sleep(500);
				}
			}
		}
	}

}
