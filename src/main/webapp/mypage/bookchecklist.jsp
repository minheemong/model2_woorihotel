<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<article class="rightarticle_aa"><%@ include file="sub_menu.jsp" %>
<div id="abox_aa">
<div id="sum_aa">예약확인/취소</div>
<br>
<span id="chklisttxt_aa">객실 및 예약 내역을 확인하실 수 있습니다.</span>
<br><br>
<form name="frm" method="post">
<div id="chklistbox_aa">
<div id="chkselectbox_aa"><!-- 검색 -->
	<span class="chkselect_aa">예약 번호 검색</span>
	<input type="text" name="booknums" value="${booknums }" >
	<input class="btny_aa" type="button" value="검색" onclick="go_search_booknum();">
	<input class="btny_aa" type="button" value="전체보기" onclick="go_total_check();">
	<br>
	<span class="chkselect_aa">체크인 날짜</span>
	<input type="number" name="checkins" value="${checkins }"
		 placeholder="예 : 20201231 (YYYYMMDD)" style="width:200px;">
	<!-- <input class="btny" type="button" value="검색" onclick="go_total_check();"> -->
	<span class="chkselect_aa">체크아웃 날짜</span>
	<input type="number" name="checkouts" value="${checkouts }"
		placeholder="예 : 20201231 (YYYYMMDD)" style="width:200px;">
	<input class="btny_aa" type="button" value="검색" onclick="go_search_checkdate();">
</div>
<div id="chklistbox2_aa">
	<div id="chklistlist_aa">객실 예약</div>
	<c:choose>
	<c:when test='${empty booklist}'><div id="chklistbox3_aa">예약이 없습니다.</div></c:when>
	<c:otherwise>
		Total : ${total}
			<div id="chklistbox3_aa">
				<div id="chklisttitle_aa">
					<div class="booknumclass_aa" id="chklisttitle2_aa">예약번호</div>
					<div class="kindclass_aa" id="chklisttitle2_aa">객실</div>
					<div class="usernumclass_aa" id="chklisttitle2_aa">인원수</div>
					<div class="checkinoutclass_aa" id="chklisttitle2_aa">체크인/체크아웃</div>
					<div class="bookresultclass_aa" id="chklisttitle2_aa">예약상태</div>
					<div class="bookpriceclass_aa" id="chklisttitle2_aa">금액</div>
				</div>
				<c:forEach items="${booklist}" var="list">
				<div id="chklistcontent_aa">
					<div class="booknumclass_aa" id="chklistcontent2_aa">
						<a href="hotel.do?command=listbookcheck&bdseq=${list.bdseq}">
						${list.booknum}</a></div>
					<div class="kindclass_aa" id="chklistcontent2_aa">${list.kind}</div>
					<div class="usernumclass_aa" id="chklistcontent2_aa">${list.usernum}명</div>
					<div class="checkinoutclass_aa" id="chklistcontent2_aa">
						<fmt:formatDate value="${list.checkin}"/> ~ 
						<fmt:formatDate value="${list.checkout}"/>
					</div>
					<div class="bookresultclass_aa" id="chklistcontent2_aa">
						<c:choose>
						<c:when test='${list.result=="1"}'>예약 완료</c:when>
						<c:when test='${list.result=="2"}'>취소 신청</c:when>
						<c:when test='${list.result=="3"}'>취소 완료</c:when>
						<c:otherwise>예약 대기</c:otherwise></c:choose>
					</div>
					<div class="bookpriceclass_aa" id="chklistcontent2_aa">${list.price}원</div>
				</div>
				<div class="clear"></div>
				</c:forEach>
			</div>
		
	</c:otherwise></c:choose>
	
</div>
</div>
</form>

	<br>
<jsp:include page="/mypage/paging.jsp">
	<jsp:param name="page" value="${paging.page}" />
	<jsp:param name="beginPage" value="${paging.beginPage}" />
	<jsp:param name="endPage" value="${paging.endPage}" />
	<jsp:param name="prev" value="${paging.prev}" />
	<jsp:param name="next" value="${paging.next}" />
	<jsp:param name="command" value="hotel.do?command=bookChecklist" />
</jsp:include>

</div>
</article>




<%@ include file="../footer.jsp" %>