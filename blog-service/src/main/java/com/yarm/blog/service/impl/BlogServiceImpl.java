package com.yarm.blog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yarm.blog.pojo.mapper.BlogMapperPojo;
import com.yarm.blog.service.BlogService;
import com.yarm.blog.dao.mapper.BlogMapper;
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	@Override
	public void insertBlog(BlogMapperPojo b) {
		b.setUid("15902124763");//TODO
		Date date = new Date();
		b.setCreateDate(date);
		b.setUpdateDate(date);
		
		this.blogMapper.insert(b);
	}
}
