<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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

.find-wrapper{
    width: 400px;
    height: 350px;
    padding: 40px;
    box-sizing: border-box;
    margin-left:37%;
    margin-top:7%;
}

.find-wrapper > h2{
    font-size: 24px;
    color: #2CBEB1;
    margin-bottom: 20px;
}
#find-form > input{
    width: 100%;
    height: 48px;
    padding: 0 10px;
    box-sizing: border-box;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #F8F8F8;
}
#find-form > input::placeholder{
    color: #D2D2D2;
}
#find-form > input[type="submit"]{
    color: #fff;
    font-size: 16px;
    background-color: #2CBEB1;
    margin-top: 20px;
}

#find-form > input[type="checkbox"]{
    display: none;
}

/*아랫부분*/
 
#findBtn{
margin-left:10px;
}
.go{
margin-left:25px;
}
.resetBtn input[type="button"] {
	float: right !important;
	background-color: pink;
	color: black;
	border-radius: 10px;
}
</style>


 <script type="text/javascript">
	function check(f){
		if(f.host_name.value == ''){
			alert("이름를 입력 하십시오!");
			f.host_name.focus();
			return false;
		}
		
		if(f.host_phone.value == ''){
			alert("전화번호를 입력하십시오!");
			f.host_phone.focus();
			return false;
		}
		return true;
	} 

</script> 
</head>
<Body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>


	<div class="find-wrapper">
	<h2>Find Email</h2>
        <form method="post" action="${ pageContext.request.contextPath }/host/find" id="find-form" name="findEmail" onsubmit="return check(this)">
        <input type="hidden" name="mode" value="host_email"> 
            <input type="text" id ="host_name" name="host_name" placeholder="이름">
		<input type="text" id="host_phone"  name="host_phone" placeholder="전화번호 (숫자만 입력)">
		<div class="resetBtn">
            <input type="button" value="초기화" onclick="document.findEmail.reset()">
        </div>
            <input type="submit"  value="확인" >
       
        </form>
	<div class="helper_utill">
		<ul class="helper_list">
			<p class="go">비밀번호가 기억이 안난다면?
			<a id="findBtn" href="${ pageContext.request.contextPath }/host/findpw" 
				class="helper_menu"><span class="btn_text">비밀번호 찾기</span></a>
			</p>
		</ul>
	</div>
</div>
</Body>	
		
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>