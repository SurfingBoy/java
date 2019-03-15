<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<!-- 只需表单域名称和Action处理类的属性名称一致，并且提供属性的set方法，那么在Action处理类中即可获得表单数据。这种获取数据的方式称为属性驱动 -->
<form action="login.action" method="post">
用户名：<input type="text" name="username"/><br>
密码：<input type="password" name="password"/><br>
<input type="submit" value="登录"/>
</form>
</body>
</html>