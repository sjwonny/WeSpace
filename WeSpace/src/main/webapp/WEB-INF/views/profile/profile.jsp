<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My Profile</title>
<style>

body {
   
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background: #ecf0f3;
}

/*관심사 테두리*/
.intrareaList,.profileOne,.interestList{
	border: 1px solid #ccc;
	margin: 5px;
    padding: 10px;
    float:left;
    font-size:9px;
    border-radius: 10px; 
}
.wrapper,
.wrapper .img-area,
.buttonbundle  button{
    background: #ecf0f3;
    box-shadow: -3px -3px 7px #ffffff, 3px 3px 5px #ceced1; 
}
.wrapper {
    position: relative;
    width: 450px;
    height:550px;
    padding: 30px;
    border-radius: 10px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    margin-left:100px;
    margin-top:100px;
}



    .wrapper .img-area {
        height: 200px;
        width: 200px;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        margin-top:-20px;
    }

.img-area .inner-area {
    height: calc(100% - 25px);
    width: calc(100% - 25px);
    border-radius: 50%;
}

.inner-area img {
    height: 100%;
    width: 100%;
    border-radius: 50%;
    object-fit: cover;
}

.wrapper .nickname {
    font-size: 23px;
    font-weight: 500;
    color: #31344b;
    margin: 10px 0 5px 0;
}
/*관심사 내용 위치 조정*/
#selectedInfo{
margin-top:-30px;
margin-bottom:70px;
}


/* input[type="file"] 요소에 대한 스타일 */
input[type="file"]{
  display: none; /* 원래 input[type="file"] 요소는 감추고 */
}

/* 커스텀 스타일이 적용된 라벨 */
#OkayBtn,label[for="photo-file"] {
  margin: 10px 0px 0px 20px;

  background-color: #2CBEB1;
  color: white;
  padding: 3px 3px 3px 3px;
  border-radius: 10px; 
  cursor: pointer; /* 커서를 포인터로 변경하여 클릭 가능한 모양으로 표시 */
  display: inline-block; /* 라벨을 inline-block 요소로 변경하여 텍스트와 같이 표시 */
  font-size: 15px;
}
#photoBtns,.bundle{
display: flex;
}
.bundle{
margin-left:16%;
}
#border1{
font-weight: bold;
}

.profiletable{
margin-top:50px;
}

<!--목록, 탈퇴 버튼-->


.buttonbundle  button:hover:before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
        border-radius: 50%;
        background: #ecf0f3;
        box-shadow: inset -3px -3px 7px #ffffff, inset 3px 3px 5px #ceced1;
    }
.buttonbundle  button:hover:before {
    z-index: -1;
    border-radius: 5px;
}

.wrapper .buttonbundle {
    display: flex;
    width: 100%;
    justify-content: space-between;
}

.buttonbundle  button {
    position: relative;
    width: 100%;
    border: none;
    outline: none;
    padding: 12px 0;
    color: #31344b;
    font-size: 17px;
    font-weight: 400;
    border-radius: 5px;
    cursor: pointer;
    z-index: 4;
}

.buttonbundle  button:first-child {
        margin-right: 10px;
}

.buttonbundle  button:last-child {
        margin-left: 10px;
}


</style>
  
    
<script type="text/javascript">
if('${msg}' !== ""){
	alert('${msg}');}       
</script>
<script>


	function updateImage(input) { //선택한 사진 미리보기로 보여줌
		var image = document.getElementById('uploaded-image'); 
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				image.src = e.target.result;
			};
			reader.readAsDataURL(input.files[0]);
		}
	}

	function sendImg() {
		var fileInput = document.getElementById('photo-file'); //선택한 파일
		var file = fileInput.files[0]; //첫번 째 파일 가져오기

		if (!file) { //선택한 파일이 없는경우
			console.log("파일이 선택되지 않았습니다.");
			return;
		}

		var formData = new FormData(); //FormData객체: 서버로 데이터 전송할 때 쓰임
		formData.append('img', file); //img라는 이름으로 전송

		var url = "${pageContext.request.contextPath}/profile/img";

		var xhr = new XMLHttpRequest();
		xhr.open("POST", url, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) { //4: 통신이 완료됐음
				if (xhr.status === 200) { //200: 성공적 응답 나타냄
					alert("변경 성공");
				} else {
					alert("변경 실패");
				}
			}
		};
		console.log("폼데이터" + formData);
		xhr.send(formData);
	}
	
