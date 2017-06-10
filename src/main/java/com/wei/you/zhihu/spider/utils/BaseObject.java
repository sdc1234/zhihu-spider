package com.wei.you.zhihu.spider.utils;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 建议所有的PO,VO和DTO都继承此类 重载了默认的toString，equals与hashCode 并且默认所有子类都支持序列化
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:19:30
 */

public class BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 通过apache commons lang3重载
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/*
	 * 通过apache commons lang3重载
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/*
	 * 通过apache commons lang3重载
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
