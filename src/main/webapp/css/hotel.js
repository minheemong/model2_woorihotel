function go_search_booknum(){
	document.frm.checkins.value="";
	document.frm.checkouts.value="";
	
	if(document.frm.booknums.value=="") return;
	
	var url = "hotel.do?command=bookChecklist&page=1";
	document.frm.action=url;
	document.frm.submit();
}


function go_total_check(){
	document.frm.booknums.value="";
	document.frm.checkins.value="";
	document.frm.checkouts.value="";
	var url = "hotel.do?command=bookChecklist&page=1";
	document.frm.action=url;
	document.frm.submit();
}


function go_search_checkdate(){
	document.frm.booknums.value="";
	if(document.frm.checkins.value==null && document.frm.checkouts.value==null) return;
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
	
	var url = "hotel.do?command=bookChecklist&page=1";
	document.frm.action=url;
	document.frm.submit();
}