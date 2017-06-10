package com.wei.you.zhihu.spider.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.wei.you.zhihu.spider.config.property.AppConfig;
import com.wei.you.zhihu.spider.constant.ConstantField;
import com.wei.you.zhihu.spider.dao.IQuestionDao;
import com.wei.you.zhihu.spider.entity.Answer;
import com.wei.you.zhihu.spider.entity.Question;
import com.wei.you.zhihu.spider.init.InitStartupRunner;
import com.wei.you.zhihu.spider.service.IAnswerService;
import com.wei.you.zhihu.spider.service.IQuestionService;
import com.wei.you.zhihu.spider.service.ISpiderService;
import com.wei.you.zhihu.spider.utils.IdGen;

/**
 * 知乎问题Service实现
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:17:23
 */
@Component
public class QuestionServiceImpl implements IQuestionService {
	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(InitStartupRunner.class);

	/**
	 * 注入问题Dao接口
	 */
	@Autowired
	private IQuestionDao questionDao;

	// 注入配置信息服务
	@Autowired
	private AppConfig config;

	/**
	 * 注入知乎问题答案Service服务
	 */
	@Autowired
	private IAnswerService answerService;
	/**
	 * 注入爬虫服务
	 */
	@Autowired
	private ISpiderService spiderService;

	@Transactional(readOnly = false)
	@Override
	public boolean save(Question question) {
		question.setId(IdGen.uuid());
		if (question.getAnswers() != null && question.getAnswers().size() > 0) {
			List<Answer> answers = Lists.newArrayList();
			for (Answer temp : question.getAnswers()) {
				// 将问题答案的详细描述限制在2000字符内
				Answer answer = new Answer(question.getId(), temp.getAuthor(),
						temp.getDesc().length() > 2000 ? temp.getDesc().substring(2000) : temp.getDesc());
				answers.add(answer);
			}
			question.setAnswers(answers);
		}
		// 将问题的详细描述限制在2000字符内容内
		question.setQuestionDesc(question.getQuestionDesc().length() > 2000 ? question.getQuestionDesc().substring(2000)
				: question.getQuestionDesc());
		// 保存问题答案
		answerService.save(question.getAnswers());
		// 保存问题
		return questionDao.save(question);
	}

	@Override
	public Question selectById(String id) {
		// 根据问题id查询问题
		return questionDao.selectById(id);
	}

	@Override
	public boolean updateById(Question question) {
		// 习惯问题描述(不包括修改问题答案)
		return questionDao.updateById(question);
	}

	@Transactional(readOnly = false)
	@Override
	public boolean deleteById(String id) {
		// 删除问题答案
		answerService.deleteByQuestionId(id);
		// 删除问题
		return questionDao.deleteById(id);
	}

	@Override
	public List<Question> queryAll(int start, int size) {
		// 查询所有问题(暂不支持分页)
		return questionDao.queryAll(start, size);
	}

	/**
	 * 初始化知乎问题
	 * 
	 * @param url
	 * @return
	 */
	@Override
	public Question initQuestion(String url) {
		// 新建知乎问题
		Question zhihuQuestion = new Question();
		try {
			if (getRealUrl(zhihuQuestion, url)) {
				// 构建问题答案对象列表
				List<Answer> answerList = new ArrayList<Answer>();
				// 调用爬虫get请求服务，爬取页面信息
				String content = spiderService.SendGet(zhihuQuestion.getUrl());
				logger.info("zhihu spider begin:" + zhihuQuestion.getUrl());
				// 当爬取的内容不为空时
				if (StringUtils.isNotEmpty(content)) {
					// 给匹配对象赋值
					Pattern patternQuestion = Pattern.compile(config.getMatchZhihuQuestion());
					// 给正则匹配进行赋值
					Matcher matcherQuestion = patternQuestion.matcher(content);
					if (matcherQuestion.find()) {
						// 设置知乎问题对象的问题
						zhihuQuestion.setQuestion(matcherQuestion.group(1));
					} else {
						// 设置知乎问题对象的替换字符串
						zhihuQuestion.setQuestion(ConstantField.NOT_GET_WANT_URL_CONSTANT_FIELD);
						logger.info("lost question:" + zhihuQuestion.getUrl());
					}
					Pattern detailQuestionPattern = Pattern.compile(config.getMatchZhihuDetailQuestion());
					Matcher detailQuestionMatcher = detailQuestionPattern.matcher(content);
					if (detailQuestionMatcher.find())
						zhihuQuestion.setQuestionDesc(detailQuestionMatcher.group(1));
					else {
						// 设置知乎问题对象的替换字符串
						zhihuQuestion.setQuestionDesc(ConstantField.NOT_GET_WANT_URL_CONSTANT_FIELD);
						logger.info("lost questionDesc:" + zhihuQuestion.getUrl());
					}
					Pattern zhihuAnswerPattern = Pattern.compile(config.getMatchZhihuAnswer());
					Matcher zhihuAnswerMatcher = zhihuAnswerPattern.matcher(content);
					while (zhihuAnswerMatcher.find()) {
						// 新建问题答案
						Answer answer = new Answer();
						answer.setQuestionId(zhihuQuestion.getId());
						// 给问题答案设置作者
						answer.setAuthor(zhihuAnswerMatcher.group(1));
						// 给问题答案设置详细答案
						answer.setDesc(zhihuAnswerMatcher.group(2));
						// 将答案添加进问题答案列表
						answerList.add(answer);
					}
					// 将问题答案列表设进问题
					zhihuQuestion.setAnswers(answerList);
				}

			}
		} catch (Exception e) {
			logger.error("zhihu class error", e);
		}
		return zhihuQuestion;
	}

	/**
	 * 判断该知乎问题uri是否是有效的uri，若是将其赋值给问题对象并返回true，否则返回false
	 * 
	 * @param question
	 * @param url
	 * @return
	 */
	@Override
	public boolean getRealUrl(Question question, String url) {
		// 定义知乎url
		String zhihuUrl = null;
		// 获取正则匹配真实知乎问题uri的正则表达式，并构建匹配对象
		Pattern pattern = Pattern.compile(config.getMatchRealQuestionURI());
		// 匹配传入的uri
		Matcher matcher = pattern.matcher(url);
		// 当可以匹配时
		if (matcher.find())
			// 构建完整的url链接
			zhihuUrl = config.getZhihuUrl() + ConstantField.URL_SPERATOR_FLAG + ConstantField.QUESTION_CONSTANT_FIELD
					+ ConstantField.URL_SPERATOR_FLAG + matcher.group(1);
		// 当传入的url非知乎问题链接时
		else if (url.length() < 25) {
			// 将其作为uri进行重新构造
			zhihuUrl = config.getZhihuUrl() + url;
		} else {
			// 两个条件都不满足时，返回false
			return false;
		}
		// 否则设置知乎的url
		question.setUrl(zhihuUrl);
		// 并返回true
		return true;
	}

}
