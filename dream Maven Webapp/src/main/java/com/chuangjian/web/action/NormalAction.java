package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: NormalAction.java
 * 
 * Description: Encapsulates the generated securityCode into the session.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.ByteArrayInputStream;
import java.util.Map;

import com.chuangjian.common.SecurityCode;
import com.chuangjian.common.SecurityImage;
import com.opensymphony.xwork2.ActionContext;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.0
 */

public class NormalAction extends BaseAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//图片流
	private ByteArrayInputStream imageStream;
	private String timestamp;//得到时间戳
	
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	//System.out.println("时间戳timestamp:"+this.timestamp);
	}

	public String execute() throws Exception {
		//如果开启Hard模式，可以不区分大小写
		//String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
	       
		//获取默认难度和长度的验证码
		String securityCode = SecurityCode.getSecurityCode();
		imageStream = SecurityImage.getImageAsInputStream(securityCode);
		System.out.println("code="+securityCode);
	    	//放入session中
		Map session=ActionContext.getContext().getSession();
		session.put("SESSION_SECURITY_CODE", securityCode);
		return SUCCESS;
	}
	
}
