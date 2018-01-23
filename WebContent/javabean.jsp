<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/user/registerUser.do" method="post">
  <!-- 这里的属性要个javabean中的一样 -->
   编号：<input type="text" name="id"><br>
    姓名：<input type="text" name="names"><br>
   年龄：<input type="text" name="age"><br>
  <input type="submit" value="提交">||
  <input type="reset" value="重置">
  
  </form>
    
  </body>
</html>
