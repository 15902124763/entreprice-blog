package com.yarm.blog.service;

import com.github.pagehelper.PageInfo;
import com.yarm.blog.pojo.mapper.BlogMapperPojo;

public interface BlogService {

	void insertBlog(BlogMapperPojo b);

	public PageInfo<BlogMapperPojo> blogList(Integer pageNum,Integer pageSize);

	/**
	 * 点赞
	 * @param blogId
	 * @return
	 */
    int agreeWith(Long blogId);
}
