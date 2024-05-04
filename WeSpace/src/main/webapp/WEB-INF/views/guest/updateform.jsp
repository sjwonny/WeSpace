<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function insertCheck(f) {

	var guest_name = document.getElementById("guest_name").value;
	if (guest_name === '') {
		alert("이름을 입력하세요!");
		return false;
	}

	var url = "${pageContext.request.contextPath}/guest/update";

	f.action = url;
	f.submit();
}


   
function checkId(f) { //닉네임 중복검사

	if (f.guest_nickname.value == "") {
		alert("닉네임을 입력하십시오!");
		return;
	}

	var url = "${pageContext.request.contextPath}/guest/checkId";
	var param = "guest_nickname="
			+ encodeURIComponent(f.guest_nickname.value); 

	sendRequest(url, param, resultFn, "POST");
}

function resultFn() { 
	if (xhr.readyState == 4 && xhr.status == 200) { 
		                

		var data = xhr.responseText; 
		const update = document.getElementById('update');
		const check = document.getElementById('check');
		const host_nick = document.getElementById('guest_nickname');

		check.innerText = ''; 

		console.log(data);

		if (data === '사용 가능한 닉네임입니다') {
			check.style.cssText = "color: blue; font-size: 10px;";
			update.disabled = false; 
		} else {
			check.style.cssText = "color: red; font-size: 10px;";
			update.disabled = true; 
		}

		check.innerText = data; 
	}
} 
</script> 
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
 <form method="post" name ="update">
         <h2>회원정보 수정</h2>
        <table>
        <tr>
            <td><label for="guest_nickname">닉네임</label></td>
            <td>
                <input type="text" id="guest_nickname" name="guest_nickname" autocomplete="off" >
               
                <input type="button" value="중복체크" onclick="checkId(this.form)">
                
               <span id="check"></span> 
            </td>
        </tr>
        <tr>
            <td><label for="guest_phone">전화번호</label></td>
            <td><input type="text" name="guest_phone" id="guest_phone" placeholder="-없이 입력해 주세요" onblur="validatePhoneSubmit(this)"></td>
        </tr>
        <tr>
        <td> <label>수신동의</label></td>
            <td>
                <label for="email_agree">이메일 수신동의</label>
                <input type="checkbox" id="email_agree" name="email_agree" value="1"> 
              
                <label for="sns_agree">SNS 수신동의</label>
                <input type="checkbox" id="sns_agree" name="sns_agree" value="1">
            </td>
        </tr>
        <tr>
            <td ><label for="guest_name">이름</label></td>
            <td><input type="text" id="guest_name" name="guest_name"></td>
        </tr>
        <tr>
            <td><label>성별</label></td>
            <td>
                <label for="male">남성</label>
                <input type="radio" id="male" name="guest_gndr" value="남성" checked>
                <label for="female">여성</label>
                <input type="radio" id="female" name="guest_gndr" value="여성">
            </td>
        </tr>
        <tr>
            <td><label for="guest_birth">생일</label></td>
            <td><input type="date" name="guest_birth"></td>
        </tr>
        
    </table>
         
         <input type="button" id="update" value="저장" onclick="insertCheck(this.form)" class="btn btn-primary" style="width: 100% height: auto" disabled="disabled" >
         
      </form>
</body>
</html> --%>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필</title>
<style>

body {
   
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background: #ecf0f3;
}

.wrapper,
.wrapper .img-area
{
    background: #ecf0f3;
    box-shadow: -3px -3px 7px #ffffff, 3px 3px 5px #ceced1; 
}
.wrapper {
    position: relative;
    width: 450px;
    height:550px;
    padding: 30px;
    border-radius: 10px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    margin-left:37%;
    margin-top:100px;
}


input[type="text"],
input[type="date"] {
  width: 180px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 8px;
  outline: none;
  background-color: rgb(233, 233, 233);
  }

<!--버튼-->


.buttonbundle  button:hover:before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
        border-radius: 50%;
        background: #ecf0f3;
        box-shadow: inset -3px -3px 7px #ffffff, inset 3px 3px 5px #ceced1;
    }

.wrapper .buttonbundle {
    display: flex;
    justify-content: space-between;
 
       display: flex;
}



label{
margin-right:50px;
}

.agree,.gender{
margin-right:0px;
 
}

