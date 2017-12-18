package com.chuangjian.entity;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: Employee.java
 * 
 * Description: Employee persistence class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei  2017-12-15  Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Describe 代表了employee表，用于实现员工管理。
 * @author	zhaomengfei
 * @version	1.1
 */

public class Employee implements Serializable{
	/**
	 * 序列化机制中用于验证版本的一致性。
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * id
	 */
	private Integer id;
	/*
	 * 姓名
	 */
	private String name;
	/*
	 * 地址
	 */
	private String address;
	/*
	 * 电话
	 */
	private String phone;
	/*
	 * 学校
	 */
	private String school;
	/*
	 * 毕业时间
	 */
	private Date graduate;
	/*
	 * 专业
	 */
	private String specialty;
	/*
	 * 学历
	 */
	private String education;
	/*
	 * 性别
	 */
	private Integer gender;
	/*
	 * 城市
	 */
	private City city;
	/*
	 * 入职时间
	 */
	private Date entryDate;
	/*
	 * 离职时间
	 */
	private Date quitDate;
	/*
	 * 部门
	 */
	private Dept dept;
	/*
	 * 一对多配置
	 */
	private Set<Files> filesSet = new HashSet<Files>(0);
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Date getGraduate() {
		return graduate;
	}
	public void setGraduate(Date graduate) {
		this.graduate = graduate;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getQuitDate() {
		return quitDate;
	}
	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Set<Files> getFilesSet() {
		return filesSet;
	}
	public void setFilesSet(Set<Files> filesSet) {
		this.filesSet = filesSet;
	}
}
