<%@page import="java.util.List"%>
<%@page import="Mypackage.JavaDateImplement"%>
<%@page import="Mypackage.JavaDataDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="mycss.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Author</title>
</head>
作者


<!-- Table goes in the document BODY -->
<table class="hovertable">
	<tr>
		<th>书名</th>
		<th>出版社</th>
		<th>出版时间</th>
	</tr>
	<%
		JavaDataDao JDD = new JavaDataDao();
		List<JavaDateImplement> JDI = JDD.readFirstTitle();
		for (JavaDateImplement J : JDI) {
			
			
			
			
			
		}
	%>

</table>

<body>

</body>
</html>