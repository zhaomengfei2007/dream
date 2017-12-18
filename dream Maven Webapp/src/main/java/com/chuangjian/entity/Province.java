package com.chuangjian.entity;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: Province.java
 * 
 * Description: Province persistence class.
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
 * Describe 代表了province表，主要用于省份信息的查询。
 * @author	zhaomengfei
 * @version	1.1
 */

public class Province implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String abbreviation;
	private Set<City> cities=new HashSet<City>(0);
	public Province(){}
	public Province(Integer id,String name){
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
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	@JSON(serialize=false)
	public Set<City> getCities() {
		return cities;
	}
	@JSON(serialize=false)
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
}
