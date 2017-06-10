/**
 * 
 */
package com.wei.you.zhihu.spider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

/**
 * 
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:41:19
 */
@Configuration
public class HystrixConfiguration {
	/**
	 * hystrix aop配置
	 * 
	 * @return
	 */
	@Bean
	public HystrixCommandAspect hystrixAspect() {
		return new HystrixCommandAspect();
	}
}
