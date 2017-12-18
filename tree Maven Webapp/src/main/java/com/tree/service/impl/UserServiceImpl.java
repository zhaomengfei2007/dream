package com.tree.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tree.dao.IUserDao;
import com.tree.entity.User;
import com.tree.service.UserService.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource  
    private IUserDao userDao;
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}

}
