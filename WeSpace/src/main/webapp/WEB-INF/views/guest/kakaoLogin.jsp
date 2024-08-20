<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
    
<!DOCTYPE html>
<html>
<head>
<!-- 카카오 로그인 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- 카카오 로그인 -->

  <script type="text/javascript">
    window.onload = function() {
    	console.log(document.kakaologinForm.guest_nickname.value);
        document.getElementById("kakaologinForm").submit();
    };
</script>
</head>
<body>
<form method="post" action="${ pageContext.request.contextPath }/guest/login/check" id="kakaologinForm" name="kakaologinForm" >
<input type="hidden" name="guest_nickname" value="${kakaoInfo.nickname}">

</form>
</body>
</html>