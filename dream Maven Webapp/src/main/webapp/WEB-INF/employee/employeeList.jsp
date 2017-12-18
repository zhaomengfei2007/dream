<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${siteName}--员工列表</title>
  </head>
  
  <body>
${index_css}
  <s:form name="search_form" action="findEmployees" namespace="/employee">
  		<s:hidden name="pager.currentPage"></s:hidden>
  		<s:hidden name="pager.pageSize"></s:hidden>
  		<table style="text-align:center;width:70%;margin:0 auto;">
  			<tr>
  				<td>姓名：<s:textfield name="employee.name"></s:textfield></td>
  				<td>学历：<s:textfield name="employee.desc"></s:textfield></td>
  				<td>专业：<s:textfield name="employee.specialty"></s:textfield></td>
  				<td>入职时间<s:textfield name="employee.entryDate" cssClass="Wdate" onClick="WdatePicker()"/></td>
  				<td>离职时间<s:textfield name="employee.quitDate" cssClass="Wdate" onClick="WdatePicker()"/></td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><s:submit value="查询"></s:submit></td>
  				<td><s:reset value="清空"></s:reset></td>
  				<td><input type="button" value="返回" id="btnback"/></td>
  				<td></td>
  			</tr>
  		</table>
  	</s:form>
    <table class="data_table" border="1">
    	<tr class="head_tr">
    		<td>序号</td>
    		<td>员工名称</td>
    		<td>员工住址</td>
    		<td>员工电话</td>
    		<td>毕业学校</td>
    		<td>毕业时间</td>
    		<td>专业</td>
    		<td>学历</td>
    		<td>性别</td>
    		<td>籍贯</td>
    		<td>入职时间</td>
    		<td>离职时间</td>
    		<td>所在部门</td>
    		<td>操作/<s:if test="currentUser.role.id==1"><a href="javascript:void(0);" id="add">增加</a></s:if>
    			<s:else>增加</s:else>
    		</td>
    	</tr>

    	<s:iterator var="employee" value="pager.pageRecords" status="s">
   		<tr <s:if test="#s.even">class="yellow"</s:if><s:if test="#s.odd">class="orange"</s:if>>
   			<s:hidden name="id" id="id"></s:hidden>
   			<td><s:property value="#s.index+1"/></td>
   			<td><s:property value="name"/></td>
   			<td><s:property value="address"/></td>
   			<td><s:property value="phone"/></td>
   			<td><s:property value="school"/></td>
   			<td><s:date name="graduate" format="yyyy-MM-dd"/></td>
   			<td><s:property value="specialty"/></td>
   			<td><s:property value="education"/></td>
   			<td>
   				<s:if test="gender == 1">
   					<span style="color:red">男</span>
   				</s:if>
   				<s:if test="gender == 2">
   					<span style="color:green">女</span>
   				</s:if>
   			</td>
   			<td><s:property value="city.name"/></td>
   			<td><s:date name="entryDate" format="yyyy-MM-dd"/></td>
   			<td><s:date name="quitDate" format="yyyy-MM-dd"/></td>
   			<td><s:property value="dept.name"/></td>
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
	${WdatePicker_js}
<script type="text/javascript">
$(function(){
	$(".delete").click(function(){
		var id = $(this).attr("rel");
		if(confirm("你确定要删除吗？")){
			var url = "${ctx}/employee/deleteEmployee.action";
			$.post(
				url,
				{"employee.id":id},
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

	$("#add").click(function(){
		window.location.href="${ctx}/employee/toAddEmployee.action";
	});
			
	$(".update").click(function(){
		var id = $(this).attr("rel");
		window.location.href="${ctx}/employee/toUpdateEmployee.action?employee.id="+id;
	});
	$("#btnback").click(function(){
		window.location.href="${ctx}/right.jsp";
	});

});
</script>
  </body>
</html>
