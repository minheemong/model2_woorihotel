<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp" %>
<script type="text/javascript">
function go_total_order(){
	document.frm.key.value="";
	document.frm.actuon="hotel.do?command=adminBookList&page=1";
	document.frm.submit();
	
}

function go_search_order(){
	
	if(document.frm.key.value=="") return;
	var url="hotel.do?command=adminBookList&page=1";
	// 보던페이지가어떤에피이지 이더라도,검색갤겨의 1페이로 가기위해 파라미터page를 1로 전송.,
	document.frm.action=url;
	document.frm.submit();
	
	
}
</script>
<div  class="clear"></div>
<article >
<h1>예약 리스트</h1>
	<form name="frm" method="post">
		<table>
			<tr>
                <td width="642">예약자 이름<input type="text" name="key" value="${key}">
				 <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search();">
				 <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total();">	
            	</td>	
			</tr>
		</table>
	</form>
	<table id="bookViewList">
		<tr>
               <th>주문번호</th><th>예약번호</th><th>아이디</th><th>이름</th><th>방 정보</th>
               <th>인원</th><th>체크인</th><th>체크아웃</th><th></th>입금현황<th>가격 </th>
        </tr>
		<c:forEach items="${bookViewList}" var="bookViewDto">
			<tr>
                <td height="23" align="center" >${bookViewDto.booknum}</td>
                <td height="23" align="center" >${bookViewDto.bdseq}</td>
                <td height="23" align="center" >${bookViewDto.id}</td>
                <td height="23" align="center" >${bookViewDto.name}</td>
                <td height="23" align="center" >${bookViewDto.kind}</td>
                <td height="23" align="center" >${bookViewDto.usernum}</td>						
				<td><fmt:formatDate value="${bookViewDto.checkin}"/></td>
                <td><fmt:formatDate value="${bookViewDto.checkout}"/></td>
                <td height="23" align="center" >${bookViewDto.result}</td>
                <td height="23" align="center" >${bookViewDto.price}</td>
		
</tr>
		</c:forEach>
	</table>
	
	<br>
<jsp:include page="../paging/paging.jsp">
	<jsp:param name="page" value="${paging.page}" />
	<jsp:param name="beginPage" value="${paging.beginPage}" />
	<jsp:param name="endPage" value="${paging.endPage}" />
	<jsp:param name="prev" value="${paging.prev}" />
	<jsp:param name="next" value="${paging.next}" />
	<jsp:param name="command" value="shop.do?command=adminProductList" />
</jsp:include>
	
		
</article>








<%@ include file="../adminfooter.jsp" %>