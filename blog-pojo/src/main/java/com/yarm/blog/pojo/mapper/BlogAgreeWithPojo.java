package com.yarm.blog.pojo.mapper;

import java.util.Date;

public class BlogAgreeWithPojo {

    private long id;

    private  long blogId;

    private  String uid;

    private Date createDate;

    public void setId(long id) {
        this.id = id;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public long getBlogId() {
        return blogId;
    }

    public String getUid() {
        return uid;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
