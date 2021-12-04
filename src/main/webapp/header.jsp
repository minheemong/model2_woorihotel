<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Woori Hotel</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&f
amily=Gothic+A1:wght@900&family=Hahmlet:wght@251&family=Nanum+Myeongjo:wght@800&display=swap"
 rel="stylesheet">
 <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<style>


.header_logo h1,p{

font-family: 'Nanum Myeongjo', serif;
}

.header_gnb {
}
.header_gnb ul li{
font-family: 'Black Han Sans', sans-serif;
font-family: 'Gothic A1', sans-serif;
font-family: 'Hahmlet', serif;
font-family: 'Nanum Myeongjo', serif;
}
</style>



<link href="css/css.css" rel="stylesheet">
<link href="css/Hotel.css" rel="stylesheet">
<link href="member/member.css" rel="stylesheet">
<!-- <link href="member/member.css" rel="stylesheet">
<link href="css/Hotel.css" rel="stylesheet">
<link href="script/script.js" rel="stylesheet"> -->
<script src="script/script.js"></script>
<script src="css/hotel.js"></script>
<!-- <script src="css/hotel.js"></script>
<script src="member/member.js"></script> -->


</head>
<body>
<div id="wrap">
<header class="header"><!-- 로고, 주메뉴, 카테고리 메뉴 등이 표시되는 영역 -->
 <!-- 상단 메뉴 시작 : 로그인 CART MyPage 등-->
   <div class="header_logo">
        <a href="hotel.do?command=mainForm ">
            <h1 >THE WOORI</h1>
            <p> HOTELS &RESORTS</p>
        </a>
    
 </div> 
 
 <div class="header_gnb">
  <ul>         
              <li><a href="hotel.do?command=goInfo">호텔 우리 소개</a></li>                              
              <li><a href="hotel.do?command=qnaList" >고객문의</a></li>

  <c:choose> 

          <c:when  test="${empty loginUser}">  
              <li><a href="hotel.do?command=loginForm">로그인</a></li>
              <li><a href="hotel.do?command=contract">회원가입</a></li>
          </c:when> 
 <c:otherwise>
               <li id="logo">${loginUser.name}(${loginUser.id})</li>
               <li><a href="hotel.do?command=logout">로그아웃</a></li>
               <li><a href="hotel.do?command=bookChecklist&page=1&a=1">마이페이지</a></li>
         
 </c:otherwise> 
 </c:choose>
           		</ul>
      </div>
        
           		
           		
           		
        
</header>