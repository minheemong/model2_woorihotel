<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="script/script.js"></script>
<style type="text/css">
body{font-family:Verdana; font-size:90%; text-align:center;}
input{border:#BEBBB9 solid 1px;}
.dup_brown{width:100px; height:22px; background:#9f876b; color:white; font-size:90%;}
.joinButton{width:70px; height:40px; position:relative; margin:0 auto;  background:#3a3125; color:white; border:0;}

</style>
</head>
<body>
<div id="wrap" style="margin:20px 0">
<h3>ID 중복확인</h3>
	<form method="post" name="idCheckFrm" action="hotel.do">
		<input type="hidden" name="command" value="idCheckForm">
		User ID&nbsp;&nbsp;&nbsp;<input type="text" name="id" value="${id}">
		<input type="submit" value="검색" class="dup_brown"><br>
		
		<div style="margin-top:20px">
			<c:if test="${result==1}">
				<script type="text/javascript">opener.document.joinFrm.id.value="";</script>
				${id} 은(는) 이미 사용중인 아이디입니다.
			</c:if>
			<c:if test="${result==-1}">
				${id} 은(는) 사용가능한 아이디입니다.
				<input type="button" value="사용" class="joinButton" onclick="idok('${id}');">
			</c:if>
	</form>
</div>
</body>
</html>