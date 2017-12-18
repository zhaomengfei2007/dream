<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
  <head> 
    <title>${siteName}--首页</title>
  </head>
  <frameset rows="147,*,11" frameborder="no" border="0" framespacing="0">
  	<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  	<frame src="center.jsp" name="mainFrame" id="mainFrame" height="60%" />
  	<frame src="down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
</html>
