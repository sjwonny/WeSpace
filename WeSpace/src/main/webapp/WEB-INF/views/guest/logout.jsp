<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	alert("로그아웃되었습니다!");
	location.href = '${pageContext.request.contextPath }'; <!--홈화면으로 리다이렉션-->
														   <!--일반적으로 사용자가 로그아웃한 후에는 로그인 페이지 또는 애플리케이션의 메인 페이지로 돌아가는 것이 일반적-->
</script>