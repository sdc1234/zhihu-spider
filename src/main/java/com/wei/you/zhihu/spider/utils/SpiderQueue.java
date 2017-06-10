package com.wei.you.zhihu.spider.utils;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 爬虫队列工具
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:21:29
 */
public class SpiderQueue {
	/**
	 * 打印日志
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 存储访问过的url
	private static Set<Object> visitedUrl = new HashSet<>();
	// 存储尚未被访问的url
	private static Queue unVisitedUrl = new Queue();

	/**
	 * 添加访问过的url
	 * 
	 * @param Url
	 */
	public void addVisitedUrl(String Url) {
		visitedUrl.add(Url);
	}

	/**
	 * 删除已访问的url
	 * 
	 * @param url
	 */
	public void removeVisitedUrl(String url) {
		visitedUrl.remove(url);
	}

	/**
	 * 获取访问过的url的数量
	 * 
	 * @return
	 */
	public int getVisitedUrlNum() {
		return visitedUrl.size();
	}

	/**
	 * 获取下一个未被访问的url
	 * 
	 * @return
	 */
	public Object unVisitedUrlDequeue() {
		return unVisitedUrl.deQueue();
	}

	/**
	 * 添加未被访问的url
	 * 
	 * @param url
	 */
	public void addUnvisitedUrl(String url) {
		if (url != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unVisitedUrl.contians(url)) {
			unVisitedUrl.enQueue(url);
			logger.info("add to list success" + url);
		} else if (url == null) {
			logger.info("url=null");
		} else if (url.trim().equals("")) {
			logger.info("url equals null");
		} else if (visitedUrl.contains(url)) {
			logger.info("vistedList alearld have");
		} else if (unVisitedUrl.contians(url)) {
			logger.info("unVisitedList alearld have");
		} else {
			logger.info("something happened");
		}

	}

	/**
	 * 判断未被访问的url队列是否为空
	 * 
	 * @return
	 */
	public boolean unVisitedUrlsEmpty() {
		return unVisitedUrl.empty();
	}

	/**
	 * 获取未被访问的url队列个数
	 * 
	 * @return
	 */
	public int getUnVisitedUrlNum() {
		return unVisitedUrl.getNum();
	}
}
