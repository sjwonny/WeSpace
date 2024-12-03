<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
    border-collapse: separate;
    border-spacing: 15px; /* 원하는 간격으로 설정 */
}
/* 입력 칸 스타일 */
input[type="text"], select, input[type="button"], input[type="radio"], input[type="hidden"] {
    border-radius: 8px; /* 둥근 모서리 */
    border: 2px solid #A66AE1; /* 연보라색 테두리 */
    padding: 5px;
    font-size: 16px; /* 텍스트 크기 */
    outline: none; /* 포커스 시 테두리 색상 변경 방지 */
}

/* 입력칸에 포커스 시 테두리 색상 */
input[type="text"]:focus, select:focus, input[type="radio"]:focus {
    border-color: #8A4F9E; /* 포커스 시 더 진한 보라색 테두리 */
}

/* 버튼 스타일 */
input[type="button"] {
    background-color: #B39DDB;/* 보라색 배경 */
    color: white; /* 흰색 텍스트 */
    border: none; /* 기본 버튼 테두리 제거 */
    cursor: pointer;
    padding: 10px 20px;
    font-size: 16px;
    border-radius: 8px; /* 둥근 모서리 */
}

input[type="button"]:hover {
    background-color: #8A4F9E; /* 버튼에 마우스 올렸을 때 더 진한 보라색 배경 */
}

/* 라디오 버튼 스타일 */
input[type="radio"] {
    border: 2px solid #B39DDB;
    border-radius: 50%;
    padding: 5px;
}

/* 숨겨진 input 필드에도 스타일 적용 */
input[type="hidden"] {
    display: none;
}
</style>
<script>
function input_Bemail(){
	document.insert4.email2.value = document.insert4.email_server.value; //옵션중에 고른것 서버로 전송될 input칸 name에 대입하기
}


function checkBsns(){
	
	 var j = document.insert4; 
	
	if(j.bsns_info_paymethod.value == ""){
		alert("결제방법을 선택하세요");
	}else if(j.bsns_info_bname.value == ""){
		alert("상호명을 입력하세요");
	}else if(j.bsns_info_rname.value == ""){
		alert("대표자명을 입력하세요");
	}else if(j.bsns_info_mainbsns.value == ""){
		alert("주업태를 입력하세요");
	}else if(j.bsns_info_mainevent.value == ""){
		alert("주종목을 입력하세요");
	}else{
		
		j.bsns_info_bnumber.value =  j.bsns_info_bnumber1.value +"-"+ j.bsns_info_bnumber2.value +"-"+ j.bsns_info_bnumber3.value;
		j.bsns_info_phone.value =  j.tel1.value + j.tel2.value + j.tel3.value;
		j.bsns_info_badr.value =  j.address.value + "_" + j.Deaddress.value;
		j.submit();
	} 
}    


function updateBImage(input) { 
    var image = document.getElementById('uploaded-image');
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {
        image.src = e.target.result;
      };
      reader.readAsDataURL(input.files[0]);
    }
  }


</script>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center"><h2>사업자 정보</h2></div>
<div align="left" style="margin: 0px 600px 0px 600px;">
<form action="${pageContext.request.contextPath}/space_reg/insert4" method="post" name = "insert4">
	<input type="hidden" name="space_info_no" value="${space_info_no }">
	<input type="hidden" name="contact_info_no" value="${contact_info_no }">
	<input type="hidden" name="usage_info_no" value="${usage_info_no }">
<h3>결제방법을 선택해주세요</h3>
<hr class="separator separator--line" />
	<table>
		<tr>
			<td>
				<label for="quick">바로결제</label> <input type="radio" id="quickpay" name="bsns_info_paymethod" value="0" checked>
				<label for="slow">승인결제</label> <input type="radio" id="slowpay" name="bsns_info_paymethod" value="1">
			</td>
		</tr>
	</table>

