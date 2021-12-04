<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>

<script src="mypage/mypage.js"></script>
<style type="text/css">
input{border:#BEBBB9 solid 1px;}
</style>
<article>

<form method="post" action="hotel.do" name="profilePw">
	<input type="hidden" name="command" value="profileForm">
	
<div id="abox_aa">
	<div id="sum_aa">프로필 수정</div>
	<br>
	<span id="chklisttxt_aa">${loginUser.name}님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인합니다.</span>
	<br><br>
	<div id="chklistbox_aa">
	<Br><br>
		<table class="pwBox">
			<tr><th>비밀번호</th>
				<td><input name="pwd" type="password"></td></tr>
		</table>
		
		<div id="profText">&nbsp;&nbsp;&nbsp;${message}</div>
		
		<div id="profButton">
			<input type="button" value="비밀번호 찾기" class="findPwButton" onclick="findPw()">
			<input type="submit" value="확인" class="okButton">
		</div>
	</div>
</div>
</form>
</article>




<%@ include file="../footer.jsp" %>