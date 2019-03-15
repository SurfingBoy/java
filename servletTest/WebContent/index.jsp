<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 指令 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style type="text/css">
 a{
   color:green;
   text-decoration:none;
 }
 a:hover{
 	color:red
 }
</style>
</head>
<body>
	<table border="1">
	<tr>
		<th>编号</th>
		<th>名称</th>
		<th>价格</th>
		<th>简介</th>
	</tr>
	<c:forEach items="${list }" var="flower">
		<tr>
			<td>${flower.id }</td>
			<td>${flower.name }</td>
			<td>${flower.price }</td>
			<td>${flower.desc }</td>
		</tr>
	</c:forEach>
	</table>
	<a href="add.jsp">添加信息</a>
</body>
</html>