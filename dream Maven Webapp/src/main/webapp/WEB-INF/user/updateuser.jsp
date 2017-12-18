<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--修改用户信息</title>

  </head>
  
  <body>
${index_css}
${validate_css}
	<s:form action="doUpdateUser" namespace="/user" id="edit_form">
		<s:hidden name="item.id" id="id"></s:hidden>
		<table class="data_table" border="1">
			<tr class="head_tr">
				<td>属性</td>
				<td>变更内容</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><s:property value="item.name"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><s:select name="item.gender" list="#{1:'男',2:'女'}"></s:select></td>
			</tr>
			<tr>
				<td>角色编号</td>
				<td><s:select name="item.role.id" list="roleList" listKey="id" listValue="name"></s:select></td>
			</tr>
			<tr>
				<td>区号</td>
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
	$("#edit_form").validate({
		rules:{
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
			"item.gender":{
				required:"需要选择性别"
			},
			"item.role.id":{
				required:"需要输入籍贯编号"
			},
			"item.district.id":{
				required:"需要输入区号"
			}
		}
	});
	
	$("#btnsave").click(function(){
	
		if($("#edit_form").valid()){
		
				var url = "${ctx}/user/doUpdateUser.action";
				
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
				$("#edit_form").ajaxSubmit(options);
				
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
