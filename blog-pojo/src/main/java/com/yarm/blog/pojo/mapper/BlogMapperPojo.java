package com.yarm.blog.pojo.mapper;

import java.util.Date;

public class BlogMapperPojo {

	private long id;
	
	private String uid;
	
	private String title;
	
	private String content;
	
	private Date createDate;

	private Date updateDate;

	private int agreeCount;

	public void setAgreeCount(int agreeCount) {
		this.agreeCount = agreeCount;
	}

	public int getAgreeCount() {
		return agreeCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
