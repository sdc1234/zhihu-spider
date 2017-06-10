/**
 * 
 */
package com.wei.you.zhihu.spider.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.google.common.collect.Lists;

/**
 * 开放跨域访问配置
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:37:03
 */
@Configuration
public class CorsConfig {

	/**
	 * CORS配置
	 * 
	 * @return
	 */
	private CorsConfiguration buildConfig() {
		// 新建CORS配置
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		// 设置允许访问的请求源HTTP
		corsConfiguration.addAllowedOrigin("*");
		// 设置允许访问的请求源方法
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.setAllowCredentials(true);
		// 添加了新的header，需要配置白名单
		List<String> allowedHeaders = Lists.newArrayList();
		allowedHeaders.add("Content-Type");
		allowedHeaders.add("authorization");
		allowedHeaders.add("x-requested-with");
		corsConfiguration.setAllowedHeaders(allowedHeaders);
		// 返回CORS配置
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {
		// 新建可进行跨域访问的路径映射配置
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		// 可进行跨域访问的路径
		source.registerCorsConfiguration("/**", buildConfig());
		// 返回跨域过滤
		return new CorsFilter(source);
	}

}
