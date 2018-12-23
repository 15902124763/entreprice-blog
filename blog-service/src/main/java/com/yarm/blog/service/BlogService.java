package com.yarm.blog.service;

import com.github.pagehelper.PageInfo;
import com.yarm.blog.pojo.mapper.BlogMapperPojo;
import com.yarm.blog.pojo.web.CommentWeb;

public interface BlogService {

	void insertBlog(BlogMapperPojo b);

	public PageInfo<BlogMapperPojo> blogList(Integer pageNum,Integer pageSize);

	/**
	 * 点赞
	 * @param blogId
	 * @return
	 */
    int agreeWith(Long blogId);

	/**
	 * 评论
	 * @param cw
	 * @return
	 */
	String commment(CommentWeb cw);
}
