package com.yarm.blog.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.yarm.blog.pojo.mapper.BlogMapperPojo;

public interface BlogMapper {

	void insert(@Param("blogMapperPojo")BlogMapperPojo b);

}
