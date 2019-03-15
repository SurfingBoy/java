<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	var pagesize="${pageInfo.pagesize}";
	var pagenum="${pageInfo.pagenum}";
	var name="${pageInfo.name}";
	var price="${pageInfo.price}";
	var pagetotal="${pageInfo.pagetotal}";
	
	$.each($(":radio"),function(i,n){
		if($(n).val()==pagesize){
			$(n).attr("checked","checked");
		}
	});
	
	//对输入框设置值
	$(":text[name='name']").val(name);
	$(":text[name='price']").val(price);
	
	$(":radio").click(function(){
		pagesize=$(this).val();
		location.href="page?pagesize="+pagesize+"&pagenum=1&name="+$(":text[name='name']").val()+"&price="+$(":text[name='price']").val();
	});
	
	$("button").click(function(){
		location.href="page?pagesize="+pagesize+"&pagenum=1&name="+$(":text[name='name']").val()+"&price="+$(":text[name='price']").val();
	});
	
	//点击上一页
	$(".page_a:eq(0)").click(function(){
		pagenum=parseInt(pagenum)-1;
		if(pageNumber>=1){
			location.href="page?pagesize="+pagesize+"&pagenum="+pagenum+"&name="+$(":text[name='name']").val()+"&price="+$(":text[name='price']").val();
		}else{
			pageNumber = 1;
		}
		return false;
	});
	//点击上一页
	$(".page_a:eq(1)").click(function(){
		pagenum=parseInt(pagenum)+1;
		if(pagenum<=pagetotal){
			location.href="page?pagesize="+pagesize+"&pagenum="+pagenum+"&name="+$(":text[name='name']").val()+"&price="+$(":text[name='price']").val();
		}else{
			pagenum = pagetotal;
		}
		return false;
	});
});
</script>
</head>
<body>
每页数量
<input type="radio" value="2" name="pagesize"/>2
<input type="radio" value="3" name="pagesize"/>3
<input type="radio" value="4" name="pagesize"/>4<br/>
名称：<input type="text" name="name"/> 价格大于：<input type="text" name="price"/><button>查询</button>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
			<th>描述</th>
		</tr>
		<c:forEach items="${pageInfo.infoList }" var="flower">
			<tr>
				<td>${flower.id }</td>
				<td>${flower.name }</td>
				<td>${flower.price }</td>
				<td>${flower.desc }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="" class="page_a">上一页</a><a href="" class="page_a">下一页</a>
	<%-- <a href="page?pagenum=${pageInfo.pagenum-1 }&pagesize=${pageInfo.pagesize}" <c:if test="${pageInfo.pagenum<=1 }"> onclick="javascript:return false;"</c:if>>上一页</a>
	<a href="page?pagenum=${pageInfo.pagenum+1 }&pagesize=${pageInfo.pagesize}" <c:if test="${pageInfo.pagenum>=pageInfo.pagetotal }"> onclick="javascript:return false;"</c:if>>下一页</a> --%> 
</body>
</html>