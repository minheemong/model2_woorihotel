<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function resetPw(){
	if(document.frm.pwd.value==""){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value!=document.frm.pwd_chk.value){
		alert("비밀번호 확인이 일치하지 않습니다");
		document.frm.pwd_chk.focus();
		return false;
	}return true;
}
</script>
<style type="text/css">
body{font-size:90%;}
table{width: 300px; border-collapse: collapse; font-size: 80%; line-height: 100%; padding: 5px;}
table td,th{border: #f2efeb solid 1px; padding: 5px;}
table th{width:100px; background:#faf1d0; }
input{border:#BEBBB9 solid 1px;}
.findIdFormbutton{width:300px; height:30px; position:relative; margin:0 auto;}
.dup_brown{width:120px; height:22px; background:#9f876b; color:white; font-size:90%;}</style>
</head>
<body>

<center><h3>비밀번호 재설정</h3></center>
<form method="post" name="frm" action="hotel.do">
<input type="hidden" name="id" value="${member.id}">
<input type="hidden" name="command" value="resetPw">

<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="white">
		<th>비밀번호</th><td><input type="password" name="pwd"></td>
	</tr>
	<tr align="center" bgcolor="white">
		<th>비밀번호 확인</th><td><input type="password" name="pwd_chk"></td>
	</tr>
</table>
<div align="center" class="findIdFormbutton">
	<br>
	<center><input type="submit" value="비밀번호 재설정" class="dup_brown" onClick="return resetPw();"></center>
	<br>
	<center>${msg}</center>
</div>

</form>
</body>
</html>