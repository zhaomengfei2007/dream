package com.chuangjian.service;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: EmployeeService.java
 * 
 * Description: Realizing the business logic of employee.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.math.BigInteger;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Dept;
import com.chuangjian.entity.Employee;
import com.chuangjian.exception.ServiceException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public interface EmployeeService {
	public Employee getEmployeeById(int id) throws ServiceException;
	public Pager<Employee> getEmployeeListByPager(int currentPage,int pageSize,Employee employee) throws ServiceException;
	public boolean updateEmployee(Employee employee) throws ServiceException;
	public boolean deleteEmployee(int id) throws ServiceException;
	public void addEmployee(Employee employee) throws ServiceException;
	public BigInteger getCountByDept(Dept dept) throws ServiceException;
}
