package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName : ProvinceServiceImpl.java
 * 
 * Description : ProvinceService implementation class.
 * 
 * History:
 * version        author        date        operation
 * 1.0	       zhaomengfei    2017-12-15      Create
 * 1.1         zhaomengfei    2017-12-16      Upgrade
 */

import java.util.List;

import com.chuangjian.entity.Province;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.ProvinceService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class ProvinceServiceImpl extends BaseService implements ProvinceService {

	public List<Province> getProvinceList() throws ServiceException {
		return provinceDao.find(Province.class);
	}

	public Province getProvinceById(int id) throws ServiceException {
		return provinceDao.findById(id, Province.class);
	}

	public List<Province> SelectProvince() throws ServiceException {
		return provinceDao.SelectProvince();
	}

}
