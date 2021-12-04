<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script>
  $.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
  });

  $(function() {
    $("#datepicker1, #datepicker2").datepicker();
  });
  
  
  // 객실 더보기 추가
  
  /* 팝업1 */
  $(document).ready(function( $ ){     
	    $(".openPopup1").on("click", function(event) {  //팝업오픈 버튼 누르면
	    $("#popup01").show();   //팝업 오픈
	    $("body").append('<div class="backon"></div>'); //뒷배경 생성
	    });
	   
	    $("body").on("click", function(event) { 
	    	if(event.target.className == 'close' || event.target.className == 'backon'){
	            $("#popup01").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
	            $(".backon").hide();
	        }
	    });
  });
  
$(document).ready(function( $ ){     
	    $(".openPopup2").on("click", function(event) {  //팝업오픈 버튼 누르면
	    $("#popup02").show();   //팝업 오픈
	    $("body").append('<div class="backon"></div>'); //뒷배경 생성
	    });
	   
	    $("body").on("click", function(event) { 
	    	if(event.target.className == 'close' || event.target.className == 'backon'){
	            $("#popup02").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
	            $(".backon").hide();
	        }
	    });
});
  
  $(document).ready(function( $ ){     
	    $(".openPopup3").on("click", function(event) {  //팝업오픈 버튼 누르면
	    $("#popup03").show();   //팝업 오픈
	    $("body").append('<div class="backon"></div>'); //뒷배경 생성
	    });
	   
	    $("body").on("click", function(event) { 
	    	if(event.target.className == 'close' || event.target.className == 'backon'){
	            $("#popup03").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
	            $(".backon").hide();
	        }
	    });
});
  
  $(document).ready(function( $ ){     
	    $(".openPopup4").on("click", function(event) {  //팝업오픈 버튼 누르면
	    $("#popup04").show();   //팝업 오픈
	    $("body").append('<div class="backon"></div>'); //뒷배경 생성
	    });
	   
	    $("body").on("click", function(event) { 
	    	if(event.target.className == 'close' || event.target.className == 'backon'){
	            $("#popup04").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
	            $(".backon").hide();
	        }
	    });
});
  
  $(function(){
      var num=0;
      $('#lbtn1').click(function(){
          if(num==0) return;
          num--;
          
          $('#seemore_imgview1').animate({left:-900*num},200);
      });
      $('#rbtn1').click(function(){
          if(num==3) return;
          num++;
          
          $('#seemore_imgview1').animate({left:-900*num},200);
      });
  });
  
  $(function(){
      var num=0;
      $('#lbtn2').click(function(){
          if(num==0) return;
          num--;
          
          $('#seemore_imgview2').animate({left:-900*num},200);
      });
      $('#rbtn2').click(function(){
          if(num==4) return;
          num++;
          
          $('#seemore_imgview2').animate({left:-900*num},200);
      });
  });
  
  $(function(){
      var num=0;
      $('#lbtn3').click(function(){
          if(num==0) return;
          num--;
          
          $('#seemore_imgview3').animate({left:-900*num},200);
      });
      $('#rbtn3').click(function(){
          if(num==2) return;
          num++;
          
          $('#seemore_imgview3').animate({left:-900*num},200);
      });
  });
  
  $(function(){
      var num=0;
      $('#lbtn4').click(function(){
          if(num==0) return;
          num--;
          
          $('#seemore_imgview4').animate({left:-900*num},200);
      });
      $('#rbtn4').click(function(){
          if(num==2) return;
          num++;
          
          $('#seemore_imgview4').animate({left:-900*num},200);
      });
  });
  
</script>

<style type="text/css">
#hotelview {border-top:1px solid #999; width:1000px; margin:0 auto; height:1100px;
	 margin-top:10px;}
