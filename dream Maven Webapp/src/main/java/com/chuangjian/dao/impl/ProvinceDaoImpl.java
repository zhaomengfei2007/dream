package com.chuangjian.dao.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: ProvinceDaoImpl.java
 * 
 * Description: ProvinceDao implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.ArrayList;
import java.util.List;

import com.chuangjian.dao.ProvinceDao;
import com.chuangjian.entity.Province;
import com.chuangjian.exception.DAOException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class ProvinceDaoImpl extends BaseDao<Province,Integer> implements ProvinceDao {
	public List<Province> SelectProvince() throws DAOException{
		String sql="select PROVINCE_ID,PROVINCE_NAME from PROVINCE";
		List<Province> provinceList=new ArrayList<Province>();
		List<Object[]> list=super.queryListBySql(sql);
		for(Object[] o:list){
			provinceList.add(new Province((Integer)o[0],(String)o[1]));
		}
		return provinceList;
	}
}
