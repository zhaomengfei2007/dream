<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}--用户信息</title>
        <style type="text/css">
    	.myImg{
    		width:100%;
    		height:50%;
    	}
    	body,table,td{
			margin:0;
			padding:0;
			font-size:12px;
			text-align:center;
		}
		.data_table{
			height:400px;
			border-collapse: collapse;
			margin:0px 0px 20px 0px;
		}
		.head_tr{
			width:200px;
		}
    </style>
  </head>
  
  <body>
<table class="data_table" border="1">
	<tr>
		<td class="head_tr">用户名</td>
		<td><s:property value="item.name"/></td>
		<td rowspan="6">
				<img alt="不存在该图" src="${ctx}/UploadFile/<s:property value="files.path"/>" class="myImg">
		</td>
	</tr>
	<tr>
		<td>性别</td>
		<td><s:if test="item.gender == 1">
   					<span style="color:red">男</span>
   			</s:if>
   			<s:if test="item.gender == 2">
   				<span style="color:green">女</span>
   			</s:if>
   		</td>
	</tr>
	<tr>
		<td>角色</td>
		<td><s:property value="item.role.name"/>
   		</td>
	</tr>
	<tr>
		<td>区号</td>
		<td><s:property value="item.district.name"/>
   		</td>
	</tr>
	<tr>
		<td>创建时间</td>
		<td><s:date name="item.create" format="yyyy-MM-dd"/></td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td><s:date name="item.update" format="yyyy-MM-dd"/></td>
	</tr>
</table>
<input type="button" value="返回" id="btnback"/>
    ${jquery_js}
    <script type="text/javascript">
    $(function(){
        $("#btnback").click(function(){
			window.history.go(-1);
		});
    });

    </script>
  </body>
</html>
