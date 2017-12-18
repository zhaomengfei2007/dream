<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${siteName}--部门列表</title>

  </head>
  
  <body>
	${index_css}
  <s:form name="search_form" action="findDepts" namespace="/dept">
  		<s:hidden name="pager.currentPage"></s:hidden>
  		<s:hidden name="pager.pageSize"></s:hidden>
  		<table style="text-align:center;width:70%;margin:0 auto;">
  			<tr>
  				<td>用户名：<s:textfield name="dept.name"></s:textfield></td>
  				<td>描述：<s:textfield name="dept.desc"></s:textfield></td>
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
    		<td>部门名称</td>
    		<td>部门描述</td>
    		<td>操作/<s:if test="currentUser.role.id==1"><a href="javascript:void(0);" id="add">增加</a></s:if>
    			<s:else>增加</s:else>
    		</td>
    	</tr>

    	<s:iterator var="dept" value="pager.pageRecords" status="s">
   		<tr <s:if test="#s.even">class="yellow"</s:if><s:if test="#s.odd">class="orange"</s:if>>
   			<s:hidden name="id" id="id"></s:hidden>
   			<td><s:property value="#s.index+1"/></td>
   			<td><s:property value="name"/></td>
   			<td><s:property value="desc"/></td>
   			<td>
   				<a href="javascript:void(0);" class="update" rel="<s:property value="id"/>">修改</a>
   				<a href="javascript:void(0);" class="delete" rel="<s:property value="id"/>">删除</a>
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
		$.get(
			"${ctx}/employee/getCountByDept.action",
			{"dept.id":id},
			function(data){
				if(confirm("该部门还有"+data.retcode+"个员工，你确定要删除吗？")){
			var url = "${ctx}/dept/deleteDept.action";
			$.post(
				url,
				{"dept.id":id},
				function(data){
					if(data.retcode == "0"){
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
		window.location.href="${ctx}/dept/toAddDept.action";
	});
			
	$(".update").click(function(){
		var id = $(this).attr("rel");
		window.location.href="${ctx}/dept/toUpdateDept.action?dept.id="+id;
	});
	$("#btnback").click(function(){
		window.location.href="${ctx}/right.jsp";
	});

});
</script>
  </body>
</html>
