package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: BaseAction.java
 * 
 * Description: The parent class for all action files defines some common methods and properties.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuangjian.service.DeptService;
import com.chuangjian.service.DistrictService;
import com.chuangjian.service.FilesService;
import com.chuangjian.service.EmployeeService;
import com.chuangjian.service.CityService;
import com.chuangjian.service.ProvinceService;
import com.chuangjian.service.RoleService;
import com.chuangjian.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class BaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Logger log = LoggerFactory.getLogger(this.getClass());
	//	为了ajax准备的
	public Map<String, Object> resultMap = new HashMap<String, Object>();
	
	protected String errMsg;//ajax返回的错误信息
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String,Object> session;
	protected Map<String, String> cookies;
	@Autowired
	protected UserService userService;
	protected RoleService roleService;
	protected DistrictService districtService;
	protected FilesService filesService;
	protected EmployeeService employeeService;
	protected DeptService deptService;
	protected CityService cityService;
	protected ProvinceService provinceService;
	
	/**
	 * Convenience method to get the request
	 * 
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * Convenience method to get the parameter
	 * 
	 * @return current request
	 */
	protected String getParameter(String key) {
		return getRequest().getParameter(key);
	}

	/**
	 * Convenience method to get the response
	 * 
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * Convenience method to get the session. This will create a session if one
	 * doesn't exist.
	 * 
	 * @return the session from the request (request.getSession()).
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected Object getFromSession(String key) {
		return getSession().getAttribute(key);
	}

	protected String getStringFromSession(String key) {
		Object get = getSession().getAttribute(key);
		return get == null ? null : get.toString();
	}

	protected void putToSession(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public String str2Resp(String str) {
		PrintWriter out = null;
		getResponse().setContentType("text/html;charset=utf-8");
		getResponse().setCharacterEncoding("utf-8");
		try {
			out = getResponse().getWriter();
			log.debug("str2Resp {} ", str);
			out.write(str);
		} catch (Exception e) {
			log.error("str2Resp error ", e);
		} finally {
			if (null != out) {
				out.close();
			}
		}

		return null;
	}



	/**
	 * 获取服务器地址
	 * 
	 * @return
	 */
	public String getBasePath() {
		String path = getRequest().getContextPath();
		String bases = getRequest().getHeader("X-FORWARDED-HOST");
		if (bases == null || bases.length() < 1) {
			bases = getRequest().getHeader("Host");
		}

		if (bases == null || bases.length() < 1) {
			bases = getRequest().getServerName() + ":" + getRequest().getServerPort();
		}
		String basePath = getRequest().getScheme() + "://" + bases + path;
		return basePath;
	}
	

	

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	/**
	 * 把指定的数据放入struts2的value stack中
	 */
	public void setAttribute(String key, Object value) {
		ActionContext.getContext().getValueStack().set(key, value);
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	
	protected String getCookieValue(String name){
		Cookie cookies[] = request.getCookies();
		if (cookies != null){
			for (Cookie cookie : cookies){
				if (!name.equals(cookie.getName()))
					continue;
				return cookie.getValue();
			}
		}
		return null;
	}
	
	protected void saveCookie(String name, String value, int maxAge){
		Cookie cookie = new Cookie(name,value);
        cookie.setPath(request.getContextPath());
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
	 */

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}
	
}
