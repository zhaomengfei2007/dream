package com.chuangjian.web.interceptor;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: InterviewInterceptor.java
 * 
 * Description: An interceptor used to verify whether a user is logged in.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import java.util.Map;

import com.chuangjian.common.Validity;
import com.chuangjian.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.0
 */

public class InterviewInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ignoreActions;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac=invocation.getInvocationContext();
		Map session=ac.getSession();
		User user=(User) session.get("loginUser");
		String uname=user.getName();
		boolean ignore=false;
		String currentAction=invocation.getProxy().getActionName();
		String[] actions=ignoreActions.split(",");
		for(String action:actions){
			if(currentAction.matches(action.trim())){
				ignore=true;
				break;
			}
		}
		if(Validity.isNotEmpty(uname) || ignore==true){
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
	}
	
	public String getIgnoreActions() {
		return ignoreActions;
	}
	public void setIgnoreActions(String ignoreActions) {
		this.ignoreActions = ignoreActions;
	}

}
