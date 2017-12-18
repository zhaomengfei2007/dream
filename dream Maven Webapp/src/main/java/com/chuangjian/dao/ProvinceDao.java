package com.chuangjian.dao;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: ProvinceDao.java
 * 
 * Description: Database operating interface for processing province information.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei  2017-12-16  Upgrade
 */

import java.util.List;

import com.chuangjian.entity.Province;
import com.chuangjian.exception.DAOException;

/**
 * role模块的数据库操作接口。
 * @author	zhaomengfei
 * @version	1.1
 */

public interface ProvinceDao extends IBaseDao<Province,Integer> {
	public List<Province> SelectProvince() throws DAOException;
}
