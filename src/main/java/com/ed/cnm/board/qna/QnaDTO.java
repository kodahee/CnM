package com.ed.cnm.board.qna;

import java.util.List;

import com.ed.cnm.board.BoardDTO;
import com.ed.cnm.board.BoardFileDTO;

public class QnaDTO extends BoardDTO {
	private String category;
	private long ref;
	private long step;
	private long depth;
	private String onOff;
	
	private List<BoardFileDTO> boardFiles;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getRef() {
		return ref;
	}

	public void setRef(long ref) {
		this.ref = ref;
	}

	public long getStep() {
		return step;
	}

	public void setStep(long step) {
		this.step = step;
	}

	public long getDepth() {
		return depth;
	}

	public void setDepth(long depth) {
		this.depth = depth;
	}

	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public List<BoardFileDTO> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFileDTO> boardFiles) {
		this.boardFiles = boardFiles;
	}
	
}
