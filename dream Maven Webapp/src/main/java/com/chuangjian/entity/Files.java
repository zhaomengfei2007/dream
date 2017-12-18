package com.chuangjian.entity;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: Files.java
 * 
 * Description: Files persistence class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei  2017-12-15  Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describe 代表了files表，用于实现文件上传下载等功能。
 * @author	zhaomengfei
 * @version	1.1
 */

public class Files implements Serializable {
	/**
	 * 序列化机制中用于验证版本的一致性。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * files表的主键id。
	 */
	private Integer id;
	/**
	 * files表的外键FK_FILES_USER所对应的USER表对象
	 */
	private User user;
	/**
	 * 文件名，包括文件名后缀。
	 */
	private String name;
	/**
	 * 文件在服务器端的存储路径，由文件名及其上级文件夹组成。
	 */
	private String path;
	/**
	 * 文件大小。
	 */
	private Long size;
	/**
	 * 修改时间。
	 */
	private Date uploadDate;
	/**
	 * 用于说明上传文件的用途。
	 */
	private Integer usage;
	/**
	 * 用于将上传文件的文件名修改为新文件名所需的日期格式。
	 */
	/**
	 * 表示员工。
	 */

	@SuppressWarnings("unused")
	private String time;
	
	public Files(){
	}
	
	public Files(User user, Integer usage) {
		this.user = user;
		this.usage = usage;
	}
	
	public Files(User user, String name, String path, Long size,
			Date uploadDate, Integer usage) {
		this.user = user;
		this.name = name;
		this.path = path;
		this.size = size;
		this.uploadDate = uploadDate;
		this.usage = usage;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUid(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Integer getUsage() {
		return usage;
	}

	public void setUsage(Integer usage) {
		this.usage = usage;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(uploadDate);
	}


}