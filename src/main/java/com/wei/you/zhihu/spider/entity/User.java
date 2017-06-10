package com.wei.you.zhihu.spider.entity;

import com.wei.you.zhihu.spider.utils.IdEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 知乎用户资料
 */
@NoArgsConstructor
@AllArgsConstructor
public class User extends IdEntity {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 4878714592685892394L;
	// 用户名
	@Getter
	@Setter
	private String username;
	// user token
	@Getter
	@Setter
	private String userToken;
	// 位置
	@Getter
	@Setter
	private String location;
	// 行业
	@Getter
	@Setter
	private String business;
	// 性别
	@Getter
	@Setter
	private String sex;
	// 企业
	@Getter
	@Setter
	private String employment;
	// 教育
	@Getter
	@Setter
	private String education;
	// 用户首页url
	@Getter
	@Setter
	private String url;
	// 答案赞同数
	@Getter
	@Setter
	private int agrees = 0;
	// 感谢数
	@Getter
	@Setter
	private int thanks = 0;
	// 提问数
	@Getter
	@Setter
	private int asks = 0;
	// 回答数
	@Getter
	@Setter
	private int answers = 0;
	// 文章数
	@Getter
	@Setter
	private int posts = 0;
	// 关注人数
	@Getter
	@Setter
	private int followees = 0;
	// 粉丝数量
	@Getter
	@Setter
	private int followers = 0;
	// hashId 用户唯一标识
	@Getter
	@Setter
	private String hashId;
}
