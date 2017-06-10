package com.wei.you.zhihu.spider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wei.you.zhihu.spider.service.IZhihuRecommendationService;
import com.wei.you.zhihu.spider.service.client.ZhihuRecommendationClient;

/**
 * 分析知乎Recommendation获取的网页数据
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:17:52
 */
@Component
public class ZhihuRecommendationServiceImpl implements IZhihuRecommendationService {
	// 注入知乎FeignClient的客户端
	@Autowired
	private ZhihuRecommendationClient requestClient;

	/**
	 * 解析页面数据
	 */
	@Override
	public String anaylicsRecommendation() {
		return requestClient.getRecommendation();
	}

}
