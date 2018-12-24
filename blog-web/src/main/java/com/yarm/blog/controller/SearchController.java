package com.yarm.blog.controller;

import com.yarm.blog.pojo.es.EsBlog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SearchController {



    @PostMapping(value = "search/add")
    public String add(@RequestBody EsBlog esBlog){
       // this.blogRepository.save(esBlog);
        return "ok";
    }
}
