package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: EmployeeAction.java
 * 
 * Description: A controller for employee.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuangjian.common.Pager;
import com.chuangjian.common.RetCode;
import com.chuangjian.common.Validity;
import com.chuangjian.entity.City;
import com.chuangjian.entity.Dept;
import com.chuangjian.entity.District;
import com.chuangjian.entity.Employee;
import com.chuangjian.entity.Province;
import com.chuangjian.entity.User;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class EmployeeAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pager<Employee> pager;
	private Employee employee;
	private User currentUser;
	private Dept dept;
	private Province province;
	private District district;
	private List<Dept> deptList;
	private List<Province> provinceList;
	private List<City> cityList;
	private Map<Integer,List<City>> provinceMap=new HashMap<Integer,List<City>>(0);
	
	
	public String findEmployees(){
		currentUser=(User)getFromSession("loginUser");
		if(Validity.isEmpty(pager)){
			pager =new Pager<Employee>();
		}
		try {
			pager=employeeService.getEmployeeListByPager(pager.getCurrentPage(), pager.getPageSize(), employee);
			return SUCCESS;
		} catch (Exception e) {
			log.error("findEmployees is bug : {}", e);
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toAddEmployee(){
		try {
			provinceList = provinceService.getProvinceList();
			for(Province province:provinceList){
				cityList=cityService.getCityListByProvince(province);
				provinceMap.put(province.getId(), cityList);
			}
			//cityList=cityService.getCityList();
			deptList=deptService.getDeptList();
			return SUCCESS;
		} catch (Exception e) {
			log.error("toAddEmployee is bug : {}",e);
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String doAddEmployee(){
		try {
			employeeService.addEmployee(employee);
			log.info("doAddEmployee success , {} has been Add", employee.getName());
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "成功添加："+employee.getName());
		} catch (Exception e) {
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "试图添加"+employee.getName()+"时发生未知错误，请检查后台程序");
			log.error("doAddEmployee is bug : {}", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String deleteEmployee(){
		try {
			boolean result=employeeService.deleteEmployee(employee.getId());
			if(result){
				resultMap.put("retcode", RetCode.SUCCESS);
				resultMap.put("retmsg", "成功删除"+employee.getName());
			}
		} catch (Exception e) {
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "尝试删除"+employee.getName()+"时失败，请检查后台程序");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String toUpdateEmployee(){
		try {
			employee=employeeService.getEmployeeById(employee.getId());
			cityList=cityService.getCityList();
			deptList=deptService.getDeptList();
		} catch (Exception e) {
			log.info("toUpdateEmployee is bug : {}",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String doUpdateEmployee(){
		try {
			boolean result=employeeService.updateEmployee(employee);
			if(result){
				resultMap.put("retcode", RetCode.SUCCESS);
				resultMap.put("retmsg", "成功修改"+employee.getName());
			}else{
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "未能修改"+employee.getName()+"，请确认数据的有效性");
			}
		} catch (Exception e) {
			log.error("doUpdateEmployee is bug",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getCountByDept(){
		try {
			resultMap.put("retcode",employeeService.getCountByDept(dept));
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	public String getCity(){
		try {
			provinceList = provinceService.getProvinceList();
			for(Province province:provinceList){
				cityList=cityService.getCityListByProvince(province);
				provinceMap.put(province.getId(), cityList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Pager<Employee> getPager() {
		return pager;
	}

	public void setPager(Pager<Employee> pager) {
		this.pager = pager;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Map<Integer, List<City>> getProvinceMap() {
		return provinceMap;
	}

	public void setProvinceMap(Map<Integer, List<City>> provinceMap) {
		this.provinceMap = provinceMap;
	}
	
}
