package com.wei.you.zhihu.spider.service;

import java.util.List;

import com.wei.you.zhihu.spider.entity.Question;

/**
 * 知乎问题Service接口
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:18:15
 */
public interface IQuestionService {

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
	public List<Question> queryAll(int start, int size);

	/**
	 * 初始化知乎问题
	 * 
	 * @param url
	 * @return
	 */
	public Question initQuestion(String url);

	/**
	 * 判断该知乎问题uri是否是有效的uri，若是将其赋值给问题对象并返回true，否则返回false
	 * 
	 * @param question
	 * @param url
	 * @return
	 */
	public boolean getRealUrl(Question question, String url);
}
