<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--新增用户</title>
  </head>
  
  <body>
${index_css}
${validate_css}
	<s:form action="doAddUser" namespace="/user" id="add_form">
		<%-- <s:hidden name="item.id" id="id"></s:hidden> --%>
		<table class="data_table" border="1">
			<tr class="head_tr">
				<td>属性</td>
				<td>变更内容</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><s:textfield name="item.name" id="uname"></s:textfield></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><s:select name="item.gender" list="#{1:'男',2:'女'}"></s:select></td>
			</tr>
			<tr>
				<td>角色</td>
				<td><s:select name="item.role.id" list="roleList" listKey="id" listValue="name"></s:select></td>
			</tr>
			<%-- <tr>
				<td>出生日期</td>
				<td><s:textfield name="item.birthday" cssClass="Wdate" onClick="WdatePicker()"/></td>
			</tr> --%>
			<tr>
				<td>住址编号</td>
				<td><s:select name="item.district.id" list="districtList" listKey="id" listValue="name"></s:select></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><s:textarea name="item.desc"></s:textarea></td>
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
			"item.name":{
				required:true,
				remote :{
					url: "${ctx}/user/checkUnameExists.action",     //后台处理程序
					type: "post",               //数据发送方式
					dataType: "json",           //接受数据格式   
					data: {                     //要传递的数据
						"item.name": function() {
							return $("#uname").val();
						}
					}
				},
				rangelength:[6,20]
			},
			"item.gender":{
				required:true
			},
			"item.role.id":{
				required:true
			},
			"item.district.id":{
				required:true
			}
	},
	messages:{
			"item.name":{
				required:"需要输入用户名",
				remote:"用户名已经存在",
				rangelength:"长度请介于6~20"
			},
			"item.gender":{
				required:"需要点选出生日期",
			},
			"item.role.id":{
				required:"需要输入角色编号"
			},
			"item.district.id":{
				required:"需要输入区号"
			}
		}
	});
	
	$("#btnsave").click(function(){
	
		if($("#add_form").valid()){
		
				var url= "${ctx}/user/doAddUser.action";
				
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
			window.location.href="${ctx}/user/findUsers.action";
	}
}
</script>
  </body>
</html>
