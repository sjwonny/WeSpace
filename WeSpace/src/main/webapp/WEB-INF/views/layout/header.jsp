<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script>
function logout(){
location.href = " https://kauth.kakao.com/oauth/logout?client_id=6b9cc9b9332b5f3938aa598be9333394&logout_redirect_uri=http://localhost:8080/space/guest/logout";
} 
</script>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/space.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/sidebar.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>

<title>We Space</title>
</head>
<body>
<div class="container"> 
	<header class="header_main" >
		<button id="open-button" class="btn-clear nav_menu"><i class="fa-solid fa-bars fa-xl"></i></button>
		<button onclick="location.href='${pageContext.request.contextPath}';" class="btn-clear logo">
			<img class="img-logo" src="${pageContext.request.contextPath}/resources/images/wespace logo.png">
		</button>
		<button class="btn-clear search-bar btn-open">
			<i class="fa-solid fa-magnifying-glass" style="color: #7b7a7f;"></i>
        </button>
	</header>
</div>

	<c:choose>
		<c:when test="${!empty hvo}">
			<aside id="all_menu" role="navigation">
				<div class="scroll_wrap">
					<div class="scroll_inner">
						<article class="profile">
							<dl>
								<dt class="logged_in">
									<a class="profile_link"><strong>${hvo.host_nick }<br></strong></a>
									<a href="${pageContext.request.contextPath }/host/mypage"
										class="profile_link">프로필 관리<i
										class="fa-solid fa-angle-right"></i>
									</a>
								</dt>
								<dd class="profile_img">
									<c:choose>
										<c:when test="${!empty hvo.host_img }">
											<img class="login_img"
												src="${pageContext.request.contextPath }/resources/update/${hvo.host_img}">
										</c:when>
										<c:otherwise>
											<img class="login_img"
												src="https://ssl.pstatic.net/static/pwe/address/img_profile.png">
										</c:otherwise>
									</c:choose>

								</dd>
							</dl>
						</article>
						<span class="profile_dim"></span>
						<div class="scroll">
							<div class="menu_top">
								<ul class="host_menu">
									<li><a> <img class="sp_icon ico_event"
											src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzEiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMSAzMCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHJlY3QgeD0iMy42NzA5NiIgeT0iMi42NzA5IiB3aWR0aD0iMjQuMTU3OSIgaGVpZ2h0PSI0LjAyNjMyIiBmaWxsPSIjRkVENjM2Ii8+CjxyZWN0IHg9IjMuNSIgeT0iMi41IiB3aWR0aD0iMjQuNSIgaGVpZ2h0PSIyNC41IiBzdHJva2U9ImJsYWNrIi8+CjxwYXRoIGQ9Ik0xOC40MzM4IDIwLjc4OTVMMjAuNDQ3IDIzLjQ3MzdMMjQuNDczMyAxOC43NzY0IiBzdHJva2U9ImJsYWNrIi8+CjxwYXRoIGQ9Ik0zIDYuNjk3MjdIMjguNSIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNy42OTc2IDEyLjA2NTlIMjMuODAyOSIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNy42OTc2IDIxLjQ2MDRIMTUuNzUwMiIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNy42OTc2IDE2Ljc2MzJIMTkuNzc2NSIgc3Ryb2tlPSJibGFjayIvPgo8L3N2Zz4K">
											<span class="tit">예약 리스트/<br>캘린더 관리
										</span>
									</a></li>
									<li><a> <img class="sp_icon ico_event"
											src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzEiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMSAzMCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTIyLjI0MzYgMjIuODAyN0g5LjI1Njc3TDE1Ljc1MDIgMjcuNTAwMUwyMi4yNDM2IDIyLjgwMjdaIiBmaWxsPSIjRkVENjM2Ii8+CjxwYXRoIGQ9Ik00LjUgMi41SDI3VjE4Ljg1NDRMMjEuOTUyOSAyMi40NTc1TDE1Ljc1IDI2Ljg4NTdMOS41NDcwOSAyMi40NTc1TDQuNSAxOC44NTQ1VjIuNVoiIHN0cm9rZT0iYmxhY2siLz4KPHBhdGggZD0iTTguMzI5NDQgMTEuMzk0NUgyMy4xNzE1IiBzdHJva2U9ImJsYWNrIi8+CjxwYXRoIGQ9Ik04LjMyOTQ0IDguMDM5NTVIMjMuMTcxNSIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNC42MTgyMyAxOC43NzYyTDkuNTY1NTkgMTUuMDg1NEwxNS43NDk4IDE5LjQ0NzNMMjEuNjI0OCAxNS4wODU0TDI2Ljg4MTQgMTguNzc2MiIgc3Ryb2tlPSJibGFjayIvPgo8L3N2Zz4K">
											<span class="tit">이용후기 /<br>Q&amp;A관리
										</span>
									</a></li>
									<li><a class="depth_1"
										href="${ pageContext.request.contextPath }/ds/showMySpace">
										<img class="sp_icon ico_event"
											src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTE1LjEyNSAyNS45NDUzSDRWMTEuMzQzOEwxNC40Mjk3IDNMMjQuNTExNyAxMS4zNDM4VjE0LjQ3MjciIHN0cm9rZT0iYmxhY2siLz4KPHBhdGggZD0iTTE3LjkwNjIgMjQuMDYyMkMxNS4zMzg5IDIxLjgzMTQgMTUuMTI1IDIwLjQxMTggMTUuMTI1IDE5LjM5NzhDMTUuMTI1IDE4LjQ1MTQgMTUuNjgxMyAxNi41NTg2IDE3LjkwNjIgMTYuNTU4NkMyMC4xMzEyIDE2LjU1ODYgMjAuNjg3NSAxOC4zNjMyIDIwLjY4NzUgMTkuMzA5NkMyMC42ODc1IDE4LjM2MzIgMjEuMjQzOCAxNi41NTg2IDIzLjQ2ODggMTYuNTU4NkMyNS42OTM4IDE2LjU1ODYgMjYuMjUgMTguNDUxNCAyNi4yNSAxOS4zOTc4QzI2LjI1IDIxLjAyMDIgMjUuMTgwMyAyMi42OTU1IDIzLjQ2ODggMjQuMDYyMkwyMC42ODc1IDI2LjI5M0wxNy45MDYyIDI0LjA2MjJaIiBmaWxsPSIjRkZEMDE0IiBzdHJva2U9ImJsYWNrIi8+Cjwvc3ZnPgo=">
											<span class="tit">공간 정보 관리</span>
									</a></li>
								</ul>
								<a href="${pageContext.request.contextPath }/host/updateform"
									class="credit_wrap">
									<div class="title">
										내 회원정보 수정 <i class="fa-solid fa-angle-right"
											style="color: #ffffff;"></i>
									</div>
								</a>
							</div>
							<nav id="gnb">
								<ul>
									<li><a class="depth_1">호스트센터 홈</a></li>
									<li><a class="depth_1"
										href="${pageContext.request.contextPath }/space_reg/insertform">공간등록하기</a>
									</li>
									<li><a class="depth_1"
										href="${ pageContext.request.contextPath }/ds/showMySpace">세부공간등록하기</a>
									</li>
								</ul>
								<div class="service_menu">
									<c:if test="${!empty login }">
										<a href="${pageContext.request.contextPath }/guest/logout">로그아웃</a>
									</c:if>
									<p class="copyright">Powered by © NSPACE Corp.</p>
								</div>
							</nav>
							<button id="close-button" class="nav_menu_close">
								<i class="fa-solid fa-arrow-left fa-xl" style="color: #704de4;"></i>
							</button>
						</div>
					</div>
				</div>
			</aside>
		</c:when>

		<c:otherwise>


			<aside id="all_menu" role="navigation">
				<div class="scroll_wrap">
					<div class="scroll_inner">

						<c:choose>
							<c:when test="${!empty login }">
								<article class="profile">
									<dl>
										<dt class="logged_in">
											<a class="profile_link"><strong>${gvo.guest_nickname }<br></strong></a>
											<a href="${pageContext.request.contextPath }/profile/mypage"
												class="profile_link">프로필 관리<i
												class="fa-solid fa-angle-right"></i>
											</a>
										</dt>
										<dd class="profile_img">
											<c:choose>
												<c:when test="${!empty gvo.guest_img }">
													<img class="login_img"
														src="${pageContext.request.contextPath }/resources/update/${gvo.guest_img}">
												</c:when>
												<c:otherwise>
													<img class="login_img"
														src="https://ssl.pstatic.net/static/pwe/address/img_profile.png">
												</c:otherwise>
											</c:choose>

										</dd>
									</dl>
								</article>
								<span class="profile_dim"></span>
							</c:when>
							<c:otherwise>
								<article class="profile">
									<dl>
										<dt class="require_login">
											<span class="login_text">로그인/회원가입<br></span> <a
												href="${pageContext.request.contextPath}/host/loginform">
												<strong>호스트</strong>
											</a> <span>&nbsp&nbsp&nbsp&nbsp</span> <a
												href="${pageContext.request.contextPath}/guest/loginform">
												<strong>게스트</strong>
											</a>
										</dt>
										<dd class="profile_img">
											<img class="profile_img_logo"
												src="${pageContext.request.contextPath}/resources/images/wespace.png">
										</dd>
									</dl>
								</article>
								<span class="profile_dim"></span>
							</c:otherwise>
						</c:choose>


						<div class="scroll">
							<div class="menu_top">
								<c:if test="${!empty login}">
									<div class="user_info">
										<div class="user_level_info">
											<div class="user_level">
												<div class="user_level_icon">

													<c:set var="cnt" value="${rsrvtCnt}"/>
													<c:choose>
														<c:when test="${cnt>= 50}">
															<img class="user_level_img"
																src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_5.png">
												</div>
												<span>스클러</span>
											</div>
											<div class="user_lever_text">
												<a class="btn_level_benefit"
													href="${pageContext.request.contextPath}/rsrvt/level">등급별 혜택</a>
												<div class="user_lever_count">
													</c:when>
													<c:when test="${cnt>= 30}">
														<img class="user_level_img"
															src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_4.png">
												</div>
												<span>크리에이터</span>
											</div>
											<div class="user_lever_text">
												<a class="btn_level_benefit"
													href="${pageContext.request.contextPath}/rsrvt/level">등급별 혜택</a>
												<div class="user_lever_count">
													<p>
														<span>스클러</span>가 되기까지<br>예약 ${50 -cnt}회 남았어요.
													</p>
													</c:when>
													<c:when test="${cnt>= 20}">
														<img class="user_level_img"
															src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_3.png">
												</div>
												<span>챌린저</span>
											</div>
											<div class="user_lever_text">
												<a class="btn_level_benefit"
													href="${pageContext.request.contextPath}/rsrvt/level">등급별 혜택</a>
												<div class="user_lever_count">
													<p>
														<span>크리에이터</span>가 되기까지<br>예약 ${30 -cnt}회 남았어요.
													</p>
													</c:when>
													<c:when test="${cnt>= 10}">
														<img class="user_level_img"
															src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_2.png">
												</div>
												<span>플레이어</span>
											</div>
											<div class="user_lever_text">
												<a class="btn_level_benefit"
													href="${pageContext.request.contextPath}/rsrvt/level">등급별 혜택</a>
												<div class="user_lever_count">
													<p>
														<span>챌리저</span>가 되기까지<br>예약 ${20 -cnt}회 남았어요.
													</p>
												</c:when>
												<c:otherwise>
													<img class="user_level_img"
														src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_1.png">
											</div>
											<span>스타터</span>
										</div>
										<div class="user_lever_text">
											<a class="btn_level_benefit"
												href="${pageContext.request.contextPath}/rsrvt/level">등급별 혜택</a>
											<div class="user_lever_count">
												<p>
													<span>플레이어</span>가 되기까지<br>예약 ${10 -cnt}회 남았어요.
												</p></c:otherwise>
	   </c:choose>
	 </div>
  </div>
