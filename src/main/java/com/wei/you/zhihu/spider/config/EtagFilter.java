package com.wei.you.zhihu.spider.config;

import javax.servlet.annotation.WebFilter;

import org.springframework.web.filter.ShallowEtagHeaderFilter;

/** 
 * 
 */
@WebFilter(filterName = "etagFilter", urlPatterns = { "/**/favicon.ico", "/statics/*" })
public class EtagFilter extends ShallowEtagHeaderFilter {

}