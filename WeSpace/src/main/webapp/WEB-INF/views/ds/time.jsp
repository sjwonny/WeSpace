<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>



	 .col{ 
		float: left;
	    width: 50%;
	    height: 50px;
	    line-height: 50px;
	    background: #fff;
	    text-align: center;
    }
    

    .pop_col{
    	float: left;
	    width: 50%;
	    height: 50px;
	    line-height: 50px;
	    background: #fff;
	    text-align: center;
    }
    .pop_wrap{
    	width: 100%;
	    position:fixed;
	     top:0;
	     left:0; 
	     right:0; 
	     bottom:0; 
	     background:rgba(0,0,0,.5); 
	     font-size:0; 
	     text-align:center;
	     margin-top: 270px;
     }
	.pop_inner{
		width: 580px;
		height: 800px;
		overflow-X: hidden;

	}
	.pop_wrap:after{
		display:inline-block; height:100%; 
		vertical-align:middle; 
		content:'';
	}
	.pop_wrap .pop_inner{
		display:inline-block; 
		padding:20px 30px; 
		background:#fff;  
		vertical-align:middle; 
		font-size:15px;
	} 
</style>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<h2>시간 단위 가격 설정</h2>
	반드시 부가세포함가로 금액을 설정해주세요.<br>
	금액은 1,000원 이상, 100원 단위로 입력이 가능합니다.<br><br></div>
	<hr>
<form action="${pageContext.request.contextPath}/ds/timeUpdate" name="time" id="time">
	<input type="hidden" name="de_sp_add_no" value="${de_sp_add_no}">
			<div>
				<div class="row">
					<div class="col">
						<input type="radio" name="set_px_hr_select" id="per_space" value="0">
						<label for="per_space" class="per_space">공간당 시간단위 가격 설정</label>
					</div>
					<div class="col">
						<input type="radio" name="set_px_hr_select" id="per_person" value="1">
						<label for="per_person" class="per_person">1인당 시간단위 가격 설정</label>
					</div>
				</div>
			</div>
	 

			<div class="row">
				<div class="col">요일</div>
				<div class="col">가격등록/수정</div>
			</div>
			<c:forEach var="dvo" items="${dlist}">
			<div class="row">
				<div class="col">${dvo.day_week_date}</div>
				<div class="col">
					<a href="#pop_${dvo.day_week_date}" class="popBtn" >등록하기</a> 
				</div>
			</div>
            </c:forEach>



	<div id="insertSection" style="display: none;" align="center">
		<h2>추가 인원 요금 설정</h2> <hr>
		<div>공간가격에 대한 기준인원은
		<input type="text" name="set_px_hr_person"> 명입니다.</div><br>
		<div>기준인원 초과 시, 추가인원 1인당 <input type="text" name="set_px_hr_fee">원 요금을 추가합니다.</div>
	</div>
	<div>
			<div align="center"><input type="button"
				id="save" value="저장" 
				 onclick="javascript:saveCheck()">
				</div>
		</div>
 	 </form>	
		<!-- 팝업창 -->
	<c:forEach var="dvo" items="${dlist}">
    <div id="pop_${dvo.day_week_date}" class="pop_wrap" style="display: none; overflow-X: hidden">
        <!-- 각 팝업에 대해 별도의 form을 생성 -->
        <form action="${pageContext.request.contextPath}/ds/timePrice" method="post" name="timePrice_${dvo.day_week_no}">
            <input type="hidden" name="day_week_no" value="${dvo.day_week_no}"> 
            <div class="pop_inner">
                <p class="dsc">${dvo.day_week_date}</p>
                <div class="pop_row">
                    <div class="pop_col">시간</div>
                    <div class="pop_col">가격</div>
                </div>
                <div class="pop_row">
                    <c:forEach var="time" items="${Times}" varStatus="loop">
                        <div class="pop_col">${time}시</div>
                        <input type="hidden" name="tm_no_start" value="${StartTime[loop.index]}">
                        <input type="hidden" name="tm_no_end" value="${EndTime[loop.index]}">
                        <br>
                        <div class="pop_col">
                            <input type="text" name="day_tm_pr_price_${dvo.day_week_no}_${StartTime[loop.index]}_${EndTime[loop.index]}" class="dayPrice"  oninput="copyToAllInputs(this)">
                        </div>
                    </c:forEach>
                </div>
                <div class="btns">
                    <input type="button" class="pop_close pop_col" value="취소" onclick="closePopup('pop_${dvo.day_week_date}')"> 
                    <button class="pop_save pop_col" onclick="savePrice('timePrice_${dvo.day_week_no}')">저장</button>
                </div>
            </div>
        </form>
    </div>
