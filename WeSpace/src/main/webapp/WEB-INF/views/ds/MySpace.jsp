<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
} 

.spacecontainer {
	max-width: 960px;
	margin-top: 100px;
    margin-left: 25%;
	padding: 20px;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

.spaceList {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}

.space-item {
	width: calc(25% - 20px);
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 10px;
	background-color: #fff;
}

.spaceImg {
	width: 100%;
	height: auto;
	margin-bottom: 10px;
}

.spaceName {
	font-size: 18px;
	font-weight: bold;
	margin-bottom: 5px;
}




.spaceNum {
	font-size: 14px;
	margin-bottom: 5px;
}

.regdate {
	font-size: 14px;
	color: #888;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

	<div class="spacecontainer">
		<div class="spaceList">
			<c:choose>
				<c:when test="${basicInfo == null}"> 
					<p>등록한 공간이 존재하지 않습니다.</p>
				</c:when>
				<c:otherwise> 
					<c:forEach var="vo" items="${basicInfo}"> 
						<div class="space-item">
							  <a href="${pageContext.request.contextPath}/ds/selectSpace${vo.SPACE_INFO_NO}/${vo.BASIC_INFO_NO}">
							<img class="spaceImg" src="${pageContext.request.contextPath}/resources/imgfile/${vo.SPACE_INFO_REPIMG}" alt="공간 대표이미지" />
							<div class="spaceName">공간명 : ${vo.SPACE_INFO_NAME}</div> </a>
							<div class="spaceNum">공간번호 : ${vo.SPACE_INFO_NO}</div> 
							<div class="regdate">등록일 : ${vo.RGST_DATE}</div> 
							
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	
	
	
	
	
	
	</div>
</body>
</html>