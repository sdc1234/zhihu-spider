package com.wei.you.zhihu.spider.entity;

import java.util.List;

import com.wei.you.zhihu.spider.utils.IdEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 知乎问题对象实体
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:06:59
 */
@NoArgsConstructor
@AllArgsConstructor
public class Question extends IdEntity {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 7634824664882839328L;
	// 问题
	@Getter
	@Setter
	private String question;
	// 问题描述
	@Getter
	@Setter
	private String questionDesc;
	// 问题链接
	@Getter
	@Setter
	private String url;
	// 问题作者
	@Getter
	@Setter
	private String author;
	// 问题答案
	@Getter
	@Setter
	private List<Answer> answers;
}
