package com.wei.you.zhihu.spider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wei.you.zhihu.spider.entity.Answer;

/**
 * 知乎问题答案Dao接口
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:15:48
 */
@Mapper
public interface IAnswerDao {
	/**
	 * 批量新增问题答案
	 * 
	 * @param answers
	 * @return
	 */
	public boolean save(List<Answer> answers);

	/**
	 * 根据问题编号删除问题答案
	 * 
	 * @param questionId
	 * @return
	 */
	public boolean deleteByQuestionId(String questionId);
}
