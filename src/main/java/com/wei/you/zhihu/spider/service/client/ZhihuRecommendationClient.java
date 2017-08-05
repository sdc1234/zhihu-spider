package com.wei.you.zhihu.spider.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wei.you.zhihu.spider.service.client.ZhihuRecommendationClient.ZhihuHystrixClientFallback;

/**
 * 知乎FeignClient的客户端
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:04:29
 */
@FeignClient(name = "zhihu", url = "https://www.zhihu.com", fallback = ZhihuHystrixClientFallback.class)
public interface ZhihuRecommendationClient {
    @RequestMapping(method = RequestMethod.GET, value = "/explore/recommendations", consumes = { "application/json" })
    String getRecommendation();

    /**
     * 这边采取了和Spring
     * Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     * 
     * @author sunzc
     */
    @Component
    static class ZhihuHystrixClientFallback implements ZhihuRecommendationClient {
	private static final Logger loggger = LoggerFactory.getLogger(ZhihuHystrixClientFallback.class);

	private final static String DEFAULT_STR = "<html>error</html>";

	/**
	 * hystrix fallback方法
	 * 
	 * @return 默认的返回值
	 */
	@Override
	public String getRecommendation() {
	    loggger.error("异常发生，进入fallback方法");
	    return DEFAULT_STR;
	}
    }
}
