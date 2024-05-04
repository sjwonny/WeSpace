<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<style>
#image-container {
	text-align: right;
}

.text_box {
	margin-top: 100px;
}

.list_detail li {
	list-style-type: disc; /* 목록 항목을 점으로 표시 */
}

.tit {
	font-weight: bold;
}

.fList {
	margin-top: 20px;
}

.holiday-table {
	border-collapse: collapse;
	width: 60%;
}

.holiday-table th, .holiday-table td {
	border: 1px solid purple;
	padding: 8px;
	text-align: center;
}
.flex{
width:55%
}
</style>

<div class="contents_padded">
	<div class="section_cont">
		<div class="inner_width">
			<div class="h_area">
				<div class="h_space">
					<span class="distance_option"> ${allDetail.SPACE_INFO_ADRINFO } </span>
					<h2 class="space_name"> ${allDetail.SPACE_INFO_NAME }</h2>
				</div>
				<p class="sub_desc">${allDetail.SPACE_INFO_TIP }</p>
				<div class="tags">
				<c:forEach var="tvo" items="${tList}">
       	<span class="space_tag">#${tvo.space_tag_name}</span>
                </c:forEach>
				</div>
			</div>
			
			
			<div class="detail_forms">
				<div class="box_form right_fixed detail_space">
					<div class="ly_right_wrap meet">
						<div class="ly_right_fixed">
							<div id="image-container">
							<button id="like-button" data-de-sp-info-no="세부공간 시퀀스 값" data-guest-no="회원 시퀀스 값" onclick="toggleLike()">
       <img id="like-image" src="${pageContext.request.contextPath}/resources/images/heart.svg" alt="Like Heart" data-liked="false"> 
                            </button></div>
							<div class="heading">
								<h3>세부공간 선택</h3>
							</div>
							<div class="scroll_box">
								<div class="scroll_inner">
									<div class="respond_infos">
										<div class="p_respond">
											<c:choose>
												<c:when test="${allDetail.BSNS_INFO_PAYMETHOD == 0 }">
													<p class="info_text_title">결제 후 바로 예약확정</p>
												</c:when>
												<c:otherwise>
													<p class="info_text_title">호스트 승인 후 예약확정</p>
												</c:otherwise>
											</c:choose>
											<p class="info_text_describe">
												확실한 예약을 위해 스페이스클라우드에서<br> 온라인 결제를 진행하세요 :-)
											</p>
										</div>
									</div>
									<ul class="reserv_list">
										<li class="lst active">
											<div class="flex_box">
													<input type="radio" name="space_reserv" class="radio" value="">
												<div class="flex" style="font-size:16px; font-weight:bold;">
														<label>${allDetail.DE_SP_INFO_NAME }</label>
												</div>
												<div class="flex align_right">
													<strong>${minPrice}원</strong>
													<span class="txt_unit">/시간</span>
												</div>
											</div>
											<div class="space_info_wrap active">
												<div class="meetspace-info">
													<div class="meetspace-info-photo" >
													<img class="detailImg" src="${pageContext.request.contextPath}/resources/imgfile/${allDetail.DE_SP_INFO_IMG}" style="width: 270px; height: 280px;"/>
													</div>
													<p class="meetspace-info-desc">
														${allDetail.DE_SP_INFO_EXP }
													</p>
												</div>
											<ul class="list_detail">
												<li >
													<span class="tit">공간유형</span>
													<span class="data">
													 <c:forEach var="svo" items="${sList}">
														<span>${svo.space_uses_name }</span>
													</c:forEach>
													</span>
												</li>
												<li>
													<span class="tit">공간면적</span>
														<span class="data">${allDetail.DE_SP_INFO_AREA }㎡</span>
						            			</li>
						            			<li>
										            <span class="tit">예약시간</span>
										            <span class="data">최소 ${allDetail.DE_SP_INFO_MINTIME}시간 부터</span>
						            			</li>
						            			<li>
										            <span class="tit">수용인원</span>
										            <span class="data">최소 ${allDetail.DE_SP_INFO_MINPERSON }명 ~ 최대 ${allDetail.DE_SP_INFO_MAXPERSON}명</span>
						            			</li>
						            		</ul>
						            		<div class="fList">
						            		 <c:forEach var="fvo" items="${fList}">
													<table>
														<tr>
															<td><img
																src="${pageContext.request.contextPath}/resources/images/${fvo.facility_no}.png"
																style="width: 30px; height: 30px; margin: 0 auto;">
															</td>
															<td>${fvo.facility_name}</td>
														</tr>
													</table>
												</c:forEach>
												</div>
						            		<div class="facility_wrap">
						            			<ul class="facility_list">
						            				<li>
						            				</li>
						            			</ul>
						            			</div>
						            			<h2 class="meetspace-heading">예약선택</h2>
						            			<div class="meetspace-radio">
							                    	<div class="meetspace-radio-item">
							                    		<input type="radio" class="radio" value="TIME">
							                      		<label>시간 단위 예약하기(최소 ${allDetail.DE_SP_INFO_MINTIME}시간 부터)</label>
							                      	</div>
						                    	</div>
						                    </div>
						                </li>
						            </ul>
					        	</div>
							</div> 
					        
					        <div class="btn_order_area">
						        <a class="btn btn_default btn_call">
						        	<span class="txt_call">
						        		<i class="fa-solid fa-phone" style="color: #d9cdff;"></i> 전화
						        	</span>
						        </a>
						        <a class="btn btn_default btn_reserve">예약신청하기</a>
					        </div>
						</div>
					</div>
				</div>
			</div>
					        
		<div class="photo_box_wrap">
			<div class="detail_box">
				<div class="photo">
					<img src="${pageContext.request.contextPath}/resources/images/product.jpeg" class="photo"/>
				</div>
				<div class="text_box">
					<h3 class="h_copy">${allDetail.SPACE_INFO_TIP }</h3>
				</div>
				<div class="nav_wrapper">
					<ul class="nav_area">
						<li class="menu selected">
							<button onclick='click(this)' id="1">공간소개</button>
						</li>
						<li class="menu">
							<button onclick="click(this)" id="2">시설안내</button>
						</li>
						<li class="menu">
							<button onclick="click(this)" id="3">유의사항</button>
						</li>
						<li class="menu">
							<button onclick="click(this)" id="4">환불정책</button>
						</li>
						<li class="menu">
							<button onclick="click(this)" id="5">Q&amp;A</button>
						</li>
						<li class="menu">
							<button onclick="click(this)" id="6">이용후기</button>
						</li>
					</ul>
				</div>
			</div>
		
		
		
		<div id="s_intro" class="text_box">
		<h4>공간 소개</h4>
		 <p>${allDetail.SPACE_INFO_INTRD }</p> 
		 <div><p>영업시간 ${allDetail.TM_NO_START-1 }~${allDetail.TM_NO_END-1 }시</p></div>
	
   <c:choose>
    <c:when test="${empty rList}">
    	<p>휴무일 없음</p>
    </c:when>
    <c:otherwise>
     	<p>휴무일</p>
        <c:forEach var="holiday" items="${rList}">
            ${holiday.day_week_date}휴무<br>
        </c:forEach>
    </c:otherwise>
