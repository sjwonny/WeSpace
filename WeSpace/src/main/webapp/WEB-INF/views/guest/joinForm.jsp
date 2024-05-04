<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<style>
    form {
        max-width: 400px;
        margin: 0 auto;
        background-color: #f9f9f9;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="password"],
    input[type="date"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin-bottom: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="button"] {
        width: 45%;
        padding: 12px;
        border: none;
        border-radius: 4px;
        background-color: #2CBEB1;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="button"]:hover {
        background-color: #2CBEB1;
    }

    input[type="button"]:last-child {
        background-color: #2CBEB1;
    }

    input[type="button"]:last-child:hover {
        background-color: #2CBEB1;
    }

    .button-group {
        display: flex;
        justify-content: space-between;
    }
</style>

<form action="${ pageContext.request.contextPath }/guest/join" method="post" name="join">
    <label for="guest_nickname">닉네임</label>
    <input type="text" id="guest_nickname" name="guest_nickname" autocomplete="off">
    <input type="button" value="중복체크" onclick="checkId(this.form)">
    <span id="check"></span>

    <label for="guest_email">이메일</label>
    <input type="text" name="guest_email" id="guest_email" onblur="validateEmailSubmit()">
    <span id="emailError"></span>

    <label for="guest_pw">비밀번호</label>
    <input type="password" name="guest_pw" id="guest_pw" onblur="validatePwSubmit()">
    <span id="pwError"></span>

    <label for="passwordConfirm">비밀번호 확인</label>
    <input type="password" id="passwordConfirm" aria-required="true" value="">

    <label for="guest_phone">전화번호</label>
    <input type="text" name="guest_phone" id="guest_phone" placeholder="-없이 입력해 주세요" onblur="validatePhoneSubmit(this)">

    <label for="guest_name">이름</label>
    <input type="text" name="guest_name">

    <label>성별</label>
    <div>
        <label for="gender">
        남성
        <input type="radio" id="male" name="guest_gndr" value="남성" checked>
        여성
        <input type="radio" id="female" name="guest_gndr" value="여성"></label>
    </div>

    <label for="guest_birth">생일</label>
    <input type="date" name="guest_birth">

    <div class="button-group">
        <input type="button" id="join" value="회원가입" onclick="javascript:checkJoin()">
        <input type="button" id="resetButton" value="Reset" onclick="document.join.reset()">
    </div>
</form>
   <script>
    
    function checkJoin() {
	   
    	if (document.join.guest_nickname.value == "") {
			alert("닉네임을 입력하십시오!");
		} else if (document.getElementById("check").textContent != "사용 가능한 닉네임입니다") {
			alert("닉네임 중복 확인을 해주십시오.");
			return; 
	    } else if (document.join.guest_email.value == "") {//guest_emaill은 id가 아니고 name임
			alert("이메일을 입력하십시오!");
		} else if (document.join.guest_pw.value == "") {
			alert("비밀번호를 입력하십시오!");
		} else if (document.join.passwordConfirm.value == "") {
			alert("비밀번호 확인칸을 입력하십시오!");
		} else if (document.join.guest_pw.value != document.join.passwordConfirm.value) {
			alert("비밀번호가 일치하지 않습니다.");
		} else if(document.join.guest_name.value == ""){
			alert("이름을 입력하십시오!");
		} else {
			document.join.submit();
		}
	} 
    
	//닉네임 중복 체크
	function checkId(f) {
		if(f.guest_nickname.value == ""){
			alert("닉네임을 입력하십시오!");
			return;
		}
		
		var url = "${pageContext.request.contextPath}/guest/checkId";
		var param = "guest_nickname=" + encodeURIComponent(f.guest_nickname.value); // "guest_nickname" 파라미터에 사용자가 입력한 닉네임을 추가하고, encodeURIComponent 함수를 사용하여 URL에서 사용 가능한 형식으로 인코딩
		
		sendRequest(url,param,resultFn,"POST"); 
	} 
	 
	function resultFn(){ // AJAX를 사용하여 서버로 요청을 보내는 함수인 sendRequest를 호출합니다. 이 함수는 url에 POST 방식으로 param을 전송하고, 응답이 도착하면 resultFn 함수를 호출합니다.
		if(xhr.readyState==4 && xhr.status==200) { //resultFn() 함수: 이 함수는 AJAX 요청이 완료되었을 때 호출되는 콜백 함수
			//도착된 데이터를 읽어오기                     //if(xhr.readyState==4 && xhr.status==200): AJAX 요청의 상태(xhr.readyState)가 4(요청이 완료됨)이고, HTTP 응답 상태 코드(xhr.status)가 200(성공)인지 확인
			var data = xhr.responseText; // 서버에서 반환된 응답 데이터를 읽어와 data 변수에 저장
			const join = document.getElementById("join");
			const check = document.getElementById('check'); //  <span id="check"></span> 
			const guest_nickname = document.getElementById('guest_nickname');
			
			check.innerText = ''; //중복 확인 결과를 표시하는 check 요소의 텍스트를 초기화
			
			console.log(data); //서버에서 받은 데이터를 콘솔에 출력
			
			if(data === '사용 가능한 닉네임입니다'){
				check.style.cssText="color: blue; font-size: 10px;";
				join.disabled=false; //"가입" 버튼을 활성화
				guest_nickname.readOnly = true; //닉네임 입력 필드를 읽기 전용으로 설정
			}else{
				check.style.cssText="color: red; font-size: 10px;";	
				join.disabled=true; //"가입" 버튼 비활성화
			}
			
			check.innerText = data; //check 요소의 텍스트를 서버에서 반환한 내용으로 설정하여 사용자에게 메시지를 표시
		}
	}   
    //닉네임 중복체크 끝
    
     
     
       //이메일 유효성 검사
      function validateEmail(email) {
         var re = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-za-z0-9\\-]+/;
         return re.test(email);
     }

     function validateEmailSubmit() {
         var guest_email = document.getElementById("guest_email");
         var email = guest_email.value; 

         if (validateEmail(email)) {
             emailError.innerText = "유효한 이메일 주소입니다.";
             emailError.style.color = "blue";
         } else {
             emailError.innerText = "유효하지 않은 이메일 주소입니다.";
             emailError.style.color = "red";
         }
     }
     //이메일 유효성 검사 끝
     
     
 
       //비밀번호 유효성 검사
		function validatePw(pw) {
	         var re =/^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,30}$/;
	         return re.test(pw);
	     }

	     function validatePwSubmit() {
	         var guest_pw = document.getElementById("guest_pw");
	         var pw = guest_pw.value; 

	         if (validatePw(pw)) {
	             pwError.innerText = "유효한 비밀번호입니다.";
	             pwError.style.color = "blue";
	         } else {
	             pwError.innerText = "비밀번호는 영문, 숫자, 특수문자 조합하여 8~30자여야 합니다.";
	             pwError.style.color = "red";
	         }
	     }
     //비밀번호 유효성 검사 끝
     
     //전화번호 형식 확인
		function validatePhoneSubmit(guest_phone) {
			guest_phone.value = guest_phone.value.replace(/\D/g, ''); // 숫자 이외의 문자는 제거
		}
     //끝
     

  
    </script>
   