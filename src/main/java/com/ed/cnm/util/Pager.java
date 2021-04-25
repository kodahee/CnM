package com.ed.cnm.util;

public class Pager {
	
	private long perPage;		// DB에 조회할 갯수
	private long perBlock;		// JSP에 출력할 번호의 갯수
	private long curPage;		// 현재 페이지 번호
	
	public Pager() {
		this.perPage = 25;
		this.perBlock = 10;
		this.curPage = 1;
	}

	private long startRow;
	private long lastRow;
	
	public void makeRow() {
		this.startRow = (this.curPage - 1) * perPage + 1;
		this.lastRow = this.curPage * perPage;
	}
	
	// ------ 페이징 계산 ----------------------------------------------
	private long totalPage;
	private long startNum;
	private long lastNum;
	private boolean pre;
	private boolean next;
	
	// 페이징 계산
	public void makeNum(long totalCount) {
		// 전체 페이지 갯수
		this.totalPage = totalCount / this.perPage;
		if(totalCount%this.perPage != 0) {
			totalPage++;
		}
		
		// 전체 block 수
		long totalBlock = this.totalPage / this.perBlock;
		if(this.totalPage%this.perBlock != 0) {
			totalBlock++;
		}
		
		// curBlock
		long curBlock = this.curPage / this.perBlock;
		if(this.curPage%this.perBlock != 0) {
			curBlock++;
		}
		
		// startNum, lastNum 
		this.startNum = (curBlock-1)*this.perBlock+1;
		this.lastNum= curBlock*this.perBlock;
		
		// curBlock == totalBlock
		if(curBlock == totalBlock) {
			this.lastNum= this.totalPage;
		}
		
		// 이전, 다음
		if(curBlock > 1) {
			this.pre=true;
		}
		
		if(curBlock != totalBlock) {
			this.next=true;
		}
	}

	// ------ getter, setter -------------------------------
	public long getPerPage() {
		return perPage;
	}

	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}

	public long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(long perBlock) {
		this.perBlock = perBlock;
	}

	public long getCurPage() {
		return curPage;
	}

	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}

	public long getStartRow() {
		return startRow;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	// ------ 검색 -------------------------------
	private String kind; 	//검색할 컬럼명
	private String search;	//검색어
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		if(search== null) {
			search="";
		}
		this.search = search;
	}
	
}
