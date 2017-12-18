package com.chuangjian.web.interceptor;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: TimeInterceptor.java
 * 
 * Description: An interceptor for calculating method run time in action file.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.0
 */

public class TimeInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long startTime=System.currentTimeMillis();
		String result=invocation.invoke();//表示正在执行的过程
		String actionName=invocation.getProxy().getActionName();
		String methodName=invocation.getProxy().getMethod();
		long endTime=System.currentTimeMillis();
		System.out.println(actionName+":"+methodName+"执行了"+(endTime-startTime));
		return result;
	}

}
