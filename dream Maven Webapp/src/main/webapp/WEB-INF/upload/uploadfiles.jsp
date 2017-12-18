<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--上传文件</title>

  </head>
  
  <body>
${validate_css}
<s:form action="doUploadFiles" namespace="/file" method="post" enctype="multipart/form-data" id="edit_form">
	<s:file name="file" id="file" label="上传文件"></s:file>
	<input type="button" value="保存" id="btnsave"/>
	<input type="button" value="返回" id="btnback"/>
</s:form>
	${jquery_js}
	${jquery_form_js}
	${validate_js}
    <script type="text/javascript">
$(function(){
	$("#edit_form").validate({
		rules:{
			"file":{
				required:true
			}
	},
	messages:{
			"file":{
				required:"需要上传文件！"
			}
		}
	});
	
	$("#btnsave").click(function(){
	
		if($("#edit_form").valid()){
		
				var url = "${ctx}/file/doUploadFiles.action";
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
			if(!confirm("是否继续上传？")){
				window.location.href="${ctx}/file/findFiles.action";
			}else{
				window.location.reload();
			}
	}
}
</script>
  </body>
</html>
