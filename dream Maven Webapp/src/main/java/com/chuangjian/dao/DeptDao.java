package com.chuangjian.dao;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DeptDao.java
 * 
 * Description: Database operation interface for processing dept information.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Dept;
import com.chuangjian.exception.DAOException;

/**
 * dept模块的数据库操作接口。
 * @author	zhaomengfei
 * @version	1.0
 */

public interface DeptDao extends IBaseDao<Dept,Integer> {
	public Dept getDeptByName(Dept dept) throws DAOException;
	public int updateDept(Dept dept) throws DAOException;
	public int deleteDept(int id) throws DAOException;
	public Pager<Dept> getDeptListByPager(int currentPage,int pageSize,Dept dept) throws DAOException;
}