<h3>전산정보를 입력해주세요</h3>
<hr class="separator separator--line" />
	<table>
		<tr>
		    <td><label for="bsns_info_bname">상호명(개인/법인)*</label></td>

		    <td><input type="text" name="bsns_info_bname" id="bsns_info_bname"></td>
		</tr>
		<tr>
		    <td><label for="bsns_info_rname">대표자명*</label></td>

		    <td><input type="text" name="bsns_info_rname" id="bsns_info_rname"></td>
		</tr>
		<tr>
		    <td><label for="bsns_info_bnumber">사업자 등록번호</label></td>
			<td><input type="text" name="bsns_info_bnumber1" id="bsns_info_bnumber1">
			<input type="text" name="bsns_info_bnumber2" id="bsns_info_bnumber2">
			<input type="text" name="bsns_info_bnumber3" id="bsns_info_bnumber3">
			<input type="hidden" name = "bsns_info_bnumber"></td>
		</tr>
	  	<tr>
	  	<td><label for="bsns_type_no">사업자 유형*</label></td>
        <td><c:forEach var="bt" items="${btlist}">
        <lable for = "bsns_type_name">${bt.bsns_type_name}</lable>
        <input type="radio" id="type${bt.bsns_type_no}" name="bsns_type_no"  value="${bt.bsns_type_no}">
        </c:forEach>
        </td>
	  	</tr>
	  	
	  	<tr>
		    <td><label for="bsns_info_mainbsns">주업태*</label></td>

			<td><input type="text" name="bsns_info_mainbsns" id="bsns_info_mainbsns"></td>
	    </tr>
	  	<tr>
		    <td><label for="bsns_info_mainevent">주종목*</label></td>

			<td><input type="text" name="bsns_info_mainevent" id="bsns_info_event"></td>
	    </tr>
	    <tr>
	        <td><label for="bsns_info_badr">사업장 주소*</label>
			<td>
			<input type="hidden" name = "bsns_info_badr">
			<input type="text" id="Baddress" name="address" readonly placeholder="주소 검색"></td>
		</tr>
		<tr>
		<td></td>
			<td><input type="text" name = "Deaddress" placeholder="상세주소를 입력해 주세요"></td>
		</tr>
		<tr>
			<td><label for="bsns_info_phone">정산용 연락처*</label></td>
			<td>
			<select name = "tel1" id="tel1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="019">019</option>
					<option value="019">070</option>
				</select>
			&nbsp; - &nbsp;<input  type="text" name = "tel2" id="tel2" >
			&nbsp; - &nbsp;<input  type="text" name = "tel3" id="tel3">
			<input type="hidden" name = "bsns_info_phone"></td>
		</tr>
    </table>
<h3>계좌 정보를 입력해주세요</h3>
<hr class="separator separator--line" />
	<table>
	<tr>
	   <td><label for="bank">은행명*</label></td>
	   <td><label for="account_info_num">계좌번호*</label></td>
	   <td><label for="bsns_info_name">예금주*</label></td>
	</tr>
	<tr>
	   <td>
	     <select name ="bank_no" >
		    <c:forEach var="vo" items="${blist }" >
	     	 <option value="${vo.bank_no}">${vo.bank_name}</option>
			</c:forEach>
		 </select>
	  </td>
	   <td><input type="text" name="account_info_num" id="account_info_num"></td>
	   <td><input type="text" name="account_info_name" id="account_info_name"></td>
	</tr>
	</table>
<h3>환불기준을 입력해주세요</h3>
    <hr class="separator separator--line" /> 
			이용 당일&nbsp&nbsp : 총 금액의         <!-- day0이 아니고 dday라서 따로 뺌 -->
			<select id="dday"  name="dday">
			        <option value="10">100%</option> 
					<option value="9">90%</option> 
					<option value="8">80%</option> 
					<option value="7">70%</option> 
					<option value="6">60%</option> 
					<option value="5">50%</option>
					<option value="4">40%</option>
					<option value="3">30%</option>
					<option value="2">20%</option>
					<option value="1">10%</option>
					<option value="0">환불불가</option>
			</select> 환불<br>
			<c:forEach begin="1" end="7" step="1" var="day">
			<br>
			이용 ${day}일 전 : 총 금액의 
			<select  id="day${day}" name="day${day}">
			        <option value="100">100%</option>
					<option value="90">90%</option>
					<option value="80">80%</option>
					<option value="70">70%</option>
					<option value="60">60%</option>
					<option value="50">50%</option>
					<option value="40">40%</option>
					<option value="30">30%</option>
					<option value="20">20%</option>
					<option value="10">10%</option>
					<option value="0">환불불가</option>
			</select>
		    환불<br>
		    </c:forEach>
		    <br>
		    이용 8일 전 : 총 금액의 100% 환불
			<div align="center">
				<input type="button" value="이전" onclick="javascript:history.back();">
				<input type="button" id ="insertBsns" value="저장" onclick="javascript:checkBsns()" >
				</div>
		    <br><br><br><br><br>
</form>

   
 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script>
window.onload = function(){
    document.getElementById("Baddress").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("Baddress").value = data.address; // 주소 넣기
                document.querySelector("input[name=Deaddress]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}

</script>





</div>









</body>
</html>