package com.chuangjian.dao;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DistrictDao.java
 * 
 * Description: Database operation interface for processing district information.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import java.util.List;

import com.chuangjian.entity.City;
import com.chuangjian.entity.District;
import com.chuangjian.exception.DAOException;

/**
 * district模块的数据库操作接口。
 * @author	zhaomengfei
 * @version	1.0
 */

public interface DistrictDao extends IBaseDao<District,Integer> {
	public List<District> getDistrictListByCity(City city) throws DAOException;
}
