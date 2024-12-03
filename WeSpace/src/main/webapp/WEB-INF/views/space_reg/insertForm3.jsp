<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
 <style>
   .hidden{
      display: none;
   }
    ul {
        list-style-type: none;
        padding: 0;
    } 
    li {
    	list-style-type: none;
        border: 1px solid #ccc;
        cursor: pointer;
        float:left;
        width:200px;
  		height:30px;
  		font-size:15px;
  		text-align:center;    
  		background-color:#FFFFFF;    
    }
    
   .lfsty-span {
       display: block; 
        margin-bottom: 10px; /* 원하는 여백 크기로 조정하세요 */
    }
  /*  선택하면 색깔 바꾸기 */
    li{font-size:20px}
    .clear{clear:both}
    li.on{color:blue; background-color:#CCE5FF;}
    li.in{color:red;}
    
    .ins1 {
  width:200px;
  height:40px;
  font-size:15px;
  text-align:center;
	}
	.ins2 {
  width:110px;
  height:40px;
  font-size:18px;
  text-align:center;
	}
	.ins3 {
  width:700px;
  height:100px;
  font-size:15px;
	}
	.btn1 {
  width:200px;
  height:30px;
  font-size:15px;
  text-align:center;
	}
	.btn2 {
  width:80px;
  height:30px;
  font-size:15px;
  text-align:center;
	}
input[type="text"],
input[type="date"],
select {
    border-radius: 8px; /* 둥근 모서리 */
    background-color: #FFFFFF; /* 흰색 배경 */
    border: 1px solid #D6B9FF; /* 연보라색 테두리 */
    padding: 5px 10px; /* 패딩을 추가하여 모양 개선 */
    font-size: 15px; /* 글자 크기 조정 */
    color: #4A2C79; /* 대비가 잘 되는 짙은 텍스트 색상 */
    width: auto; /* 내용에 맞는 너비로 설정 */
    margin: 5px 0; /* 입력 필드 주변 여백 */
}

input[type="text"]:focus,
input[type="date"]:focus,
input[type="button"]:focus,
select:focus {
    outline: none; /* 포커스 시 기본 테두리 제거 */
    border-color: #A66AE1; /* 포커스 시 테두리 색상 변경 */
}
input[type="button"] {
    border-radius: 8px; /* 둥근 모서리 */
    background-color: #B39DDB; /* 보라색 배경 */
    border: 1px solid #A66AE1; /* 보라색 테두리 */
    color: #FFFFFF; /* 흰색 텍스트 */
    font-size: 15px; /* 글자 크기 */
    padding: 10px 20px; /* 충분한 패딩 추가 */
    cursor: pointer; /* 마우스 포인터를 클릭할 수 있게 표시 */
    width: auto; /* 버튼 너비 자동 조정 */
    margin: 5px 0; /* 버튼 간 간격 */
}

input[type="button"]:hover {
    background-color: #8A56D6; /* 호버 시 조금 더 어두운 보라색 */
    border-color: #8A56D6; /* 테두리 색도 어두운 보라색으로 변경 */
}
/* 라디오 버튼 및 체크박스 스타일 */
input[type="radio"], input[type="checkbox"] {
    -webkit-appearance: none; /* 기본 스타일 제거 (Chrome, Safari) */
    -moz-appearance: none; /* Firefox 기본 스타일 제거 */
    appearance: none; /* 기본 스타일 제거 */
    width: 20px;
    height: 20px;
    border-radius: 50%; /* 라디오 버튼은 원형으로 */
    border: 2px solid #A66AE1; /* 보라색 테두리 */
    background-color: #FFFFFF; /* 흰색 배경 */
    position: relative;
    cursor: pointer;
    margin: 0px 2px; /* 간격 조정 */
}
/* 라디오 버튼 선택된 상태 */
input[type="radio"]:checked {
    background-color: #A66AE1; /* 선택된 상태는 보라색 배경 */
    border-color: #A66AE1; /* 선택된 상태의 보라색 테두리 */
}

/* 체크박스 선택된 상태 */
input[type="checkbox"]:checked {
    background-color: #A66AE1; /* 선택된 상태는 보라색 배경 */
    border-color: #A66AE1; /* 선택된 상태의 보라색 테두리 */
}

/* 체크박스나 라디오 버튼에 점 추가 */
input[type="radio"]:checked::before, input[type="checkbox"]:checked::before {
    content: '';
    position: absolute;
    top: 4px;
    left: 4px;
    width: 10px;
    height: 10px;
    background-color: #FFFFFF; /* 흰색 점 */
    border-radius: 50%; /* 둥근 점 */
}
</style>   
<script>
// HTML이 로드된 후 실행될 JavaScript 코드
/* document.addEventListener("DOMContentLoaded", function() {
  // 각 체크박스의 초기값을 0으로 설정
  document.getElementById("public_holiday").value = "0";
  document.getElementById("mon_holiday").value = "0";
  document.getElementById("tue_holiday").value = "0";
  document.getElementById("wed_holiday").value = "0";
  document.getElementById("thu_holiday").value = "0";
  document.getElementById("fri_holiday").value = "0";
  document.getElementById("sat_holiday").value = "0";
  document.getElementById("sun_holiday").value = "0";
}); */
function checkJoin() {
	   var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	    checkboxes.forEach(function(checkbox) {
	        if (!checkbox.checked) {
	            checkbox.value = "0"; // 체크되지 않은 경우 0으로 설정
	        }
	    });
	    
	if (document.insert3.tm_no_start.value == "") { //참고 여기에서 tm_no_start는 id가 아니고 name임
		alert("시작시간을 입력하십시오!");
	} else if (document.insert3.tm_no_end.value == "") {
		alert("끝나는시간을 입력하십시오!");
	}else if (document.insert3.usage_info_floor.value == "") {
		alert("공간층수를 선택하십시오!");
	} else if (document.insert3.usage_info_park.value == "") {
		alert("주차여부를 선택하십시오!");
	} else if (document.insert3.usage_info_elvtr.value == "") {
		alert("엘레베이터여부를 선택하십시오!");
	} else {
		document.insert3.submit();
	}
	
} 

	    
	
	function selectFOption() {
	    var select = document.getElementById('myFloor');
	    var customInput = document.getElementById('customInput'); //나올 인풋창
	    var floorSpan = document.getElementById('floorSpan'); //옆에 층이라는 글자 구간

	    if (select.value === 'custom') { //직접입력 선택하면
	        customInput.style.display = 'inline-block'; //인풋창이 나온다.
	        floorSpan.style.display = 'inline-block'; 
	    } else { //다른거 선택하면
	        customInput.style.display = 'none'; //인풋창이 안나온다.
	        floorSpan.style.display + 'none';
	    }
	}
	function selectPOption() {
	    var select = document.getElementById('myPark');
	    var customInput2 = document.getElementById('customInput2'); //나올 인풋창
	    var parkSpan = document.getElementById('parkSpan'); //옆에 층이라는 글자 구간

	    if (select.value === 'custom') { //직접입력 선택하면
	        customInput2.style.display = 'inline-block'; //인풋창이 나온다.
	        parkSpan.style.display = 'inline-block'; 
	    } else { //다른거 선택하면
	        customInput2.style.display = 'none'; //인풋창이 안나온다.
	        parkSpan.style.display + 'none';
	    }
	}
	
	
	 var selectedHolidays  = []; //배열 생성
     
     
     function insertHday(){//추가하기 버튼 누를 때 실행되는 함수임
        var holidayDate = document.getElementById("myHoliday").value; 
        
           var index = selectedHolidays .indexOf(holidayDate); //이미 선택한 항목인지 확인 //selectedVaues배열에서 s_area의 값을 찾아내어 그 인덱스를 index 변수에 할당하는 것.
              
              if (index === -1) { //선택안했던 항목이라면 
                  // 배열에 추가
                  selectedHolidays.push(holidayDate);
              } else {
                 alert("중복된 날짜입니다");
                 return;
              }
              console.log("선택한 날짜는?: " + holidayDate); //선택한 애 
              console.log("배열에 담긴 날짜들?: " + selectedHolidays  );//배열에 담긴애들
              
              // 선택한 휴무일들을 쉼표로 구분된 문자열로 변환
              var holidaysString = selectedHolidays.join(", ");
        
        var target = document.getElementById("holidayList"); //넣을 구역(div태그의 id)
        
        // 선택한 날짜 보여주기
        var span = document.createElement("span");
        span.innerText = holidayDate;
        span.id = "select" + holidayDate;//span아이디 설정해주기 
        
        // 선택한 이름 옆 x버튼
        var input = document.createElement("input");
        input.type="button";
        input.value="X";
        input.id="rm_button"+holidayDate; //삭제 버튼 아이디 설정해주기
        input.onclick = () => deleteHoliday(holidayDate); 
        
        //생성한 span과 버튼 넣어주기
        target.appendChild(span); 
        target.appendChild(input);
     }
     
     function deleteHoliday(holidayDate){
        var remove = document.getElementById("select"+holidayDate);
        var btn = document.getElementById("rm_button"+holidayDate);
        
        for(let i = 0; i < selectedHolidays.length; i++) {
            if(selectedHolidays[i] === holidayDate)  { //선택한 x버튼에 해당하는 지역이 배열속에 있다면
            	selectedHolidays.splice(i, 1); //배열에서 삭제
              i--; //배열요소가 줄었기 때문에 인덱스 하나 줄여주는 것.
            }
          }
        
        
        remove.remove(); //span 지우기
        btn.remove(); //삭제버튼 지우기
        
        
     }
	
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<h2>이용정보를 입력해주세요</h2>
<form action="${ pageContext.request.contextPath }/space_reg/insert3" method="post" name = "insert3">
	<input type="hidden" name="space_info_no" value="${space_info_no }">
	<input type="hidden" name="contact_info_no" value="${contact_info_no }">
	<table>
		<tr>
			<td><h3>이용시간*</h3></td>
		<td>
			<select name ="tm_no_start" >
			    <option value=""> 시작시간 </option>
				<c:forEach var="vo" items="${tlist }" >
				
					<option value="${vo.tm_no}">${vo.tm_time}</option>
					
					</c:forEach>
			</select>
			
			부터
			<select name = "tm_no_end">
			    <option value=""> 마감시간 </option>
				<c:forEach var="vo1" items="${tlist }" >
				
					<option value="${vo1.tm_no}">${vo1.tm_time}</option>
					
					</c:forEach>
			</select>까지</td>
		</tr>
		
		<tr>
			<td><h3>공간층수*</h3></td>
			<td>
			<select class = "ins1" name = "usage_info_floor" id="myFloor" onchange="selectFOption()">
			        <option value="">층수여부 선택</option>
					<option value="지상1층">지상1층</option>
					<option value="지상2층">지상2층</option>
					<option value="지상3층">지상3층</option>
					<option value="지하1층">지하1층</option>
					<option value="지하2층">지하2층</option>
					<option value="지하3층">지하3층</option>
					<option value="custom">직접입력</option>
			</select>
			 <input type="text" id="customInput" style="display: none;" placeholder="4이상의 숫자만 입력">
			 <span id="floorSpan" style="display: none;">층</span>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><h3>주차여부*</h3></td>
			<td>
			<select class = "ins1" name = "usage_info_park" id="myPark" onchange="selectPOption()">
			        <option value="">주차여부 선택</option>
					<option value="0">주차불가</option>
					<option value="1">1대</option>
					<option value="2">2대</option>
					<option value="3">3대</option>
					<option value="4">4대</option>
					<option value="custom">직접입력</option>
				</select>
			     <input type="text" id="customInput2" style="display: none;" placeholder="5이상의 숫자만 입력">
				 <span id="parkSpan" style="display: none;">대</span>
		</tr>
		<tr>
			<td><h3>엘레베이터 여부*</h3></td>
            <td>
                <label for="yes">있음</label>
                <input type="radio" id="yesEV" name="usage_info_elvtr" value="1" >
                <label for="no">없음</label>
                <input type="radio" id="noEV" name="usage_info_elvtr" value="0">
           </td>
		</tr>
		<tr>
			<td><h3>정기휴무*</h3></td>
            <td><c:forEach var="dvo" items="${dList }" >
            ${dvo.day_week_date}
                <input type="checkbox" name="dayWeekNo[]" value="${dvo.day_week_no}">
            </c:forEach>
           </td>
		</tr>
		<tr>
		<td><h3>지정휴무일 추가</h3></td>
		   <td>
                <input type="date" id="myHoliday" name="dsg_closed_day">
                <input type="button" onclick="insertHday()" value="추가">
		   </td>
		</tr>
		<tr>
		<td><h3>추가한 태그</h3></td>
		<td>
            <div id="holidayList"> <!-- target이 됨 -->
            </div>
        </td>
		</tr>
		<td colspan="2" align="center">
				<input type="button" value="이전" onclick="javascript:history.back();">
				<input type="button" id ="insert" value="저장" onclick="javascript:checkJoin()" >
			</td>
		</tr>
	</table>		
</form>
</div>
        
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>











