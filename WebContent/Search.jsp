<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="assets/css/slicy.css" rel="stylesheet" type="text/css" />
<html>
<head>
<title>DynamicBookSystem</title>
<script src="Search.jsp" type="text/javascript"></script>
</head>
<body style="background-image: url(images/bg.jpg)">

	<div align="center" style="margin-top: 48px;">
		<a href="#"><img src="images/dog.jpg" class="img-scale"
			width="150" height="225" /></a>
	</div>
	<p class="txt-green" align="center">DynamicBookSystem</p>
	<div align="center" style="margin-top: 60px;">
		<form action="Result" method="POST" >
			<input type="text" placeholder="请输入作者姓名" name="Author" /> <a
				href="Error.html" class="btn bg-green bg-inverse">搜索</a>
		</form>
	</div>


</body>
</html>