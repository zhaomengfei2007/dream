package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName : BaseService.java
 * 
 * Description : The parent class of all the business logic implementation classes
 * 
 * History:
 * version  author       date        operation
 * 1.0	    zhaomengfei  2017-12-15  Create
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chuangjian.dao.DeptDao;
import com.chuangjian.dao.DistrictDao;
import com.chuangjian.dao.FilesDao;
import com.chuangjian.dao.EmployeeDao;
import com.chuangjian.dao.CityDao;
import com.chuangjian.dao.ProvinceDao;
import com.chuangjian.dao.RoleDao;
import com.chuangjian.dao.UserDao;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.0
 */

public class BaseService {
	
	public Logger log = LoggerFactory.getLogger(this.getClass());
	
	//按类型注入
	//@Autowired
	protected UserDao userDao;
	protected RoleDao roleDao;
	protected DistrictDao districtDao;
	protected FilesDao filesDao;
	protected EmployeeDao employeeDao;
	protected DeptDao deptDao;
	protected CityDao cityDao;
	protected ProvinceDao provinceDao;
	
	//@Resource按名称
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}
	public void setFilesDao(FilesDao filesDao) {
		this.filesDao = filesDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}
}
