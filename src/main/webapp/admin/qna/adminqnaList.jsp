<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp" %>

 <style>
article h1{
 text-align: center; margin-top: 50px;
}

#qnaList123{
margin:0 auto;
 width:1000px; border:1px soloid black; text-align: center;  margin-right: 80px;font-weight:bold;
 margin:0 auto;     border-collapse: collapse;
    border-collapse: collapse;

width:1000px;  border-bottom:1px solid #999;   color:#666; font-size:12px; table-layout:fixed;
margin:0 auto; margin-right:400px; 
border:1;
}
#qnaList123 tr th{
padding:5px 0 6px;  border-top: solid 1px #999;   border-bottom: solid 1px #b2b2b2; background-color:#9F876B; color: #333; font-weight: bold;  
line-height: 10px;
}
#qnaList123 tr td{
padding: 8px 0 6px; border-top:solid 1px #999; background-color:white; color:#333; font-weight: bold; vertical-align: top;
line-height: 30px; 
}
#qna_button{
border:1px solid black;
 height: 36px;
    width: 80px;
    font-weight: bold;
    background: #9F876B;
    font-size: 65%;
}

</style>
<script type="text/javascript">
function go_view(qnaseq){
	/* location.href="hotel.do?command=adminQnaDetail&qnaseq="+qnaseq; */
	var url="hotel.do?command=adminQnaDetail&qnaseq="+qnaseq;
	document.formm.action=url;
	document.formm.submit();
}

function go_serch_qna(){
	
	if(document.frm.key.value=="") return;
	var url="hotel.do?command=adminQnaList&page=1";
	// 보던페이지가어떤에피이지 이더라도,검색갤겨의 1페이로 가기위해 파라미터page를 1로 전송.,
	document.formm.action=url;
	document.formm.submit();
	
	
}
function go_total_qna(){
	document.formm.key.value="";
	document.formm.actuon="hotel.do?command=adminQnaList&page=1";
	document.formm.submit();
	
}
</script>

<article>
<h1>Q&amp;A게시글 리스트</h1>
<form name="formm" method="post">
<table style=" margin:0 auto;
	width:1000px; border:1px soloid black; text-align: center;  margin-right: 100px;font-weight:bold;">
  <tr>
     <td> 아이디<input type="text" name="key" value="${key}">
           <input class="btn" type="button"                   value="검색"  onclick="go_serch_qna();" id="qna_button">
           <input class="btn" type="button" name="btb_total" value="전체보기" onclick="go_total_qna();"id="qna_button">
    </td>
    
  </tr>

</table>
</form>

<table  id="qnaList123" style="center;">
    <tr><th>번호</th><th >제목</th><th>작성자</th><th>작성일</th><th>답변여부</th></tr>
       <c:forEach items="${qnatList}" var ="qnaDto">
             <tr>
                   <td>${qnaDto.qnaseq}</td>                
                    <td><a  onClick= "javascript:go_view('${qnaDto.qnaseq}')">${qnaDto.title }</a>
        <c:choose>
        
                 <c:when test="${qnaDto.rep==1}">
                     <img width="10" height="9" id="new" src="images/ic_new.gif">  
                </c:when>
             
          </c:choose>    
                    </td>
                    <td >${qnaDto.id}</td>
                    <td><fmt:formatDate value="${qnaDto.indate }"/></td>
                    <td>
                     <c:choose>
                                <c:when test='${qnaDto.rep=="1"}'>(미처리)</c:when>
                                <c:otherwise>(답변 처리완료)</c:otherwise>
                     </c:choose>
                     </td>
              </tr>
       </c:forEach>
</table>

<br>
 <jsp:include page="/admin/paging/paging.jsp">
  <jsp:param name="page" value="${paging.page}" />
  <jsp:param name="beginPage" value="${paging.beginPage}" />
  <jsp:param name="endPage" value="${paging.endPage}" />
  <jsp:param name="prev" value="${paging.prev}" />
  <jsp:param name="next" value="${paging.next}" />
  <jsp:param name="command" value="hotel.do?command=adminQnaList" />
</jsp:include> 








</article>

<%@ include file="../adminfooter.jsp" %>