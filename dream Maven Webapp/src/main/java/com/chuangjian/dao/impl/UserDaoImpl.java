package com.chuangjian.dao.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: UserDaoImpl.java
 * 
 * Description: UserDao implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuangjian.common.Pager;
import com.chuangjian.common.Validity;
import com.chuangjian.dao.UserDao;
import com.chuangjian.entity.User;
import com.chuangjian.exception.DAOException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

//@Repository("userDao")
public class UserDaoImpl extends BaseDao<User,Integer> implements UserDao {

	public User getUserByName(String name) throws DAOException {
		String hql="from User where USER_NAME=:name";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("name", name);
		List<User>userList=super.getObjects(hql, params);
		return (userList!=null && userList.size()>0) ? userList.get(0) : null;
	}
	
	public int deleteUserById(int id) throws DAOException {
		String hql = "delete User where USER_ID=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return super.executeUpdate(hql, params);
	}
	
	public int updateUser(User user) throws DAOException {
		String hql="update User set USER_GENDER=:gender,USER_ROLE=:role,USER_DISTRICT=:district,USER_DESC=:desc,USER_UPDATETIME=:update where USER_ID=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gender", user.getGender());
		params.put("role", user.getRole().getId());
		params.put("district", user.getDistrict().getId());
		params.put("desc", user.getDesc());
		params.put("update", user.getUpdate());
		params.put("id", user.getId());
		return super.executeUpdate(hql, params);
	}
	
	public Pager<User> getUserListByPager(int currentPage, int pageSize,User user) throws DAOException {
		StringBuffer sb= new StringBuffer("from User where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if(!Validity.isEmpty(user)){
			if(!Validity.isNullAndEmpty(user.getName())){
				sb.append(" and USER_NAME like:name");
				params.put("name", "%"+user.getName().trim()+"%");
			}
			if(user.getGender()!=0){
				sb.append(" and USER_GENDER=:gender");
				params.put("gender", user.getGender());
			}
			if(Validity.isNotEmpty(user.getDesc())){
				sb.append(" and USER_DESC like:desc");
				params.put("desc", "%"+user.getDesc().trim()+"%");
			}
		}
		return super.findPager(sb.toString(),currentPage, pageSize, params);
	}
	
	public int updatePwd(User user) throws DAOException {
		String hql="update User set USER_PASSWORD=:pwd where USER_ID=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pwd", user.getPwd());
		params.put("id", user.getId());
		return super.executeUpdate(hql, params);
	}

}
