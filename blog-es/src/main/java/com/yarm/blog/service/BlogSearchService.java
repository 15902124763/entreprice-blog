package com.yarm.blog.service;

import com.yarm.blog.pojo.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogSearchService {
    //保存Poem实体
    void save (EsBlog poem);

    //基于title和content进行搜索，返回分页
    Page<EsBlog> search(String title, String content, Pageable pageable);

    //基于content进行搜索，返回分页
    Page<EsBlog> search(String content,Pageable pageable);

    //返回所有数据集合
    Page<EsBlog> findAll(Pageable pageable);
}