#roomview {position:relative; width:1000px; margin:0 auto; height:230px; }
#room_img {float:left; width:250px; height:150px;  margin-top:40px;}
#room_img img{width:250px; height:150px;}
#room_content {float:left; height:150px;  width:430px; margin-top:40px;}
#room_content ul{list-style:none;}
#room_content ul li{margin-top:17px;}
#room_content ul li:nth-child(1){margin-top:-17px; font-size:130%; font-weight:bold;}
#room_content ul li:nth-child(2){margin-top:20px;}
#price_view{float:left; height:150px; width:160px;  margin-top:40px;}
#button_view{float:left; height:150px; width:160px;  margin-top:40px;}
#price{height:30px; width:160px;  margin-top:90px; font-size:130%; font-weight:bold; text-align:right;}
#price2{height:20px; width:160px;  font-size:90%;  text-align:right;}
#button_view_div{height:50px; width:160px; margin-top:90px;}
#book_button{ height:40px; width:150px; background:#856f56; font-size:120%; font-weight:bold; margin-left:5px; margin-top:5px;
	color:white;}
	


/* 추가 */

.popup00{ display: none;}
.popup00{width: 1000px; height: 930px; position: absolute; top: 50%; left: 50%;
	margin: 0px 0 0 -500px;	background-color: #fff;	z-index: 2; }

.backon{content: ""; width: 100%; height: 100%; background: #00000054; position: fixed;
    top: 0; left: 0; z-index: 1;}
.close{position:absolute; top:-25px; right: 0; cursor:pointer;}
.openPopup{ cursor:pointer; }


#seemore_div1{width:900px; height:400px;  margin:0 auto; overflow:hidden;}
#seemore_div1 img{width:900px; height:400px;}
.seemore_imgview{width:4500px; height:400px; position:relative;}

#seemore_div2{position:absolute; height:500px; width:500px; left:50px;}
#seemore_div3{position:absolute; height:500px; width:392px; background:#Faf1d0; right:50px;
			text-align:left;}
#seemore_view{width:900px; height:900px; margin:0 auto;}
#seemore_div2_1{position:relative; width:500px; height:191px; }
#seemore_div2_1left{ height:191px; width:110px;  float:left; text-align:center; line-height:191px;
	font-weight:bold; background:#Faf1d0;}
#seemore_div2_1right{ height:191px; width:390px;  float:left; font-size:90%;}
#seemore_div2_1right ul li{padding-top:11px;}

#seemore_div2_2{postion:relative; width:500px; height:291px; }
#seemore_div2_2left{height:291px; width:110px;  float:left; text-align:center; line-height:291px;
	font-weight:bold; background:#Faf1d0;}
#seemore_div2_2right{height:291px; width:390px;  float:left; font-size:90%;}
#seemore_div2_2right ul{list-style:none; padding-top:10px;}
#seemore_div2_2right ul li:nth-child(1){list-style:disc;}
#seemore_div2_2right ul li:nth-child(10){list-style:disc;}
#seemore_div2_2right ul li:nth-child(5){font-size:85%; padding-top:4px;}

#seemore_div3 ul{list-style:none; padding:13px; padding-top:0px; padding-right:0px;}
#seemore_div3 ul li{font-size:90%;}
#seemore_div3 ul li:nth-child(1){font-size:120%; font-weight:bold;}
#seemore_div3 ul li:nth-child(5){font-size:120%; font-weight:bold;}
#seemore_div3 ul li:nth-child(8){font-size:120%; font-weight:bold;}

.lbtn{position:absolute; left:50px; background-image: url(images/ico_movie_171115.png); background-position: -60px -460px; width:50px; height:50px; border-radius: 50%; top:180px;}
.rbtn{position:absolute; left:900px; background-image: url(images/ico_movie_171115.png); background-position: 0px -460px; width:50px; height:50px; border-radius: 50%; top:180px;}
</style>




<!-- 임시 -->



