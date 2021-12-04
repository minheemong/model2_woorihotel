function go_search_booknum(){
	if(document.frm.booknums.value=="") return;
	document.frm.checkins.value="";
	document.frm.checkouts.value="";
	document.frm.bookid.value="";
	
	var url = "hotel.do?command=adminbookList&page=1";
	document.frm.action=url;
	document.frm.submit();
}


function go_total_check(){
	document.frm.booknums.value="";
	document.frm.checkins.value="";
	document.frm.checkouts.value="";
	document.frm.bookid.value="";
	var url = "hotel.do?command=adminbookList&page=1";
	document.frm.action=url;
	document.frm.submit();
}


function go_search_checkdate(){
	if(document.frm.checkins.value==null && document.frm.checkouts.value==null) return;
	document.frm.booknums.value="";
	document.frm.bookid.value="";
	
	if(document.frm.checkins.value.length!=null && document.frm.checkouts.value==null){
		if(document.frm.checkins.value.length!=8){
			alert("날짜 형식이 잘못되었습니다.");
			alert(document.frm.checkins.value.length);
			return;
		}
	} else if(document.frm.checkins.value==null && document.frm.checkouts.value.length!=null){
		if(document.frm.checkouts.value.length!=8){
			alert("날짜 형식이 잘못되었습니다.");
			alert(document.frm.checkouts.value.length);
			return;
		}
	}
	
	var url = "hotel.do?command=adminbookList&page=1";
	document.frm.action=url;
	document.frm.submit();
}




function go_search_bookid() {
	if(document.frm.bookid.value=="") return;
	document.frm.booknums.value="";
	document.frm.checkins.value="";
	document.frm.checkouts.value="";
	
	var url = "hotel.do?command=adminbookList&page=1";
	document.frm.action=url;
	document.frm.submit();
	
}




function go_search_dateANDid() {
	if(document.frm.bookid.value=="") return;
	if(document.frm.checkins.value=="" && document.frm.checkouts.value=="") return;
	document.frm.booknums.value="";
	
	if(document.frm.checkins.value.length!=null && document.frm.checkouts.value==null){
		if(document.frm.checkins.value.length!=8){
			alert("날짜 형식이 잘못되었습니다.");
			alert(document.frm.checkins.value.length);
			return;
		}
	} else if(document.frm.checkins.value==null && document.frm.checkouts.value.length!=null){
		if(document.frm.checkouts.value.length!=8){
			alert("날짜 형식이 잘못되었습니다.");
			alert(document.frm.checkouts.value.length);
			return;
		}
	}
	
	var url = "hotel.do?command=adminbookList&page=1";
	document.frm.action=url;
	document.frm.submit();
}




function confirmbookcancel(){
	var url="";
	if(document.frm.gotonum.value=="1"){
		url = "hotel.do?command=adminbookcancel&bdseq="
		+document.frm.bookdetailnum.value+"&gotonum="+document.frm.gotonum.value;
		/*alert(document.frm.gotonum.value);*/
	} else if(document.frm.gotonum.value=="2"){
		url="hotel.do?command=adminbookcancel&bdseq="
		+document.frm.bookdetailnum.value+"&gotonum="+document.frm.gotonum.value;
	}
	
	if(window.confirm(document.frm.bookdetailname.value+" 님의 예약을 정말로 취소하시겠습니까?")){
		/*alert(document.frm.gotonum.value);
		alert(url);*/
		document.frm.action=url;
		document.frm.submit();
	} else return;
	
}

function go_order_save(){
	var count = 0;
	if(document.frm.result.length == undefined){
		if(document.frm.result.checked == ture) count ++;
	}else {
		for (var i =0; i<document.frm.result.length; i++){
			if(document.frm.result[i].checked == true) count++;
		}
	}
	if(count ==0){
		alert("주문처리할 항목을 선택해 주세요.");
	}else{
		document.frm.action ="hotel.do?command=adminBookSave";
		document.frm.submit();
	}
}



