<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored ="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>后台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${ path}/css/zui.min.css">
	<script src="${ path}/lib/jquery/jquery.js"></script>
	<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
	<script src="${ path}/js/zui.min.js"></script>
  </head>
  <body>
    <%-- ${message.username} --%>
    <form action="${path }/user/login" method="post">
    	<div class="container-fixed-xs" style="padding-top:220px;">
	   		<div class="container-fixed-xs" style="padding-bottom:20px;text-align:center">
	   			<h1>后台管理系统</h1>
	   		</div>
	   		<div class="container-fixed-xs" style="padding-top:0px;">
	   			<input class="form-control form-focus" autofocus type="text" placeholder="用户名">
	   		</div>
	   		<div class="container-fixed-xs" style="padding-top:30px;">
	   			<input class="form-control form-focus" autofocus type="text" placeholder="密码">
	   		</div>
	   		<div class="container-fixed-xs" style="padding-top:30px;">
	   			<button class="btn btn-block btn-primary" type="submit">登录</button>
	   		</div>
	   	</div>
    </form>
  </body>
</html>
