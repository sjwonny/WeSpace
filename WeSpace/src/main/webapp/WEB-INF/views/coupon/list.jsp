<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

.container {
  width: 100%;
  height: 100vh;
  justify-content: center;
  align-items: center;
  display: flex;
  background-color: #dc143c;
}
.card {
  width: 400px;
  height: 180px;
  border-radius: 5px;
  box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.2);
  background-color: #fff;
  padding: 10px 10px;
  position: relative;
}

.main
 {
  display: flex;
  justify-content: space-between;
  padding: 0 10px;
  align-items: center;
}


.co-img img {
  width: 170px;
  height: 100px;
}
 .vertical {
  border-left: 5px dotted black;
  height: 100px;
  position: absolute;
  left: 40%;
} 

h3,h4{
text-align: center;
margin-top:30px;
margin-bottom:50px;
}
.content h1 {
  font-size: 35px;
  margin-left: -20px;
  color: #565656;
}

.content h1 span {
  font-size: 18px;
}
.content h2 {
  font-size: 18px;
  margin-left: -20px;
  color: #565656;
  text-transform: uppercase;
}

.content p {
  font-size: 16px;
  color: #696969;
  margin-left: -20px;
}


/* /*여기부터 다른것*/
* {
    margin: 0;
    padding: 0;
    border: 0;
    box-sizing: border-box
}



h1 {
    text-transform: uppercase;
    font-weight: 900;
    border-left: 10px solid #fec500;
    padding-left: 10px;
    margin-bottom: 30px;
    margin-top : 20px;
}


.card {
    display: table-row;
    width: 49%;
    background-color: #fff;
    color: #989898;
    margin-top : 70px;
    margin-bottom: 10px;
    font-family: 'Oswald', sans-serif;
    text-transform: uppercase;
    border-radius: 4px;
    position: relative
}

</style>
<script>

let copybtn = document.querySelector(".copybtn");


function copyIt(){
  let copyInput = document.querySelector('#copyvalue');

  copyInput.select();

  document.execCommand("copy");

  copybtn.textContent = "COPIED";
}
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<h3>내가 보유한 쿠폰</h3>
	<h4>총 ${countCpn }개</h4>
	
	
	
	
	<c:forEach var="cvo" items="${clist}">
	 <div class="container">
      <div class="card">
        <div class="main">
          <div class="co-img">
           <img class="img-logo" src="${pageContext.request.contextPath}/resources/images/wespace logo.png">
          </div>
          <div class="vertical"></div>
          <div class="content">
            <h2>${cvo.CPN_NAME}</h2>
           <span> <h1>${cvo.CPN_PRICE}원 할인</h1></span>
            <p>유효기간 : ${cvo.CPN_PER}일 / 최소이용시간 : ${cvo.CPN_MINIPER}시간
            <br>${cvo.A} 까지</p>
          </div>
        </div>
      </div>
    </div> 
    <br><br><br><br><br><br>
</c:forEach>



</body>
</html>