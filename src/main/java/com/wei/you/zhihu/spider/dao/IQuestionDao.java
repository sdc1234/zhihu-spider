package com.wei.you.zhihu.spider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wei.you.zhihu.spider.entity.Question;

/**
 * 知乎问题Dao接口
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:16:03
 */
@Mapper
public interface IQuestionDao {
	/**
	 * 保存问题对象
	 * 
	 * @param question
	 * @return
	 */
	public boolean save(Question question);

	/**
	 * 查询问题对象
	 * 
	 * @param id
	 * @return
	 */
	public Question selectById(String id);

	/**
	 * 修改问题对象
	 * 
	 * @param question
	 * @return
	 */
	public boolean updateById(Question question);

	/**
	 * 删除问题对象
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(String id);

	/**
	 * 获取所有问题对象的集合
	 * 
	 * @return
	 */
	public List<Question> queryAll(@Param(value = "start") int start, @Param(value = "size") int size);
}
