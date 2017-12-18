<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--修改密码</title>
  </head>
  
  <body>
${index_css}
${validate_css}
	<s:form action="doUpdatePwd" namespace="/user" id="pass_form">
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
				<td>旧密码</td>
				<td><s:password name="item.pwd" id="pwd"></s:password></td>
			</tr>
			<tr>
				<td>新密码</td>
				<td><s:password name="newPwd" id="newPwd"></s:password></td>
			</tr>
			<tr>
				<td>重复密码</td>
				<td><s:password name="rpwd" id="rpwd"></s:password></td>
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
${ipass_js}
<script type="text/javascript">
$(function(){
	$("#pass_form").validate({
		rules:{
			"item.pwd":{
				required:true,
				rangelength:[6,20]
			},
			"newPwd":{
				required:true,
				rangelength:[6,20]
			},
			"rpwd":{
				required:true,
				rangelength:[6,20],
				equalTo:"#newPwd"
			}
	},
	messages:{
			"item.pwd":{
				required:"需要输入密码",
				rangelength:"长度请介于6~20"
			},
			"newPwd":{
				required:"需要再次输入密码",
				rangelength:"长度请介于6~20"
			},
			"rpwd":{
				required:"需要再次输入密码",
				rangelength:"长度请介于6~20",
				equalTo:"请保证前后一致"
			}
		}
	});
	
	$("#btnsave").click(function(){

		if($("#pass_form").valid()){

				var url= "${ctx}/user/doUpdatePwd.action";
				//异步提交表单
				 /* var options = {
					url : url,
					success : callback,
					type : 'post',
					dataType : 'json'
				};
				$("#edit_form").ajaxSubmit(options);  */
				 $.post(
				url,
				{
					"item.id":$("#id").val(),
					"item.pwd":$("#pwd").val(),
					"newPwd":$("#newPwd").val
				},
				function(data){
					alert(data.retmsg);
					if(data.retcode=="0"){
						window.location.href="${ctx}/home.jsp";
					}
				}
			); 
				
			}

	});
	
	$("#btnback").click(function(){
		window.history.go(-1);
	});
	
});

/* function callback(data){
	alert(data.retmsg);
		if(data.retcode == "0"){
			window.location.href="${ctx}/user/findUsers.action";
		}
} */

$(document).ready(function(){
	$("#pwd").iPass();
}); 
</script>
  </body>
</html>
