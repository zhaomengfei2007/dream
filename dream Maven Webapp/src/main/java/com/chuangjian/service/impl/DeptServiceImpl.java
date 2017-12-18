package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName : DeptServiceImpl.java
 * 
 * Description : DeptService implementation class.
 * 
 * History:
 * version        author        date        operation
 * 1.0	       zhaomengfei    2017-12-15      Create
 * 1.1         zhaomengfei    2017-12-16      Upgrade
 */

import java.util.List;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Dept;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.DeptService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class DeptServiceImpl extends BaseService implements DeptService{

	public Dept getDeptById(Dept dept) throws ServiceException {
		return deptDao.findById(dept.getId(), Dept.class);
	}

	public Dept getDeptByName(Dept dept) throws ServiceException {
		return deptDao.getDeptByName(dept);
	}

	public void addDept(Dept dept) throws ServiceException {
		deptDao.add(dept);
	}

	public boolean updateDept(Dept dept) throws ServiceException {
		return deptDao.updateDept(dept)>0;
	}

	public boolean deleteDept(int id) throws ServiceException {
		employeeDao.deleteEmployeeByDept(id);
		return deptDao.deleteDept(id)>0;
	}

	public Pager<Dept> getDeptListByPager(int currentPage, int pageSize,
			Dept dept) throws ServiceException {
		return deptDao.getDeptListByPager(currentPage, pageSize, dept);
	}

	public List<Dept> getDeptList() throws ServiceException {
		return deptDao.find(Dept.class);
	}

}
