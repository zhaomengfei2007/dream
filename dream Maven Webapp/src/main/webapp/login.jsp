<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--登录</title>
  </head>
  <body>

    ${validate_css}
<s:form action="login" namespace="/user" id="login_form">
<table>
	<tr>
		<td>用户名</td>
		<td><s:textfield name="item.name" id="name" placeholder="请输入用户名"></s:textfield></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><s:password name="item.pwd" id="pwd" placeholder="请输入密码"></s:password></td>
	</tr>
	<tr>
		<td>验证码</td>
		<td><s:textfield name="imageCode" id="imageCode"></s:textfield>
		<img id="img_code" src="${ctx}/normal/securityCodeImageAction.action" style="cursor:pointer;" title="看不清，换一张" /></td>
	</tr>
	<tr>
		<td><input type="button" value="登录" id="btnlogin"/></td>
		<td><s:reset value="撤销"></s:reset></td>
	</tr>
</table>
</s:form>
<div id="msg_div" style="color:red"></div>
    ${jquery_js}
    ${validate_js}
    ${ipass_js}
<script type="text/javascript">
$(function(){
	$("#img_code").click(function(){
    		$(this).attr("src","${ctx}/normal/securityCodeImageAction.action?catch="+(new Date()).getTime());
    	});
    	
	$("#login_form").validate({
		rules:{
			"item.name":"required",
			"item.pwd":{
				required:true,
				minlength:3
			},"imageCode" : {
    					required : true,
    					minlength : 4,
    					maxlength: 4,
    					remote:{
							    url: "${ctx}/user/checkImageCode.action",     //后台处理程序
							    type: "post",               //数据发送方式
							    dataType: "json",           //接受数据格式   
							    data: {               //要传递的数据
							        "imageCode": function() {
							            return $("#imageCode").val();
							        }
							    }
							}
    					
    				}
    			},
		messages:{
			"item.name":"用户名不能为空",
			"item.pwd":{
				required:"密码不能为空",
				minlength:"密码长度不能小于3位"
			},"imageCode" : {
    			required : "验证码不能为空！",
    			minlength : "验证码必须是4位！",
    			maxlength:  "验证码必须是4位！",
    			remote:"验证码不正确！"	
    		}
		}
	});
	
	$("#btnlogin").click(function(){
		//var username=$("#username");
		//var password=$("#password");
		if($("#login_form").valid()){
			var url="${ctx}/user/login.action";
			$.post(
				url,
				{
					"item.name":$("#name").val(),
					"item.pwd":$("#pwd").val(),
					"imageCode":$("#imageCode").val()
				},
				function(data){
					if(data.retcode=="0"){
						window.location.href="home.jsp";
					}else{
						$("#msg_div").html(data.retmsg);
					}
				}
			);
		}
	});
	
});

$(document).ready(function(){
	$("#pwd").iPass();
});
</script>
  </body>
</html>
