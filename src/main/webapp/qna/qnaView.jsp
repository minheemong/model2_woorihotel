<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<%@ include file="sub_menu.jsp" %>
<meta charset="UTF-8">
<style>
#qnaform{
font-size: 86%; line-height: 500%;  font-weight: bold;
}
article h1{
 text-align: center; margin-right: 400px;
}
article h3{
  text-align: center; margin-right: 400px;
}
#qnatable{
margin:0 auto; 
margin-left:600px;

border-collapse:collapse;
border:1px solid black;
width:600px; text-align: center;      
table-layout:fixed;
 
}
#qnatable tr th{
 border-bottom:1px solid black;
 background-color:#9F876B;
}
#qnatable tr td{
 border-bottom:1px solid black;
}

#qna_buttons{
margin:0 auto; width: 300px;
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
<div>
   <h1 > 1:1 고객 게시판 </h1>
   <h3 > 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
</div>
<form  id="qnaform"name="formm" method="post" >
 <input type="hidden" name="qnaseq" value="${qnaDto.qnaseq}">
 <table id="qnatable" >
          <tr>
              <th >제목</th><td width="400" >${qnaDto.title}</td>
          </tr>
 
           <tr>
              <th>등록번호</th><td width="400" >${qnaDto.qnaseq}</td>
          </tr>
 
          <tr> 
               <th>등록일</th>
               <td>
       		<fmt:formatDate value="${qnaDto.indate}" type="date"/></td>
          </tr>
          <tr>
                 <th>문의내용</th><td align="left" style="text-align:center;font-size:115%;">
       		  <pre>${qnaDto.content}</pre></td>
          </tr>
          <tr>
                 <th>답변 내용</th><td align="left" style="text-align:center;">${qnaDto.reply}</td>
                 
          </tr>
  </table>

 <div class="clear"></div>
<div  id="qna_buttons">
<input type="button"  value="목록보기" id="qna_button"
onclick="location.href='hotel.do?command=qnaList'">
<input type="button"  value="수정" id="qna_button"
onclick="go_qna_update();"> 

<input type="button"  value="삭제" onclick="go_qna_delete(); "  id="qna_button">  
</div>
  </form>
</article>
<%@ include file="../footer.jsp" %> 

<script type="text/javascript">
function go_qna_delete(){
  document.formm.action = "hotel.do?command=qnaDelete";
     document.formm.submit();
 } 
 function go_qna_update() {
	 document.formm.action = "hotel.do?command=qnaUpdateForm";
     document.formm.submit();
}
</script>