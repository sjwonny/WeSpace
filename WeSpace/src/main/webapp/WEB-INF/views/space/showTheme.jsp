<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<style>
.wrapper-sub-section{
     	display:flex;
	    flex-direction: row; 
	    flex-wrap : wrap;
	    width: 100%;
	    justify-content: space-between;
	}
	
.product{
    margin-bottom: 40px;
     width: calc(30% - 20px);
     margin-left:40px;
}
</style>
<body>
<div align="center">
	<h2>테마별 공간 - ${space_theme_name}</h2><br><br>
</div>
<div class="container">
<div class="wrapper-sub-section">
			<c:forEach var="asvo" items="${ThemeSpaceList}" >
		 <a href="${pageContext.request.contextPath}/space/detail?de_sp_add_no=${asvo.DE_SP_ADD_NO}&space_info_no=${asvo.SPACE_INFO_NO} 
		 &de_sp_info_no=${asvo.DE_SP_INFO_NO}&usage_info_no=${asvo.USAGE_INFO_NO}"> 
		<div class="product">
			<div class="product_img_div">
					<img src="${pageContext.request.contextPath}/resources/imgfile/${asvo.SPACE_INFO_REPIMG}" class="product_img"/>
			</div>	</a> 
			<div class="text_box">
			    <div class="product_title">${asvo.SPACE_INFO_NAME }</div>
			    <p class="card_text">
			    	<span class="location">
			    		<i class="fa-solid fa-location-dot" style="color: #333333;"></i>
			    		노량진동
			    	</span>
			    	<span class="tag">
			    		<span>#${asvo.TAGS}</span>
			    	</span>
			    </p>
			    <p class="card_text">
			    	<span class="price">
			    		<span class="card_highlight">16,000</span>
			    		<span>원/시간</span>
			    	</span>
			    	
			    	<span class="card_text_icon">
			    		<i class="fa-solid fa-user-group" style="color: #333333;"></i>
			    		<span>최대 ${asvo.DE_SP_INFO_MAXPERSON}인</span>
			    		<i class="fa-solid fa-comment" style="color: #333333;"></i>
			    		<span>0</span>
			    		<i class="fa-solid fa-heart" style="color: #333333;"></i>
						<span>0</span>
					</span>
			    </p>
		    </div>
		</div>
	
	</c:forEach>
	</div>
	
</body>
</html>