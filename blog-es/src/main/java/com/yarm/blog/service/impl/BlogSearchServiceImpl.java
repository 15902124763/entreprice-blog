package com.yarm.blog.service.impl;

import com.yarm.blog.pojo.es.EsBlog;
import com.yarm.blog.repository.BlogRepository;
import com.yarm.blog.service.BlogSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogSearchServiceImpl implements BlogSearchService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void save(EsBlog poem) {
        blogRepository.save(poem);
    }

    @Override
    public Page<EsBlog> search(String title, String content, Pageable pageable) {
        return blogRepository.findByTitleLikeOrContentLike(title,content,pageable);
    }

    @Override
    public Page<EsBlog> search(String content, Pageable pageable) {
        return blogRepository.findByContentLike(content,pageable);
    }

    @Override
    public Page<EsBlog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
