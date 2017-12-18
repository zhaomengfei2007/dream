<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${siteName}测试</title>
${jquery_js}
${echarts_js}
<script type="text/javascript">
$(function(){
	var url = "${ctx}/balance/findBalances.action";
			$.post(
				url,
				{},
				function(data){
		var myChart = echarts.init(document.getElementById("main")); 
        var option = {
    tooltip: {
        trigger: "axis",
        axisPointer: {
            type: "cross",
            crossStyle: {
                color: "#999"
            }
        }
    },
    toolbox: {
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ["line", "bar"]},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    legend: {
        data:["收入","支出"]
    },
    xAxis: [
        {
            type: "category",
            data: data.createDates,
            axisPointer: {
                type: "shadow"
            }
        }
    ],
    yAxis: [
        {
            type: "value",
            name: "金额",
            min: 0,
            max: 10000,
            interval: 500,
            axisLabel: {
                formatter: "{value} ml"
            }
        }
    ],
    series: [
    	{
    	name:"收入",
    	type:"bar",
    	data:data.incomes
    	},
    	{
    	name:"支出",
    	type:"bar",
    	data:data.consumptions
    	}
    ]
};

        // 为echarts对象加载数据 
        myChart.setOption(option); 
				}
			);
});
</script>
  </head>
  
  <body>
<div id="main" style="height:400px"></div>
  </body>
</html>
