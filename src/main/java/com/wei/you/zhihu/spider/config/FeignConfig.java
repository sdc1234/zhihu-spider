/**
 * 
 */
package com.wei.you.zhihu.spider.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.codec.Encoder;
import feign.form.FormEncoder;

/**
 * 
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:41:08
 */
@Configuration
@EnableFeignClients(basePackages = { "com.wei.you.zhihu.spider.service.client" })
public class FeignConfig {
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}

	@Bean
	public Encoder encoder() {
		return new FormEncoder();
	}
}
