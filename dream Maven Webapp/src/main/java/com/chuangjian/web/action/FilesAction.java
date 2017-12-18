package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: FilesAction.java
 * 
 * Description: A controller for files.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.File;
import java.util.List;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class FilesAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//上传文件域
	private List<File> upload;
	//上传文件类型
	private List<String> uploadContentType;
	//上传文件名
	private List<String> uploadFileName;
	//上传文件保存在服务器的路径，通过参数设置
	private String uploadPath;
	//处理结果
	private String result;
	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
