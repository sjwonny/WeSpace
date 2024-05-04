<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ccc;
}

th, td {
	padding: 10px;
	text-align: left;
}

input[type="text"], input[type="password"], input[type="date"] {
	width: 100%;
	padding: 8px;
	margin: 4px 0;
}

label {
	font-weight: bold;
}

#checkButton {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 5px 10px;
	cursor: pointer;
}

#joinButton {
	background-color: #28a745;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}

#resetButton {
	background-color: #dc3545;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}
</style>

<script>
	function checkJoin() {

		if (document.join.host_nick.value == "") {
			alert("닉네임을 입력하십시오!");
		} else if (document.getElementById("check").textContent != "사용 가능한 닉네임입니다") {
			alert("닉네임 중복 확인을 해주십시오.");
			return;
		} else if (document.join.host_email.value == "") {
			alert("이메일을 입력하십시오!");
		} else if (document.join.host_pw.value == "") {
			alert("비밀번호를 입력하십시오!");
		} else if (document.join.passwordConfirm.value == "") {
			alert("비밀번호 확인칸을 입력하십시오!");
		} else if (document.join.host_pw.value != document.join.passwordConfirm.value) {
			alert("비밀번호가 일치하지 않습니다.");
		} else if (document.join.host_name.value == "") {
			alert("이름을 입력하십시오!");
		} else {
			document.join.submit();
		}
	}

	//닉네임 중복 체크
	function checkId(f) {
		if (f.host_nick.value == "") {
			alert("닉네임을 입력하십시오!");
			return;
		}

		var url = "${pageContext.request.contextPath}/host/checkId";
		var param = "host_nick=" + encodeURIComponent(f.host_nick.value);

		sendRequest(url, param, resultFn, "POST");
	}

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//도착된 데이터를 읽어오기
			var data = xhr.responseText;
			const join = document.getElementById("join");
			const check = document.getElementById('check');
			const host_nick = document.getElementById('host_nick');

			check.innerText = '';

			console.log(data);

			if (data === '사용 가능한 닉네임입니다') {
				check.style.cssText = "color: blue; font-size: 10px;";
				join.disabled = false;
				host_nick.readOnly = true;
			} else {
				check.style.cssText = "color: red; font-size: 10px;";
				join.disabled = true;
			}

			check.innerText = data;
		}
	}
	//닉네임 중복체크 끝

	//닉네임 유효성 검사
	/*  function validateNickname(nick) {
	   // 닉네임은 두 글자 이상이어야 합니다.
	   if (nick.length < 2) {
	       return false;
	   }

	   // 특수문자가 포함되어서는 안 됩니다.
	   var re = /[!@#$%^&*(),.?":{}|<>]/;
	   if (re.test(nick)) {
	       return false;
	   }

	   return true;
	}
	
	 function validateNickSubmit() {

	
	  var host_nick = document.getElementById("host_nick");
	    var nick = host_nick.value; 

	if (validateNickname(nick)) {
	 nickError.innerText ="유효한 닉네임입니다.";
	 nickError.style.color = "blue";
	} else {
	 nickError.innerText ="닉네임은 두 글자 이상이어야 하며 특수문자를 포함해서는 안됩니다.";
	 nickError.style.color = "red";
	}
	 }  */
	//닉네임 유효성 검사 끝
	//이메일 유효성 검사
	function validateEmail(email) {
		var re = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-za-z0-9\\-]+/;
		return re.test(email);
	}

	function validateEmailSubmit() {
		var host_email = document.getElementById("host_email");
		var email = host_email.value;

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
		var re = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,30}$/;
		return re.test(pw);
	}

	function validatePwSubmit() {
		var host_pw = document.getElementById("host_pw");
		var pw = host_pw.value;

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
	function validatePhoneSubmit(host_phone) {
		host_phone.value = host_phone.value.replace(/\D/g, ''); // 숫자 이외의 문자는 제거
	}
	//끝
</script>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<form action="${ pageContext.request.contextPath }/host/join" method="post" name = "join">
    <table>
        <tr>
            <td><label for="host_nick">닉네임</label></td>
            <td>
                <input type="text" id="host_nick" name="host_nick" autocomplete="off" onblur="validateNickSubmit()">
               
                <input type="button" value="중복체크" onclick="checkId(this.form)">
                
               <span id="check"></span> 
             
            </td>
        </tr>
        <tr>
            <td><label for="host_email">이메일</label></td>
            <td><input type="text" name="host_email" id="host_email" onblur="validateEmailSubmit()"><br>
            <span id="emailError"></span>
            </td>
            
        </tr>
        <tr>
            <td><label for="host_pw">비밀번호</label></td>
            <td><input type="password" name="host_pw" id="host_pw" onblur="validatePwSubmit()">
            <span id="pwError"></span>
           </td>
        </tr>
        <tr>
            <td><label for="passwordConfirm">비밀번호 확인</label></td>
            <td><input type="password" id="passwordConfirm" aria-required="true" value=""></td>
        </tr>
        <tr>
            <td><label for="host_phone">전화번호</label></td>
            <td><input type="text" name="host_phone" id="host_phone" placeholder="-없이 입력해 주세요" onblur="validatePhoneSubmit(this)"></td>
        </tr>
        <tr>
        <td> <label>수신동의</label></td>
            <td>
                <label for="email_agree">이메일 수신동의</label>
                <input type="checkbox" id="email_agree" name="email_agree" value="1">
                <label for="sns_agree">SNS 수신동의</label>
                <input type="checkbox" id="sns_agree" name="sns_agree" value="1">
                </td></tr>
                 <tr> <td> 
                 <label>sns연동</label></td>
                <td><label for="snscnnt_agree">네이버 연동</label>
                 <input type="checkbox" id="snscnnt_agree" name="snscnnt_agree" value="1">
            </td>
        </tr>
        <tr>
            <td><label for="host_name">이름</label></td>
            <td><input type="text" name="host_name"></td>
        </tr>
        <tr>
            <td><label>성별</label></td>
            <td>
                <label for="male">남성</label>
                <input type="radio" id="male" name="host_gender" value="남성" checked>
                <label for="female">여성</label>
                <input type="radio" id="female" name="host_gender" value="여성">
            </td>
        </tr>
        <tr>
            <td><label for="host_birth">생일</label></td>
            <td><input type="date" name="host_birth"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="button" id="join" value="회원가입" onclick="javascript:checkJoin()">
                <input type="button" id="resetButton" value="Reset" onclick="document.join.reset()">
            </td>
        </tr>
    </table>
    </form>
