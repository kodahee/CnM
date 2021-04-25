package com.ed.cnm.board.community;

import java.util.List;

import com.ed.cnm.board.BoardDTO;
import com.ed.cnm.board.BoardFileDTO;

public class CommunityDTO extends BoardDTO{
	private String genre;
	private List<BoardFileDTO> boardFiles;
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<BoardFileDTO> getBoardFiles() {
		return boardFiles;
	}
	public void setBoardFiles(List<BoardFileDTO> boardFiles) {
		this.boardFiles = boardFiles;
	}

}
