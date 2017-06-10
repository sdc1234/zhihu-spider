package com.wei.you.zhihu.spider.init;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wei.you.zhihu.spider.config.property.AppConfig;
import com.wei.you.zhihu.spider.service.ISpiderService;

/**
 * 初始化调度搜索
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:16:45
 */
@Component
public class InitStartupRunner implements CommandLineRunner {
	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory.getLogger(InitStartupRunner.class);

	// 注入爬虫服务
	@Autowired
	private ISpiderService spiderService;

	// 注入配置服务
	@Autowired
	private AppConfig config;

	/**
	 * 启动运行
	 */
	@Override
	public void run(String... args) {
		logger.info("************start**********" + LocalDateTime.now());
		// String result =
		// spiderService.SendGet(config.getZhihuExploreRecommendationsUrl());
		// spiderService.getTarget(result);
		logger.info("************end**********" + LocalDateTime.now());
	}
}