<div id="hotelview">
	<!-- 용언씨 datepicker 아직 css 미적용 -->
	
	<div id="serch_bar_view">
    <form method="post" name="formm" action="hotel.do">
    <input type="hidden" name="command" value="bookForm">
    <input type="hidden" id = "oldUsernum" name="oldUsernum" value="${oldUsernum }">
    <input type="hidden" id = "oldRoomnum" name="oldRoomnum" value="${oldRoomnum }">
    <input type="hidden" id = "oldCheckin" name="oldCheckin" value="${oldCheckin }">
    <input type="hidden" id = "oldCheckout" name="oldCheckout" value="${oldCheckout }">
    <input type="hidden" id = "kind" name="kind" value="">
           <div id="serch_bar">
                  <ul>
                    <li >체크인&nbsp;&nbsp;<input type="text"  name="checkin" id="datepicker1" size="20" value="${oldCheckin }"> </li>                  
                    <li >체크아웃&nbsp;&nbsp;<input type="text" name="checkout" id="datepicker2" size="20" value="${oldCheckout }">  </li>
                            
                    <li>객실&nbsp;&nbsp;<input type="text" name="roomnum" size="5" id="datepicker3" value="${oldRoomnum }"></li>
                    <li>성인&nbsp;&nbsp;<input type="text" name="usernum" size="5" id="datepicker4" value="${oldUsernum }"></li>
                    <li><input type="submit" value="검색하기"id="serch_bar_button" onclick="return checkRoom();"></li>
                  </ul>
           </div></form>          
	</div>
	
	
	 
	
	


	<hr> <!-- 방선택 뷰  Deluxe--> 
 
 <c:if test="${DBool == false && DBool == false && GCDBool == false && EBDBool == false}">
   <div style="margin-top:250px; margin-left:370px;"><h2>남아있는 방이 없습니다.</h2></div>
   </c:if>
  <!--  ----------------- -->
	<c:if  test="${DBool == true }">
	<div id="roomview">
		<div id=room_img><img src="images/deluxe1.jpg"></div>
		<div id=room_content>
			<ul>
				<li>Deluxe</li>
				<li>객실크기 : 36㎡</li>
				<li>침대타입 : 더블(킹 사이즈)</li>
				<li><div class="openPopup1">객실 자세히 보기</div></li>
			</ul>
		</div>
		<div id =price_view>
			<div id=price>320,000 원 ~</div>
			<div id=price2>1박</div>
		</div>
		<div id =button_view>
			<div id=button_view_div><input type="button" value="예약하기" id="book_button" onclick="book_go1('Deluxe')"></div>
		</div>
	</div>
	<hr>
	</c:if>
	
	<!-- Business Deluxe -->
	<c:if  test="${BDBool == true }">
	<div id="roomview">
		<div id=room_img><img src="images/businessDeluxe1.jpg"></div>
		<div id=room_content>
			<ul>
				<li>Business Deluxe</li>
				<li>객실크기 : 43㎡</li>
				<li>침대타입 : 더블(킹 사이즈)</li>
				<li><div class="openPopup2">객실 자세히 보기</div></li>
			</ul>
		</div>
		<div id =price_view>
			<div id=price>370,000 원 ~</div>
			<div id=price2>1박</div>
		</div>
		<div id =button_view>
			<div id=button_view_div><input type="button" value="예약하기" id="book_button" onclick="book_go1('Business Deluxe')"></div>
		</div>
	</div>
	<hr>
	</c:if>
	
	<c:if  test="${GCDBool == true }">
	<div id="roomview">
		<div id=room_img><img src="images/grandCornerDeluxe1.jpg"></div>
		<div id=room_content>
			<ul>
				<li>Grand Corner Deluxe</li>
				<li>객실크기 : 51㎡</li>
				<li>침대타입 : 더블(킹 사이즈)</li>
				<li><div class="openPopup3">객실 자세히 보기</div></li>
			</ul>
		</div>
		<div id =price_view>
			<div id=price>420,000 원 ~</div>
			<div id=price2>1박</div>
		</div>
		<div id =button_view>
			<div id=button_view_div><input type="button" value="예약하기" id="book_button" onclick="book_go1('Grand Corner Deluxe')"></div>
		</div>
	</div>
	<hr>
	</c:if>
	
	<c:if  test="${EBDBool == true }">
	<div id="roomview">
		<div id=room_img><img src="images/executiveBusinessDeluxe1.jpg"></div>
		<div id=room_content>
			<ul>
				<li>Executive Business Deluxe</li>
				<li>객실크기 : 43㎡</li>
				<li>침대타입 : 더블(킹 사이즈)</li>
				<li><div class="openPopup4">객실 자세히 보기</div></li>
			</ul>
		</div>
		<div id =price_view>
			<div id=price>520,000 원 ~</div>
			<div id=price2>1박</div>
		</div>
		<div id =button_view>
			<div id=button_view_div><input type="button" value="예약하기" id="book_button" onclick="book_go1('Executive Business Deluxe')"></div>
		</div>
	</div>
	<hr>
	</c:if>
	


