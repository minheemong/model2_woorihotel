<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{font-size:90%;}
table{width: 300px; border-collapse: collapse; font-size: 80%; line-height: 100%; padding: 5px;}
table td,th{border: #f2efeb solid 1px; padding: 5px;}
table th{width:100px; background:#faf1d0; }
input{border:#BEBBB9 solid 1px;}
.findIdFormbutton{width:300px; height:30px; position:relative; margin:0 auto;}
.dup_brown{width:100px; height:22px; background:#9f876b; color:white; font-size:90%;}
.dup_darkbrown{width:100px; height:22px; background:#3a3125; color:white; font-size:90%;}
</style>
<script type="text/javascript">
function move_login(){
	opener.location.href='hotel.do?command=loginForm';
	self.close();
}
</script>
</head>
<body>
<center><h3>ID 찾기</h3></center>
<table align="center" bgcolor="black" cellspacing="1" width="400">

<tr align="center" bgcolor="white">
		<th>성명</th><td>${member.name}</td>
	</tr>
	<tr align="center" bgcolor="white">
		<th>전화번호</th><td>${member.phone}</td>
	</tr>
</table>
<div align="center" class="findIdFormbutton">
	<br>
	<center>조회한 회원의 아이디는 ${member.id}입니다</center>
	<br>
	<input type="button" value="로그인 창으로" class="dup_brown" onclick="move_login();">
	<input type="button" value="비밀번호 찾기" class="dup_darkbrown" onclick="location.href='hotel.do?command=findPwForm&id=${member.id}'">
	<br>
	<center>${msg}</center>
</div>


</form>
</body>
</html>