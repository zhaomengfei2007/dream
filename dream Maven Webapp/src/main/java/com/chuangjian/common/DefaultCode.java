package com.chuangjian.common;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DefaultCode.java
 * 
 * Description: Default values associated with the user.
 * 
 * History:
 * version  author       date        operation
 * 1.1      zhaomengfei	 2017-12-16	 Create
 */

import java.io.File;

import org.apache.struts2.ServletActionContext;

public class DefaultCode {
	/**赋予添加后用户的默认密码 */
	public static final String PASSWORD = "123456";
	/**新用户的默认头像 */
	public static final String ICONNAME = "201608231051592796.jpg";
	/**新用户默认头像的存储地址 */
	public static final String ICONPATH = "default/201608231051592796.jpg";
	/**默认头像的大小 */
	public static final long ICONSIZE =  28672;
	/**头像的文件类型编号 */
	public static final int ICONID = 1;
	/**个人普通文件的文件类型编号 */
	public static final int REGULAR = 2;
	/**已上传文件的保存主目录 */
	public static final String UPLOADPATH=ServletActionContext.getServletContext().getRealPath("uploadFile")+File.separator;
}