<!-- 팝업 -->
<div id="popup01" class="popup00">
	    <div class="close">close</div>
	    <div>
	    	<div id=seemore_view>
		    	<div id=seemore_div1>
		    		<div id=seemore_imgview1 class="seemore_imgview">
						<img src="images/deluxe11.jpg"><img src="images/deluxe12.jpg"><img src="images/deluxe13.jpg"><img src="images/deluxe14.jpg">
					</div>
					<div id="lbtn1" class="lbtn"></div>
        			<div id="rbtn1" class="rbtn"></div>
		    	</div>
		    	<hr>
				<div id=seemore_div2>
					<div id=seemore_div2_1>
						<div id=seemore_div2_1left>
							객실이용
						</div>
						<div id=seemore_div2_1right>
							<ul>
								<li>55인치 스마트 TV(위성 TV 48개 채널)</li>
								<li>50~100Mbps 초고속 유·무선(wifi) 인터넷 무</li>
								<li>220V, 110V 전압 사용 가능</li>
								<li>커피·차 티백 무료 제공</li>
								<li>베이비 크립(무료)</li>
							</ul>
						</div>
					</div>
					<hr>
					<div id=seemore_div2_2>
						<div id=seemore_div2_2left>
							부대시설
						</div>
						<div id=seemore_div2_2right>
							<ul>
								<li>피트니스 클럽 이용 안내</li><br>
								<li>- 체육관(Gym) 무료 이용(만 16세 이상 입장 가능)</li>
								<li>- 실내 수영장 무료 이용(만 13세 이상 입장 가능)</li>
								<li>&nbsp;&nbsp;&nbsp;(단, 주말 및 공휴일에는 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;만 13세 미만인 고객이 이용 가능하며,<br>
									&nbsp;&nbsp;&nbsp;신장 140cm 미만인 고객은 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;구명조끼 착용 시 이용 가능)
								</li><br>
								<li>- 사우나 이용 시 유료(만 13세 이상 입장 가능)</li>
								<li>- 피트니스 클럽은 매월 세 번째 수요일 정기휴일</li><br>
								<li>투숙 기간 내 무료 주차 가능</li>
							</ul>
						</div>
					</div>
				</div>
				<div id=seemore_div3>
				<ul>
					<li>조식 이용 안내</li>
						<li><br>&nbsp;&nbsp;- 더 파크뷰 06:00~10:00(주중/주말/공휴일)</li>
						<li>&nbsp;&nbsp;- 더 라이브러리 08:00~11:30</li>
						<li>&nbsp;&nbsp;&nbsp;※ 현재 더 라이브러리는 코로나19로 인한 운영시간<br>
							&nbsp;&nbsp;&nbsp;&nbsp;축소로 조식 운영을 하지 않고 있사오니 이용에<br>
							&nbsp;&nbsp;&nbsp;&nbsp;참고 부탁드립니다.</li>
					<li><br>체크인/체크아웃 시간</li>
						<li><br>&nbsp;&nbsp;- 체크인 : 오후 2시 이후</li>
						<li>&nbsp;&nbsp;- 체크아웃 : 오전 11시까지</li>
				
					<li><br>취소/변경 및 노쇼(No-show) 안내</li>
						<li><br>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시까지는 위약금 없음</li>
						<li>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시 이후 취소/변경/노쇼 발생 시</li>
					
						<li><br>&nbsp;&nbsp;성수기(5월~10월, 12월 24일~31일)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 80%가 위약금으로 부과</li>
						<li><br>&nbsp;&nbsp;비수기(성수기 외 기간)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 10%가 위약금으로 부과</li>
				</ul>
				</div>
			</div>
	    </div>
