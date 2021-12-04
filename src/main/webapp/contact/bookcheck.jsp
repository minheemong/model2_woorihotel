<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
<div class="bbox">
<div id="sum">예약 확인</div>
<div id="bboxb">
	<div id="bcheck">예약 확인</div>
	<div id="bigctextbox">
		<div class="smallctextbox">
			<div class="ctextsub"> &nbsp;이름</div>
			<div class="ctexttext">${bookcheck.name}</div>
		</div>
		<div class="smallctextbox">
			<div class="ctextsub">&nbsp;예약 번호</div>
			<div class="ctexttext">${bookcheck.booknum}</div>
		</div>
		<div class="smallctextbox">
			<div class="ctextsub">&nbsp;객실</div>
			<div class="ctexttext">${bookcheck.kind}</div>
		</div>
		<div class="smallctextbox">
			<div class="ctextsub">&nbsp;인원</div>
			<div class="ctexttext">${bookcheck.usernum}</div>
		</div>
		<div class="smallctextbox">
			<div class="ctextsub">&nbsp;체크인</div>
			<div class="ctexttext"><fmt:formatDate value="${bookcheck.checkin}"/></div>
		</div>
		<div class="smallctextbox">
			<div class="ctextsub">&nbsp;체크아웃</div>
			<div class="ctexttext"><fmt:formatDate value="${bookcheck.checkout}"/></div>
		</div>
		<div class="smallctextbox">
			<div class="ctextsub">&nbsp;결제 금액</div>
			<div class="ctexttext">${bookcheck.price}</div>
		</div>
		
	</div>
</div>

<div id="buttons">
	<input type="button" value="메인으로" class="btn" id="checkmain"
		onclick="location.href='hotel.do?command=mainForm'">
</div> 
</div>
</article>
<%@ include file="../footer.jsp" %>