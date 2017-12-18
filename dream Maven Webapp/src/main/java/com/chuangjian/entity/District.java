package com.chuangjian.entity;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: District.java
 * 
 * Description: District persistence class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei  2017-12-15  Create
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Describe 代表了district表，主要用于区县信息的查询。
 * @author	zhaomengfei
 * @version	1.0
 */

public class District implements Serializable {
	/**
	 * 序列化机制中用于验证版本的一致性。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id。
	 */
	private Integer id;
	/**
	 * 对应的。
	 */
	private City city;
	/**
	 * 区县名称。
	 */
	private String name;
	/**
	 * 用于配置与user表的一对多关联关系。
	 */
	public District(){}
	public District(Integer id,String name){
		this.id=id;
		this.name=name;
	}
	private Set<User> users = new HashSet<User>(0);
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
