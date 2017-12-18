<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
  <meta charset="utf-8">
    <title>登录</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#btn").click(function(){
    		var url="${pageContext.request.contextPath }/user/login.action";
    	$.post(
				url,
				{
					"username":$("#username").val(),
					"password":$("#password").val()
				},
				function(data){
					//alert(data);
					
					if(data==0){
						//alert(data.retcode);
						window.location.href="${pageContext.request.contextPath}/user/tuSuccess.action";
					}else{
						//alert(data.retmsg);
						$("#msg_div").html(data.retmsg);
					}
					
				}
			);
    	});
    });
    </script>
  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/user/login.action" method="post">  
        <table border="1">  
            <tr>
                <td>用户名</td>  
                <td><input type="text" name="username" id="username"></td>  
            </tr>  
            <tr>  
                <td>密码</td>
                <td><input type="password" name="password" id="password"></td>  
            </tr>  
            <tr>  
                <td><input type="button" id="btn" value="登录"></td>  
            </tr>  
        </table>  
    </form>
    <div id="msg_div"></div>
  </body>
</html>
