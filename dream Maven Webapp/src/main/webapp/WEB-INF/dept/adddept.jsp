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
	<s:form action="doAddDept" namespace="/dept" id="add_form">
		<%-- <s:hidden name="item.id" id="id"></s:hidden> --%>
		<table class="data_table" border="1">
			<tr class="head_tr">
				<td>属性</td>
				<td>变更内容</td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td><s:textarea name="dept.name"></s:textarea></td>
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
	$("#add_form").validate({
		rules:{
			"dept.name":{
				required:true,
				remote :{
					url: "${ctx}/dept/checkDeptExists.action",     //后台处理程序
					type: "post",               //数据发送方式
					dataType: "json",           //接受数据格式   
					data: {                     //要传递的数据
						"dept.name": function() {
							return $("#name").val();
						}
					}
				},
				rangelength:[3,10]
			},
			"dept.desc":{
				required:true,
				rangelength:[3,200]
			}
	},
	messages:{
			"dept.name":{
				required:"需要输入部门名称",
				remote:"部门名称已经存在或输入不正确",
				rangelength:"长度请介于3~10"
			},
			"dept.desc":{
				required:"需要输入说明",
				rangelength:"长度请介于3~200"
			}
		}
	});
	
	$("#btnsave").click(function(){
	
		if($("#add_form").valid()){
		
				var url= "${ctx}/dept/doAddDept.action";
				
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
			window.location.href="${ctx}/dept/findDepts.action";
	}
}
</script>
  </body>
</html>
