package com.yarm.blog.service.impl;

import java.util.Date;
import java.util.List;

import com.yarm.blog.dao.mapper.BlogAgreeWithMapper;
import com.yarm.blog.dao.mapper.CommentMapper;
import com.yarm.blog.pojo.mapper.CommentMapperPojo;
import com.yarm.blog.pojo.web.CommentWeb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yarm.blog.dao.mapper.BlogMapper;
import com.yarm.blog.pojo.mapper.BlogMapperPojo;
import com.yarm.blog.pojo.mapper.BlogAgreeWithPojo;
import com.yarm.blog.service.BlogService;
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private BlogAgreeWithMapper blogAgreeWithMapper;
	@Autowired
	private CommentMapper commentMapper;
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

    @Override
    public int agreeWith(Long blogId) {
	    //获取当前登入人 TODO
        String uid = "pinglunId123";
        BlogAgreeWithPojo bap = new BlogAgreeWithPojo();
        bap.setBlogId(blogId);
        bap.setUid(uid);
        int i = this.blogAgreeWithMapper.insert(bap);
        //统计博客评论
        BlogMapperPojo blogMapperPojo = this.blogMapper.selectBlogById(blogId);
        BlogMapperPojo bmp = new BlogMapperPojo();
        bmp.setId(blogId);
        bmp.setAgreeCount(blogMapperPojo.getAgreeCount() + 1);
        int j = this.blogMapper.update(bmp);
        return i;
    }

    @Override
    public String commment(CommentWeb cw) {
	    //获取当前登入人 TODO
        if(cw == null || StringUtils.isBlank(cw.getComment())){
            return "评论为空";
        }
        if(cw.getBlogId() == null){
            return "博客id为空";
        }
        String uid="pinglu1234";

        CommentMapperPojo cmp = new CommentMapperPojo();
        cmp.setBlogId(cw.getBlogId());
        cmp.setUid(uid);
        cmp.setComment(cw.getComment());
        int count = this.commentMapper.insert(cmp);

        return null;
    }
}
