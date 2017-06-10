package com.wei.you.zhihu.spider.utils;

import org.springframework.util.StringUtils;

/**
 * 实体基对象
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:20:54
 */
public class IdEntity extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;

	public IdEntity() {
		if (StringUtils.isEmpty(id)) {
			id = IdGen.uuid();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
