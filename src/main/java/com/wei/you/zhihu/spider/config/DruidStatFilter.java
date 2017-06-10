package com.wei.you.zhihu.spider.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:40:46
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/monitor/sql/*") })
public class DruidStatFilter extends WebStatFilter {

}