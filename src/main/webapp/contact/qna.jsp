<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>

<article>
<div id="sbox">
<div id="sum">문의하기</div>
<br><br>
<form action="#" method="post" name="frm"></form>
	<input type="hidden" name="command" value="qnaWrite">
	<div id="qnawrite">
		<div class="qnabox" id="qnabox1">
			<div class="qnasub" id="qnasub1">제목</div>
				<div class="qnacon" id="qnacon1"><input type="text" name="subject" size="60"></div></div>
		<div class="qnabox" class="qnabox2">
			<div class="qnasub" id="qnasub2">내용</div>
				<div class="qnacon" id="qnacon2"><textarea rows="8" cols="97" name="content"></textarea></div></div>
</div>
<br><br><br>

	
<div id="buttons" style="">
	<input type="submit" value="등록" class="btn" id="submit">
	<input type="reset" value="취소" class="btn" id="cancel">
	
</div>
</div>
</article>

<%@ include file="../footer.jsp" %>