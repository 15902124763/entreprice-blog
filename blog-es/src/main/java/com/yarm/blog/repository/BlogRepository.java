package com.yarm.blog.repository;

import com.yarm.blog.pojo.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BlogRepository extends ElasticsearchRepository<EsBlog, Long> {
    Page<EsBlog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
    Page<EsBlog> findByContentLike(String content,Pageable pageable);
}
