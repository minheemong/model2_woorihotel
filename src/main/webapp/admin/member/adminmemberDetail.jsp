<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp" %>

<script type="text/javascript">
function go_memberlist_member(){
	document.adminmemberDetail.action = "hotel.do?command=adminMemberList&page=1";
	document.adminmemberDetail.submit();
}

function okButton_member(id){
	 var url="hotel.do?command=adminMemberUpdate&id=" + id;
	 document.adminmemberDetail.action=url;
	 document.adminmemberDetail.submit();
}
</script>
<style>
#adminmemebrlist{
    border: 2px solid #9F876B;
    margin: 0 auto;
    width: 400px;
    height:200px;
    border-collapse: collapse;
    
}
#adminmemebrlist tr th{
border-bottom:1px solid black;
}
#adminmemebrlist td{
border-bottom:1px solid black;
}
#adminmemebrlist tr td input{
text-align: left;
}

#qna_button{
border:1px solid black;
 height: 36px;
    width: 80px;
    font-weight: bold;
    background: #9F876B;
    font-size: 70%;
}
</style>

<article>


<form method="post" action="hotel.do" name="adminmemberDetail">
	<input type="hidden" name="command" value="adminMemberUpdate">

<table  id="adminmemebrlist" style="center;">

<caption>
   <h1>우리 호텔 ${memberDto.name}(${memberDto.id})님 회원 정보</h1>
</caption>

           <tr><th>아이디&nbsp;&nbsp;:</th><td style="text-align: left;">${memberDto.id}</td></tr>
			<tr><th>이름&nbsp;&nbsp;:</th><td>${memberDto.name}</td></tr>
			<tr><th>이메일&nbsp;&nbsp;:</th><td><input type="text" size="30" name="email" value="${memberDto.email}"></td></tr>
			<tr><th>전화번호&nbsp;&nbsp;:</th><td><input type="text" size="20" name="phone" value="${memberDto.phone}"></td></tr>	
</table>

		<div id="profText">&nbsp;&nbsp;&nbsp;${message}</div>
		<div id="profButton"  style="margin:0 auto;
	width:1000px; border:1px soloid black; text-align: center;">
  <input class="btn" type="button" name="btb_total" value="목록으로" onclick="go_memberlist_member();"id="qna_button">
			<input type="button" value="수정하기" onclick="okButton_member('${memberDto.id}')" id="qna_button">
		</div>
</form>

</article>


<%@ include file="../adminfooter.jsp" %>