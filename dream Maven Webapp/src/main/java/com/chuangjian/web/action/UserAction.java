package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: UserAction.java
 * 
 * Description: A controller for user.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.chuangjian.common.DefaultCode;
import com.chuangjian.common.FileUtils;
import com.chuangjian.common.MD5Util;
import com.chuangjian.common.Pager;
import com.chuangjian.common.RetCode;
import com.chuangjian.common.Validity;
import com.chuangjian.entity.District;
import com.chuangjian.entity.Files;
import com.chuangjian.entity.Role;
import com.chuangjian.entity.User;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

//@Controller("userAction")
//@Scope("prototype")
public class UserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User item;
	private List<User> userList;
	private Pager<User> pager;
	private String newPwd;
	private String imageCode;
	private List<District> districtList;
	private Files files;
	private User currentUser;
	private List<Role> roleList;
	
	public String login(){
		User user=null;
		try {
			user = userService.checkLogin(item.getName(), MD5Util.MD5((MD5Util.MD5(item.getPwd()))));
			if(!Validity.isEmpty(user) ){
				//ActionContext.getContext().getSession().put("loginUser",user.getUser_name());
				putToSession("loginUser",user);
				resultMap.put("retcode", RetCode.SUCCESS);
				log.info("{} login success.",user.getName());
			}else{
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "用户名或密码错误。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("login is bug : {}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", item.getName()+"登录时发生未知错误，请检查后台程序。");
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String checkImageCode(){
		HttpServletResponse response = ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=UTF-8");  
		try {
			PrintWriter out = response.getWriter();  
	        if(imageCode == null || Validity.isEmpty(imageCode)){
				out.print(false);
			}else{
				boolean result = imageCode.equals((String)getFromSession("SESSION_SECURITY_CODE"));
				if(result){
					out.print(true);
				}else{
					out.print(false);
				}
			}
		} catch (Exception e) {
			log.error("method checkImageCode bug {} ",e);
			return ERROR;
		}
		 return null;
	}
	
	public String findUsers(){
		try {
			currentUser=(User)getFromSession("loginUser");
			if(Validity.isEmpty(pager)){
				pager=new Pager<User>();
			}
			pager=userService.getUserListByPager(pager.getCurrentPage(), pager.getPageSize(), item);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("findUsers is bug : {}",e);
			return ERROR;
		}
	}
	
	public String deleteUser(){
		try {
			item=userService.getUserById(item.getId());
			int row = filesService.deleteFilesByUser(item);
			boolean result = userService.deleteUserById(item.getId());
			
			if(result){
				if(row>0){
					log.info("{} deleteUser success,id:{}.",((User)getFromSession("loginUser")).getName(),item.getId());
					resultMap.put("retcode", RetCode.SUCCESS);
					resultMap.put("retmsg", "已删除用户，同时删除用户文件仓库及其包含的"+row+"个文件");
				}else{
					log.info("{} deleteUser success , but no files have been delete ,id:{}",((User)getFromSession("loginUser")).getName(),item.getId());
					resultMap.put("retcode", RetCode.SUCCESS);
					resultMap.put("retmsg", "在用户"+item.getName()+"的文件仓库删除了"+row+"个文件，如果您认为结果不符，请联系运维人员确认。");
				}
			}else{
				log.info("{} deleteUser whitout success,id:{}",((User)getFromSession("loginUser")).getName(),item.getId());
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "未完成对用户"+item.getName()+"及其文件仓库的删除工作，请及时联系运维人员。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("deleteUser is bug :{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "删除"+item.getName()+"发生未知错误，请检查后台程序。");
		}
		return SUCCESS;
	}
	
	public String toAddUser(){
		try {
			roleList=roleService.getRoleList();
			districtList=districtService.getDistrictList();
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("toAddUser is bug : {}",e);
		}
		return SUCCESS;
	}
	
	public String doAddUser(){
		try {
			item.setPwd(MD5Util.MD5((MD5Util.MD5(DefaultCode.PASSWORD))));
			item.setCreate(new Date());
			userService.addUser(item);
			filesService.addFiles(new Files(item,DefaultCode.ICONNAME,item.getId()+File.separator+DefaultCode.ICONNAME,DefaultCode.ICONSIZE,new Date(),DefaultCode.ICONID));
			FileUtils.createPath(DefaultCode.UPLOADPATH+item.getId());
			FileUtils.nioBufferCopy(new File(DefaultCode.UPLOADPATH+DefaultCode.ICONPATH), new File(DefaultCode.UPLOADPATH+item.getId()+File.separator+DefaultCode.ICONNAME));
			log.info("doAddUser success:{}",item.getId());
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "成功添加"+item.getName());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("doAddUser is bug :{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "试图添加"+item.getName()+"时发生未知错误，请检查后台程序。");
		}
		return SUCCESS;
	}
	
	public String toUpdateUser(){
		try {
			item=userService.getUserById(item.getId());
			roleList=roleService.getRoleList();
			districtList=districtService.getDistrictList();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("toUpdateUser is bug :{}",e);
			return ERROR;
		}
	}
	
	public String doUpdateUser(){
		try {
			item.setUpdate(new Date());
			boolean result=userService.updateUser(item);
			if(result){
				log.info("{} doUpdateUser success.",item.getId());
				resultMap.put("retcode", RetCode.SUCCESS);
				resultMap.put("retmsg", "修改成功！");
			}else{
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "修改失败，请确认数据的有效性。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("doUpdateUser is bug :{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "修改时发生未知错误，请检查后台程序。");
		}
		return SUCCESS;
	}
	
	public String toUpdatePwd(){
		try {
			item=userService.getUserById(item.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("toUpdatePassword is bug:{}",e);
			return ERROR;
		}
	}
	
	public String doUpdatePwd(){
		try {
			User oddUser=userService.getUserById(item.getId());
			User ckUser=userService.checkLogin(oddUser.getName(), MD5Util.MD5(MD5Util.MD5(item.getPwd())));
			if(!Validity.isEmpty(ckUser)){
				item.setPwd(MD5Util.MD5(MD5Util.MD5(newPwd)));
				boolean result=userService.updatePwd(item);
				if(result){
					log.info("{} doUpdatePwd success.",oddUser.getId());
					resultMap.put("retcode", RetCode.SUCCESS);
					resultMap.put("retmsg", "成功修改"+oddUser.getName()+"的密码");
				}else{
					resultMap.put("retcode", RetCode.FAIL);
					resultMap.put("retmsg", "修改"+oddUser.getName()+"的密码失败，请确认数据的有效性。");
				}
			}else{
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "修改"+oddUser.getName()+"的密码失败，因为原密码错误。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("doUpdatePwd is bug:{}",e);
		}
		return SUCCESS;
	}
	
	public String checkUnameExists(){
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
	        if(item == null || Validity.isEmpty(item.getName())){
				out.print(false);
			}else{
				boolean result = userService.checkUnameExists(item.getName().trim());
				if(result){
					out.print(false);
				}else{
					out.print(true);
				}
			}
		} catch (Exception e) {
			log.error("method checkUsernameExists bug {} ",e);
			return ERROR;
		}
		 return null;
	}
	
	public String toViewUser(){
		try {
			item=userService.getUserById(files.getUser().getId());
			List<Files> icon=filesService.getFilesByUser(files);
			if(!Validity.isEmpty(icon)){
				files=icon.get(0);
			}else{
				files=new Files(item, DefaultCode.ICONNAME, DefaultCode.ICONPATH, DefaultCode.ICONSIZE,null, DefaultCode.ICONID);
			}
		} catch (Exception e) {
			log.error("toViewUser is bug:",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String backToLogin(){
		try{
			session.remove("loginUser");
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public User getItem() {
		return item;
	}

	public void setItem(User item) {
		this.item = item;
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Pager<User> getPager() {
		return pager;
	}

	public void setPager(Pager<User> pager) {
		this.pager = pager;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public List<District> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
