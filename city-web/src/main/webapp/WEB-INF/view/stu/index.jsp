<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</head>
<body>
	<input type="button" value="添加" onclick="add()">
	<table  class="table">
		<tr>
			<th>编号</th>
			<th>省</th>
			<th>市</th>
			<th>县</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${info.list}" var="s">
		<tr>
			<td>${s.headerImg}</td>
			<td>${s.sheng.cityname}</td>
			<td>${s.shi.cityname}</td>
			<td>${s.xian.cityname}</td>
			<td>
				<input type="button" value="修改" onclick="update(${s.id})">
			</td>
		</tr>	
		</c:forEach>
		<tr align="center">
			<td colspan="4">
				<a href="index?pageNum=1">首页</a>
				<a href="index?pageNum=${info.prePage}">上一页</a>
				<a href="index?pageNum=${info.nextPage}">下一页</a>
				<a href="index?pageNum=${info.pages}">尾页</a>
			</td>
	</tr>
	</table>
<script type="text/javascript">
	function add(){
		location="toAdd"
	}
	
	function update(id){
		location="toupdate?id="+id
	}
</script>
</body>
</html>