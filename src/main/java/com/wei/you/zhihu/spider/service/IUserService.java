package com.wei.you.zhihu.spider.service;

import java.util.List;

import com.wei.you.zhihu.spider.entity.User;

/**
 * 知乎用户资料Service接口
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:44:22
 */
public interface IUserService {
	/**
	 * 保存知乎用户资料
	 * 
	 * @param question
	 * @return
	 */
	public boolean save(User user);

	/**
	 * 查询知乎用户资料
	 * 
	 * @param id
	 * @return
	 */
	public User selectById(String id);

	/**
	 * 修改知乎用户资料
	 * 
	 * @param question
	 * @return
	 */
	public boolean updateById(User user);

	/**
	 * 删除知乎用户资料
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(String id);

	/**
	 * 获取所有知乎用户资料的集合
	 * 
	 * @return
	 */
	public List<User> queryAll(int start ,int size);
}
