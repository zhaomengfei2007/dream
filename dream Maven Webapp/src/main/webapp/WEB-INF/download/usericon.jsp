<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--文件下载</title>


  </head>
  
  <body>
  <h2>用户<s:property value="item.name"/>的文件</h2>
  <table>
  	<tr>
  		<td>文件名</td>
  		<td>上传时间</td>
  		<td>操作</td>
  	</tr>
  	<tr>
  		<td><s:property value="files.name"/></td>
  		<td><s:date name="files.uploadDate" format="yyyy-MM-dd"/></td>
  		<td><a href="${ctx}/file/downloadIcon.action">下载</a></td>
  	</tr>
  </table>
  </body>
</html>
