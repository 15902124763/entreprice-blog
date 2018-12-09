package com.yarm.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yarm.blog.dao.mapper.BlogMapper;
import com.yarm.blog.pojo.mapper.BlogMapperPojo;
import com.yarm.blog.service.BlogService;
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
	
	@Override
	public PageInfo<BlogMapperPojo> blogList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BlogMapperPojo> blogList = blogMapper.selectBlogList();
        PageInfo<BlogMapperPojo> pageInfo = new PageInfo<BlogMapperPojo>(blogList);
        return pageInfo;
	}
}
