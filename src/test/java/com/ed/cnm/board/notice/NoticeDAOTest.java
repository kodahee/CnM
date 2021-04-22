package com.ed.cnm.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ed.cnm.MyAbstractTest;
import com.ed.cnm.board.notice.NoticeDAO;
import com.ed.cnm.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
	public void getList() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		//List<NoticeDTO> ar = noticeDAO.getList(noticeDTO);
		//assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void getSelect() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		//noticeDTO = noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	@Test
	public void setInsert() throws Exception {
		for(int i=0; i<120; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			long num = noticeDAO.getNum();
			noticeDTO.setNum(num);
			noticeDTO.setNickName("admin"+i);
			noticeDTO.setTitle("title" + i);
			noticeDTO.setContents("contents" + i);
			int result = noticeDAO.setInsert(noticeDTO);
			System.out.println(result);
//			assertEquals(1, result);
			if(i%10 == 0) {
				Thread.sleep(500);
			}
		}
	}
	
//	@Test
	public void setUpdate() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3);
		noticeDTO.setTitle("rr");
		noticeDTO.setContents("rrrr");
		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDelete() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(4);
		int result = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, result);
	}

}
