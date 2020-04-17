<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post" enctype="multipart/form-data">
		<label>驾驶证号码</label>
		<input name="headerImg" value="${stu.headerImg}">
		<br/>
		<label>姓名：</label>
		<input type="text" name="id" value="${stu.id}">
		<input name="name" value="${stu.name}">
		<br/>
		<br/>
		
		<label>省：</label>
		<select name="shengId" id="shengId" onchange="showSubs('shengId','shiId')">
			<c:forEach items="${shengList}" var="sheng" >
				<option value="${sheng.id}" ${sheng.id==stu.sheng.id?"selected='selected'":""} >${sheng.cityname}</option>
			</c:forEach>
		</select>
		<br/>
		<br/>
		
		<label>市：</label>
		<select name="shiId" id="shiId" onchange="showSubs('shiId','xianId')">
			
		</select>
		<br/>
		<br/>
		
		<label>县：</label>
		<select name="xianId" id="xianId">
			
		</select>
		<br/>
		<br/>
		
		
		<button type="submit">提交</button>
		
		
	</form>
	<script type="text/javascript">
		/**
		parId 上一级比的对象的id
		subId 下一个级别对象的id
		*/
		function showSubs(parId,subId){
			
			var selId = $("#"+parId).val();//得到了改变的那个下拉框中的数据
			//发送ajax请求
			$.post('/stu/getSubs',{pid:selId},function(subList){
				$("#"+subId).empty();
				for(var i=0;i<subList.length;i++){
					if(parId=="shengId" && subList[i].id=='${stu.shi.id}'){
						$("#"+subId).append("<option value='"+subList[i].id+" selected'>"+subList[i].cityname+"</option>")
						//处理县的回显
						showSubs('shiId','xianId');
					}else if(parId=="shiId" && subList[i].id=='${stu.xian.id}'){
						$("#"+subId).append("<option value='"+subList[i].id+" 'selected>"+subList[i].cityname+"</option>")
					}else{
						$("#"+subId).append("<option value='"+subList[i].id+"'>"+subList[i].cityname+"</option>")
					}	
				}
			})
		}
		
		// 回显省
		showSubs('shengId','shiId');
		
	
	</script>

</body>
</html>