package com.chuangjian.entity;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: City.java
 * 
 * Description: City persistence class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei  2017-12-15  Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Describe 代表了city表，主要用于城市或其他省直属县级行政区划信息的查询。
 * @author	zhaomengfei
 * @version	1.1
 */

public class City implements Serializable {
	/**
	 * 序列化机制中用于验证版本的一致性。
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Province province;
	private Set<Employee> employees=new HashSet<Employee>(0);
	public City(){}
	public City(Integer id,String name){
		this.id=id;
		this.name=name;
	}
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
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	@JSON(serialize=false)
	public Set<Employee> getEmployees() {
		return employees;
	}
	@JSON(serialize=false)
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
