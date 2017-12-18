package com.chuangjian.service;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DeptService.java
 * 
 * Description: Realizing the business logic of dept.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.List;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Dept;
import com.chuangjian.exception.ServiceException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public interface DeptService {
	public Dept getDeptById(Dept dept) throws ServiceException;
	public Dept getDeptByName(Dept dept) throws ServiceException;
	public void addDept(Dept dept) throws ServiceException;
	public boolean updateDept(Dept dept) throws ServiceException;
	public boolean deleteDept(int id) throws ServiceException;
	public Pager<Dept> getDeptListByPager(int currentPage, int pageSize,Dept dept) throws ServiceException;
	public List<Dept> getDeptList() throws ServiceException;
}
