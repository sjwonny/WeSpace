<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<head>
<script>
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<input type="hidden" id ="de_sp_add" name = "de_sp_add_no">
	<table>
		<tr>
			<td><input type="checkbox" name="setByTime" value="1" ></td>
			<td>시간 단위</td>
			<td><input type="button" value="가격등록" onclick="location.href='${ pageContext.request.contextPath }/ds/time?basic_info_no=${basic_info_no}&de_sp_add_no=${de_sp_add_no}'"></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="setByPackage" value="1"></td>
			<td>패키지 단위</td>
			<td><input type="button" value="가격등록" onclick="location.href='${ pageContext.request.contextPath }/ds/package?basic_info_no=${basic_info_no}&de_sp_add_no=${de_sp_add_no}'"></td>
		</tr>
	</table>
 <a href="${pageContext.request.contextPath }"><button>목록</button></a>


	
</body>
</html>