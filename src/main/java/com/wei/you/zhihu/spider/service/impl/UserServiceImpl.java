package com.wei.you.zhihu.spider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wei.you.zhihu.spider.dao.IUserDao;
import com.wei.you.zhihu.spider.entity.User;
import com.wei.you.zhihu.spider.service.IUserService;

/**
 * 知乎用户资料Service实现
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:12:55
 */
@Component
public class UserServiceImpl implements IUserService {

	// 注入dao服务
	@Autowired
	private IUserDao userDao;

	/**
	 * 保存知乎用户资料
	 * 
	 * @param question
	 * @return
	 */
	@Override
	public boolean save(User user) {
		return userDao.save(user);
	}

	/**
	 * 查询知乎用户资料
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public User selectById(String id) {
		return userDao.selectById(id);
	}

	/**
	 * 修改知乎用户资料
	 * 
	 * @param question
	 * @return
	 */
	@Override
	public boolean updateById(User user) {
		return userDao.updateById(user);
	}

	/**
	 * 删除知乎用户资料
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteById(String id) {
		return userDao.deleteById(id);
	}

	/**
	 * 获取所有知乎用户资料的集合
	 * 
	 * @return
	 */
	@Override
	public List<User> queryAll(int start, int size) {
		return userDao.queryAll(start, size);
	}

}
