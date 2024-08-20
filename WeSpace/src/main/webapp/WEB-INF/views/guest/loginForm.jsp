<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
    


<!DOCTYPE html>
<html>
<head>
<title>로그인창</title>
<!-- 카카오 로그인 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- 카카오 로그인 -->

<style type="text/css">
ul{list-style: none;}  /* 리스트 앞에 . 같은거 제거*/
a{text-decoration: none;} /* 링크에 밑줄 같은거 제거*/

*{
    padding: 0;
    margin: 0;
    border: none;
}
body{
    font-size: 14px;
    font-family: 'Roboto', sans-serif;
} 


.login-wrapper{
    width: 400px;
    height: 350px;
    padding: 40px;
    box-sizing: border-box;
    margin-left:37%;
    margin-top:7%;
}

.login-wrapper > h2{
    font-size: 24px;
    color: #2CBEB1;
    margin-bottom: 20px;
}
#login-form > input{
    width: 100%;
    height: 48px;
    padding: 0 10px;
    box-sizing: border-box;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #F8F8F8;
}
#login-form > input::placeholder{
    color: #D2D2D2;
}
#login-form > input[type="submit"]{
    color: #fff;
    font-size: 16px;
    background-color: #2CBEB1;
    margin-top: 20px;
}

#login-form > input[type="checkbox"]{
    display: none;
}

/*아랫부분*/
 .helper_list{
   width: 400px;
    height: 80px;
    padding: 10px;
    box-sizing: border-box;
 }
 
 .helper_list li{
    display: inline;
     margin: 0 10px;
}

  .oauth_list li{
    display: inline;
     margin: 0 13px;
} 

.resetBtn input[type="button"] {
	float: right !important;
	background-color: pink;
	color: black;
	border-radius: 10px;
}
</style>
<script type="text/javascript">
	function check(f) {
		if(f.guest_email.value == ""){
			alert("이메일을 입력하십시오!");
			f.guest_email.focus();
			return false;
		}else if(f.guest_pw.value == ""){
			alert("비밀번호를 입력하십시오!");
			f.guest_pw.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>

<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

	<div class="login-wrapper">
        <h2>Guest Login</h2>
		<form method="post" action="${ pageContext.request.contextPath }/guest/login/check" id="login-form" onsubmit="return check(this)">
			<input type="text" name="guest_email" value="${guest_email }" placeholder="이메일">
			
			<input type="password" name="guest_pw" placeholder="비밀번호">
			
			<label for="remember-check"> 
			 <c:choose>
								<c:when test="${check }"> <!-- check가 true라면(쿠키가 있다면)  -->
									<input type="checkbox" name="ckid" value="true" checked="checked"> <!-- 체크된 상태의 체크박스 -->
								</c:when>
								<c:otherwise> <!-- 쿠키가 없다면 -->
									<input type="checkbox" name="ckid" value="true"> <!-- 체크 안된 체크박스  -->
								</c:otherwise>
							</c:choose>
				<span>이메일 저장하기</span>
			
			</label>	
			<input type="submit" value="로그인">	
			
		</form>
		<div class="helper_utill">
			<ul class="helper_list">
				<li><a id="findEmailBtn"
					href="${ pageContext.request.contextPath }/guest/findemail"
					class="helper_menu"><span class="btn_text">이메일 찾기</span></a></li>
				<li><a id="findPwBtn"
					href="${ pageContext.request.contextPath }/guest/findpw"
					class="helper_menu"><span class="btn_text">비밀번호 찾기</span></a></li>
				<li><a id="signUpBtn"
					href="${ pageContext.request.contextPath }/guest/joinform"
					class="helper_menu"><span class="btn_text">회원가입</span></a></li>
			</ul>
		</div>
		<ul>
    <li onclick="kakaoLogin();">
        <a href="javascript:void(0)">
        <img class="img-logo" src="${pageContext.request.contextPath}/resources/images/kakao_login.png"  style="width: 318px; height: 60px;">
        </a>
      </li>
  </ul>
	</div>
</body>
<script>
  //카카오로그인
  function kakaoLogin() {

    $.ajax({
        url: '${pageContext.request.contextPath}/guest/getKakaoAuthUrl',
        type: 'get',
        async: false,
        dataType: 'text',
        success: function (res) {
            location.href = res;
        }
    });
  }
  </script>
</html>


