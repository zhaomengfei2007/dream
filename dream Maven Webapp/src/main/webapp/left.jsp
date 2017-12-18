<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>${siteName}--导航</title>
  </head>
  
<body style="background-color:yellow;">
	<a href="${ctx}/user/findUsers.action" class="user" target="rightFrame">用户管理</a><br/>
	<a href="${ctx}/user/toUpdatePwd.action?item.id=${loginUser.id}" target="rightFrame">修改密码</a><br/>
	<a href="${ctx}/file/toUploadIcon.action" class="file" target="rightFrame">头像上传</a><br/>
	<a href="${ctx}/file/toDownloadIcon.action?files.usage=1&files.user.id=${loginUser.id}" class="file" target="rightFrame">下载头像</a><br/>
	<a href="${ctx}/file/findFiles.action" class="file" target="rightFrame">文件列表</a><br/>
	<a href="${ctx}/user/toViewUser.action?files.usage=1&files.user.id=${loginUser.id}" class="view" target="rightFrame">查看用户</a><br/>
	<a href="${ctx}/dept/findDepts.action" class="dept" target="rightFrame">部门列表</a><br/>
	<a href="${ctx}/employee/findEmployees.action" class="employee" target="rightFrame">员工列表</a>
	<a href="${ctx}/region/toSelect.action" class="region" target="rightFrame">测试城市</a>
</body>
</html>
