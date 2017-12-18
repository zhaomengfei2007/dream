<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${siteName}--测试</title>
	<style type="text/css">
		br{
			display: none;
		}
	</style>
  </head>
  
  <body>
	<s:form name="getcity">
		<%-- <s:doubleselect name="province.id" list="provinceList" listKey="id" listValue="name" 
	                doubleName="city.id" doubleList="provinceMap[top.id]" doubleListKey="id" doubleListValue="name"></s:doubleselect> --%>
		<s:select name="province.id" list="provinceList" listKey="id" listValue="name" onchange="getCityList(this.value)" id="province"></s:select>
		<s:select name="city.id" list="cityList" listKey="id" listValue="name" onchange="getDistrictList(this.value)" id="city"></s:select>
		<s:select name="district.id" list="districtList" listKey="id" listValue="name"></s:select>
	</s:form>
${jquery_js}
<script type="text/javascript">
//$(function(){
	function getCityList(id){
		$.post(
			"${ctx}/region/getCityListByProvince.action",
			{"province.id":id},
			function(data){
				if(data.retcode=="0"){
					$("#city").attr("list",data.cityList);
				}else{
					alert(data.retmsg);
				}
				
			}
		);
	}
	
	function getDistrictList(id){
		$.post(
			"${ctx}/region/getCityListByProvince.action",
			{"city.id":id},
			function(data){
				if(data.retcode=="0"){
					$("#district").attr("list",data.cityList);
				}else{
					alert(data.retmsg);
				}
				
			}
		);
	}
//});
</script>
  </body>
</html>
