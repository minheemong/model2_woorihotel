<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findIdPw.jsp</title>
<style type="text/css">
body{font-size:90%;}
.joinButton{width:70px; height:40px; position:relative; margin:0 auto;  background:#3a3125; color:white; border:0;}

</style>
</head>
<body>
<center><h3>아이디 찾기 / 비밀번호 찾기</h3></center>
<table align="center" bgcolor="white" cellspacing="20" width="350">
	<tr align="center" bgcolor="#faf1d0" height="150">
		<td width="230"><h3>아이디 찾기</h3>
			<input type="button" class="joinButton" value="이동"
				onclick="location.href='hotel.do?command=findIdForm'">
		</td>
		<td width="230"><h3>비밀번호 찾기</h3>
			<input type="button" class="joinButton" value="이동"
				onclick="location.href='hotel.do?command=findPwForm'">
		</td>
	</tr>
</table>
</body>
</html>