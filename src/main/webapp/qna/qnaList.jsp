<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
#qnaviewtable,#qnaviewtable th,#qnaviewtable td{
border:0;}
#qnaviewtable a{
color:#383838; text-decoration: none; 
}
#qnaviewtable{
width:100%;  border-bottom:1px solid #999;  color:#666; font-size:12px; table-layout:fixed;
margin:0 auto; margin-right:400px; 
border:1;     border-collapse: collapse;

}
#qna_buttons{
text-align: center; border:0;

}
#qna_button{
border:1px solid black;
 height: 36px;
    width: 80px;
    font-weight: bold;
    background: #9F876B;
    font-size: 65%;
}
#qnaviewtable tr th{ padding:5px 0 6px; /* border-top: solid 1px #999;  *//* border-bottom: solid 1px #b2b2b2; */ background-color:#9F876B; color: #333; font-weight: bold; vertical-align: top; 
line-height: 50px;
}
#qnaviewtable tr td{
padding: 8px 0 6px; border-top:solid 1px #999; background-color:white; color:#333; font-weight: bold; vertical-align: top;
line-height: 30px; 
}
#qnaviewtable #qna_date,#qna_rep{ padding: 0; font-family: Tahoma; font-size: 11px; line-height: normal;
} 
#qnaviewtable #qna_title{
 text-align: left; padding-left: 15px; font-size: 13px;
 margin:  0 0 2px; vertical-align: middle;
}
#qnaviewtable #qna_title,#qna_size,#qna_id,#qna_date,#qna_rep{
 margin:  0 0 2px; vertical-align: middle;
}
#qnaviewtable #qna_date{
line-height: 50px;}

#qnaviewtable caption{
font-weight: bold; font-size: 140%;

}


</style>
<article >

<form name="formm" method="post">
<table style=" border:1; cellspacing:0; width: 1000px;" id="qnaviewtable">
<caption>
<h1 style=" text-align: center; color:#3a3125;"> 1:1 고객 게시판 목록</h1>
<h3 style=" text-align:center;  color:#3a3125;"> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
</caption>
	<tr style="height: 60px; border:0;"  >
           <th scope="col">등록번호</th><th scope="col">제목</th><th scope="col">아이디</th><th scope="col">등록일</th><th scope="col">답변 여부</th>
    </tr>
  
	<c:forEach items="${qnaList}"  var="qnaDto"  varStatus="status"> 
           <c:set var="size" value="${fn:length(qnaList)+1-(status.count)}"/>   
        		<tr style="height: 30px;  text-align:center;">
                 
                    <td id="qna_size"> <c:out value="${size}"/></td>
                    <td id="qna_title"><a href="hotel.do?command=qnaView&qnaseq=${qnaDto.qnaseq}">${qnaDto.title}</a>
        <c:choose>
           <c:when test="${qnaDto.rep==1}">
                     <img width="10" height="9" id="new" src="images/ic_new.gif">  
                </c:when>
                
             <c:when test="${qnaDto.rep==2 }">
            <br> <img  src="images/ic_reply.png"> &nbsp;&nbsp;${qnaDto.reply}
              </c:when>
          </c:choose>    
                     
                     </td> 
                    <td id="qna_id">  ${qnaDto.id} </td>   
               		<td id="qna_date"><fmt:formatDate value="${qnaDto.indate}" type="date"/></td>
               		<td id="qna_rep">
                        <c:choose>
                				<c:when test="${qnaDto.rep==1}"> no </c:when>
                				<c:when test="${qnaDto.rep==2}"> yes </c:when>
               		    </c:choose>
                   </td>    
           		</tr>
       <%--       <c:choose>
                  <c:when test="${qnaDto.rep==2 }">
                      <tr>
                      <td>
                      </td>
                        <td>
                        <img  src="images/ic_reply.png"> &nbsp;&nbsp; (답변) ${qnaDto.reply} 
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        
                      </tr>
                      
                  </c:when>
             </c:choose> --%>
  	</c:forEach>
</table>

<div class="clear"></div>
<div id="qna_buttons"  >
	<input type="button"  value="1:1 질문하기"  class="submit" id="qna_button"
	onClick="location.href='hotel.do?command=qnaWriteForm'"> 
	<input type="button"    value="되돌아가기"  class="cancel" id="qna_button"
	onclick="location.href='hotel.do?command=mainForm'">  
</div>
</form>
</article>

<%@ include file="../footer.jsp" %> 