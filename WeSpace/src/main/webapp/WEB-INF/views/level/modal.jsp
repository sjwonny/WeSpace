<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><!--모달창 부분-->


#btnWrap {
  width: 500px;
  margin: 100px auto;
 
}
#popupBtn {
  width: 150px;
  height: 50px;
  padding: 10px 5px;
  border: 1px solid pink;
}
#modalWrap {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0px; 
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  display: none;

}

#modalBody {
  width: 500px;
  height: 1200px;
  padding: 30px 30px;
  margin: 0 auto;
  border: 1px solid #777;
  background-color: #fff;
}

#closeBtn {
  float:right;
  font-weight: bold;
  color: #777;
  font-size:25px;
  cursor: pointer;
}



.levelicon{
 width:100px;
 height:100px;

}

.levelWrap li{
 margin-bottom:50px;
}

#levelInfo{	
 margin-top:100px;
 text-align:center;
}
</style>

</head>
<body>
<div id="levelInfo">
<c:choose>
    <c:when test="${cnt>= 50}">
        <img class="levelicon" src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_5.png">
        <p>${gvo.guest_nickname}님은</p><P>이번달 we space의 스클러 입니다.</P>
    </c:when>
    <c:when test="${cnt >= 30}">
        <img class="levelicon" src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_4.png">
        <p>${gvo.guest_nickname}님은</p><P>이번달 we space의 크리에이터 입니다.</P>${50 -cnt}번 더 예약하면 스클러가 될 수 있어요!
    </c:when>
    <c:when test="${cnt >= 20}">
        <img class="levelicon"  src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_3.png">
        <p>${gvo.guest_nickname}님은</p><P>이번달 we space의 챌린저 입니다.</P>${30 -cnt}번 더 예약하면 크리에이터가 될 수 있어요!
    </c:when>
    <c:when test="${cnt >= 10}">
        <img class="levelicon" src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_2.png">
        <p>${gvo.guest_nickname}님은</p><P>이번달 we space의 플레이어 입니다.</P>${20 -cnt}번 더 예약하면 챌린저가 될 수 있어요!
    </c:when>
    <c:otherwise>
        <img class="levelicon" src = "https://kr.object.ncloudstorage.com/scloud-service/service/member/level_1.png">
       <p>${gvo.guest_nickname}님은</p><P>이번달 we space의 스타터 입니다.</P>${10 -cnt}번 더 예약하면 플레이어가 될 수 있어요!
    </c:otherwise>
</c:choose>
<p>(단, 최소 이용금액 10,000원 이상의 예약만 집계에 반영됩니다)</p>


<div id="btnWrap">
<button type="button" id="popupBtn">전체 등급별 혜택 보기</button>
</div> 
</div>
 <div id="modalWrap">
    <div id="modalBody">
     <span id="closeBtn">&times;</span>
    <div style="text-align:center"><h1>등급별 혜택</h1>
    <h4>단, 최소 이용금액 1만원 이상</h4>
     </div>
     
    <ul class="levelWrap">
     <li> <img class="levelicon" src = "https://kr.object.ncloudstorage.com/scloud-service/service/member/level_1.png">스타터
     <br>예약 수 10회 미만</li>
	<li><img class="levelicon" src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_2.png">플레이어 
	<br> 예약 수 10회 이상<br>💌1000원 쿠폰 제공</li>
	<li><img class="levelicon"  src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_3.png">챌린저 
	<br>예약 수 20회 이상<br>💌2000원 쿠폰 제공</li>
	<li><img class="levelicon" src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_4.png">크리에이터
	<br>예약 수 30회 이상<br>💌3000원 쿠폰 제공 </li>
	<li><img class="levelicon" src="https://kr.object.ncloudstorage.com/scloud-service/service/member/level_5.png">스클러 
	<br>예약 수 50회 이상<br>💌5000원 쿠폰 제공<br><br><br><br><br></li>
    </ul> 
      
     </div>
     </div> 
     
 
<script><!--모달창 부분-->

const btn = document.getElementById('popupBtn');
const modal = document.getElementById('modalWrap');
const closeBtn = document.getElementById('closeBtn');

btn.onclick = function() {
  modal.style.display = 'block';
}
 closeBtn.onclick = function() {
  modal.style.display = 'none';
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

</script>
</body>
</html>