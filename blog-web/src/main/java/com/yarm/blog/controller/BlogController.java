package com.yarm.blog.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yarm.blog.pojo.mapper.BlogMapperPojo;
import com.yarm.blog.pojo.web.AjaxResult;
import com.yarm.blog.pojo.web.Blog;
import com.yarm.blog.pojo.web.Page;
import com.yarm.blog.service.BlogService;

import java.util.Map;

@Controller
@RequestMapping("blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="/submit.html", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult<String> submit(@RequestBody Blog b){
		AjaxResult<String> ar = new  AjaxResult<>();
		if (StringUtils.isBlank(b.getTitle())) {
			ar.setErrorStr("标题为空！");
			ar.setSuccess(false);
			ar.setResult("");
			return ar;
		}
		if (StringUtils.isBlank(b.getTitle())) {
			ar.setErrorStr("正文为空！");
			ar.setSuccess(false);
			ar.setResult("");
			return ar;
		}
		BlogMapperPojo bm = new BlogMapperPojo();
		bm.setTitle(b.getTitle());
		bm.setContent(b.getContent());
		this.blogService.insertBlog(bm);
		return ar;
	}
	
	@RequestMapping(value="blogList.html", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult<PageInfo<BlogMapperPojo>>  blogList(Page p){
		AjaxResult<PageInfo<BlogMapperPojo>> ar = new AjaxResult<PageInfo<BlogMapperPojo>>();
		if(p.getPageNum() == 0){
			p.setPageNum(1);
		}
		if(p.getPageSize() == 0){
			p.setPageSize(10);
		}
		PageInfo<BlogMapperPojo> blogList = this.blogService.
				blogList(p.getPageNum(), p.getPageSize());
		ar.setResult(blogList);
		return ar;
	}

	@RequestMapping(value="agreeWith.html", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult<String>  agreeWith(@RequestBody Map<String, String> map){
		AjaxResult<String> ar = new AjaxResult<String>();
		String blogId = map.get("blogId");
		long l = Long.parseLong(blogId);
		int i = this.blogService.agreeWith(l);
		if(i==1){
			ar.setResult("成功点赞");
			return ar;
		}
		ar.setSuccess(false);
		ar.setErrorStr("点赞出错");
		return ar;
	}
}
