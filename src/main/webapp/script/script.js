

function book_go1(kind){
   document.formm.kind.value= kind;
   document.formm.action = "hotel.do?command=book";
   document.formm.submit();
}

  function checkRoom () {
      var checkinStr =  document.formm.checkin.value;
      var checkoutStr = document.formm.checkout.value;
      var checkin = new Date(checkinStr);
      var checkout = new Date(checkoutStr);
      
   if (checkinStr == ""){
      alert("입실날짜를 입력하세요.");
      return false;
   } else if (checkoutStr == ""){
      alert("퇴실날짜를 입력하세요.");
      return false;
   } else if (document.formm.roomnum.value == ""){
      alert("객실갯수를 입력하세요.");
      document.formm.roomnum.focus();
      return false;
   } else if (document.formm.usernum.value ==""){
      alert("인원수를 입력하세요.");
      document.formm.usernum.focus();
      return false;
   } else if (checkin >= checkout){
      alert("예약날짜오류. 예약날짜를 확인하세요.");
      return false;
   }
   return true;
}

function bookcheckpopup(){
	var url = ".html";
	var option="width:880px; "
	window.open(url,"",option);
}
function loginCheck(){
	
	if(document.loginFrm.id.value == ""){
		alert("아이디를 입력하세요");
		document.loginFrm.id.focus();
		return false;
	}
	if(document.loginFrm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		document.loginFrm.pwd.focus();
		return false;
	}
	return true;
}


function go_next(){
	// 자바스크립트에서 jsp 페이지 내의 radio 버튼을 바라볼때, 같은 name의 radio가 여러개라면
	// name  값에 의한 배열로 인식되어 사용됩니다.   
	// 동의함 버튼 : okon[0],  동의안함  버튼 : okon[1]  
	if( document.contractFrm.okon1[1].checked == true ){
		alert('약관에 동의하셔야 회원 가입이 가능합니다.');
	} else if( document.contractFrm.okon2[1].checked == true ){
		alert('약관에 동의하셔야 회원 가입이 가능합니다.');
	} else if( document.contractFrm.okon3[1].checked == true ){
		alert('약관에 동의하셔야 회원 가입이 가능합니다.');
	} else{
		//  스크립트 명령으로 폼의 액션 설정하고 submit  실행
		document.contractFrm.action ="hotel.do?command=joinForm";
		document.contractFrm.submit(); 
	}
}//







function idcheck(){
   if( document.joinFrm.id.value=="" ){
      alert("아이디를 입력하세요" );
      documnet.joinFrm.id.focus();
      return;
   }
   var url = "hotel.do?command=idCheckForm&id=" + document.joinFrm.id.value;
   var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=200";
   window.open(url, "IdCheck", opt);
}



function idok(userid){
	opener.joinFrm.id.value=userid;
	opener.joinFrm.reid.value=userid;
	self.close();
}







function post_zip(){
   var url = "hotel.do?command=findZipNum";
   var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=550,";
   opt = opt + " height=300, top=300, left=300";
   window.open( url, "우편번호 찾기", opt );
}




function result(zip_num, sido, gugun, dong){
	opener.document.joinFrm.zip_num.value=zip_num;
	opener.document.joinFrm.addr1.value=sido+" "+gugun+" "+dong;
	self.close();
}//완료


function go_save(){
	if (document.joinFrm.id.value == "") {
		alert("아이디를 입력하여 주세요."); 	    
	    document.joinFrm.id.focus();
	} if(document.joinFrm.reid.value != document.joinFrm.id.value){
		alert("아이디 중복확인을 하지 않았습니다");		
		document.joinFrm.id.focus();
	} if(document.joinFrm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");	    
	    document.joinFrm.pwd.focus();
	} if(document.joinFrm.pwd.value != document.joinFrm.pwdCheck.value) {
	    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");	    
	    document.joinFrm.pwd.focus();
	} if(document.joinFrm.name.value == "") {
	    alert("이름을 입력해 주세요.");	    
	    document.joinFrm.name.focus();
	} if(document.joinFrm.email.value == "") {
	    alert("이메일을 입력해 주세요.");	   
	    document.joinFrm.email.focus();
	}  if(document.joinFrm.phone.value == "") {
	    alert("전화번호를 입력해 주세요.");	   
	    document.joinFrm.phone.focus();
	} if(document.joinFrm.zip_num.value == "") {
	    alert("주소를 입력해 주세요.");	   
	    document.joinFrm.zip_num.focus();
	} else{
		document.joinFrm.action = "hotel.do";
	    document.joinFrm.submit();
	}
}








function go_update(){
	if (document.joinFrm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");
	    document.joinFrm.pwd.focus();
	}else if ((document.joinFrm.pwd.value != document.joinFrm.pwdCheck.value)) {
	    alert("비밀번호가 일치하지 않습니다.");
	    document.joinFrm.pwd.focus();
	}else if (document.joinFrm.name.value == "") {
	    alert("이름을 입력해 주세요.");
	    document.joinFrm.name.focus();
	} else if (document.joinFrm.email.value == "") {
	    alert("이메일을 입력해 주세요.");
	    document.joinFrm.email.focus();
	}else {
	    document.joinFrm.action = "hotel.do";
	    document.joinFrm.submit();
	}
}


function move_login(){
	document.joinComFrm.action='hotel.do?command=loginForm';
	document.joinComFrm.submit();
}



function find_id(){
   var url = "hotel.do?command=findIdPwd";
   var opt = "toolbar=no,menubar=no,scrollbars=no,resizable=no,width=500,";
   opt = opt + "height=250, top=300, left=300";
   window.open(url, "Find Id/Pw", opt);
}





