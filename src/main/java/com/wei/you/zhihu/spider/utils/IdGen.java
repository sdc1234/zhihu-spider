/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.wei.you.zhihu.spider.utils;

import java.security.SecureRandom;
import java.util.UUID;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:21:08
 */
@Service
@Lazy(false)
public class IdGen implements IdGenerator {

	private static SecureRandom random = new SecureRandom();

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 使用SecureRandom随机生成Long.
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * Activiti ID 生成
	 */
	public String getNextId() {
		return IdGen.uuid();
	}

	@Override
	public UUID generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
