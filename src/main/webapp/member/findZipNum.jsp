<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findZipNum.jsp</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');
body{font-family:Verdana; font-size:90%;}
#popup{padding:0 10px;}

table#zipcode{border-collapse:collapse; border-top:2px solid #9f876b; border-bottom:2px solid #9f876b;
margin-top:15px; width:100%; font-size:100%;}
table#zipcode th{background:#faf1d0;}
table#zipcode th, table#zipcode td{text-align:center; border-bottom:1px dotted #9f876b; font-size:90%;}
table td, th{padding:8px;}
table#zipcode a{display:block; height:8px; text-decoration:none; padding:8px; font-size:90%;}
table#zipcode a:hover{font-weight:bold;}

input{border:#BEBBB9 solid 1px;}
</style>
<script type="text/javascript">
function result(zip_num, sido, gugun, dong){
	opener.document.joinFrm.zip_num.value=zip_num;
	opener.document.joinFrm.addr1.value=sido+" "+gugun+" "+dong;
	self.close();
}
</script>
</head>
<body>
<div id="popup">
	<h3>우편번호 검색</h3>
	<form method="post" name="formm" action="hotel.do">
		<input type="hidden" name="command" value="findZipNum">
		동이름 : <input name="dong" type="text">
		<input type="submit" value="찾기" class="dup_brown">
	</form>
	<!-- 검색된 우편번호와 동이 표시되는 곳 -->
	<table id="zipcode">
		<tr><th width="100">우편번호</th><th>주소</th></tr>
		<c:forEach items="${addressList}" var="addressDto">
			<tr>
				<td>${addressDto.zip_num}</td>
				<!-- onClick="result(우편번호, 시도, 구군, 동);" -->
				<td><a href="#" onClick="result('${addressDto.zip_num}',
				'${addressDto.sido}', '${addressDto.gugun}', '${addressDto.dong}' );">
				${addressDto.sido} ${addressDto.gugun} ${addressDto.dong} ${addressDto.bunji}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>