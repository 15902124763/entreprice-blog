package com.yarm.blog.dao.mapper;

import com.yarm.blog.pojo.mapper.CommentMapperPojo;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    int insert(@Param("commentMapperPojo") CommentMapperPojo commentMapperPojo);
}