</c:forEach>
	
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
	
	// 팝업 닫기
	function closePopup(popupId) {
	    var popup = document.getElementById(popupId); // 팝업 요소 가져오기
	    popup.style.display = 'none'; 
	}
</script>

<script>
    var perSpaceRadio = document.getElementById('per_space'); //공간당 선택
    var perPersonRadio = document.getElementById('per_person'); //1인당 선택
    var insertSection = document.getElementById('insertSection'); //보이게하거나 숨기는 공간

    perSpaceRadio.addEventListener('change', function() { 
        if (this.checked) { //공간당 선택하면 
            insertSection.style.display = 'block'; //보이게
        } 
    });
    perPersonRadio.addEventListener('change', function() { 
        if (this.checked) {  //1인당 선택하면 
            insertSection.style.display = 'none'; //안보이게
        }
    });
    
    
    
    
   

</script>
<script>
	
    //저장 누를 때 
	function savePrice(formId) {
	    var form = document.getElementsByName(formId)[0]; // 해당 폼의 이름을 사용하여 폼 요소 가져오기
	    var formData = new FormData(form); // 폼 데이터 가져오기

	    // set_px_hr_no 값 가져오기
	    formData.append("set_px_hr_no", hrNo.toString());

	    
	    formData.forEach(function(value, key) {
	        console.log(key + ": " + value);
	    });

	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", form.action);
	    xhr.onload = function () {
	        if (xhr.status === 200) {
	            var response = xhr.responseText; // 서버에서 전송된 JSON 데이터 파싱
	            alert("서버 응답: " + response); // 서버에서 전송된 메시지를 alert 창에 표시
	            var popup = form.closest('.pop_wrap');
	            popup.style.display = 'none'; // 팝업 닫기
	        } else {
	            alert("저장에 실패했습니다.");
	            return;
	        }
	    };
	    xhr.send(formData); // 해당 폼의 데이터만 전송
	    
	    event.preventDefault(); //페이지 안넘어가게하기
	}
	 
	
	
</script>

<script>


//입력칸에 맨 위쪽에 작성하면 나머지도 같은 데이터 입력
function copyToAllInputs(input) {
    var value = input.value;
    var popup = input.closest(".pop_wrap");
    var allInputs = popup.querySelectorAll(".dayPrice");
    allInputs.forEach(function(element) {
        element.value = value;
    });
}


var hrNo; //전역변수 생성(여기에 라디오 select값 넣을 것)

//라디오버튼누르면 미리 저장(계속 insert되면 안되니까 한 번만)
$(document).ready(function() {
    // 라디오 버튼 변경 이벤트에 대한 핸들러 등록
    $('input[type="radio"]').on('change', function() {
        // 기본 제출 행동 방지
        event.preventDefault(); 
        // 선택된 값 가져오기
        var set_px_hr_select = $('input[name="set_px_hr_select"]:checked').val();
        var de_sp_add_no = $('input[name="de_sp_add_no"]').val();
        // formData 생성
        var formData = { 
            "set_px_hr_select": set_px_hr_select,
            "de_sp_add_no": de_sp_add_no
        };
        console.log("폼데이터", formData);
        // AJAX를 통해 데이터 전송
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/ds/timeinsert',
            data: formData,
            success: function(response) {
                console.log("응답" + response);
               hrNo = response;
            },
            error: function(xhr, status, error) {
                console.error("에러" + error);
            }
        });
    });
});



//페이지 저장
function saveCheck() {
    var form = document.getElementById("time"); // 시간 단위 설정 폼 가져오기
    var item = document.querySelector(".pop_wrap .dayPrice");
    if (form.set_px_hr_select.value == "") {
        alert("공간당인지 1인당인지 선택하십시오!");
        return; 
    } else if (item.value.trim() === "") {
        alert("값을 입력하세요!");
        return false; // 폼 제출 중지
    } else {
        if (form.set_px_hr_select.value == "1") {
            // 1인당을 선택한 경우
            form.set_px_hr_person.value = "0"; // 1인당인 경우 기준인원은 1명으로 설정
            form.set_px_hr_fee.value = "0"; // 추가인원 요금도 0으로 설정 
        } 
        var hrNoInput = document.createElement('input');
        hrNoInput.type = 'hidden';
        hrNoInput.name = 'hrNo';
        hrNoInput.value = hrNo; // 전역 변수 hrNo의 값 할당
        form.appendChild(hrNoInput);
        // 폼 제출
        form.submit();
    }
}

</script>
</html>




























