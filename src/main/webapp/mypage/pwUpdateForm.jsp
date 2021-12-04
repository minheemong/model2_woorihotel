<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>

<script src="mypage/mypage.js"></script>
<style type="text/css">
input{border:#BEBBB9 solid 1px;}
</style>
<article>

<form method="post" action="hotel.do" name="pwUpdateForm">
	<input type="hidden" name="command" value="pwUpdate">
	
<div id="abox_aa">
	<div id="sum_aa">비밀번호 변경</div>
	<br>
	<span id="chklisttxt_aa">고객님의 정보를 언제든지 확인, 변경하실 수 있습니다.</span>
	<br><br>
	<div id="chklistbox_aa">
	<br><br>
		<table class="pwBox">
			<tr><th>현재 비밀번호</th><td><input name="pwd" type="password"></td></tr>
			<tr><th>새 비밀번호</th><td><input name="newpwd" type="password"></td></tr>
			<tr><th>새 비밀번호 확인</th><td><input name="newpwd_re" type="password"></td></tr>
		</table>
		<br>
		<div id="profText">&nbsp;&nbsp;&nbsp;${message}</div>
		
		<div id="profButton">
			<input type="submit" value="변경" class="okButton">
			<input type="reset" value="취소" class="cancleButton">
		</div>
	</div>
</div>
</form>
</article>




<%@ include file="../footer.jsp" %>