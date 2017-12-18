<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--文件列表</title>
  </head>
  
  <body>
${index_css}
  <s:form name="search_form" action="findFiles" namespace="/file">
  		<s:hidden name="pager.currentPage"></s:hidden>
  		<s:hidden name="pager.pageSize"></s:hidden>
  		<table style="text-align:center;width:70%;margin:0 auto;">
  			<tr>
  				<td>文件名：<s:textfield name="files.name"></s:textfield></td>
  				<td>
  					<s:submit value="查询"></s:submit>
  					<s:reset value="清空"></s:reset>
  					<input type="button" value="返回" id="btnback"/>
  				</td>
  			</tr>
  		</table>
  	</s:form>
    <table class="data_table" border="1">
    	<tr class="head_tr">
    		<td>序号</td>
    		<td>文件名</td>
    		<td>文件大小</td>
    		<td>上传时间</td>
    		<td>操作/<a href="javascript:void(0);" class="upload">上传</a></td>
    	</tr>

    	<s:iterator var="item" value="pager.pageRecords" status="s">
   		<tr <s:if test="#s.even">class="yellow"</s:if><s:if test="#s.odd">class="orange"</s:if>>
   			<s:hidden name="id" id="id"></s:hidden>
   			<td><s:property value="#s.index+1"/></td>
   			<td><s:property value="name"/></td>
   			<td><s:property value="size"/></td>
   			<td><s:date name="uploadDate" format="yyyy-MM-dd HH:mm:ss"/></td>
   			<td>
   					<a href="javascript:void(0);" class="download" rel="<s:property value="id"/>">下载</a>
   					<a href="javascript:void(0);" class="delete" rel="<s:property value="id"/>">删除</a>
   			</td>
   		</tr>
   		</s:iterator>
    	
    </table>
    <%@ include file="../common/page.jsp" %>
    <hr>
    <h3>总大小：<s:property value="totalSize"/>M</h3>
${jquery_js}
<script type="text/javascript">
$(function(){
	$(".delete").click(function(){
		var id = $(this).attr("rel");
		if(confirm("你确定要删除吗？")){
			var url = "${ctx}/file/deleteFiles.action";
			$.post(
				url,
				{"files.id":id},
				function(data){
					if(data.retcode == "0"){
						location.reload();
					}else{
						alert(data.retmsg);
					}
				}
			);
		}
	});

	$(".upload").click(function(){
		window.location.href="${ctx}/file/toUploadFiles.action";
	});
			
	$(".download").click(function(){
		var id = $(this).attr("rel");
		window.location.href="${ctx}/file/downloadFiles.action?files.id="+id;
	});
	$("#btnback").click(function(){
		window.location.href="${ctx}/right.jsp";
	});

});
</script>
  </body>
</html>
