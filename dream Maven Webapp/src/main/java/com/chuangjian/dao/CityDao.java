package com.chuangjian.dao;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: CityDao.java
 * 
 * Description: Database operation interface for processing city information.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import java.util.List;

import com.chuangjian.entity.City;
import com.chuangjian.entity.Province;
import com.chuangjian.exception.DAOException;

/**
 * city模块的数据库操作接口。
 * @author	zhaomengfei
 * @version	1.0
 */

public interface CityDao extends IBaseDao<City,Integer> {
	public List<City> getCityListByProvince(Province province) throws DAOException;
	public List<City> selectCity(Province province) throws DAOException;
}
