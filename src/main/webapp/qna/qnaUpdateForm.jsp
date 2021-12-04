        
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<%@ include file="sub_menu.jsp"%>
<style>

#qnawriteview{
 margin-left: 570px; height:200px;
position:relative; border:1px solid black;
}
article h2{
 margin:0 auto; margin-left: 800px; margin-top:20px;
}

article h3{
 margin:0 auto; margin-left: 800px; margin-top:50px; margin-bottom: 30px
}
#qnaview1{
height: 400px; margin-top:100px; margin :0 atuo;
}

#qna_btn{
    margin-left: 850px;
    margin-top: 20px;
}
</style>
<article>
<div id="qnaview1">
<h3> 고객문의 수정하기</h3>
<form name="formm"  method="post"  >
 <input type="hidden" name="qnaseq" value="${qnaDto.qnaseq}">
 <table id="qnawriteview">
     <tr>
             <td align="center" width="150">제목</td>
             <td width="450"><input type="text" name="title" size="60"/></td>
   </tr>
   <tr>
            <td align="center" width="150">문의사항</td>
            <td width="450"><textarea rows="10" cols="60" name="content"></textarea></td>
   </tr>
 
  </table>
 
 <div class="clear"></div>
<div  id="qna_btn">
<input type="reset"  value="취소">
<input type="button"  value="저장" onclick="go_qna_update()"> 

 
</div>
</form>
</div>
</article>
<%@ include file="../footer.jsp" %> 
<script type="text/javascript">
function go_qna_update() {
	 document.formm.action ="hotel.do?command=qnaUpdate";
    document.formm.submit();
}
</script>
