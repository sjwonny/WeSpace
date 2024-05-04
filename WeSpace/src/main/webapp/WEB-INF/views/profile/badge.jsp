<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
ul{list-style: none;} /* 리스트 앞에 . 같은거 제거*/



.badge_list li {
  text-align: center;
}



.badge_list li img {
 
    width: 100px; height: 100px; 
   
    border-radius: 50%;  
    box-shadow: 0 0 3px rgba(0, 0, 0, 0.25); 
}
img {
    vertical-align: middle;
    border: 0;
    
}

.badge_list li {
  flex: 0 0 calc(12.5% - 10px); /* 8개의 사진을 한 줄에 배치 (10px는 사진 사이의 간격) */
  margin-right: 20px; /* 사진들 간의 오른쪽 간격 */
  margin-bottom: 60px; /* 사진들 간의 아래쪽 간격 */
   text-align: center;
   margin-left: 70px;
}
.badge_list {
    padding-top: 60px; 
    width:70%;
    display: flex;
    flex-wrap: wrap;
}
.badge_list li p {
  font-size: 14px; /* 원하는 글씨 크기로 변경 */
  color: black; /* 검정색으로 변경 */
}
.sub_tit {
    padding: 60px 0 50px 0;
    text-align: center;
    line-height: 1;
}

<!--모달창-->
#btnWrap {
  width: 500px;
  margin: 100px auto;
 
}

#modalWrap{
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
  height: 500px;
  padding: 30px 30px;
 /*  margin: 0 auto; */
  border: 1px solid #777;
  background-color: #fff;
    border-radius: 10px;
    margin-top:100px;
}

#closeBtn {
  float:right;
  font-weight: bold;
  color: #777;
  font-size:25px;
  cursor: pointer;
}
<!--이미지 크기 변경-->
#here.img {
  width:50px;
  height:50px;
}
</style>
<script>

</script>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center" >
	<div class="sub_tit_m" style="font-size:30px; font-weight: bold; margin-top:50px;">내 배지</div>
	<p>지금까지 획득한 배지를 만나보세요!<br>we space에서 활동이 많아질수록 더 다양한 배지를 모을 수 있어요:)</p>

		
	<ul class="badge_list">
    <c:forEach var="vo" items="${list}">
        <c:choose>
           <c:when test="${myList.contains(vo.badge_name)}">
                <li id="popupBtn" class="popupBtn" divide-no="1"  onclick="selectItem(this,${vo.badge_no})">
                  <img src="${pageContext.request.contextPath}/resources/images/${vo.badge_name}.png">
                  <p>${vo.badge_name}</p>
                </li>
            </c:when>
            <c:otherwise>
                <li id="popupBtn" class="popupBtn"  divide-no="2" onclick="selectItem(this,${vo.badge_no})">
                 <img src="${pageContext.request.contextPath}/resources/images/lock.svg" >
                 <p>${vo.badge_name}</p>
                </li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>	
 <div id="modalWrap" class="modal">
 <div id="modalBody">
     <span id="closeBtn">&times;</span>
    <div style="text-align:center">
       <div id="here"></div>
       <br>
    <span id ="check"></span>
    <br>
    <h5>배지 획득 방법</h5>
    <span id ="info"></span> 
     </div>
     </div>
     </div>  
  
  
  
  
<script>

<!--모달창 부분-->


const modalWrap = document.getElementById('modalWrap');
const closeBtn = document.getElementById('closeBtn');

function selectItem(element, badge_no) {
	
	  //구분 번호
		const divide_no = element.getAttribute('divide-no');
   // ajax(값 보내기)부분 시작
    param =  "badge_no=" +badge_no;

    var url = "${pageContext.request.contextPath}/profile/badgeNo";
    /* sendRequest(url,param,resultFn(divide_no),"POST");  */
  // ajax부분 끝 
  
  sendRequest(url, param, function() {
        resultFn(divide_no); // divide_no를 인수로 resultFn 함수를 호출
    }, "POST");
  
  // modal 변수를 모달 창으로 설정
	  const modal = modalWrap;
  
  if (modal) {
  // 모달을 보이게 함
	    modal.style.display = 'block';
	  }
	}
closeBtn.onclick = function() {
  modalWrap.style.display = 'none';
};

// 모달 외부를 클릭하면 모달 닫기
 window.onclick = function(event) {
  if (event.target == modalWrap) {
    modalWrap.style.display = "none";
  }
}; 

function resultFn(divide_no) {
    if(xhr.readyState==4 && xhr.status==200) {
    var data = xhr.responseText; //컨트롤러에서 받아온 값
    
    var dataDivide = JSON.parse(data); // JSON 문자열을 파싱하여 JavaScript 객체로 변환//변수명은 그냥 지은것임
    var badge_no = dataDivide.badge_no;
    var badge_name = dataDivide.badge_name;
    var badge_info = dataDivide.badge_info;
   
    
    
    clearImages(); //함수 호출
    
    
    	 var imgElement = document.createElement('img'); 
    if (divide_no === '1') {
    	 imgElement.src = '${pageContext.request.contextPath}/resources/images/' + badge_name + '.png';
    	 imgElement.setAttribute('data-badge-no', badge_no); // 데이터를 추가하여 중복을 방지
     	 imgElement.style="width:100px; height:100px; margin:50px 0 50px 10px;" 
    	 here.appendChild(imgElement);
    } if (divide_no === '2') {
    	 imgElement.src = '${pageContext.request.contextPath}/resources/images/lock.svg';
    	 imgElement.setAttribute('data-badge-no', badge_no); // 데이터를 추가하여 중복을 방지
         imgElement.style="width:100px; height:100px; margin:50px 0 50px 10px;"
    	 here.appendChild(imgElement);
    
    }
    	 check.style.cssText="font-weight: bold; font-size: 30px;";
    	 check.innerText = badge_name;
    	 info.innerText = badge_info;
   
    
    }
}

function clearImages() {
    var existingImages = document.querySelectorAll('#here img');
    existingImages.forEach(function(image) {
        image.remove();
    });
}


</script>
			 
			 

</body>
</html>