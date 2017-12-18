package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DeptAction.java
 * 
 * Description: A controller for dept.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import com.chuangjian.common.Pager;
import com.chuangjian.common.RetCode;
import com.chuangjian.common.Validity;
import com.chuangjian.entity.Dept;
import com.chuangjian.entity.User;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class DeptAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pager<Dept> pager;
	private Dept dept;
	private User currentUser=(User)getFromSession("loginUser");
	
	public String findDepts(){
		if(Validity.isEmpty(pager)){
			pager=new Pager<Dept>();
		}
		try {
			pager=deptService.getDeptListByPager(pager.getCurrentPage(), pager.getPageSize(), dept);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("findDepts is bug : {}",e);
			return ERROR;
		}
	}
	
	public String toAddDept(){
		return SUCCESS;
	}
	
	public String doAddDept(){
		try {
			deptService.addDept(dept);
			log.debug("{} has add",dept.getName());
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "成功添加"+dept.getName());
		} catch (Exception e) {
			log.error("doAddDept {} is bug : {}",dept.getName(),e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "试图添加"+dept.getName()+"时发生未知错误，请检查后台程序");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String toUpdateDept(){
		try {
			dept=deptService.getDeptById(dept);
		} catch (Exception e) {
			log.error("toUpdateDept is bug : {}",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String doUpdateDept(){
		try {
			boolean result=deptService.updateDept(dept);
			if(result){
				log.info("{} has update",dept.getId());
				resultMap.put("retcode", RetCode.SUCCESS);
				resultMap.put("retmsg", "成功修改");
			}else{
				log.info("{} can not update",dept.getId());
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "修改"+dept.getName()+"失败");
			}
		} catch (Exception e) {
			log.error("doUpdateDept is bug : {}", e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "试图修改"+dept.getName()+"时发生未知错误，请检查后台程序");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String deleteDept(){
		try {
			boolean result=deptService.deleteDept(dept.getId());
			if(result){
				log.debug("{} had deleted by {}",dept.getId(),currentUser.getName());
				resultMap.put("retcode", RetCode.SUCCESS);
				resultMap.put("retmsg", "成功删除"+dept.getName());
			}else{
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "未能删除"+dept.getName()+"确认数据的有效性");
			}
		} catch (Exception e) {
			log.error("deleteDept is bug : {}", e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "试图删除"+dept.getName()+"时发生未知错误，请检查后台程序");
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Pager<Dept> getPager() {
		return pager;
	}

	public void setPager(Pager<Dept> pager) {
		this.pager = pager;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
