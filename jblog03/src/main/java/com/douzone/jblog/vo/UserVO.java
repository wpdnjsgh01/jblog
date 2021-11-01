package com.douzone.jblog.vo;

import java.util.Date;

public class UserVO {

	private String id;
	private String name;
	private String password;
	private Date join_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", join_date=" + join_date + "]";
	}

	public Object getRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
