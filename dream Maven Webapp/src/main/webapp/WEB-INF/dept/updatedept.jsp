<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${siteName}--修改部门</title>
  </head>
  <body>
${index_css}
${validate_css}
	<s:form action="doUpdateDept" namespace="/dept" id="edit_form">
		<s:hidden name="dept.id" id="id"></s:hidden>
		<table class="data_table" border="1">
			<tr class="head_tr">
				<td>属性</td>
				<td>变更内容</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><s:textarea name="dept.name"/></td>
			</tr>
			
			<tr>
				<td>描述</td>
				<td><s:textarea name="dept.desc"></s:textarea></td>
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
			"item.name":{
				required:true,
				rangelength:[3,10]
			},
			"item.desc":{
				required:true,
				rangelength:[3,200]
			}
	},
	messages:{
			"item.name":{
				required:"需要输入部门",
				rangelength:"长度限定为3~10"
			},
			"item.desc":{
				required:"需要输入描述",
				rangelength:"长度限定为3~200"
			}
		}
	});
	
	$("#btnsave").click(function(){
	
		if($("#edit_form").valid()){
		
				var url = "${ctx}/dept/doUpdateDept.action";
				
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
		window.location.href="${ctx}/dept/findDepts.action";
	}
}
</script>
  </body>
</html>
