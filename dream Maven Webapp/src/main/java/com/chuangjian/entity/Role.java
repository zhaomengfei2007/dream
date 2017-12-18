package com.chuangjian.entity;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: Role.java
 * 
 * Description: Role persistence class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei  2017-12-15  Create
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Describe 代表了role表，用于声明用户的权限等级。
 * @author	zhaomengfei
 * @version	1.0
 */

public class Role implements Serializable {
	/**
	 * 序列化机制中用于验证版本的一致性
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * role表的主键id。
	 */
	private Integer id;
	/**
	 * 用户的权限登记名称。
	 */
	private String name;
	/**
	 * 用于配置与user表的一对多关联关系。
	 */
	private Set<User> users = new HashSet<User>(0);

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
