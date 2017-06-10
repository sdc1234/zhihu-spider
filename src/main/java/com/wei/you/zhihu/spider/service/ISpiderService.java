package com.wei.you.zhihu.spider.service;

import java.util.List;

import com.wei.you.zhihu.spider.entity.Question;

/**
 * 爬虫服务接口
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:18:25
 */
public interface ISpiderService {
	/**
	 * 发送get请求，获取整个页面html
	 * 
	 * @param url
	 * @return
	 */
	public String SendGet(String url);

	/**
	 * 根据爬取的页面内容构建知乎问题列表
	 * 
	 * @param content
	 * @return
	 */
	public List<Question> getRec(String content);

	/**
	 * 根据爬取的uri获取真实可访问的url
	 * 
	 * @param url
	 * @return
	 */
	public String getRealUrl(String url);

	/**
	 * 将爬取的问题列表入库
	 * 
	 * @param content
	 * @return
	 */
	public void getTarget(String content);
}
