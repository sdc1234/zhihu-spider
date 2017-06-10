package com.wei.you.zhihu.spider.entity;

import com.wei.you.zhihu.spider.utils.IdEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 知乎回答对象实体
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:06:47
 */
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends IdEntity {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 8700739329116603334L;
	// 所属问题编号
	@Getter
	@Setter
	private String questionId;
	// 答案作者
	@Getter
	@Setter
	private String author;
	// 答案描述
	@Getter
	@Setter
	private String desc;
}
