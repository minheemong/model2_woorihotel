<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>  
<!-- <link href="qna/qna.css" rel="stylesheet"> -->
<style>
#qnawriteview{
 margin-left: 570px; height:200px;
position:relative;
background-color:#9F876B;
border-collapse:collapse;
border: 2px solid black;
}
#qnawriteview tr{
border-bottom: 
2px solid black;
}

#qnaview1{
height: 400px; margin-top:px;
}
#qnawriteview caption {
	    font-size: 120%;  font-weight: bold;
}
#qna_button{
border:1px solid black;
 height: 36px;
    width: 80px;
    font-weight: bold;
    background: #FAF1DO;
    font-size: 65%;
}

</style>
<article>

<div id="qnaview1">
  
<form name="formm" method="post" action="hotel.do" >
	<input type="hidden" name="command" value="qnaWrite">
<table id="qnawriteview">
<caption>
               <h2> 1:1질문하기</h2>
               <h3>고객님의 질문에 대해서 운영자가 답변을 드립니다</h3>
</caption>
   <tr height="25" >
             <td align="center" width="130 " style="font-weight: bold; ">제목</td>
             
             <td width="450"><input type="text" name="title" size="68"  style="background-color:white;" /></td>
   </tr>
   <tr  >
            <td align="center" width="150" style="font-weight: bold; ">문의사항</td>
            <td width="450"  ><textarea rows="11" cols="70" name="content"  style="background-color:white;"></textarea></td>
   </tr>
   <tr height="20">
             <td align="center" colspan="2">
                  <input type="submit"  value="저장하기"     class="submit" id="qna_button"> 
         		
         		  <input type="button"  value="취소"  class="submit"  id="qna_button"
       							onclick="location.href='hotel.do?command=qnaList'"> 
              </td>
   </tr>
      
</table>
</form>
</div>
</article>
<!-- 1. QnaWriteFormAction  을 제작하여,  qnaWrite.jsp 으로 포워딩합니다
	2. 게시글을 쓰고 글쓰기 버튼을 클릭하면  QnaWriteAction 으로 이동하여
		화면에 사용자가 쓴 내용을 레코드를 추가합니다-별도 QnaDao 내부 메서드제작
	3. 게시글 등록을 마치고    qnaList.jsp  로 이동합니다 -->
<%@ include file="../footer.jsp" %>   