</div>

<div id="popup02" class="popup00">
	    <div class="close">close</div>
	    <div>
	    	<div id=seemore_view>
		    	<div id=seemore_div1>
		    		<div id=seemore_imgview2 class="seemore_imgview">
						<img src="images/businessDeluxe11.jpg"><img src="images/businessDeluxe12.jpg"><img src="images/businessDeluxe13.jpg"><img src="images/businessDeluxe14.jpg"><img src="images/businessDeluxe15.jpg">
					</div>
					<div id="lbtn2" class="lbtn"></div>
        			<div id="rbtn2" class="rbtn"></div>
		    	</div>
		    	<hr>
				<div id=seemore_div2>
					<div id=seemore_div2_1>
						<div id=seemore_div2_1left>
							객실이용
						</div>
						<div id=seemore_div2_1right>
							<ul>
								<li>55인치 스마트 TV(위성 TV 48개 채널)</li>
								<li>50~100Mbps 초고속 유·무선(wifi) 인터넷 무</li>
								<li>220V, 110V 전압 사용 가능</li>
								<li>커피·차 티백 무료 제공</li>
								<li>베이비 크립(무료)</li>
							</ul>
						</div>
					</div>
					<hr>
					<div id=seemore_div2_2>
						<div id=seemore_div2_2left>
							부대시설
						</div>
						<div id=seemore_div2_2right>
							<ul>
								<li>피트니스 클럽 이용 안내</li><br>
								<li>- 체육관(Gym) 무료 이용(만 16세 이상 입장 가능)</li>
								<li>- 실내 수영장 무료 이용(만 13세 이상 입장 가능)</li>
								<li>&nbsp;&nbsp;&nbsp;(단, 주말 및 공휴일에는 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;만 13세 미만인 고객이 이용 가능하며,<br>
									&nbsp;&nbsp;&nbsp;신장 140cm 미만인 고객은 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;구명조끼 착용 시 이용 가능)
								</li><br>
								<li>- 사우나 이용 시 유료(만 13세 이상 입장 가능)</li>
								<li>- 피트니스 클럽은 매월 세 번째 수요일 정기휴일</li><br>
								<li>투숙 기간 내 무료 주차 가능</li>
							</ul>
						</div>
					</div>
				</div>
				<div id=seemore_div3>
				<ul>
					<li>조식 이용 안내</li>
						<li><br>&nbsp;&nbsp;- 더 파크뷰 06:00~10:00(주중/주말/공휴일)</li>
						<li>&nbsp;&nbsp;- 더 라이브러리 08:00~11:30</li>
						<li>&nbsp;&nbsp;&nbsp;※ 현재 더 라이브러리는 코로나19로 인한 운영시간<br>
							&nbsp;&nbsp;&nbsp;&nbsp;축소로 조식 운영을 하지 않고 있사오니 이용에<br>
							&nbsp;&nbsp;&nbsp;&nbsp;참고 부탁드립니다.</li>
					<li><br>체크인/체크아웃 시간</li>
						<li><br>&nbsp;&nbsp;- 체크인 : 오후 2시 이후</li>
						<li>&nbsp;&nbsp;- 체크아웃 : 오전 11시까지</li>
				
					<li><br>취소/변경 및 노쇼(No-show) 안내</li>
						<li><br>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시까지는 위약금 없음</li>
						<li>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시 이후 취소/변경/노쇼 발생 시</li>
					
						<li><br>&nbsp;&nbsp;성수기(5월~10월, 12월 24일~31일)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 80%가 위약금으로 부과</li>
						<li><br>&nbsp;&nbsp;비수기(성수기 외 기간)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 10%가 위약금으로 부과</li>
				</ul>
				</div>
			</div>
	    </div>
