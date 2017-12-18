package com.chuangjian.service;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: FilesService.java
 * 
 * Description: Realizing the business logic of province.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.List;

import com.chuangjian.entity.Province;
import com.chuangjian.exception.ServiceException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public interface ProvinceService {
	public List<Province> getProvinceList() throws ServiceException;
	public Province getProvinceById(int id) throws ServiceException;
	public List<Province> SelectProvince() throws ServiceException;
}
