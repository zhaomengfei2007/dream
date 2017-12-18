package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DownloadFilesAction.java
 * 
 * Description: A controller for file download.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.chuangjian.entity.Files;
import com.chuangjian.entity.User;

public class DownloadFilesAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Files files;
	private String inputPath;
	private User item;
	private InputStream inputStream;
	
	public InputStream getInputStream(){
		try {
			files=filesService.getFilesById(files.getId());
			inputPath="/UploadFile"+"/"+files.getPath();
		} catch (Exception e) {
			log.error("DownloadFilesAction--getInputStream is bug:{}",e);
			e.printStackTrace();
		}
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}
	
	public String downloadFiles(){
		return SUCCESS;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public User getItem() {
		return item;
	}

	public void setItem(User item) {
		this.item = item;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
