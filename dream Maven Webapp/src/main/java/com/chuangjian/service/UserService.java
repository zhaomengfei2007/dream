package com.chuangjian.service;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: UserService.java
 * 
 * Description: Realizing the business logic of user.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.List;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.User;
import com.chuangjian.exception.ServiceException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public interface UserService {
	public User checkLogin(String uname,String pwd) throws ServiceException;
	public List<User> getUserList() throws ServiceException;
	public boolean deleteUserById(int id) throws ServiceException;
	public User getUserById(int id) throws ServiceException;
	public void addUser(User user) throws ServiceException;
	public boolean updateUser(User user) throws ServiceException;
	public Pager<User> getUserListByPager(int currentPage,int pageSize,User user) throws ServiceException;
	public boolean updatePwd(User user) throws ServiceException;
	public boolean checkUnameExists(String name) throws ServiceException;
}
