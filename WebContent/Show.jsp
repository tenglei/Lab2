<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/css/slicy.css">
<link rel="stylesheet" href="css/prettify.css">
<link rel="stylesheet" href="css/docs.css">
	<script src="assets/js/jquery-1.7.1.min.js"></script>
	<script src="assets/js/slicy.js"></script>
	<script src="js/prettify.js"></script>
	<script src="js/docs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书展示</title>
</head>
<body style="background-image: url(images/result.jpg)">




	<table class="table table-zebra">
		<tbody>
		<tr>
		<td>图书名称</td>
		<td>出版日期</td>
		<td>出版社</td>
		<td>价格</td>
		
		</tr>
		
		
		<tr>
			<td><s:property value="Title" /></td>
			<td><s:property value="PublishDate" /></td>
			<td><s:property value="Publisher" /></td>
			<td><s:property value="Price" /></td>
			<s:url var="rurl" value="Search.jsp">
			</s:url>
			<s:a href="%{rurl}">返回</s:a>
		</tr>
		</tbody>

	
	</table>

</body>
</html>