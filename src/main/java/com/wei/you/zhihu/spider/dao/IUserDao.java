package com.wei.you.zhihu.spider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wei.you.zhihu.spider.entity.User;

/**
 * 知乎用户资料Dao接口
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:12:55
 */
@Mapper
public interface IUserDao {
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
	public List<User> queryAll(@Param(value = "start") int start, @Param(value = "size") int size);
}
