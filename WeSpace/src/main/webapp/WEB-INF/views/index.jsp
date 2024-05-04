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
	.theme_group_btns button{
		font-size: 10px;
    	margin: 8px 8px 0 0;
    	font-weight: 400;
	    padding: 4px 12px;
	    border-radius: 20px;
	    background-color: #fff;
   	 	color: #767676;
	}
</style>
<div class="container">
	<section class="category">
		<div class="category-align">
			<div class="category-title">
				<h2>찾는 공간이 있나요?</h2>
				<span class="category-tabs">
					<button onclick="left_click(this)" class="left selected" id="left">카테고리별</button>
					<button onclick="right_click(this)" class="right" id="right">테마별</button>
				</span>
			</div>
			<div class="wrap-btns">
				<div class="category-taps-sub">
					<button onclick="category(this, 0)"class="type selected">전체</button>
					<c:forEach var="type" items="${type }"> <!-- 유형 전체개수만큼 반복 -->
						<c:if test="${type.space_type_no <= 5 }"> <!-- 유형넘버가 5보다 같거나 작을때(모임~오피스)-->
							<button onclick="category(this, ${type.space_type_no})" class="type">${type.space_type_name }</button>
						</c:if>
					</c:forEach>
				</div>
				
				<div class="category-btns">
					<c:forEach var="uses" items="${uses }">
						<div class="wrap-btn" id="${uses.space_type_no }">
					<a href="${pageContext.request.contextPath}/space/showUses?space_uses_no=${uses.space_uses_no}&space_uses_name=${uses.space_uses_name } ">
							<button class="btn-clear btn-keyword" id="${uses.space_type_no }">
								<img class="icon" src="${uses.space_icon }">
								<div class="keyword">
					      			${uses.space_uses_name }
					    		</div>
					    	</button>
					    </a>
					    </div>
					</c:forEach>
				</div>
			</div>
			<div class="wrap-btns hidden">
				<div class="theme_board">
					<h3>🎉&nbsp;&nbsp;모임/파티</h3>
					<div class="theme_group_btns">
						<c:forEach var="theme" items="${theme }">
							<c:if test="${theme.space_type_no == 7 }">
						 <a href="${pageContext.request.contextPath}/space/showTheme?space_theme_no=${theme.space_theme_no}&space_theme_name=${theme.space_theme_name } ">
								<button>${theme.space_theme_name }</button>
								 </a>
							</c:if>
						</c:forEach>
						
					</div>
				</div>
				<div class="theme_board">
					<h3 data-v-5e9fc0ce="">📸&nbsp;&nbsp;촬영/연습</h3>
					<div class="theme_group_btns">
						<c:forEach var="theme" items="${theme }">
							<c:if test="${theme.space_type_no == 8 }">
						<a href="${pageContext.request.contextPath}/space/showTheme?space_theme_no=${theme.space_theme_no}&space_theme_name=${theme.space_theme_name } "> 
								<button>${theme.space_theme_name }</button>
						</a> 
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="theme_board">
					<h3 data-v-5e9fc0ce="">📝&nbsp;&nbsp;공부/업무</h3>
					<div class="theme_group_btns" data-v-5e9fc0ce="">
						<c:forEach var="theme" items="${theme }">
							<c:if test="${theme.space_type_no == 9 }">
						<a href="${pageContext.request.contextPath}/space/showTheme?space_theme_no=${theme.space_theme_no}&space_theme_name=${theme.space_theme_name } ">
								<button>${theme.space_theme_name }</button>
						</a>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
		<h2 class="sub_title">새로 등록됐어요</h2>
	<div class="wrapper-sub-section">
			<c:forEach var="asvo" items="${allspaceList }" >
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
	<div class="wrapper-sub-section">
		<h2 class="sub_title">방금 올라온 후기에요</h2>
		<div class="product">
			<div class="product_img_div">
				<a href="${pageContext.request.contextPath}/space/detail" >
					<img src="${pageContext.request.contextPath}/resources/images/product.jpeg" class="product_img"/>
				</a>
			</div>
			<div class="text_box">
			    <div class="product_title">노량진 편안하고 아늑한 쉼표카페</div>
			    <p class="card_text">
			    	<span class="location">
			    		<i class="fa-solid fa-location-dot" style="color: #333333;"></i>
			    		노량진동
			    	</span>
			    	<span class="tag">
			    		<span>#문토</span>
			    		<span>#모임</span>
			    	</span>
			    </p>
			    <p class="card_text">
			    	<span class="price">
			    		<span class="card_highlight">16,000</span>
			    		<span>원/시간</span>
			    	</span>
			    	
			    	<span class="card_text_icon">
			    		<i class="fa-solid fa-user-group" style="color: #333333;"></i>
			    		<span>최대 10인</span>
			    		<i class="fa-solid fa-comment" style="color: #333333;"></i>
			    		<span>0</span>
			    		<i class="fa-solid fa-heart" style="color: #333333;"></i>
						<span>0</span>
					</span>
			    </p>
		    </div>
		</div>
	</div>
 </div> 




<script type="text/javascript">

	function left_click(left){
		const btns = document.getElementsByClassName("wrap-btns");
		const right = document.getElementById("right");
		left.className="left selected";
		right.className="right";
		
		btns[0].className="wrap-btns";
		btns[1].className="wrap-btns hidden";
	
	}
	
	function right_click(right){
		const btns = document.getElementsByClassName("wrap-btns");
		const left = document.getElementById("left");
		left.className="left";
		right.className="right selected";
		
		btns[0].className="wrap-btns hidden";
		btns[1].className="wrap-btns";
	
	}
	
	function category(select, no){
		const type = document.getElementsByClassName("type");
		const icon = document.getElementsByClassName("btn-clear btn-keyword");

		for(var i = 0; i < type.length; i++){
			type[i].className="type";
		}
		console.log(no);
		
		select.className="type selected";
		
		for(var i = 0; i < icon.length; i++){
			console.log(icon[i].id);
			if(no == 0){
				console.log(icon[i].id);
				icon[i].className="btn-clear btn-keyword";
			}else if(no == icon[i].id){
				icon[i].className="btn-clear btn-keyword";
			}else{
				icon[i].className="btn-clear btn-keyword hidden";
			}
		}
	
	}
	
</script>



<%-- <%@ include file="/WEB-INF/views/layout/footer.jsp" %>		 --%>	