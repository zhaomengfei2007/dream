<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${siteName}--修改部门信息</title>
  </head>
  <body>
${index_css}
${validate_css}
	<s:form action="doAddEmployee" namespace="/employee" id="add_form">
		<%-- <s:hidden name="item.id" id="id"></s:hidden> --%>
		<table class="data_table" border="1">
			<tr class="head_tr">
				<td>属性</td>
				<td>变更内容</td>
			</tr>
			<tr>
				<td>员工名称</td>
				<td><s:textarea name="employee.name"></s:textarea></td>
			</tr>
			<tr>
				<td>员工住址</td>
				<td><s:textarea name="employee.address"></s:textarea></td>
			</tr>
			<tr>
				<td>员工电话</td>
				<td><s:textarea name="employee.phone"></s:textarea></td>
			</tr>
			<tr>
				<td>毕业学校</td>
				<td><s:textarea name="employee.school"></s:textarea></td>
			</tr>
			<tr>
				<td>毕业时间</td>
				<td><s:textfield name="employee.graduate" cssClass="Wdate" onClick="WdatePicker()"/></td>
			</tr>
			<tr>
				<td>专业</td>
				<td><s:textarea name="employee.specialty"></s:textarea></td>
			</tr>
			<tr>
				<td>学历</td>
				<td><s:textarea name="employee.education"></s:textarea></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><s:select name="employee.gender" list="#{1:'男',2:'女'}"></s:select></td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td><%-- <s:select name="employee.city.id" list="cityList" listKey="id" listValue="name"></s:select> --%>
					<s:doubleselect name="province.id" list="provinceList" listKey="id" listValue="name" 
	                doubleName="employee.city.id" doubleList="provinceMap[top.id]" doubleListKey="id" doubleListValue="name"></s:doubleselect>
				</td>
			</tr>
			<tr>
				<td>入职时间</td>
				<td><s:textfield name="employee.entryDate" cssClass="Wdate" onClick="WdatePicker()"/></td>
			</tr>
			<tr>
				<td>离职时间</td>
				<td><s:textfield name="employee.quitDate" cssClass="Wdate" onClick="WdatePicker()"/></td>
			</tr>
			<tr>
				<td>所在部门</td>
				<td><s:select name="employee.dept.id" list="deptList" listKey="id" listValue="name"></s:select></td>
			</tr>
			<tr>
				<td>处理</td>
				<td><input type="button" value="保存" id="btnsave"/>
					<s:reset value="重置"></s:reset>
					<input type="button" value="返回" id="btnback"/></td>
			</tr>
		</table>
	</s:form>
${jquery_js}
${validate_js}
${jquery_form_js}
${WdatePicker_js}
<script type="text/javascript">
$(function(){
	$("#add_form").validate({
		rules:{
			"employee.name":{
				required:true,
				rangelength:[2,10]
			},
			"employee.address":{
				required:true,
				rangelength:[2,200]
			},
			"employee.phone":{
				required:true,
				rangelength:[3,20]
			},
			"employee.school":{
				required:true,
				rangelength:[3,20]
			},
			"employee.graduate":{
				required:true,
				date:true
			},
			"employee.specialty":{
				required:true,
				rangelength:[3,20]
			},
			"employee.education":{
				required:true,
				rangelength:[3,10]
			},
			"employee.gender":{
				required:true
			},
			"employee.city.id":{
				required:true
			},
			"employee.entryDate":{
				required:true,
				date:true
			}
	},
	messages:{
			"employee.name":{
				required:"需要输入员工姓名",
				rangelength:"长度请限于2~10"
			},
			"employee.address":{
				required:true,
				rangelength:[2,200]
			},
			"employee.phone":{
				required:"需要输入员工住址",
				rangelength:"长度请限于3~20"
			},
			"employee.school":{
				required:"需要输入毕业学校",
				rangelength:"长度请限于3~20"
			},
			"employee.graduate":{
				required:"需要点选毕业时间",
				date:"日期格式有误"
			},
			"employee.specialty":{
				required:"需要输入专业",
				rangelength:"长度请限于3~20"
			},
			"employee.education":{
				required:"需要输入学历",
				rangelength:"长度请限于3~10"
			},
			"employee.gender":{
				required:"需要选择性别"
			},
			"employee.city.id":{
				required:"需要选择籍贯"
			},
			"employee.entryDate":{
				required:"需要点选入职时间",
				date:"日期格式有误"
			}
		}
	});
	
	$("#btnsave").click(function(){
	
		if($("#add_form").valid()){
		
				var url= "${ctx}/employee/doAddEmployee.action";
				
				/* if($("#uid").val() == ""){
					//add
					url = "${ctx}/user/doAddUser.action";
				}else{
					//update
					url = "${ctx}/user/doUpdateUser.action";
				} */
				
				//异步提交表单
				var options = {
					url : url,
					success : callback,
					type : 'post',
					dataType : 'json'
				};
				$("#add_form").ajaxSubmit(options);
				
			}

	});
	
	$("#btnback").click(function(){
		window.history.go(-1);
	});
	
});
function callback(data){
	alert(data.retmsg);
		if(data.retcode == "0"){
			window.location.href="${ctx}/employee/findEmployees.action";
	}
}
</script>
  </body>
</html>
