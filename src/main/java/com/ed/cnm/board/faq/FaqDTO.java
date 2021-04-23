package com.ed.cnm.board.faq;

import java.util.List;

import com.ed.cnm.board.BoardDTO;
import com.ed.cnm.board.BoardFileDTO;

public class FaqDTO extends BoardDTO {
	
	private List<BoardFileDTO> boardFiles;

	public List<BoardFileDTO> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFileDTO> boardFiles) {
		this.boardFiles = boardFiles;
	}
	
}
