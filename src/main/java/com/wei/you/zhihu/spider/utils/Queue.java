package com.wei.you.zhihu.spider.utils;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 队列工具
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:21:19
 */
public class Queue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1158570610013765237L;
	private LinkedList<Object> queue = new LinkedList<Object>();

	public void enQueue(Object t) {
		queue.addLast(t);
	}

	public Object deQueue() {
		return queue.removeFirst();
	}

	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	public boolean contians(Object t) {
		return queue.contains(t);
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	public int getNum() {
		return queue.size();
	}
}
