package com.yarm.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yarm.blog.pojo.mapper.BlogMapperPojo;

public interface BlogMapper {

	/**
	 * 插入一条博客
	 * @Title: insert 
	 * @Description: TODO
	 * @Company:小松鼠课堂
	 * @author yarm_杨松
	 * @param @param b
	 * @return void
	 */
	void insert(@Param("blogMapperPojo")BlogMapperPojo b);

	/**
	 * 
	 * @Title: selectBlogList 
	 * @Description: 博客列表
	 * @Company:小松鼠课堂
	 * @author yarm_杨松
	 * @param @return
	 * @return List<BlogMapperPojo>
	 */
	List<BlogMapperPojo> selectBlogList();

	/**
	 * 更新
	 * @param bmp
	 * @return
	 */
	int update(@Param("blogMapperPojo") BlogMapperPojo bmp);

	/**
	 * 查询一条博客
	 * @param blogId
	 * @return
	 */
	BlogMapperPojo selectBlogById(@Param("id") Long blogId);
}
