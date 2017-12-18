package com.chuangjian.dao.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DistrictImpl.java
 * 
 * Description: District implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuangjian.dao.DistrictDao;
import com.chuangjian.entity.City;
import com.chuangjian.entity.District;
import com.chuangjian.exception.DAOException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class DistrictDaoImpl extends BaseDao<District,Integer> implements DistrictDao {

	public List<District> getDistrictListByCity(City city) throws DAOException {
		String hql="from District where DISTRICT_CITY=:cityId";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("cityId", city.getId());
		return super.getObjects(hql, params);
	}

}
