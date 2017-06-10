package com.wei.you.zhihu.spider.service;

import java.util.List;

import com.wei.you.zhihu.spider.entity.Answer;

/**
 * 知乎问题答案Service接口
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:18:04
 */
public interface IAnswerService {
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