.overlap-button {
    background-color:#2CBEB1; 
            border-radius: 8px;
    color: white;
    padding: 5px 10px;
    margin-top:10px;
    cursor: pointer; 
}
.update-button {
    background-color: #2CBEB1; 
            border-radius: 8px;
    color: white;
    padding: 7px 20px;
    margin-top:10px;
    cursor: pointer; 
}

.overlap-button:hover,.update-button:hover {
    background-color: #7DC0AD /* 마우스 오버시 배경 색상 변경 */
}

table{
   border-collapse: collapse;
   width: 100%;
 }

        
tr{
   margin-bottom: 20px; /* 원하는 간격으로 조절하세요. */
}

        
td{
   padding: 10px;
}
</style>
  
    
<script type="text/javascript">


	
	function updateCheck(f) {
	guest_nickname = document.getElementById("guest_nickname").value;
	guest_name = document.getElementById("guest_name").value;
	guest_phone = document.getElementById("guest_phone").value;
	
		if (guest_nickname === '') {
			alert("닉네임을 입력하세요!");
			return false;
		}
		if (document.getElementById("check").textContent != "사용 가능한 닉네임입니다") {
			alert("닉네임 중복 확인을 해주십시오.");
			return false;
		}
		if (guest_name === '') {
			alert("이름을 입력하세요!");
			return false;
		}
		if(guest_phone === ''){
			alert("전화번호를 입력하십시오!");
			return false;
		}
		
		var url = "${pageContext.request.contextPath}/guest/update";

		f.action = url;
		f.submit();
		return true;
	} 

	
	
	function validatePhoneSubmit(guest_phone) {
		guest_phone.value = guest_phone.value.replace(/\D/g, ''); // 숫자 이외의 문자는 제거
	}
	function checkId(f) { //닉네임 중복검사

		if (f.guest_nickname.value == "") {
			alert("닉네임을 입력하십시오!");
			return;
		}

		var url = "${pageContext.request.contextPath}/guest/checkId";
		var param = "guest_nickname="
				+ encodeURIComponent(f.guest_nickname.value); 

		sendRequest(url, param, resultFn, "POST");
	}

	function resultFn() { 
		if (xhr.readyState == 4 && xhr.status == 200) { 
			                

			var data = xhr.responseText; 
			const update = document.getElementById('update');
			const check = document.getElementById('check');
			const host_nick = document.getElementById('host_nick');

			check.innerText = ''; 

			console.log(data);

			if (data === '사용 가능한 닉네임입니다') {
				check.style.cssText = "color: blue; font-size: 10px;";
				update.disabled = false;
			} else {
				check.style.cssText = "color: red; font-size: 10px;";
				update.disabled = true; 
			}

			check.innerText = data; 
		}
	}
	//닉네임 중복체크 끝
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div class="bundle">	  
    <div class="wrapper" >
<form method="post" name ="update">
        
        
         <h2 align="center" style="margin-bottom:80px;" >회원정보 수정</h2>
        <table>
        <tr>
            <td><label for="guest_nickname">닉네임</label></td>
            <td>
                <input type="text" id="guest_nickname" name="guest_nickname" autocomplete="off" >
               
               <input type="button" value="중복체크" class="overlap-button" onclick="checkId(this.form)"> 
              <Br> <span id="check"></span>
            </td>
        </tr>
          <tr>
            <td ><label for="guest_name">이름</label></td>
            <td><input type="text" id="guest_name" name="guest_name"></td>
        </tr>
        <tr>
            <td><label for="guest_phone">전화번호</label></td>
            <td><input type="text" name="guest_phone" id="guest_phone" placeholder="-없이 입력해 주세요" onblur="validatePhoneSubmit(this)"></td>
        </tr>
        <tr>
            <td><label>성별</label></td>
            <td>
                <label for="male"  class="gender">남성</label>
                <input type="radio" id="male" name="guest_gndr" value="남성" checked>
                <label for="female"  class="gender">여성</label>
                <input type="radio" id="female" name="guest_gndr" value="여성">
            </td>
        </tr>
        <tr>
            <td><label for="guest_birth">생일</label></td>
            <td><input type="date" name="guest_birth"></td>
        </tr>
    </table>
<div class="buttonbundle">
<input type="button" id="update" value="수정" onclick="updateCheck(this.form)" class="update-button" style="margin-left:85%;">
        </div>
    </form>
    </div>
    
</div>
	
	
</body>
</html>
