/* 회원 탈퇴 */

function confirmModal() {
	if (window.confirm("정말 탈퇴하시겠습니까?")) {
		return true;
	} else {
		return false;   
 }
}
	 	
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div class="bundle">	  
    <div class="wrapper" >
<form action="${pageContext.request.contextPath}/profile/img" method="post" enctype="multipart/form-data" name="data">
<c:choose>
        <c:when test="${!empty gvo.guest_img}">
        <div class="img-area">
            <div class="inner-area">
                <img id="uploaded-image" src="${pageContext.request.contextPath}/resources/update/${gvo.guest_img }"/>
				<div id="photoBtns"> 
                <label for="photo-file" >사진 변경
					<input type="file" name="img" id="photo-file" accept=".jpg, .jpeg, .png" onchange="updateImage(this)"> <!-- 파일 선택 -->
			    </label>
			    <input id="OkayBtn" type="button" value="저장"  onclick="sendImg()" style="font-size: 13px; border-radius: 12px;">
			    </div> 
			   
            </div> 
        </div>   
        </c:when>
        <c:otherwise>    
		<div class="img-area">
            <div class="inner-area">
                <img id="uploaded-image"
				src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTExMjZfMTg2%2FMDAxNjM3OTA1NjUyOTIw.eX8gewQbE7_bhldD-nKIFWEH9wcZJnENh-FxfiIXBbEg.qS2lvjBUuPTTV1GdcICvSIdlTUgNw8_lPscvtmifkq8g.JPEG.dlehdrber%2F20211125%25A3%25DF173535.jpg&type=sc960_832">
               <div id="photoBtns"> 
                <label for="photo-file">사진 변경
					<input type="file" name="img" id="photo-file" accept=".jpg, .jpeg, .png" onchange="updateImage(this)">
			    </label>
				    <input id="OkayBtn" type="button" value="저장"  onclick="sendImg()" >
            </div> 
            </div>
        </div>
        </c:otherwise>
    </c:choose>
        </form>
        
        
        <table class="profiletable" >
		<tr>
			<td id="border1">닉네임</td>
			<td id="border">&nbsp; ${gvo.guest_nickname}</td> 
		</tr>
		<tr>
			<td id="border1">이름</td>
			<td id="border">&nbsp; ${gvo.guest_name}</td>
		</tr>
		<tr>
			<td id="border1">이메일</td>
			<td id="border">&nbsp; ${gvo.guest_email}</td>
		</tr>
		<tr>
			<td id="border1">전화번호</td> 
			<td id="border">&nbsp; ${gvo.guest_phone}</td> 
		</tr>
		<tr>
			<td id="border1">성별</td>
			<td id="border">&nbsp; ${gvo.guest_gndr}</td> 
		</tr>
		<tr>
			<td id="border1">생일</td> 
			<td id="border">&nbsp; ${gvo.guest_birth}</td> 
		</tr>
</table>
      
    </div>
     <div class="wrapper" >
     	<div id="selectedInfo">
		<h4>🏕️관심지역🏕️</h4>
		<c:forEach var="all" items="${dlist}">
			<div class="intrareaList">${all.detaarea_detail}</div>
		</c:forEach>
		<Br>
		<Br>
		<h4>😊프로필</h4>
		<div class="profileOne">${pvo.profile_item}</div>
		<Br>
		<Br>
		<h4>😊관심사</h4>
		<c:forEach var="all" items="${llist}">
			<div class="interestList">${all.lfsty_item}</div>
		</c:forEach>
	</div>
	<div class="buttonbundle">
             <a href="${pageContext.request.contextPath }"><button>목록</button></a>
             <a href="${pageContext.request.contextPath}/profile/update"><button>관심사 수정</button></a>
            <a href="${pageContext.request.contextPath}/guest/unregister" class=""><button onclick="return confirmModal()">회원 탈퇴</button></a>
        </div>
     </div>
   </div>
</body>