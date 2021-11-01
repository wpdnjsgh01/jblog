package com.douzone.jblog.vo;

import java.util.Date;

public class PostVO {

	private int no;
	private String title;
	private String contents;
	private Date reg_date;
	private int category_no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	@Override
	public String toString() {
		return "PostVO [no=" + no + ", title=" + title + ", contents=" + contents + ", reg_date=" + reg_date
				+ ", category_no=" + category_no + "]";
	}

}
