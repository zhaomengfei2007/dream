package com.chuangjian.entity;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: User.java
 * 
 * Description: User persistence class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei  2017-12-15  Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.chuangjian.common.Conversion;

/**
 * Describe 代表了user表，用于实现用户管理。
 * @author	zhaomengfei
 * @version	1.1
 */

//@Entity
//@org.hibernate.annotations.Entity(dynamicUpdate=true)
//@Table(name = "user")
public class User implements Serializable{
	/**
	 * 序列化机制中用于验证版本的一致性。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * user表的主键id。
	 */
	private Integer id;
	/**
	 * 用于登录系统的用户名。
	 */
	private String name;
	/**
	 * 用于登录系统的用户密码。
	 */
	private String pwd;
	/**
	 * 用户的角色权限，对应role表。
	 */
	private Role role;
	/**
	 * 用户的籍贯信息。
	 */
	private District district;
	/**
	 * 用户的文件。
	 */
	private Set<Files> fileSet = new HashSet<Files>(0);
	/**
	 * 用户的性别。
	 */
	private Integer gender;
	/**
	 * 用户的描述。
	 */
	private String desc;
	/**
	 * 用户的注册时间。
	 */
	private Date create;
	/**
	 * 用户的更新时间。
	 */
	private Date update;
	/**
	 * 用户登录时所在的网络ip地址。
	 */
	private String loginip;
	/**
	 * 用户登录时的系统时间。
	 */
	private String loginTime;
	
	public User(){
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Set<Files> getFileSet() {
		return fileSet;
	}

	public void setFileSet(Set<Files> fileSet) {
		this.fileSet = fileSet;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public String getLoginip() {
		String ip="";
		try {
			ip=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
	public String getLoginTime() {
		return Conversion.dateToChinese(new Date());
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

}
