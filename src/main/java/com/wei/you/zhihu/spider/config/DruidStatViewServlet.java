package com.wei.you.zhihu.spider.config;

import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * 
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:40:55
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/monitor/sql/*")
public class DruidStatViewServlet extends StatViewServlet {

}