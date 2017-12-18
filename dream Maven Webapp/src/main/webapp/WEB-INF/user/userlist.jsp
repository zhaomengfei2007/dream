<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>${siteName}--用户列表</title>
  </head>

  <body>
${index_css}
  <s:form name="search_form" action="findUsers" namespace="/user">
  		<s:hidden name="pager.currentPage"></s:hidden>
  		<s:hidden name="pager.pageSize"></s:hidden>
  		<table style="text-align:center;width:70%;margin:0 auto;">
  			<tr>
  				<td>用户名：<s:textfield name="item.name"></s:textfield></td>
  				<td>性别：<s:select list="#{1:'男',2:'女'}" name="item.gender" headerKey="0" headerValue="请选择"></s:select></td>
  				<td>描述：<s:textfield name="item.desc"></s:textfield></td>
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
    		<td>用户名</td>
    		<td>性别</td>
    		<td>角色</td>
    		<td>区域</td>
    		<td>描述</td>
    		<td>创建时间</td>
    		<td>更新时间</td>
    		<td>操作/<s:if test="currentUser.role.id==1"><a href="javascript:void(0);" id="add">增加</a></s:if>
    			<s:else>增加</s:else>
    		</td>
    	</tr>

    	<s:iterator var="item" value="pager.pageRecords" status="s">
   		<tr <s:if test="#s.even">class="yellow"</s:if><s:if test="#s.odd">class="orange"</s:if>>
   			<s:hidden name="id" id="id"></s:hidden>
   			<td><s:property value="#s.index+1"/></td>
   			<td><s:property value="name"/></td>
   			<td>
   				<s:if test="gender == 1">
   					<span style="color:red">男</span>
   				</s:if>
   				<s:if test="gender == 2">
   					<span style="color:green">女</span>
   				</s:if>
   			</td>
   			<td><s:property value="role.name"/></td>
   			<td><s:property value="district.name"/></td>
   			<td><s:property value="desc"/></td>
   			<td><s:date name="create" format="yyyy-MM-dd"/></td>
   			<td><s:date name="update" format="yyyy-MM-dd"/></td>
   			<td>
   				<s:if test="id==currentUser.id">
   					<a href="javascript:void(0);" class="update" rel="<s:property value="id"/>">修改</a>
   				</s:if>
   				<s:else>
   					<a href="javascript:void(0);" class="update" rel="<s:property value="id"/>">修改</a>
   					<a href="javascript:void(0);" class="delete" rel="<s:property value="id"/>">删除</a>
   				</s:else>
   			</td>
   		</tr>
   		</s:iterator>
    	
    </table>
    <%@ include file="../common/page.jsp" %>
    <hr>
${jquery_js}
<script type="text/javascript">
$(function(){
	$(".delete").click(function(){
		var id = $(this).attr("rel");
		$.post(
			"${ctx}/file/getFilesCountByUser.action",
			{"item.id":id},
			function(data){
				if(confirm("该用户的网络硬盘还存在"+data.retcode+"个文件，你确定要删除吗？")){
					var url = "${ctx}/user/deleteUser.action";
					$.post(
						url,
						{"item.id":id},
						function(data){
							if(data.retcode == "0"){
								alert(data.retmsg);
								location.reload();
							}else{
								alert(data.retmsg);
							}
						}
					);
				}
			}
		);
		
		
	});

	$("#add").click(function(){
		window.location.href="${ctx}/user/toAddUser.action";
	});
			
	$(".update").click(function(){
		var id = $(this).attr("rel");
		window.location.href="${ctx}/user/toUpdateUser.action?item.id="+id;
	});
	$("#btnback").click(function(){
		window.location.href="${ctx}/right.jsp";
	});

});
</script>  
  </body>
</html>
