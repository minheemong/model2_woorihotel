
function idcheck(){
	var url = "hotel.do?command=fineIdPwd";
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250";
	window.open(url, "IdCheck", opt);
}//완료


function findPw(){
	var url = "hotel.do?command=findPwForm";
	var opt = "toolbar=no,menubar=no,scrollbars=no,resizable=no,width=700,";
	opt = opt + "height=500, top=300, left=300";
	window.open(url, "Find Id/Pw", opt);
}

function go_profilePw(){
	document.profileForm.action ="hotel.do?command=profilePw";
	document.profileForm.submit(); 
}

function quit(){
	alert("탈퇴가 완료되었습니다" );
	document.quitOk.action ="hotel.do?command=quit";
	document.quitOk.submit(); 
}
