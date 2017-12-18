package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DistrictServiceImpl.java
 * 
 * Description: DistrictService implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.List;

import com.chuangjian.entity.City;
import com.chuangjian.entity.District;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.DistrictService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class DistrictServiceImpl extends BaseService implements DistrictService {
	public List<District> getDistrictList() throws ServiceException {
		return districtDao.find(District.class);
	}

	public List<District> getDistrictListByCity(City city) throws ServiceException {
		return districtDao.getDistrictListByCity(city);
	}
}
