package com.chuangjian.dao.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DeptDaoImpl.java
 * 
 * Description: DeptDao implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuangjian.common.Pager;
import com.chuangjian.common.Validity;
import com.chuangjian.dao.DeptDao;
import com.chuangjian.entity.Dept;
import com.chuangjian.exception.DAOException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class DeptDaoImpl extends BaseDao<Dept,Integer> implements DeptDao {

	public Dept getDeptByName(Dept dept) throws DAOException {
		String hql="from Dept where DEPT_NAME like=:name";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("name", "%"+dept.getName()+"%");
		List<Dept> deptList=super.queryListByHql(hql, Dept.class, params);
		return Validity.isEmpty(deptList)?null:deptList.get(0);
	}
	
	public int updateDept(Dept dept) throws DAOException {
		String hql="update Dept set DEPT_NAME=:name,DEPT_DESC=:desc where DEPT_ID=:id";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("name", dept.getName());
		params.put("desc", dept.getDesc());
		params.put("id", dept.getId());
		return super.executeUpdate(hql, params);
	}

	public int deleteDept(int id) throws DAOException {
		String hql="delete Dept where id=:id";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("id", id);
		return super.executeUpdate(hql, params);
	}

	public Pager<Dept> getDeptListByPager(int currentPage, int pageSize,
			Dept dept) throws DAOException {
		StringBuffer sb=new StringBuffer("from Dept where 1=1 ");
		Map<String,Object>params=new HashMap<String,Object>();
		if(!Validity.isEmpty(dept)){
			if(!Validity.isNullAndEmpty(dept.getName())){
				sb.append("and DEPT_NAME like=:name ");
				params.put("name", "%"+dept.getName()+"%");
			}
			if(!Validity.isNullAndEmpty(dept.getDesc())){
				sb.append("and DEPT_DESC like=:desc ");
				params.put("desc", "%"+dept.getDesc()+"%");
			}
		}
		return super.findPager(currentPage, pageSize, Dept.class);
	}

}
