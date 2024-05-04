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
<style type="text/css">
*{margin: 0px; padding: 0px;}
ul{list-style: none;} /* 리스트 앞에 . 같은거 제거*/
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

</style>
<script type="text/javascript">
	function check(f) {
		if(f.host_email.value == ""){
			alert("이메일을 입력하십시오!");
			f.host_email.focus();
			return false;
		}else if(f.host_pw.value == ""){
			alert("비밀번호를 입력하십시오!");
			f.host_pw.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>

<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
    <div class="login-wrapper">
        <h2>Host Login</h2>
		<form method="post" action="${ pageContext.request.contextPath }/host/login/check" id="login-form" onsubmit="return check(this)">
			<input type="text" name="host_email" value="${host_email }" placeholder="이메일">
			
			<input type="password" name="host_pw" placeholder="비밀번호">
			
			<label for="remember-check">
			
				<input type="checkbox" id="remember-check">이메일 저장하기
			
			</label>	
			<input type="submit" value="로그인">	
			
		</form>
		<div class="helper_utill">
			<ul class="helper_list">
				<li><a id="findEmailBtn" href="${ pageContext.request.contextPath }/host/findemail" 
						class="helper_menu"><span class="btn_text">이메일 찾기</span></a></li>
				<li><a id="findPwBtn" href="${ pageContext.request.contextPath }/host/findpw"
						class="helper_menu"><span class="btn_text">비밀번호 찾기</span></a></li>
				<li><a id="signUpBtn" href="${ pageContext.request.contextPath }/host/joinform"
						class="helper_menu"><span class="btn_text">회원가입</span></a></li>	
			</ul>
		</div>
	</div>
</body>
</html>


