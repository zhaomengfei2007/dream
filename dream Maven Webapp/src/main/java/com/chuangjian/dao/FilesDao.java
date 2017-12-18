package com.chuangjian.dao;
/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: FilesDao.java
 * 
 * Description: Database operation interface for processing files information.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Files;
import com.chuangjian.entity.User;
import com.chuangjian.exception.DAOException;

/**
 * files模块的数据库操作接口。
 * @author	zhaomengfei
 * @version	1.1
 */

public interface FilesDao extends IBaseDao<Files,Integer> {
	/**
	 * 根据页面传来的files对象删除对应行数据。
	 * @param id 主键id
	 * @return int: 删除修改之后判断删除结果的返回值。
	 * @exception DAOException
	 */
	public int deleteFilesByUser(Files files) throws DAOException;
	/**
	 * 删除user对象具有的所有文件
	 * @param id 主键id
	 * @return int: 删除修改之后判断删除结果的返回值。
	 * @exception DAOException
	 */
	public int deleteFilesByUser(User user) throws DAOException;
	/**
	 * 根据页面传来的主键id删除对应行数据。
	 * @param id files表的主键id。
	 * @return int: 删除修改之后判断删除结果的返回值。
	 * @exception DAOException。
	 */
	public int deleteFilesById(int id) throws DAOException;
	/**
	 * 根据页面传来的外键userId查询对应用户所拥有的文件的总大小。
	 * @param userId 用于区分用户的外键。
	 * @return Long: 文件总大小。
	 * @exception DAOException
	 */
	public BigDecimal getFilesSize(User user,int usage) throws DAOException;
	/**
	 * 根据页面传来的外键userId查询对应用户的所有数据。
	 * @param User user : 用户user对象。
	 * @return List<Files>: files对象集合。
	 * @exception DAOException
	 */
	public Pager<Files> getFilesListByUser(int currentPage,int pageSize,Files files,User user,int usage) throws DAOException;
	/**
	 * 根据页面传来的外键userId查询对应用户上传的头像数据。
	 * @param userId 用于区分用户的外键。
	 * @return Files: files对象。
	 * @exception DAOException
	 */
	public List<Files> getFilesByUser(Files files) throws DAOException;
	
	public List<Files> getFileListByUser(User user) throws DAOException;
	/**
	 * 根据文件名查询对应文件信息。
	 * @param name 文件名。
	 * @return Files: files对象。
	 * @exception DAOException
	 */
	public Files getFilesByName(String name) throws DAOException;
	/**
	 * 根据文件名查询对应文件信息。
	 * @param User user : user对象
	 * @return BigInteger: 指定用户所拥有的files对象数量
	 * @exception DAOException
	 */
	public BigInteger getFilesCountByUser(User user) throws DAOException;
}
