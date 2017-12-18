package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: UserServiceImpl.java
 * 
 * Description: UserService implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.List;

import com.chuangjian.common.Pager;
import com.chuangjian.common.Validity;
import com.chuangjian.entity.User;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.UserService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

//@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {
	
	public User checkLogin(String name, String pwd) throws ServiceException {
		User user=userDao.getUserByName(name);
		if(!Validity.isEmpty(user) && pwd.equals(user.getPwd())){
			return user;
		}
		return null;
	}

	
	public List<User> getUserList() throws ServiceException {
		return userDao.find(User.class);
	}

	
	public boolean deleteUserById(int id) throws ServiceException {
		return userDao.deleteUserById(id)>0?true:false;
	}

	
	public User getUserById(int id) throws ServiceException {
		return userDao.findById(id, User.class);
	}

	
	public boolean updateUser(User user) throws ServiceException {
		return userDao.updateUser(user)>0?true:false;
	}

	
	public void addUser(User user) throws ServiceException {
		userDao.add(user);
	}

	
	public Pager<User> getUserListByPager(int currentPage, int pageSize,
			User user) throws ServiceException {
		return userDao.getUserListByPager(currentPage, pageSize, user);
	}

	
	public boolean updatePwd(User user) throws ServiceException {
		return userDao.updatePwd(user)>0?true:false;
	}

	
	public boolean checkUnameExists(String name) throws ServiceException {
		return userDao.getUserByName(name)!= null ? true : false;
	}
}
