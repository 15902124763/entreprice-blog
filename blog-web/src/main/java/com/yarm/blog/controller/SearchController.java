package com.yarm.blog.controller;

import com.yarm.blog.pojo.es.EsBlog;
import com.yarm.blog.service.BlogSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@Controller
public class SearchController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private BlogSearchService blogSearchService;

    @GetMapping(value = "search/q")
    @ResponseBody
    public Map<String,Object> add(String q,Pageable pageable){
        //使用queryStringQuery完成单字符串查询
        Page<EsBlog> all = blogSearchService.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("data",all);
        return map;
    }
}
