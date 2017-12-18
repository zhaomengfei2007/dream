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

import java.util.List;

import com.chuangjian.entity.City;
import com.chuangjian.entity.Province;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.CityService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class CityServiceImpl extends BaseService implements CityService {

	public List<City> getCityList() throws ServiceException {
		return cityDao.find(City.class);
	}

	public List<City> getCityListByProvince(Province province) throws ServiceException {
		return cityDao.getCityListByProvince(province);
	}

	public List<City> selectCity(Province province) throws ServiceException {
		return cityDao.selectCity(province);
	}

}
