<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/adminheader.jsp" %>


<article  class="rightarticle_aa"><%@ include file="sub_menu.jsp" %>
<form name="frm" method="post">
<div class="bbox_aa">
<div id="bboxb_aa">
	<div id="bcheck_aa">예약 확인</div>
	<div id="bigctextbox_aa">
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa"> &nbsp;아이디</div>
			<div class="ctexttext_aa">${bookcheck.id}</div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa"> &nbsp;이름</div>
			<div class="ctexttext_aa">${bookcheck.name}</div>
			<input type="hidden" id="bookdetailname" value="${bookcheck.name }">
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;예약 번호</div>
			<div class="ctexttext_aa">${bookcheck.booknum}</div>
			<input type="hidden" id="bookdetailnum" value="${bookcheck.bdseq }">
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;객실</div>
			<div class="ctexttext_aa">${bookcheck.kind}</div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;객실 번호</div>
			<div class="ctexttext_aa">${bookcheck.hotelnum}</div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;인원</div>
			<div class="ctexttext_aa">${bookcheck.usernum}</div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;체크인</div>
			<div class="ctexttext_aa"><fmt:formatDate value="${bookcheck.checkin}"/></div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;체크아웃</div>
			<div class="ctexttext_aa"><fmt:formatDate value="${bookcheck.checkout}"/></div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;결제 금액</div>
			<div class="ctexttext_aa">${bookcheck.price}</div>
		</div>
		
	</div>
	
	<div id="buttons_aa">
	<input type="button" value="목록으로" class="btn_aa" id="checkmain_aa"
		onclick="location.href='hotel.do?command=adminbookList'">
	<input type="button" value="예약 취소" class="btn_aa" id="checkmain_aa"
		onclick="confirmbookcancel();">
	<input type="hidden" id="gotonum" value="${gotonum}">
		<!-- location.href='hotel.do?command=adminbookcancel&booknum=${bookcheck.booknum}' -->
</div> 
	
	
</div>


</div>
</form>
</article>
<%@ include file="/admin/adminfooter.jsp" %>