</div>


<div id="popup03" class="popup00">
	    <div class="close">close</div>
	    <div>
	    	<div id=seemore_view>
		    	<div id=seemore_div1>
		    		<div id=seemore_imgview3 class="seemore_imgview">
						<img src="images/GCD11.jpg"><img src="images/GCD12.jpg"><img src="images/GCD13.jpg">
					</div>
					<div id="lbtn3" class="lbtn"></div>
        			<div id="rbtn3" class="rbtn"></div>
		    	</div>
		    	<hr>
				<div id=seemore_div2>
					<div id=seemore_div2_1>
						<div id=seemore_div2_1left>
							객실이용
						</div>
						<div id=seemore_div2_1right>
							<ul>
								<li>55인치 스마트 TV(위성 TV 48개 채널)</li>
								<li>50~100Mbps 초고속 유·무선(wifi) 인터넷 무</li>
								<li>220V, 110V 전압 사용 가능</li>
								<li>커피·차 티백 무료 제공</li>
								<li>베이비 크립(무료)</li>
							</ul>
						</div>
					</div>
					<hr>
					<div id=seemore_div2_2>
						<div id=seemore_div2_2left>
							부대시설
						</div>
						<div id=seemore_div2_2right>
							<ul>
								<li>피트니스 클럽 이용 안내</li><br>
								<li>- 체육관(Gym) 무료 이용(만 16세 이상 입장 가능)</li>
								<li>- 실내 수영장 무료 이용(만 13세 이상 입장 가능)</li>
								<li>&nbsp;&nbsp;&nbsp;(단, 주말 및 공휴일에는 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;만 13세 미만인 고객이 이용 가능하며,<br>
									&nbsp;&nbsp;&nbsp;신장 140cm 미만인 고객은 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;구명조끼 착용 시 이용 가능)
								</li><br>
								<li>- 사우나 이용 시 유료(만 13세 이상 입장 가능)</li>
								<li>- 피트니스 클럽은 매월 세 번째 수요일 정기휴일</li><br>
								<li>투숙 기간 내 무료 주차 가능</li>
							</ul>
						</div>
					</div>
				</div>
				<div id=seemore_div3>
				<ul>
					<li>조식 이용 안내</li>
						<li><br>&nbsp;&nbsp;- 더 파크뷰 06:00~10:00(주중/주말/공휴일)</li>
						<li>&nbsp;&nbsp;- 더 라이브러리 08:00~11:30</li>
						<li>&nbsp;&nbsp;&nbsp;※ 현재 더 라이브러리는 코로나19로 인한 운영시간<br>
							&nbsp;&nbsp;&nbsp;&nbsp;축소로 조식 운영을 하지 않고 있사오니 이용에<br>
							&nbsp;&nbsp;&nbsp;&nbsp;참고 부탁드립니다.</li>
					<li><br>체크인/체크아웃 시간</li>
						<li><br>&nbsp;&nbsp;- 체크인 : 오후 2시 이후</li>
						<li>&nbsp;&nbsp;- 체크아웃 : 오전 11시까지</li>
				
					<li><br>취소/변경 및 노쇼(No-show) 안내</li>
						<li><br>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시까지는 위약금 없음</li>
						<li>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시 이후 취소/변경/노쇼 발생 시</li>
					
						<li><br>&nbsp;&nbsp;성수기(5월~10월, 12월 24일~31일)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 80%가 위약금으로 부과</li>
						<li><br>&nbsp;&nbsp;비수기(성수기 외 기간)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 10%가 위약금으로 부과</li>
				</ul>
				</div>
			</div>
	    </div>
