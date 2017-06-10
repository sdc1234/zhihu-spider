package com.wei.you.zhihu.spider.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wei.you.zhihu.spider.service.IZhihuRecommendationService;

/**
 * 定时任务
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:18:42
 */
@Component
public class SpiderTask {

	// 注入分析知乎Recommendation获取的网页数据
	@Autowired
	private IZhihuRecommendationService zhihuRecommendationService;

	/**
	 * Druid的监控数据定时发送至ES
	 */
	@Scheduled(cron = "0 */1 *  * * * ")
	public void work() {
		zhihuRecommendationService.anaylicsRecommendation();
	}

}
