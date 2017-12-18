package com.chuangjian.dao;
/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: UserDao.java
 * 
 * Description: Database operation interface for processing user information.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-14	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import com.chuangjian.common.Pager;
import com.chuangjian.entity.User;
import com.chuangjian.exception.DAOException;
/**
 * user模块的数据库操作接口。
 * @author	zhaomengfei
 * @version	1.1
 */
public interface UserDao extends IBaseDao<User,Integer> {
	/**
	 * 根据页面传来的字符串name查询对应行数据。
	 * @param name 用户名。
	 * @return User: user对象。
	 * @exception DAOException
	 */
	public User getUserByName(String name) throws DAOException;
	/**
	 * 根据页面传来的主键id删除对应行数据。
	 * @param id user表的主键id。
	 * @return int: 删除之后判断删除结果的返回值。
	 * @exception DAOException: 如果id为空可能产生空指针异常。
	 */
	public int deleteUserById(int id) throws DAOException;
	/**
	 * 根据页面传来的user对象修改对应行数据。
	 * @param user user对象
	 * @return int: 修改之后判断修改结果的返回值。
	 * @exception DAOException: 如果id为空可能产生空指针异常。
	 */
	public int updateUser(User user) throws DAOException;
	/**
	 * 分页查询user表。
	 * @param currentPage 当前页
	 * @param pageSize 每页记录数
	 * @param user 封装了查询条件的user对象
	 * @return Pager<User>: Pager的实例。
	 * @exception DAOException: 如果传入的页码不符合规范则可能产生异常。
	 */
	public Pager<User> getUserListByPager(int currentPage,int pageSize,User user) throws DAOException;
	/**
	 * 根据页面传来的user对象修改对应行数据的密码字段的值。
	 * @param user user对象
	 * @return int: 修改之后判断修改结果的返回值。
	 * @exception DAOException: 如果user为空可能产生空指针异常。
	 */
	public int updatePwd(User user) throws DAOException;
}
