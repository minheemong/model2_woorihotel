<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<script>

function loginCheck(){
	
	if(document.loginFrm.id.value == ""){
		alert("아이디를 입력하세요");
		document.loginFrm.id.focus();
		return false;
	}
	if(document.loginFrm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		document.loginFrm.pwd.focus();
		return false;
	}
	return true;
}

</script>
<article>
<div class="logtitle">로그인</div>

<form method="post" action="hotel.do" name="loginFrm">
	<input type="hidden" name="command" value="login">
	
<div class="logview">
	<div class="logbox1">
		<div class="loginput">
			<input name="id" type="text" class="logidPwd" placeholder="아이디 입력">
			<input name="pwd" type="password" class="logidPwd"  placeholder="비밀번호 입력">
		</div>
			<input type="submit" value="로그인" class="login" onclick="return loginCheck()"> <!-- 문제1. 버튼이 안눌림, 커서모양 안바뀜 -->
	</div>	
	<div class="logbox2">
			<input type="button" value="회원가입" class="logbutton"	
				onclick="location.href='hotel.do?command=contract'">
			<input type="button" value="아이디 비밀번호 찾기" class="logbutton" onclick="find_id()">	
			<div>&nbsp;&nbsp;&nbsp;${message}</div>
	</div>
</div>
</form>
</article>







<%@ include file="../footer.jsp" %>