<%@page import="java.util.List"%>
<%@page import="Mypackage.JavaDateImplement"%>
<%@page import="Mypackage.JavaDataDao"%>
<%@page import="Mypackage.BookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/mycss.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Author</title>
</head>



<!-- Table goes in the document BODY -->
<table class="hovertable">
	
		
		
	
	<%
		JavaDataDao JDD = new JavaDataDao();
		request.setCharacterEncoding("utf-8");
		String author = request.getParameter("author");
		List<JavaDateImplement> JDI = JDD.search(author);
		for (JavaDateImplement J : JDI) {
			
	%>
		<tr>
		<th>作者</th>
		<th>国家</th>
		<th>年龄</th>
		<th>书名</th>
		<th>价格</th>
		<th>出版日期</th>
		<th>出版社</th>
	</tr>
	
	<tr>
		<td><%=J.getAuthor()%></td>
		<td><%=J.getCountry()%></td>
		<td><%=J.getAge()%></td>
		<%
		for(BookList book:J.getBooks()){%>
			<td><%=book.getBookName()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getPublishDate()%></td>
			<td><%=book.getPublisher()%></td>
			
		<%}
		
		
		%>  
	
	</tr>
	<%
		}
	%>

</table>

<body>

</body>
</html>