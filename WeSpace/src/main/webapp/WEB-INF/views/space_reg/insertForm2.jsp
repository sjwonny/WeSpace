<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
    <style>
   .hidden{
      display: none;
   }
    ul {
        list-style-type: none;
        padding: 0;
    } 
    li {
    	list-style-type: none;
        border: 1px solid #ccc;
        cursor: pointer;
        float:left;
        width:200px;
  		height:30px;
  		font-size:15px;
  		text-align:center;    
  		background-color:#FFFFFF;    
    }
    
   .lfsty-span {
       display: block; 
        margin-bottom: 10px; /* 원하는 여백 크기로 조정하세요 */
    }
  /*  선택하면 색깔 바꾸기 */
    li{font-size:20px}
    .clear{clear:both}
    li.on{color:blue; background-color:#CCE5FF;}
    li.in{color:red;}
    
    .ins1 {
  width:70px;
  height:40px;
  font-size:15px;
  text-align:center;
	}
	.ins2 {
  width:110px;
  height:40px;
  font-size:18px;
  text-align:center;
	}
	.ins3 {
  width:250px;
  height:40px;
  font-size:18px;
  text-align:center;
	}
	.btn1 {
  width:200px;
  height:30px;
  font-size:15px;
  text-align:center;
	}
	.btn2 {
  width:80px;
  height:30px;
  font-size:15px;
  text-align:center;
	}
	/* 입력 칸 스타일 */
input[type="text"], select, input[type="button"] {
    border-radius: 8px; /* 둥근 모서리 */
    border: 2px solid #A66AE1; /* 연보라색 테두리 */
    padding: 5px;
    font-size: 16px; /* 텍스트 크기 */
    outline: none; /* 포커스 시 테두리 색상 변경 방지 */
}

/* 입력칸에 포커스 시 테두리 색상 */
input[type="text"]:focus, select:focus {
    border-color: #8A4F9E; /* 포커스 시 더 진한 보라색 테두리 */
}

/* 버튼 스타일 */
input[type="button"] {
    background-color: #B39DDB; /* 보라색 배경 */
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
</style>   
<script>
	function input_email(){
		document.insert2.e2.value = document.insert2.email_server.value; //옵션중에 고른것 서버로 전송될 input칸 name에 대입하기
	}
	
	function checkJoin(){
		
		var j = document.insert2;
		
 		if(j.e1.value == ""){
			alert("이메일입력!");
		}else if(j.tel1.value == ""){
			alert("번호입력!");
		}else{
			j.contact_info_email.value =  j.e1.value + "@" + j.e2.value;
			j.contact_info_phone.value =  j.tel1.value + j.tel2.value + j.tel3.value;
			j.contact_info_main.value =  j.dtel1.value + j.dtel2.value + j.dtel3.value;
			j.submit();
		} 
	}    
	
	
	function makeVcall() {
		var vcallSpan = document.getElementById('vcallDisplay'); //이미 가상번호가 나와있음(1번만 생성하게)
		if (vcallSpan.innerText !== ''){
			alert("가상번호는 이미 생성되었습니다");
			return;
		}
	    // 가상번호 길이 설정
	    var vcallLength = 12;

	    // 가상번호 생성
	    var vcall = '';
	    for (var i = 0; i < vcallLength; i++) {
	        var randNum = Math.floor(Math.random() * 10); // 0부터 9까지의 랜덤한 숫자 생성
	        vcall += randNum;

	        // - 표시 추가 (4번째 자리마다)
	        if ((i + 1) % 4 === 0 && i !== vcallLength - 1) {
	            vcall += "-";
	        }
	    }

	    // 생성된 가상번호를 화면에 표시
	    document.getElementById('vcallDisplay').innerText = vcall;
	    document.getElementById('vcallNum').value = vcall;
	}
	    
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<h2>연락처 정보를 입력해주세요</h2>
<form action="${ pageContext.request.contextPath }/space_reg/insert2" method="post" name = "insert2">
    <input type="hidden" name="space_info_no" value="${space_info_no}">
	<table>
		<tr>
			<td><h3>이메일*</h3></td>
			<td>
			<input class= "ins2" name="e1" id="e1" type="text" style="width:120px" > &nbsp; @ &nbsp; 
			<input class= "ins2" name="e2" type="text" style="width:120px" >
			<input type="hidden" name = "contact_info_email">
		<select name="email_server" id="email_server" onchange="input_email();">
		
			<option value="">직접입력</option>
		
			<option value="naver.com">naver.com</option>
		
			<option value="nate.com">nate.com</option>
		
			<option value="hanmail.net">hanmail.net</option>
		
			<option value="gmail.com">gmail.com</option>
		
			<option value="yahoo.com">yahoo.com</option>
		
			<option value="yahoo.co.kr">yahoo.co.kr</option>
		
			<option value="hotmail.com">hotmail.com</option>
		
		</select>
			
			</td>
		</tr>
		
		<tr>
			<td><h3>휴대폰*</h3></td>
			<td>
			<select class = "ins1" name = "tel1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="019">019</option>
					<option value="019">070</option>
				</select>
			&nbsp; - &nbsp;<input class = "ins1" type="text" name = "tel2" >
			&nbsp; - &nbsp;<input class = "ins1" type="text" name = "tel3" >
			<input type="hidden" name = "contact_info_phone"></td>
		</tr>
		
		
		<tr>
			<td><h3>대표번호*</h3></td>
			<td>
			<input class = "ins1" type="text" name = "dtel1" >
			&nbsp; - &nbsp;<input class = "ins1" type="text" name = "dtel2" >
			&nbsp; - &nbsp;<input class = "ins1" type="text" name = "dtel3" >
			<input type="hidden" name = "contact_info_main"></td>
		</tr>
		<tr>
			<td><h3>가상번호*</h3></td>
			<td>
			<input class = "ins3" type="hidden" name = "contact_info_vrtl" id="vcallNum" >
			<span id="vcallDisplay"></span>
			<input type="button" value="생성" onclick="makeVcall()"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="이전" onclick="javascript:history.back();">
				<input type="button" id ="insert" value="다음" onclick="javascript:checkJoin()" >
			</td>
		</tr>
	</table>		
</form>
</div>
        
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>











