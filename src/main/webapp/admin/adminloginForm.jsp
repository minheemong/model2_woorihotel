<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/admin.css">
<style>
#admin_login_title {width:865px; height:80px; position:relative; margin:0 auto; margin-bottom:0; 
border-bottom:3px solid #3a3125; color:#865009; font-size:120%; font-weight:bold; line-height:600%;}

#admin_login_view{width:600px; height:250px; position: relative; margin:100px auto; background:#F1EBD6;}

#admin_box1{width:410px; height:60px; position: relative; margin-top:50px; margin-left:100px; margin-bottom:20px; float:left;}
.input{width:290px; height:60px; position:relative; margin:0; float:left; color:#727272; }
#admin_idPwd{width:280px; height:25px; margin-top:0px; margin-bottom:5px; position: relative; background:white; border:0; padding-left:10px;}
#admin_login{width:105px; height:60px; float:right; position:relative; background: wheat;  border:0px solid white; background:#3a3125; color:#F1EBD6; margin:0;}

#login_btn{width:410px; height:25px; float:left; margin-bottom:0px;}


</style>
<script type="text/javascript">
function workerCheck(){
	  if(document.loginFrm.workId.value==""){
	      	alert("아이디를 입력하세요.");
	      	return false;
	  }else if(document.loginFrm.workPwd.value==""){
	     	alert("비밀번호를 입력하세요.");
	      	return false;
	  }
	  return true;  
}
</script>
</head>
<body>

<div id="admin_login_title"> 관리자페이지 로그인</div>
<form method="post" action="hotel.do" name="loginFrm">
 <input type="hidden" name="command" value="adminlogin">
 
<div id="admin_login_view">
    <div id="admin_box1">
    <p> 관리자 로그인</p>
          <div class="input">
           
          <input name="workId" type="text" id="admin_idPwd" placeholder="&nbsp;&nbsp; 관리자 아이디 입력"><br>
          <input name="workPwd" type="password" id="admin_idPwd"  placeholder="&nbsp;&nbsp; 비밀번호 입력"><br>
     </div>
         <input type="submit" value="로그인" id="admin_login" onclick="return workerCheck()">
         <div>&nbsp;&nbsp;&nbsp;${message}</div>
    </div> 

</div>
</form>
</body>
</html>