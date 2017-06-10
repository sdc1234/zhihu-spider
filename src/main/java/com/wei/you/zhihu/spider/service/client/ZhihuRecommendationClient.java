package com.wei.you.zhihu.spider.service.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 知乎FeignClient的客户端
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:04:29
 */
@FeignClient(name = "zhihu", url = "https://www.zhihu.com")
public interface ZhihuRecommendationClient {
	@RequestMapping(method = RequestMethod.GET, value = "/explore/recommendations", consumes = { "application/json" })
	String getRecommendation();
}
