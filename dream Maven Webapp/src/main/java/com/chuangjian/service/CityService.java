package com.chuangjian.service;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: CityService.java
 * 
 * Description: Realizing the business logic of city.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import java.util.List;

import com.chuangjian.entity.City;
import com.chuangjian.entity.Province;
import com.chuangjian.exception.ServiceException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.0
 */

public interface CityService {
	public List<City> getCityList() throws ServiceException;
	public List<City> getCityListByProvince(Province province) throws ServiceException;
	public List<City> selectCity(Province province) throws ServiceException;
}
