<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findIdconfirmNumber.jsp</title>
<style type="text/css">
body{font-size:90%;}
table{width: 300px; border-collapse: collapse; font-size: 80%; line-height: 100%; padding: 5px;}
table td,th{border: #f2efeb solid 1px; padding: 5px;}
table th{width:100px; background:#faf1d0; }
input{border:#BEBBB9 solid 1px;}
.findIdFormbutton{width:300px; height:30px; position:relative; margin:0 auto;}
.dup_brown{width:100px; height:22px; background:#9f876b; color:white; font-size:90%;}</style>
</head>
<body>


<center><h3>ID 찾기</h3></center>

<form method="post" name="frm" action="hotel.do">
<input type="hidden" name="command" value="findIdStep2">
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="white">
		<th>성명</th><td>${member.name}<input type="hidden" name="name" value="${member.name}"></td>
	</tr>
	<tr align="center" bgcolor="white">
		<th>전화번호</th><td>${member.phone}
			<input type="hidden" name="phone" value="${member.phone}">
			<input type="hidden" name="id" value="${member.id}"></td>
	</tr>
	<tr align="center" bgcolor="white">
		<th>인증번호</th><td><input type="text" name="confirmNum">전송받은 번호를 입력하세요</td>
	</tr>
</table>
<div align="center" class="findIdFormbutton">
	<br>
	<center><input type="submit" value="인증번호 확인" class="dup_brown" align="center"></center>
	<br>
	<center>${msg}</center>
</div>


</form>
</body>
</html>