</div>
	<div class="user_memory">
									<div class="user_memory_title"><h6>스페이스클라우드와 함께한 추억</h6>
										<div class="user_memory_title_bg">
									</div>
								</div>
								<div class="user_memory_info">
									<dl>
										<dt>누적 예약</dt>
										<dd>
											<span>2</span>회
										</dd>
									</dl>
									<dl>
										<dt>이용한 공간</dt>
										<dd>
											<span>0</span>개
										</dd>
									</dl>
									<dl>
										<dt>함께한 사람들</dt>
										<dd>
											<span>0</span>명
										</dd>
									</dl>
								</div>
							</div>
							<div class="user_coupon_info">
								<a class="btn_level_benefit"
													href="${pageContext.request.contextPath}/profile/coupon"> 
									<div class="user_coupon_count">
										<div class="user_coupon_icon">
											<img src="https://www.spacecloud.kr/_nuxt/img/menu_coupon.e5237b1.svg">
										</div>
										
													<div class="user_coupon_text">
											<dl>
												<dt>내 쿠폰</dt>
												<dd>
													<span>${countCpn}</span>장
													<i class="ico_arrow_right"></i>
												</dd>
											</dl>
										</div>
									</div>
							 	</a>
								<a href="${pageContext.request.contextPath}/profile/badge">
									<div class="user_coupon_count">
										<div class="user_badge_icon">
											<img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNDAiIGhlaWdodD0iNDAiIHZpZXdCb3g9IjAgMCA0MCA0MCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iMjAiIGN5PSIxNS41IiByPSIxNCIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNMjAuMzU0NyA4LjIzMDZMMjIuMjYyNiAxMi42NTA0TDI3LjE0NzMgMTMuMDYxMUMyNy40ODYxIDEzLjA4OTcgMjcuNjIzOSAxMy41MDM1IDI3LjM2NjggMTMuNzIxM0wyMy42NjE3IDE2Ljg2M0wyNC43NzIgMjEuNTM2N0MyNC44NDkgMjEuODYxNSAyNC40ODk0IDIyLjExNyAyNC4xOTgzIDIxLjk0NDRMMjAuMDAwNSAxOS40NjY2TDE1LjgwMjYgMjEuOTQ0NEMxNS41MTA4IDIyLjExNjIgMTUuMTUyIDIxLjg2MDggMTUuMjI5IDIxLjUzNjdMMTYuMzM5MyAxNi44NjNMMTIuNjMzNCAxMy43MjA1QzEyLjM3NjMgMTMuNTAyNyAxMi41MTMzIDEzLjA4OSAxMi44NTI5IDEzLjA2MDRMMTcuNzM3NSAxMi42NDk3TDE5LjY0NTUgOC4yMzA2QzE5Ljc3OCA3LjkyMzEzIDIwLjIyMjIgNy45MjMxMyAyMC4zNTQ3IDguMjMwNloiIGZpbGw9IiNGRUQ2MzYiIHN0cm9rZT0iYmxhY2siLz4KPHBhdGggZD0iTTI5LjUgMjZWMzhMMjAuMTcyNyAzMy4zNjg0TDEwLjUgMzhWMjYiIHN0cm9rZT0iYmxhY2siLz4KPC9zdmc+Cg==">
										</div>
										<div class="user_badge_text">
											<dl>
												<dt>내 배지</dt>
												<dd>
													<span>${badgeCnt}</span>개 획득
													<i class="ico_arrow_right"></i>
												</dd>
											</dl>
										</div>
									</div>
								</a>
							</div>
						</div>
					</c:if>
						<ul class="login_menu">
							<li>
								<a>
									<img class="sp_icon ico_event" src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzEiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMSAzMCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTE5IDIxTDcuNSAxNEw1IDIwTDEyIDI0TDE5IDIxWiIgZmlsbD0iI0ZFRDYzNiIvPgo8cGF0aCBkPSJNNyAxNEwxOSAyMSIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNSAyMEwxMiAyNCIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNMSAyOUM0LjAwODU1IDIxLjcxNjcgMTAuMTM4NSA2LjkyIDEwLjU4OTcgNkwyMyAxOS4yMjVMMSAyOVoiIHN0cm9rZT0iYmxhY2siIHN0cm9rZS1saW5lam9pbj0iYmV2ZWwiLz4KPGNpcmNsZSBjeD0iMTIuMjYxNyIgY3k9IjIuMjYxNzIiIHI9IjEuMjYxNzIiIHN0cm9rZT0iYmxhY2siLz4KPGNpcmNsZSBjeD0iMjguMjYxNyIgY3k9IjUuMjYxNzIiIHI9IjEuMjYxNzIiIHN0cm9rZT0iYmxhY2siLz4KPGNpcmNsZSBjeD0iMjguMjYxNyIgY3k9IjE4LjI2MTciIHI9IjEuMjYxNzIiIHN0cm9rZT0iYmxhY2siLz4KPHBhdGggZD0iTTE2LjMzMzUgMy41VjcuMDQxNjciIHN0cm9rZT0iYmxhY2siLz4KPHBhdGggZD0iTTI2LjI1MDIgOS4xNjY1TDIyLjcwODUgMTAuNTgzMiIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNMjUuNTQyIDE1LjU0MkwyMy40MTcgMTMuNDE3IiBzdHJva2U9ImJsYWNrIi8+CjxwYXRoIGQ9Ik0xOC4yMDE4IDkuNjcyNTVDMTguMTQ4MyA4Ljk3ODQ5IDE4LjUwMzMgNy41MjI1IDIwLjM1MTMgNy4yNTEwN0MyMS4yNTY5IDcuMTU0MzYgMjMuMTg4NyA2LjY0NTUzIDIzLjY3MTQgNS4zODM3N0MyMy42NzE0IDUuMzgzNzcgMjMuOTQ4NiA0Ljc5ODU4IDIzLjgxOTEgNC4xNjQwOCIgc3Ryb2tlPSJibGFjayIvPgo8L3N2Zz4K">
									<span class="tit">이벤트</span>
								</a></li>
							<li>
								<a>
									<img class="sp_icon ico_event" src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzEiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMSAzMCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHJlY3QgeD0iMy42NzA5NiIgeT0iMi42NzA5IiB3aWR0aD0iMjQuMTU3OSIgaGVpZ2h0PSI0LjAyNjMyIiBmaWxsPSIjRkVENjM2Ii8+CjxyZWN0IHg9IjMuNSIgeT0iMi41IiB3aWR0aD0iMjQuNSIgaGVpZ2h0PSIyNC41IiBzdHJva2U9ImJsYWNrIi8+CjxwYXRoIGQ9Ik0xOC40MzM4IDIwLjc4OTVMMjAuNDQ3IDIzLjQ3MzdMMjQuNDczMyAxOC43NzY0IiBzdHJva2U9ImJsYWNrIi8+CjxwYXRoIGQ9Ik0zIDYuNjk3MjdIMjguNSIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNy42OTc2IDEyLjA2NTlIMjMuODAyOSIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNy42OTc2IDIxLjQ2MDRIMTUuNzUwMiIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNy42OTc2IDE2Ljc2MzJIMTkuNzc2NSIgc3Ryb2tlPSJibGFjayIvPgo8L3N2Zz4K">
									<span class="tit">예약<br>리스트</span>
								</a>
							</li>
							<li>
								<a>
									<img class="sp_icon ico_event" src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzEiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMSAzMCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTIyLjI0MzYgMjIuODAyN0g5LjI1Njc3TDE1Ljc1MDIgMjcuNTAwMUwyMi4yNDM2IDIyLjgwMjdaIiBmaWxsPSIjRkVENjM2Ii8+CjxwYXRoIGQ9Ik00LjUgMi41SDI3VjE4Ljg1NDRMMjEuOTUyOSAyMi40NTc1TDE1Ljc1IDI2Ljg4NTdMOS41NDcwOSAyMi40NTc1TDQuNSAxOC44NTQ1VjIuNVoiIHN0cm9rZT0iYmxhY2siLz4KPHBhdGggZD0iTTguMzI5NDQgMTEuMzk0NUgyMy4xNzE1IiBzdHJva2U9ImJsYWNrIi8+CjxwYXRoIGQ9Ik04LjMyOTQ0IDguMDM5NTVIMjMuMTcxNSIgc3Ryb2tlPSJibGFjayIvPgo8cGF0aCBkPSJNNC42MTgyMyAxOC43NzYyTDkuNTY1NTkgMTUuMDg1NEwxNS43NDk4IDE5LjQ0NzNMMjEuNjI0OCAxNS4wODU0TDI2Ljg4MTQgMTguNzc2MiIgc3Ryb2tlPSJibGFjayIvPgo8L3N2Zz4K">
									<span class="tit">이용후기<br>Q&amp;A관리</span>
								</a>
							</li>
							<li>
								<a>
									<img class="sp_icon ico_event" src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTE1LjEyNSAyNS45NDUzSDRWMTEuMzQzOEwxNC40Mjk3IDNMMjQuNTExNyAxMS4zNDM4VjE0LjQ3MjciIHN0cm9rZT0iYmxhY2siLz4KPHBhdGggZD0iTTE3LjkwNjIgMjQuMDYyMkMxNS4zMzg5IDIxLjgzMTQgMTUuMTI1IDIwLjQxMTggMTUuMTI1IDE5LjM5NzhDMTUuMTI1IDE4LjQ1MTQgMTUuNjgxMyAxNi41NTg2IDE3LjkwNjIgMTYuNTU4NkMyMC4xMzEyIDE2LjU1ODYgMjAuNjg3NSAxOC4zNjMyIDIwLjY4NzUgMTkuMzA5NkMyMC42ODc1IDE4LjM2MzIgMjEuMjQzOCAxNi41NTg2IDIzLjQ2ODggMTYuNTU4NkMyNS42OTM4IDE2LjU1ODYgMjYuMjUgMTguNDUxNCAyNi4yNSAxOS4zOTc4QzI2LjI1IDIxLjAyMDIgMjUuMTgwMyAyMi42OTU1IDIzLjQ2ODggMjQuMDYyMkwyMC42ODc1IDI2LjI5M0wxNy45MDYyIDI0LjA2MjJaIiBmaWxsPSIjRkZEMDE0IiBzdHJva2U9ImJsYWNrIi8+Cjwvc3ZnPgo=">
									<span class="tit">찜한 공간</span>
								</a>
							</li>
						</ul>
						<a href="${pageContext.request.contextPath }/guest/updateform" class="credit_wrap" >
							<div class="title">내 회원정보 수정
								<i class="fa-solid fa-angle-right" style="color: #ffffff;"></i>
							</div>
						</a>
					</div>
					<nav id="gnb">
						<!-- <ul>
							<li>
								<a class="depth_1">스페이스클라우드 홈</a>
							</li>
							<li>
								<a class="depth_1">공지사항</a>
							</li>
							<li>
								<a href="https://plucky-sleep-a52.notion.site/3ee61c78fc1c442a85dea202782d5102" target="_blank" class="depth_1">도움말</a>
							</li>
							<li>
								<a title="고객문의" class="depth_1">1:1문의</a>
							</li>
							<li>
								<a class="depth_1 folded">서비스 정보</a>
								<div>
									<ul class="depth_2">
										<li>
											<a>서비스 소개</a>
										</li>
										<li>
											<a>이용약관</a>
										</li>
										<li>
											<a>개인정보처리방침</a>
										</li>
										<li>
											<a>운영정책</a>
										</li>
									</ul>
								</div>
							</li>
						</ul> -->
					<div class="service_menu">
						<c:if test="${!empty login }">
						 <button onclick="logout();">로그아웃</button>
						</c:if>
						<p class="copyright">Powered by © NSPACE Corp.</p>
					</div>
					</nav>
					<button id="close-button" class="nav_menu_close">
						<i class="fa-solid fa-arrow-left fa-xl" style="color: #704de4;"></i>
					</button>
				</div>
			</div>
		</div>
		</aside>
	</c:otherwise>
</c:choose>
	
<script type="text/javascript">
       const openButton = document.getElementById("open-button");
       const closeButton = document.getElementById("close-button");
       const sidebar = document.getElementById("all_menu");

       // 열기 버튼 클릭 시
       openButton.addEventListener("click", () => {
           sidebar.style.left = "0px";
       });

       // 닫기 버튼 클릭 시
       closeButton.addEventListener("click", () => {
           sidebar.style.left = "-365px";
       }); 
</script> 
	 
