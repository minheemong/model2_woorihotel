<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<link href="../css/css.css" rel="stylesheet">
<script src="../script/script.js"></script>


<!-- cont테마 css -->
<article>
<div class="contTitle">회원가입</div>
<div class="contThreeStep">
	<div class="contNonselect">약관동의</div>
	<div class="contNonselect">회원정보 입력</div>
	<div class="contSelect">가입완료</div>
</div>

<form method="post" name="joinComFrm" action="../hotel.do">
<input type="hidden" name="command" value="joinCom">

	<div class="joinComView">
	 	<c:choose> 
	 		<c:when  test="${empty joinName}">  
	 			정상적으로 가입되지 못하였습니다.
	 			다시 회원가입해주세요.
	 			<br><br>
	 			<center><input type="button" value="로그인 페이지로" class="dup_brown_long" onclick="move_login();" align="center"></center>
	 		</c:when>
	 		 <c:otherwise>
	 		 	<div class="joinComText">
					감사합니다.<br>
					${joinName.name} 님께서는 우리호텔에 정상적으로 가입되셨습니다.
				</div>
				<div id="joinComButton"><input type="submit" value="로그인" class="joinButton"></div>
			</c:otherwise>
		</c:choose>
	</div>

</form>

</article>
<%@ include file="../footer.jsp" %>