<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
//相当于: window.onload=function(){}   $(document).ready(function(){});
$(function(){
	$("form").submit(function(){
		if($(":text[name='name']").val()==""||$(":text:eq(1)").val()==""||$(":text:eq(2)").val()==""){
			alert("请填写完整信息");
			return false
		}
	});
});
</script>
</head>
<body>
<form action="insert" method="post">
	<table border="1">
		<tr>
			<td colspan="2" style="text-align:center;font-size:30px;font-weight:bold">花卉信息</td>
		</tr>
		<tr>
			<td>名称：</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>价格：</td>
			<td><input type="text" name="price"/></td>
		</tr>
		<tr>
			<td>简介：</td>
			<td><input type="text" name="desc"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="提交"/><input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>