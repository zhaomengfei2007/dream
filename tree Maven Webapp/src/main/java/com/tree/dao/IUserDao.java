package com.tree.dao;

import com.tree.entity.Pager;
import com.tree.entity.User;

public interface IUserDao {

	public User getUserById(int userId);
	public User getUserList();
	public User getUserByName(String username);
	public Pager<User> getUserListByPager(int currentPage,int pageSize,User user);
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser();
}
