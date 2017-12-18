package com.chuangjian.service;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DistrictService.java
 * 
 * Description: Realizing the business logic of district.
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

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public interface DistrictService {
	public List<District> getDistrictList() throws ServiceException;
	public List<District> getDistrictListByCity(City city) throws ServiceException;
}
