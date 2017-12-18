package com.chuangjian.service;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: FilesService.java
 * 
 * Description: Realizing the business logic of files.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.chuangjian.common.Pager;
import com.chuangjian.entity.Files;
import com.chuangjian.entity.User;
import com.chuangjian.exception.ServiceException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public interface FilesService {
	public List<Files> getFilesList() throws ServiceException;
	public BigDecimal getFilesSize(User user,int usage) throws ServiceException;
	public Files getFilesById(int id) throws ServiceException;
	public void addFiles(Files files) throws ServiceException;
	public boolean deleteFilesByUser(Files files) throws ServiceException;
	public int deleteFilesByUser(User user) throws ServiceException, IOException;
	public boolean deleteFilesById(int id) throws ServiceException;
	public Pager<Files> getFilesListByUser(int currentPage,int pageSize,Files files,User user,int usage) throws ServiceException;
	public boolean deleteOldFile(Files files) throws IOException;
	public List<Files> getFilesByUser(Files files) throws ServiceException;
	public Files checkNameExists(String name) throws ServiceException;
	public void fileStream(FileInputStream input,FileOutputStream out) throws IOException;
	public BigInteger getFilesCountByUser(User user) throws ServiceException;
}
