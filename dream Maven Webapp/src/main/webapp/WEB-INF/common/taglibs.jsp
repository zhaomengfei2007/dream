<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--  system values--%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="addr" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}" />
<c:set var="siteName" value="个人信息管理系统" />
<%-- css file define--%>
<c:set var="index_css" value="<link href='${ctx}/css/index.css' rel='stylesheet' type='text/css' />"/>
<c:set var="validate_css" value="<link href='${ctx}/css/validate.css' rel='stylesheet' type='text/css' />"/>
<c:set var="autocomplete_css" value="<link href='${ctx}/css/autocomplete.css' rel='stylesheet' type='text/css' />"/>
<%-- js file define --%>
<c:set var="jquery_js" value="<script type='text/javascript' src='${ctx}/js/jquery-1.7.js'></script>"  />
<c:set var="jquery_form_js" value="<script type='text/javascript' src='${ctx}/js/jquery.form.js'></script>"  />
<c:set var="WdatePicker_js" value="<script type='text/javascript' src='${ctx}/js/My97DatePicker/WdatePicker.js'></script>"  />
<c:set var="validate_js" value="<script type='text/javascript' src='${ctx}/js/jquery.validate.js'></script>"  />
<c:set var="ipass_js" value="<SCRIPT type='text/javascript' src='${ctx}/js/iPass.packed.js'></SCRIPT>"  />
<c:set var="echarts_js" value="<SCRIPT type='text/javascript' src='${ctx}/js/echarts.js'></SCRIPT>"  />
<%@ page trimDirectiveWhitespaces="true" %>