package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: RoleServiceImpl.java
 * 
 * Description: RoleService implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.List;

import com.chuangjian.entity.Role;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.RoleService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class RoleServiceImpl extends BaseService implements RoleService {

	public List<Role> getRoleList() throws ServiceException {
		return roleDao.find(Role.class);
	}
}
