package com.wei.you.zhihu.spider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wei.you.zhihu.spider.dao.IAnswerDao;
import com.wei.you.zhihu.spider.entity.Answer;
import com.wei.you.zhihu.spider.service.IAnswerService;

/**
 * 知乎问题答案Service实现
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:17:13
 */
@Component
public class AnswerServiceImpl implements IAnswerService {
	/**
	 * 注入问题答案Dao接口
	 */
	@Autowired
	private IAnswerDao answerDao;

	@Override
	public boolean save(List<Answer> answers) {
		if (answers == null || answers.size() == 0) {
			return false;
		}
		return answerDao.save(answers);
	}

	@Override
	public boolean deleteByQuestionId(String questionId) {
		return answerDao.deleteByQuestionId(questionId);
	}

}
