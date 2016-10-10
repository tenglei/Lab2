<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>搜索结果</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link type="image/x-icon" href="assets/ico/favicon.ico"
	rel="shortcut icon">
<link rel="stylesheet" href="assets/css/slicy.css">
<link rel="stylesheet" href="css/prettify.css">
<link rel="stylesheet" href="css/docs.css">
</head>
<body style="background-image: url(images/result.jpg)">
	<script src="assets/js/jquery-1.7.1.min.js"></script>
	<script src="assets/js/slicy.js"></script>
	<script src="js/prettify.js"></script>
	<script src="js/docs.js"></script>
	<s:iterator value="Books" var="singlelist" status="index">
		<p>
			<s:url var="url" value="Show">
				<s:param name="ISBN" value="%{#singlelist.ISBN}"></s:param>
			</s:url>
			<s:a href="%{url}">
				<s:property value="#singlelist.BookName" />
				<s:property value="  " />
				ISBN:
				<s:property value="#singlelist.ISBN" />
			</s:a>
		</p>
	</s:iterator>
		<a href="#dialog" class="btn" rel="dialog" >编辑</a>	
		<a href="#delete" class="btn" rel="dialog"> 删除 </a>
		<a href="#add" class="btn" rel="dialog">添加</a>
<form action="Edit" method=POST id="editform">	
			<div class="dialog" id="dialog">
				<div class="dialog-head">
					编辑作品
					<del>×</del>
				</div>
				<div class="dialog-body">
				    <p>
						ISBN：<input type="text" name="ISBN" id="editISBN" >
					</p>
					<p>
						作者： <input name="Author" type="text">
					</p>
					<p>
						价格: <input name="Price" type="text">
					</p>
					<p>
						出版社: <input name="Publisher" type="text">
					</p>
					<p>
						出版日期: <input name="PublishDate" type="text">
					</p>

				</div>
				<div class="dialog-foot">
					<input name="" type="submit" value="确定" class="btn blue" onclick="window.reload();"> <input
						name="" type="submit" value="取消" class="btn" >
				</div>
			</div>
			</form>
		
	

<form action="Delete" method="POST">
	<div class="dialog" id="delete">
		<div class="dialog-head">
			请输入删除的图书编号
			<del>×</del>
		</div>
		<div class="dialog-body"></div>
		<p>
				图书ISBN： <input name="ISBN" type="text"> 
			</p>
		<div class="dialog-foot">
			<input name="" type="submit" value="确定" class="btn blue">
			<input name="" type="submit" value="取消" class="btn">
		</div>
	</div>
</form>


 <form action="Add" method="POST">
	<div class="dialog" id="add">
		<div class="dialog-head">
			添加作品
			<del>×</del>
		</div>
		<div class="dialog-body">
			<p>
				作者： <input name="Author" type="text"> 作品： <input
					name="Title" type="text">
			</p>
			<p>
				价格: <input name="Price" type="text"> 出版社: <input
					name="Publisher" type="text">
			</p>
			<p>
				作者国籍： <input name="Country" type="text"> 作者年龄： <input
					name="Age" type="text">
			</p>

			<p>
				出版日期: <input name="PublishDate" type="text">
			</p>


		</div>
		<div class="dialog-foot">
			<input name="" type="submit" value="确定" class="btn blue">
			<input name="" type="submit" value="取消" class="btn">
		</div>
	</div>
</form>
</body>
</html>