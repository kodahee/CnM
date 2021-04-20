package com.ed.cnm.comments;

import java.sql.Date;

public class CommentsDTO {
	private long commentsNum;
	private long num;
	private String nickName;
	private String contents;
	private Date regDate;
	private long ref;
	private long step;
	private long depth;
	
	public long getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(long commentsNum) {
		this.commentsNum = commentsNum;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	
	
	
	
}
