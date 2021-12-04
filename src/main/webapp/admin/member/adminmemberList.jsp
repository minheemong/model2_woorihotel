<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp" %>

<script type="text/javascript">
function go_view_detail(id){
	 /* location.href="hotel.do?command=adminQnaDetail&qnaseq="+qnaseq; */
	 var url="hotel.do?command=adminMemberDetail&id="+id;
	 document.formm.action=url;
	 document.formm.submit();	
	}
function go_view_detail_book(id) {
/* 	var url="hotel.do?command=adminMemberDetailBook&id="+id;
	 document.formm.action=url;
	 document.formm.submit(); */

	 var url="hotel.do?command=adminMemberDetailBook&id="+id;
	 var opt = "toolbar=no,menubar=no,scrollbars=no,resizable=no,width=800,";
		opt = opt + "height=500, top=300, left=300";
		window.open(url, "예약 정보", opt); 
}

function go_serch_member(){
 
 if(document.formm.key.value=="") return;
 var url="hotel.do?command=adminMemberList&page=1";
 // 보던페이지가어떤에피이지 이더라도,검색갤겨의 1페이로 가기위해 파라미터page를 1로 전송.,
 document.formm.action=url;
 document.formm.submit();
 
 
}
function go_total_member(){
 document.formm.key.value="";
 document.formm.action="hotel.do?command=adminMemberList&page=1";
 document.formm.submit();
 
}
</script>
<style>
#adminmemebrlist{ margin:0 auto;     border-collapse: collapse;
    border-collapse: collapse;
width:1000px;  border-bottom:1px solid #999;   color:#666; font-size:12px; table-layout:fixed;
margin:0 auto; margin-right:400px; 
border:1

}
#adminmemebrlist tr th{
padding:5px 0 6px;  border-top: solid 1px #999;   border-bottom: solid 1px #b2b2b2; background-color:#9F876B; color: #333; font-weight: bold;  
line-height: 10px;
}
#adminmemebrlist tr td{
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

<article>
<h1>우리 호텔 회원 리스트</h1>
<form name="formm" method="post">
<table style="margin:0 auto; 
	width:1000px; border:1px soloid black; text-align: center; margin-right: 140px;font-weight:bold;">
  <tr>
     <td> 아이디 또는 이름<input type="text" name="key" value="${key}">
           <input class="btn" type="button"                   value="검색"  onclick="go_serch_member();" id="qna_button">
           <input class="btn" type="button" name="btb_total" value="전체보기" onclick="go_total_member();"id="qna_button">
    </td>
    
  </tr>

</table>
</form>


<table  id="adminmemebrlist" style="center;">
    <tr>
           <th>아이디</th><th >이름</th><th>이메일</th><th>전화번호</th><th>번지수</th><th >상세주소</th></tr>
    
       <c:forEach items="${memberList}" var ="memberDto">
             <tr>
                   <td><a href="#" onClick= "go_view_detail('${memberDto.id}')">${memberDto.id}<br>(회원정보수정)</a></td>                
                    <td><a href="hotel.do?command=adminMemberDetailBook&id=${memberDto.id}" 
                    target="_blank" onClick= "window.open(this.href,'popup','width=900,height=400,toolbar=no,nomenubar=no,scrollbars=no,resizable=no')">${memberDto.name}<br>(예약정보)</a></td>
                    <td>${memberDto.email}</td>
                    <td>${memberDto.phone}</td>
                    <td>${memberDto.zip_num} </td>
                    <td>&nbsp;${memberDto.address}</td>                  
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
  <jsp:param name="command" value="hotel.do?command=adminMemberList" />
</jsp:include> 


</article>


<%@ include file="../adminfooter.jsp" %>