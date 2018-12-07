package com.yarm.blog.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yarm.blog.pojo.mapper.BlogMapperPojo;
import com.yarm.blog.pojo.web.AjaxResult;
import com.yarm.blog.pojo.web.Blog;
import com.yarm.blog.service.BlogService;

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
		bm.setTitle(b.getContent());
		bm.setContent(b.getContent());
		this.blogService.insertBlog(bm);
		return ar;
	}
	
}
