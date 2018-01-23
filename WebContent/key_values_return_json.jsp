<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
<title>注册页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src=js/jquery-1.8.2.js></script>
	<script type="text/javascript">
	$(function() {
		var $button = $('button');

		$button.click(function() {
			var content = $('form').serialize();   //返回的是key-value字符串
			console.log(content);
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath }/user/json01.do',
				data : content,
				dataType:"json",     //设置返回类型为json对象 不设置则为后台传来的json字符串
				success : function(backDate, statusText, xhr) {
					console.log(typeof backDate);
					console.log(backDate.id+"||"+backDate.name+"||"+backDate.age);
				}

			});

		});
	});
	</script>
  </head>
  
  <body>
  <form>
  <!-- 这里的name属性可以自定义，会议js中的key值出现，后台中形参的值要和key值相同 -->
   编号： <input type="text" name="id"><br>
    姓名：<input type="text" name="name"><br>
   年龄： <input type="text" name="age"><br>
 	      <button>json数据提交</button>||
          <input type="reset" value="重置">
  </form>
  </body>
</html>
