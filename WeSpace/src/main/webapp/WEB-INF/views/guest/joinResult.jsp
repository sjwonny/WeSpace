<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script type="text/javascript">
	alert('${msg}');        
	location.href = "${url}"; 
</script>