</c:choose>
		 </div>


<ul style="display: flex; list-style-type: none; padding: 0;">
    <li style="margin-right: 20px;"><img src="${pageContext.request.contextPath}/resources/images/stairs.png"><br><div style="text-align: center;"><span style="font-size: 12px;">${allDetail.USAGE_INFO_FLOOR}</span></div></li>
    <li style="margin-right: 20px;"><img src="${pageContext.request.contextPath}/resources/images/park.png"><br><div style="text-align: center;"><span style="font-size: 12px;"><c:choose><c:when test="${allDetail.USAGE_INFO_PARK ==0 }">주차불가</c:when><c:when test="${allDetail.USAGE_INFO_PARK >0}">${allDetail.USAGE_INFO_PARK}대</c:when><c:otherwise>주차 정보 없음</c:otherwise></c:choose></span></div></li>
    <li><img src="${pageContext.request.contextPath}/resources/images/elevator.png"><br><div style="text-align: center;"><span style="font-size: 12px;"><c:choose><c:when test="${allDetail.USAGE_INFO_ELVTR ==0 }">엘리베이터 없음</c:when><c:otherwise>엘리베이터 있음</c:otherwise></c:choose></span></div></li>
</ul>

<h4>시설 안내</h4>
<ol>
    <c:forEach var="gvo" items="${gList}">
        <li style="list-style-type: decimal;">${gvo.fclty_guide_content}</li>
    </c:forEach>
</ol>

<h4>예약시 주의사항</h4>
<ol>
    <c:forEach var="nvo" items="${nList}">
        <li style="list-style-type: decimal;">${nvo.rsrvt_notes_content}</li>
    </c:forEach>
</ol>
<h4>환불규정 안내</h4>
<table>
	<tr><td>이용 8일 전  </td><td>&nbsp&nbsp 총 금액의 100% 환불</td></tr>
	<tr><td>이용 7일 전  </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DAY7}% 환불</td></tr>
	<tr><td>이용 6일 전  </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DAY6}% 환불</td></tr>
	<tr><td>이용 5일 전  </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DAY5}% 환불</td></tr>
	<tr><td>이용 4일 전  </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DAY4}% 환불</td></tr>
	<tr><td>이용 3일 전  </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DAY3}% 환불</td></tr>
	<tr><td>이용 2일 전  </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DAY2}% 환불</td></tr>
	<tr><td>이용 1일 전  </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DAY1}% 환불</td></tr>
	<tr><td>이용 당일    </td><td>&nbsp&nbsp 총 금액의 ${allDetail.DDAY}% 환불</td></tr>
</table>
<Br><Br>
<div  style="font-size: 40px;">🚩${allDetail.SPACE_INFO_NAME} </div>
<div  style="font-size: 20px;"> ${allDetail.SPACE_INFO_ADR } </div>
<Br><Br>
<div id="map" style="width:100%;height:350px;"></div>
				</div>
		
		
		</div>
	</div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=22cc23c5e09bec247548cf8e26150476&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${allDetail.SPACE_INFO_ADR } ', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${allDetail.SPACE_INFO_NAME }</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
<script type="text/javascript">
	function click(e){
		const menu = document.getElementsByClassName("menu");
		consol.log(e);
		for(var i = 0; i < menu.length; i++){
			menu[i].className="menu";
		}
	
	}
</script>

<script>
// 이미지 클릭 시 실행될 함수
function toggleLike() {
    var image = document.getElementById('like-image');
    var liked = image.getAttribute('data-liked');
    var contentContainer = document.getElementById('content-container');

    if(liked === "false") {
        // 빨간 하트로 변경
        image.src = '${pageContext.request.contextPath}/resources/images/redHeart.svg';
        // data-liked 속성 변경
        image.setAttribute('data-liked', 'true');
    }else{
        // 하얀 하트로 변경
        image.src = '${pageContext.request.contextPath}/resources/images/heart.svg';
        // data-liked 속성 변경
        image.setAttribute('data-liked', 'false');
    }
}

// 이미지 클릭 이벤트 리스너 추가
document.getElementById('like-image').addEventListener('click', toggleLike); 
</script>



<%@ include file="/WEB-INF/views/layout/footer.jsp" %>	