<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>

<script src="mypage/mapage.js"></script>
<style type="text/css">
input{border:#BEBBB9 solid 1px;}
p{line-height:200%;}
</style>
<article>

<form method="post" action="hotel.do" name="quitOk">
	<input type="hidden" name="command" value="quit">
	
<div id="abox_aa">
	<div id="sum_aa">탈회 요청</div>
	<br>
	<span id="chklisttxt_aa">탈회 신청하시기 전에 아래의 유의 사항을 한 번 더 확인해 주시기 바랍니다</span>
	<br><br>
	<div id="chklistbox_aa">
	<br><br>
		<div id="quitText"><br><br>
		<p>- 탈회를 신청하시면 번복이 불가능하며 보유하신 모든 포인트는 소멸됩니다.</p>
			<p>- 개인정보보호법에 따라 고객님의 호텔 이용기록, 개인정보 및 문의내역 기록도 모두 삭제됩니다</p>
			<p>- 탈회 신청이 완료되면 즉시 홈페이지 로그인이 제한됩니다.</p>
			</div>
		<div id="profButton">
			<input type="submit" value="신청" class="okButton" onclick="quit()">
		</div>
	</div>
</div>
</form>
</article>




<%@ include file="../footer.jsp" %>