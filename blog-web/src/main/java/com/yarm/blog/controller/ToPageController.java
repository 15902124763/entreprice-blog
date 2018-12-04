package com.yarm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ToPageController {

	@RequestMapping(value={"/","page/index"})
	public String toIndex(){
		return "page/index-web";
	}
}
