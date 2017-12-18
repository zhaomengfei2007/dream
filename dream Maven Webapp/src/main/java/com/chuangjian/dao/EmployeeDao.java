package com.chuangjian.dao;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: EmployeeDao.java
 * 
 * Description: Database operation interface for processing employee information.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import java.math.BigInteger;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Dept;
import com.chuangjian.entity.Employee;
import com.chuangjian.exception.DAOException;

/**
 * employee模块的数据库操作接口。
 * @author	zhaomengfei
 * @version	1.0
 */

public interface EmployeeDao extends IBaseDao<Employee,Integer> {
	public Employee getEmployeeById(int id) throws DAOException;
	public Pager<Employee> getEmployeeListByPager(int currentPage,int pageSize,Employee employee) throws DAOException;
	public int updateEmployee(Employee employee) throws DAOException;
	public int deleteEmployee(int id) throws DAOException;
	public int deleteEmployeeByDept(int deptId) throws DAOException;
	public BigInteger getCountByDept(Dept dept) throws DAOException;
}
