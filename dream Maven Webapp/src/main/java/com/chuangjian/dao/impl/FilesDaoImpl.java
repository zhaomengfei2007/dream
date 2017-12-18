package com.chuangjian.dao.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: FilesDaoImpl.java
 * 
 * Description: FilesDao implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuangjian.common.DefaultCode;
import com.chuangjian.common.Pager;
import com.chuangjian.common.Validity;
import com.chuangjian.dao.FilesDao;
import com.chuangjian.entity.Files;
import com.chuangjian.entity.User;
import com.chuangjian.exception.DAOException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class FilesDaoImpl extends BaseDao<Files,Integer> implements FilesDao {
	
	public int deleteFilesByUser(Files files) throws DAOException {
		String hql="delete Files where FILES_USER =:uid and FILES_USAGE=:usage";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("uid", files.getUser().getId());
		params.put("usage", files.getUsage());
		return super.executeUpdate(hql, params);
	}
	
	public int deleteFilesByUser(User user) throws DAOException {
		String hql="delete Files where FILES_USER =:uid";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("uid", user.getId());
		return super.executeUpdate(hql, params);
	}
	
	public int deleteFilesById(int id) throws DAOException {
		String hql="delete Files where FILES_ID =:id";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("id", id);
		return super.executeUpdate(hql, params);
	}
	
	public BigDecimal getFilesSize(User user,int usage) throws DAOException {
		String sql="select SUM(FILES_SIZE) from FILES where FILES_USER =:uid and FILES_USAGE =:usage";
		Map<String,Object>params=new HashMap<String,Object>();
			params.put("uid", user.getId());
			params.put("usage", DefaultCode.REGULAR);
		return  (BigDecimal) super.getUniqueBeanResultSql(sql, params);
	}
	
	public Pager<Files> getFilesListByUser(int currentPage,int pageSize,Files files,User user,int usage) throws DAOException {
		StringBuffer sb= new StringBuffer("from Files where 1=1");
		Map<String,Object>params=new HashMap<String,Object>();
		if(!Validity.isEmpty(user.getId())){
			sb.append(" and FILES_USER =:uid");
			params.put("uid", user.getId());
		}
		if(!Validity.isEmpty(usage)){
			sb.append(" and FILES_USAGE =:usage");
			params.put("usage", usage);
		}
		if(!Validity.isEmpty(files)){
			if(!Validity.isNullAndEmpty(files.getName())){
				sb.append(" and FILES_NAME like:name");
				params.put("name", "%"+files.getName()+"%");
			}
		}
		sb.append(" order by files_uploadtime desc");
		return super.findPager(sb.toString(), currentPage, pageSize, params);
	}
	
	public List<Files> getFilesByUser(Files files) throws DAOException {
		StringBuffer sb= new StringBuffer("from Files where 1=1");
		Map<String,Object>params=new HashMap<String,Object>();
		if(!Validity.isEmpty(files)){
			if(!Validity.isEmpty(files.getUser().getId())){
				sb.append(" and FILES_USER =:uid");
				params.put("uid", files.getUser().getId());
			}
			if(!Validity.isEmpty(files.getUsage())){
				sb.append(" and FILES_USAGE =:usage");
				params.put("usage", files.getUsage());
			}
		}
		return super.queryListByHql(sb.toString(), params);
	}
	
	public Files getFilesByName(String name) throws DAOException {
		String hql="from Files where FILES_NAME =:name";
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("name", name);
		List<Files>filesList=super.queryListByHql(hql, params);
		return Validity.isEmpty(filesList)?null:filesList.get(0);
	}

	public BigInteger getFilesCountByUser(User user) throws DAOException {
		String sql = "select COUNT(FILES_ID) from FILES where FILES_USER=:userId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		return (BigInteger) super.getUniqueBeanResultSql(sql, params);
	}

	public List<Files> getFileListByUser(User user) throws DAOException {
		String hql = "from Files where FILES_USER=:userId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		return super.getObjects(hql, params);
	}
	
	
}
