package com.chuangjian.dao.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: CityDaoImpl.java
 * 
 * Description: CityDao implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuangjian.dao.CityDao;
import com.chuangjian.entity.City;
import com.chuangjian.entity.Province;
import com.chuangjian.exception.DAOException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class CityDaoImpl extends BaseDao<City,Integer> implements CityDao {

	public List<City> getCityListByProvince(Province province) throws DAOException {
		String hql="from City where CITY_PROVINCE=:provinceId";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("provinceId", province.getId());
		return super.getObjects(hql, params);
	}

	public List<City> selectCity(Province province) throws DAOException {
		String hql="select id,name from City where CITY_PROVINCE=:provinceId";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("provinceId", province.getId());
		return super.getObjects(hql, params);
	}

}
