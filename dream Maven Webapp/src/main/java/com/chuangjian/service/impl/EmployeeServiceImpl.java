package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName : CityServiceImpl.java
 * 
 * Description : CityService implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0	    zhaomengfei  2017-12-15  Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.math.BigInteger;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Dept;
import com.chuangjian.entity.Employee;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.EmployeeService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class EmployeeServiceImpl extends BaseService implements EmployeeService {

	public Employee getEmployeeById(int id) throws ServiceException {
		return employeeDao.findById(id, Employee.class);
	}

	public Pager<Employee> getEmployeeListByPager(int currentPage, int pageSize,
			Employee employee) throws ServiceException {
		return employeeDao.getEmployeeListByPager(currentPage, pageSize, employee);
	}

	public boolean updateEmployee(Employee employee) throws ServiceException {
		return employeeDao.updateEmployee(employee)>0;
	}

	public boolean deleteEmployee(int id) throws ServiceException {
		return employeeDao.deleteEmployee(id)>0;
	}

	public void addEmployee(Employee employee) throws ServiceException {
		employeeDao.add(employee);
	}

	public BigInteger getCountByDept(Dept dept) throws ServiceException {
		return employeeDao.getCountByDept(dept);
	}

}
