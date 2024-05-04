<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<style>
.line{
top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
  text-align: center;
  margin-top:200px;
  
}
</style>
<body>

<div class="line" align="center" >
	<c:choose>
		<c:when test="${!check}"> <!-- 체크가 false일 때(찾은 아이디 또는 비번이 없을 경우) -->
			<h3>이메일 혹은 비밀번호를 찾지 못하였습니다.</h3>
			<a href="${ pageContext.request.contextPath }/host/findemail">이메일 찾기</a> | 
			<a href="${ pageContext.request.contextPath }/host/findpw">패스워드 찾기</a> |
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${param.mode == 'host_email' }"> <!-- 전달받은 mode가 id일 떄 -->
						<h1>📧<br>회원님의 이메일을 찾았습니다</h1>
						<h3>이메일 : ${host_email }</h3><!-- 아이디 알려줌 -->
				</c:when>
				<c:otherwise> <!-- 전달받은 mode가 pw일 때 -->
				        <h1>🔒<br>회원님의 비민번호를 찾았습니다</h1>
						<h3>패스워드 : ${host_pw }</h3> <!-- 비밀번호 알려줌 -->
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<a href="${ pageContext.request.contextPath }/host/loginform">Login 화면으로</a>
	</div>
	
</body>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
