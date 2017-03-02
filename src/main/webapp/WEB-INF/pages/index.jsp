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
    <title>My JSP 'index.jsp' starting page</title>
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
   	<div class="container-fluid">
   		
   	<div id="top" style="width: 100%;height:50px;float: left;border-bottom:1px solid #ccc">
        
    </div>
    <div id="left" style="width: 10%;height:100%;float: left;border-right:1px solid #ccc">
        
    </div>
    <div id="right" style="width: 90%;height: auto;float: right">
        
    </div>
   	
   	<!-- <div class="pull-left" style="width: 10%">
   	<nav class="menu" data-toggle="menu" style="width: 100%">
  <button class="btn btn-primary"><i class="icon-edit"></i> CREATE</button>
  <button class="btn"><i class="icon-cloud-upload"></i> UPLOAD</button>
  <ul class="nav nav-primary">
    <li><a href="javascript:;"><i class="icon-th"></i> Dashboard</a></li>
    <li><a href="javascript:;"><i class="icon-user"></i> Me</a></li>
    <li class="nav-parent">
      <a href="javascript:;"><i class="icon-time"></i> Time</a>
      <ul class="nav">
        <li><a href="javascript:;">Today</a></li>
        <li><a href="javascript:;">Tomarrow</a></li>
        <li><a href="javascript:;">Yestorday</a></li>
        <li><a href="javascript:;">This Week</a></li>
      </ul>
    </li>
    <li><a href="javascript:;"><i class="icon-trash"></i> Trash</a></li>
    <li><a href="javascript:;"><i class="icon-list-ul"></i> All</a></li>
    <li class="active show nav-parent">
      <a href="javascript:;"><i class="icon-tasks"></i> Status</a>
      <ul class="nav">
        <li><a href="javascript:;"><i class="icon-circle-blank"></i> Ready</a></li>
        <li class="active"><a href="javascript:;"><i class="icon-play-sign"></i> Ongoing</a></li>
        <li><a href="javascript:;"><i class="icon-ok-sign"></i> Completed</a></li>
      </ul>
    </li>
  </ul>
</nav>
   	</div>
   	
   	<div class="pull-right"  style="width:89.5%">
   	<div style="background: red;width: 100%;height: 30px;">
   		asdad
   	</div>
   	</div> -->
  		

	</div>
  </body>
</html>