</div>

<div id="popup04" class="popup00">
	    <div class="close">close</div>
	    <div>
	    	<div id=seemore_view>
		    	<div id=seemore_div1>
		    		<div id=seemore_imgview4 class="seemore_imgview">
						<img src="images/EBD11.jpg"><img src="images/EBD12.jpg"><img src="images/EBD13.jpg">
					</div>
					<div id="lbtn4" class="lbtn"></div>
        			<div id="rbtn4" class="rbtn"></div>
		    	</div>
		    	<hr>
				<div id=seemore_div2>
					<div id=seemore_div2_1>
						<div id=seemore_div2_1left>
							객실이용
						</div>
						<div id=seemore_div2_1right>
							<ul>
								<li>55인치 스마트 TV(위성 TV 48개 채널)</li>
								<li>50~100Mbps 초고속 유·무선(wifi) 인터넷 무</li>
								<li>220V, 110V 전압 사용 가능</li>
								<li>커피·차 티백 무료 제공</li>
								<li>베이비 크립(무료)</li>
							</ul>
						</div>
					</div>
					<hr>
					<div id=seemore_div2_2>
						<div id=seemore_div2_2left>
							부대시설
						</div>
						<div id=seemore_div2_2right>
							<ul>
								<li>피트니스 클럽 이용 안내</li><br>
								<li>- 체육관(Gym) 무료 이용(만 16세 이상 입장 가능)</li>
								<li>- 실내 수영장 무료 이용(만 13세 이상 입장 가능)</li>
								<li>&nbsp;&nbsp;&nbsp;(단, 주말 및 공휴일에는 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;만 13세 미만인 고객이 이용 가능하며,<br>
									&nbsp;&nbsp;&nbsp;신장 140cm 미만인 고객은 성인 보호자의 보호 하에<br>
									&nbsp;&nbsp;&nbsp;구명조끼 착용 시 이용 가능)
								</li><br>
								<li>- 사우나 이용 시 유료(만 13세 이상 입장 가능)</li>
								<li>- 피트니스 클럽은 매월 세 번째 수요일 정기휴일</li><br>
								<li>투숙 기간 내 무료 주차 가능</li>
							</ul>
						</div>
					</div>
				</div>
				<div id=seemore_div3>
				<ul>
					<li>조식 이용 안내</li>
						<li><br>&nbsp;&nbsp;- 더 파크뷰 06:00~10:00(주중/주말/공휴일)</li>
						<li>&nbsp;&nbsp;- 더 라이브러리 08:00~11:30</li>
						<li>&nbsp;&nbsp;&nbsp;※ 현재 더 라이브러리는 코로나19로 인한 운영시간<br>
							&nbsp;&nbsp;&nbsp;&nbsp;축소로 조식 운영을 하지 않고 있사오니 이용에<br>
							&nbsp;&nbsp;&nbsp;&nbsp;참고 부탁드립니다.</li>
					<li><br>체크인/체크아웃 시간</li>
						<li><br>&nbsp;&nbsp;- 체크인 : 오후 2시 이후</li>
						<li>&nbsp;&nbsp;- 체크아웃 : 오전 11시까지</li>
				
					<li><br>취소/변경 및 노쇼(No-show) 안내</li>
						<li><br>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시까지는 위약금 없음</li>
						<li>&nbsp;&nbsp;- 숙박 예정일 1일 전 18시 이후 취소/변경/노쇼 발생 시</li>
					
						<li><br>&nbsp;&nbsp;성수기(5월~10월, 12월 24일~31일)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 80%가 위약금으로 부과</li>
						<li><br>&nbsp;&nbsp;비수기(성수기 외 기간)</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;-> 최초 1일 숙박 요금의 10%가 위약금으로 부과</li>
				</ul>
				</div>
			</div>
	    </div>
</div>

	
	
</div>



<%@ include file="footer.jsp" %>