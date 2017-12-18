package com.chuangjian.dao.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: EmployeeDaoImpl.java
 * 
 * Description: EmployeeDao implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.chuangjian.common.Pager;
import com.chuangjian.common.Validity;
import com.chuangjian.dao.EmployeeDao;
import com.chuangjian.entity.Dept;
import com.chuangjian.entity.Employee;
import com.chuangjian.exception.DAOException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class EmployeeDaoImpl extends BaseDao<Employee,Integer> implements EmployeeDao {

	public Employee getEmployeeById(int id) throws DAOException {
		return super.findById(id, Employee.class);
	}

	public Pager<Employee> getEmployeeListByPager(int currentPage, int pageSize,
			Employee employee) throws DAOException {
		StringBuffer sb= new StringBuffer("from Employee where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if(!Validity.isEmpty(employee)){
			if(Validity.isNotEmpty(employee.getName())){
				sb.append(" and EMPLOYEE_NAME like:name");
				params.put("name", "%"+employee.getName().trim()+"%");
			}
			if(Validity.isNotEmpty(employee.getEducation())){
				sb.append(" and EMPLOYEE_EDUCATION like:education");
				params.put("gender", "%"+employee.getEducation().trim()+"%");
			}
			if(Validity.isNotEmpty(employee.getSpecialty())){
				sb.append(" and EMPLOYEE_SPECIALTY like:specialty");
				params.put("specialty", "%"+employee.getSpecialty().trim()+"%");
			}
			if(!Validity.isEmpty(employee.getEntryDate())){
				sb.append(" and EMPLOYEE_ENTRYDATE>=:entryDate");
				params.put("entryDate", employee.getEntryDate());
			}
			if(!Validity.isEmpty(employee.getQuitDate())){
				sb.append(" and EMPLOYEE_QUITTIME<=:quitDate");
				params.put("quitDate", employee.getQuitDate());
			}
			if(!Validity.isEmpty(employee.getDept())){
				sb.append(" and EMPLOYEE_DEPT=:deptId");
				params.put("quitId", employee.getDept().getId());
			}
		}
		return super.findPager(sb.toString(),currentPage, pageSize, params);
	}

	public int updateEmployee(Employee employee) throws DAOException {
		String hql="update Employee set EMPLOYEE_NAME=:name,EMPLOYEE_ADDRESS=:address,EMPLOYEE_PHONE=:phone,EMPLOYEE_SCHOOL=:school"
				+ ",EMPLOYEE_GRADUATEDATE=:graduate,EMPLOYEE_SPECIALTY=:specialty,EMPLOYEE_EDUCATION=:education,EMPLOYEE_GENDER=:gender"
				+ ",EMPLOYEE_CITY=:city,EMPLOYEE_ENTRYDATE=:entryDate,EMPLOYEE_QUITDATE=:quitDate,EMPLOYEE_DEPT=:deptId where EMPLOYEE_ID=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", employee.getName());
		params.put("address", employee.getAddress());
		params.put("phone", employee.getPhone());
		params.put("school", employee.getSchool());
		params.put("graduate", employee.getGraduate());
		params.put("specialty", employee.getSpecialty());
		params.put("education", employee.getEducation());
		params.put("gender", employee.getGender());
		params.put("city", employee.getCity().getId());
		params.put("entryDate", employee.getEntryDate());
		params.put("quitDate", employee.getQuitDate());
		params.put("deptId", employee.getDept().getId());
		params.put("id", employee.getId());
		return super.executeUpdate(hql, params);
	}

	public int deleteEmployee(int id) throws DAOException {
		String hql = "delete Employee where EMPLOYEE_ID=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return super.executeUpdate(hql, params);
	}

	public int deleteEmployeeByDept(int deptId) throws DAOException {
		String hql="delete Employee where EMPLOYEE_DEPT=:deptId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptId", deptId);
		return super.executeUpdate(hql, params);
	}

	public BigInteger getCountByDept(Dept dept) throws DAOException {
		String sql = "select COUNT(EMPLOYEE_ID) from EMPLOYEE where EMPLOYEE_DEPT=:deptId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptId", dept.getId());
		return (BigInteger) super.getUniqueBeanResultSql(sql, params);
	}

}
