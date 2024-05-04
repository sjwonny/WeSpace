<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .pop_wrap{
    	width: 100%;
	    position:fixed;
	     top:10%;
	     left:0; 
	     right:0; 
	     bottom:0; 
	     background:rgba(1,1,0,.5); 
	     font-size:0; 
	     text-align:center;
	     z-index: 9999;
     }
     .pop_inner{
		
		background-color: #fff; /* 팝업 창의 배경색을 흰색으로 설정 */
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5); /* 그림자 효과 추가 */
        display: inline-block;
	}
	
	.pop_wrap:after{
		 height:100%; 
		vertical-align:middle; 
		content:'';
	}
	
	.pop_wrap .pop_inner{
		
		padding:40px 100px; 
	    background:#fff; 
		vertical-align:middle; 
		font-size:23px;
	} 
</style>
</head>
<body>

<div align="center">
		<form action="${pageContext.request.contextPath}/ds/pckgUpdate"  name="pack" id="pack">
			<input type="hidden" name="de_sp_add_no" id="de_sp_add_no"
				value="${de_sp_add_no}">
			<h2>패키지단위 가격 설정</h2>
			<h6>금액은 1,000원 이상,100원 단위로 입력이 가능합니다.</h6>
			<hr>
			<a href="#pop" class="popBtn" onclick="sendData()">패키지시간 추가 +</a>

			
      <div>
		<h2>추가인원 요금 설정</h2> 
		<div>공간가격에 대한 기준인원은
		<input type="text" name="pckg_prcst_person"> 명입니다.</div><br>
		<div>기준인원 초과 시, 추가인원 1인당 <input type="text" name="pckg_prcst_fee">원 요금을 추가합니다.</div>
	</div>
	<div align="center"><input type="button"
				id="save" value="저장" 
				 onclick="javascript:CheckForm()">
				</div>
</form>

	
	
	</div>
	<!-- 팝업창 -->
	<form action="${pageContext.request.contextPath}/ds/packageInsert"
		method="post" name="pckgDayPrice" id="pckgDayPrice">
		<div id="pop" class="pop_wrap"
			style="display: none; overflow-X: hidden">
			method="post" name="PackageTime"> 
			<div class="pop_inner">
				<table>
					<tr>
						<td><label for="pckgName">패키지명*</label></td>

					</tr>
					<tr>
						<td><input type="text" id="add_pckg_t_name"
							name="add_pckg_t_name">
							<hr></td>
					</tr>
					<tr>
						<td><label for="time">시간*</label></td>
					</tr>
					<tr>
						<td><select id="tm_no_start" name="tm_no_start"
							onchange="citykindchange(this.value)">
								<c:forEach var="start" items="${StartTime}">
									<option value="${start+1}">${start}시</option>
									<!-- value가 시간이 아니고 시간시퀀스니까 +1 해줌 -->
								</c:forEach>
						</select> ~ <select id="tm_no_end" name="tm_no_end"
							onchange="citykindchange(this.value)">
								<c:forEach var="end" items="${EndTime}">
									<option value="${end+1}">${end}시</option>
								</c:forEach>
						</select>
							<hr></td>
					</tr>
					<tr>
						<td><label for="host_pw">가격</label></td>
					</tr>

					<c:forEach var="dvo" items="${dlist}">
						<input type="hidden" name="day_week_no[]" value="${dvo.day_week_no}">
						<tr>
							<td>${dvo.day_week_date}<input type="text"
								name="day_price_price[]" id="day_price_price"></td>
						</tr>
					</c:forEach>
				</table>
				<div class="btns">
					<button class="pop_save pop_col" onclick="sendInsert()">저장</button>
				</div>
			</div>
		</div>
	</form>


	<!-- 팝업창 끝 -->
	
	
	
	</div>
</body>


<script>
	var popBtns = document.querySelectorAll('.popBtn'); // 모든 팝업 열기 버튼 가져오기
	var popCloses = document.querySelectorAll('.pop_wrap .pop_close'); // 모든 팝업 닫기 버튼 가져오기

	// 팝업 열기
	popBtns.forEach(function(popBtn) {
		popBtn.addEventListener('click', function() {
			var popBtnID = this.getAttribute('href'); // 클릭된 버튼의 href 속성값 가져오기
			document.querySelector(popBtnID).style.display = 'block'; // 해당 팝업 보이게 설정
		});
	});
	
	
	
	
var pckgNo; //전역변수 생성
	// 패키지 추가 버튼을 클릭할 때 호출되는 함수
	function sendData() {


	    // 데이터를 가져와서 옮기는 작업을 수행합니다.
	      var de_sp_add_no = "${de_sp_add_no}";
	    var formData = { 
	        "de_sp_add_no": de_sp_add_no
	    };
	    console.log("데이터" + de_sp_add_no);
	    // AJAX를 통해 데이터 전송
	    $.ajax({
	        type: 'POST',
	        url: '${pageContext.request.contextPath}/ds/preInsert',
	        data: formData,
	        success: function(response) {
	            console.log("응답" + response);
	            pckgNo = response;
	        },
	        error: function(xhr, status, error) {
	            console.error("에러" + error);
	        }
	    }); 
	} 
	
	 function sendInsert() {
	   

	    var form = document.getElementById("pckgDayPrice");
	    var formData = new FormData(form);
	    formData.forEach(function(value, key) {
	        console.log(key + ": " + value);
	    });
	    formData.append("pckg_prcst_no", pckgNo.toString());
	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", form.action);
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState == 4) {
	            if (xhr.status == 200) {
	                console.log(xhr.responseText);
	                var response = xhr.responseText; 
	                alert("서버 응답: " + response); 
	                var popup = document.getElementById("pop"); // 팝업을 직접 참조
	                popup.style.display = 'none'; // 팝업 닫기
	            } else {
	                // 서버로부터 응답을 받지 못했을 때의 처리
	                alert("저장에 실패했습니다");
	                return;
	            }
	        }
	    };
	    xhr.send(formData);
	    event.preventDefault(); 
	}
	 
	 
	 
	//페이지 저장
	 function CheckForm() {
	     var form = document.getElementById("pack"); // 시간 단위 설정 폼 가져오기
	     if (form.pckg_prcst_person.value == "") {
	         alert("기준인원을 입력하십시오!");
	         return; 
	     } else if (form.pckg_prcst_fee.value == "") {
	         alert("초과요금을 입력하세요!");
	         return false; // 폼 제출 중지
	     } else {
	    	 var pckgNoInput = document.createElement('input');
	    	 pckgNoInput.type = 'hidden';
	    	 pckgNoInput.name = 'pckgNo';
	    	 pckgNoInput.value = pckgNo; // 전역 변수 hrNo의 값 할당
	         form.appendChild(pckgNoInput);
	         // 폼 제출
	         form.submit();
	     }
	 }
</script>
</html>