package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DownloadAction.java
 * 
 * Description: Interaction between download services and pages.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.chuangjian.common.Validity;
import com.chuangjian.entity.Files;
import com.chuangjian.entity.User;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class DownloadIconAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Files files;
	private String inputPath;
	private User item;
	private InputStream inputStream;

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public String toDownloadIcon(){
		try {
			item=(User) getFromSession("loginUser");
			List<Files> icon=filesService.getFilesByUser(files);
			if(!Validity.isEmpty(icon)){
				files=icon.get(0);
			}
		} catch (Exception e) {
			log.error("toDownload is bug:{}",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public InputStream getInputStream(){
		ServletContext servletContext=null;
		try {
			item=(User) getFromSession("loginUser");
			List<Files> icon=filesService.getFilesByUser(new Files(item,1));
			if(!Validity.isEmpty(icon)){
				files=icon.get(0);
			}
			inputPath="/UploadFile/"+files.getPath();
			servletContext=ServletActionContext.getServletContext();
		} catch (Exception e) {
			log.error("DownloadIconAction--getInputStream is bug:{}",e);
			e.printStackTrace();
		}
		return servletContext.getResourceAsStream(inputPath);
	}
	
	public String downloadIcon(){
		return SUCCESS;
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
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
