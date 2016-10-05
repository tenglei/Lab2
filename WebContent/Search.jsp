<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DynamicBookSystem</title>
<script src="Search.js" type="text/javascript"></script>
</head>
<body>
	<!-- 
<div id="Layer1" style="position:absolute; width:100%; height:100%; ">    
<img src="images/background.jpg" height="100%" width="100%"/>    
</div> 
 -->
	<div align="center" style="margin-top: 48px;">
		<img src="images/dog.jpg" width="100" height="150" />
	</div>
	<div align="center">DynamicBookSystem</div>
	<div align="center" style="margin-top: 60px;">
		<form name="Request">
			<input type="text" placeholder="请输入作者姓名" name="author" /> <input
				type="button" value="搜索" onclick="window.location.href='Result.jsp'" />
		</form>
	</div>


</body>
</html>