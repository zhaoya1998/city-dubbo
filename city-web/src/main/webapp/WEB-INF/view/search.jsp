<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<button  onclick="location.href='toAdd'">添加</button>
		<form action="/search"> <input type="text" name="key"> <button type="submit">搜索</button></form>
		
	</div>
	<div>
		<table>
			<tr>
				<th>id</th>
				<th>title</th>
				<th>content</th>
				<th>createtime</th>
				<th>exector</th>
				<th>publiher</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageInfo.content}" var="task" >
			<tr>
				<td>${task.id}</td>
				<td>${task.title}</td>
				<td>${task.content}</td>
				<td>${task.createTime}</td>
				<td>${task.executor}</td>
				<td>${task.publisher}</td>
				<td></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>