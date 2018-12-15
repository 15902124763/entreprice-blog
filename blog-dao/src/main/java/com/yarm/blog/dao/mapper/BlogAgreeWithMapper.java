package com.yarm.blog.dao.mapper;

import com.yarm.blog.pojo.mapper.BlogAgreeWithPojo;
import org.apache.ibatis.annotations.Param;

public interface BlogAgreeWithMapper {
    int insert(@Param("bap") BlogAgreeWithPojo bap);
}
