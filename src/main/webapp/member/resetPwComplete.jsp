<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resetPwComplete.jsp</title>
<style type="text/css">
body{font-size:90%;}
table{width: 300px; border-collapse: collapse; font-size: 80%; line-height: 100%; padding: 5px;}
table td,th{border: #f2efeb solid 1px; padding: 5px;}
table th{width:100px; background:#faf1d0; }
input{border:#BEBBB9 solid 1px;}
.findIdFormbutton{width:300px; height:30px; position:relative; margin:0 auto;}
.dup_brown_long{width:120px; height:22px; background:#9f876b; color:white; font-size:90%; border:0;}</style>
<script type="text/javascript">
function move_login(){
	opener.location.href='hotel.do?command=loginForm';
	self.close();
}
</script>

</head>
<body>


<center><h3>비밀번호 재설정 완료</h3></center>

<form method="post" name="frm" action="hotel.do">
<input type="hidden" name="command" value="findPwStep2">
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="white">
		<th>비밀번호 재설정이 완료되었습니다</th>
	</tr>
	
</table>
<div align="center" class="findIdFormbutton">
	<br>
	<center><input type="button" value="로그인 페이지로" class="dup_brown_long" onclick="move_login();" align="center"></center>
	<br>
	<center>${msg}</center>
</div>

</body>
</html>