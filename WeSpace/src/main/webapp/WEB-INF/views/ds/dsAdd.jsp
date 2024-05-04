<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.image-container {
	display: flex;
	justify-content: left;
	margin-top: 10px;
}

.image-box {
	margin-left: 5px;
	margin-right: 5px;
}

.hidden-input {
	width: 0px;
	height: 0px;
	font-size: 0px;
	position: absolute;
	left: -3000px;
}

#spaceUsesList ul {
	list-style-type: none;
	padding: 0;
}

#spaceUsesList ul>li {
	border: 1px solid #ccc;
	margin: 5px;
	padding: 10px;
	cursor: pointer;
	float: left;
}

img {
	width: 200px;
	height: 200px;
	cursor: pointer;
}

.facility-space ul {
	list-style-type: none;
	padding: 0;
}

.facility-space ul li {
	border: 1px solid #ccc;
	margin: 5px;
	padding: 10px;
	cursor: pointer;
	float: left;
}




/* 폼 컨테이너의 스타일 */
form {
    width: 80%;
     margin: 0 auto; 
      margin-bottom :  100px;
}

/* 테이블의 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
  
}

/* 테이블 셀의 스타일 */
td {
    padding: 10px;
    border: 1px solid black;
}

/* 버튼의 스타일 */
input[type="button"] {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}


/* 목록 항목의 스타일 */
ul {
    list-style-type: none;
    padding: 0;
}

/* 목록 항목의 스타일 */
li {
    cursor: pointer;
    display: inline-block;
    margin-right: 10px;
}


/* 입력 필드의 스타일 */
input[type="text"],
input[type="number"],
textarea {
    width: calc(100% -500px); /* 필요에 따라 너비 조절 */
    padding: 8px;
    border-radius: 4px;
    border: 1px solid #ccc; /* 기본 테두리 색상 */
    box-sizing: border-box;
    margin-top: 5px;
    margin-bottom: 10px;
    text-align: center;
}

</style>
</head>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript">
	function checkInfo() {
		if(document.deinfo1.de_sp_info_name.value == ""){
			alert("세부 공간명은 필수 입력 항목입니다");
			document.deinfo1.de_sp_info_name.focus();
		}else if(document.deinfo1.de_sp_info_area.value == ""){
			alert("세부 공간면적은 필수 입력 항목입니다")
			document.deinfo1.de_sp_info_area.focus();
		}else{
		    document.getElementById('minValueInput').value = document.getElementById('de_sp_info_mintime').value; //예약조건 hidden으로 넘기기
		    document.getElementById('minPersonValueInput').value = document.getElementById('de_sp_info_minPerson').value; //same
			document.getElementById('maxPersonValueInput').value = document.getElementById('de_sp_info_maxPerson').value; //same 
	
			document.deinfo1.submit(); 
			
			
		}
	}
	
	
	var selectedItems = []; // 선택한 항목을 저장할 배열

    function selectUses(e) { //공간 용도 3개로 제한하고,선택 값을 누적으로 저장함
        var index = selectedItems.indexOf(e); // 이미 선택한 항목인지 확인
        
        var space_uses = document.getElementById("space_uses"); //서버로 넘어갈 애
        
        if (index === -1) { //선택한적 없을 때 
           if(selectedItems.length == 3){
            alert("최대 3개만 선택 가능합니다.");
            return;
         }
            // 선택한 항목이 아직 선택되지 않은 경우, 배열에 추가
            selectedItems.push(e);
           
            
        } else {
            // 이미 선택한 항목인 경우, 배열에서 제거
            selectedItems.splice(index, 1);
            
        }
        
        console.log("매개변수는?: " + e);
        console.log("선택된 항목?: " + selectedItems);
        
        // 선택한 항목을 쉼표로 구분하여 문자열로 변환하여 hidden input에 설정
        space_uses.value = selectedItems.join(",");  //서버로 넘어갈 애한테 배열 값을 ,넣어서 문자열로 토스함 
    } 
	
	
	
	
	
	
	function updateImage(input) {  //선택한 파일 사진으로 보여주기
	     var image = document.getElementById('uploaded-deimage');
	     if (input.files && input.files[0]) {
	       var reader = new FileReader();
	       reader.onload = function (e) {
	         image.src = e.target.result;
	       };
	       reader.readAsDataURL(input.files[0]);
	     }
	   }
	
	
    /* var imageCount = 0;
	 function attachdePhotos() { //사진 여러개 첨부
	    var fileInput = document.createElement('input');
	    fileInput.type = 'file';
	    fileInput.multiple = true;
	    
	    //파일 선택 시 동작
	    fileInput.addEventListener('change', function(event) {
	      var files = event.target.files;
	      var imageCount = Math.min(files.length, 5); // 최대 5개의 사진만 처리
	      
        //이미지 초기화
        for (var i = 0; i < 5; i++) {
            var previewImg = document.getElementById('preview_dephoto' + (i + 1));
            previewImg.src = 'https://recipe1.ezmember.co.kr/img/pic_none3.gif'; // 미리보기 이미지 초기화
        }
	      
	      //이미지 미리보기
	      for (var i = 0; i < imageCount; i++) {
	        var file = files[i];
	        var reader = new FileReader();
	        reader.onload = createImageHandler(i);
	        reader.readAsDataURL(file);
	      } 
	       // 이미지를 선택한 후 각 파일의 이름을 각각의 hidden input 요소의 value로 설정
	      for (var i = 0; i < imageCount; i++) {
	        var file = files[i];
	        var imageName = file.name; // 파일의 이름 가져오기
	        var inputName = 'dephoto' + (i + 1); // hidden input 요소의 name 설정
	        document.querySelector('input[name="' + inputName + '"]').value = imageName; // hidden input 요소의 value 설정
	      }
	    });
	    
	   fileInput.click(); 
	    
	  }
	 
	 
	 function createImageHandler(index) {
		    return function(event) {
		        var previewImg = document.getElementById('preview_dephoto' + (index + 1));
		        previewImg.src = event.target.result;
		    };
		} */
	 
		
		
	 
	//예약 기준 플마 버튼 작동
function increaseValue(inputId) {
  var inputElement = document.getElementById(inputId);
  inputElement.stepUp();
}

function decreaseValue(inputId) {
  var inputElement = document.getElementById(inputId);
  inputElement.stepDown();
}


//편의시설 다중선택

 var selectedFc = []; // 선택한 항목을 저장할 배열

        function selectFacility(e) { //라이프스타일 선택값을 3개로 제한하고,선택 값을 누적으로 저장함
            var index = selectedFc.indexOf(e); // 이미 선택한 항목인지 확인
            
            var facility = document.getElementById("facility"); //서버로 넘어갈 애
            
            if (index === -1) { //선택한적 없을 때 
            
                // 선택한 항목이 아직 선택되지 않은 경우, 배열에 추가
                selectedFc.push(e);
            } else {
                // 이미 선택한 항목인 경우, 배열에서 제거
                selectedFc.splice(index, 1);
            }
            
            console.log("매개변수는?: " + e);
            console.log("선택된 항목?: " + selectedFc);
            
            // 선택한 항목을 쉼표로 구분하여 문자열로 변환하여 hidden input에 설정
            facility.value = selectedFc.join(",");  //서버로 넘어갈 애한테 배열 값을 ,넣어서 문자열로 토스함 
        } 
       





</script>
<body style="margin-top:200px;">
	<form action="${pageContext.request.contextPath}/ds/insert1" method="post" name="deinfo1" id="deinfo1"  enctype="multipart/form-data"> <!-- 텍스트와 파일 둘 다 보낼때에도 enctype필요 -->
	<input type="hidden" name="basic_info_no" value="${basic_info_no}">
 	<table>
			<tr>
				<td><h5>세부 공간명*</h5></td>
				<td><input type="text" name="de_sp_info_name"></td>
			</tr>
			<tr>
				<td><h5>세부 공간 소개</h5></td>
				<td><textarea name="de_sp_info_exp" id="de_sp_info_exp" rows="9" cols="50" ></textarea></td>
			</tr>
			 <tr>
				<td><h5>세부 공간 유형</h5></td>
				<td>
				<div id="spaceUsesList">
            <ul>
               <c:forEach var="us" items="${uses }">
                  <li class="uses-item" onclick="selectUses(${us.SPACE_USES_NO})">${us.SPACE_USES_NAME}</li>
               </c:forEach>
            </ul> <input type="hidden" id="space_uses" name="space_uses_no">
				</div></td>
			</tr>
			<tr>
			<td><h5>세부 공간 면적*</h5></td>
			<td><input type="text" name="de_sp_info_area">㎡</td>
		</tr>
		<tr>
			<td><h5>세부 공간 대표 이미지*</h5></td>
			  <td> 
			    <img id="uploaded-deimage" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif"  cursor:pointer" style="width: 200px; height: 250px; margin-right: 300px; cursor:pointer">
				<input type="file" name="photo" id="photo" accept=".jpg, .jpeg, .png" class="hidden" onchange="updateImage(this)">
			</td>
		</tr>
	  
		
		
		
		<!-- 
		<tr>
			<th><h3>세부 공간 이미지*</h3></th>
			<td>
		
		 <div class="image-container">
        <div class="image-box">
            <input type="file" name="dephoto"  id="fileInput1" class="hidden-input">
            <img id="preview_dephoto1" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="이미지 없음">
        </div>
        <div class="image-box">
            <input type="file" name="dephoto"  id="fileInput2" class="hidden-input" >
            <img id="preview_dephoto2" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="이미지 없음">
        </div>
        <div class="image-box">
            <input type="file" name="dephoto"  id="fileInput3" class="hidden-input" >
            <img id="preview_dephoto3" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="이미지 없음">
        </div>
        <div class="image-box">
            <input type="file" name="dephoto" id="fileInput4" class="hidden-input" > 
            <img id="preview_dephoto4" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="이미지 없음">
        </div>
        <div class="image-box">
            <input type="file" name="dephoto" id="fileInput5" class="hidden-input" >
            <img id="preview_dephoto5" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="이미지 없음">
        </div>
    </div>
    <p class="result"> -->
        <!-- <input type="file" name="file" style="display:none;"> -->
     <!--  <input type="button" onclick="attachdePhotos()" value="이미지추가"> 이미지 파일을 추가 해 주세요. (JPG, JPEG, PNG)
    </p> -->
		
		
			<tr>
				<td><h5>편의시설</h5></td>
				<td>
					<div class="facility-space">
						<input type="hidden" name="facility_no" id="facility">
						<ul>
							<c:forEach var="fvo" items="${flist}">
								<li onclick="selectFacility(${fvo.facility_no})"><img src="${pageContext.request.contextPath}/resources/images/${fvo.facility_no}.png" style="width:35px; height:35px;  margin: 0 auto; display: block; "><br><span style="font-size: 12px;"> ${fvo.facility_name}</span></li>
							</c:forEach>
						</ul>
					</div>
				</td>
			</tr> 
			<tr>
			<td><h5>예약기준</h5></td>
		
		<td>	
	최소예약시간 <button type="button"  onclick="decreaseValue('de_sp_info_mintime')">-</button>
			 <input type="number" value="1" min="1"  id="de_sp_info_mintime">
			 <button type="button" onclick="increaseValue('de_sp_info_mintime')">+</button>
			 <br>
			
	최소수용인원 <button type="button" onclick="decreaseValue('de_sp_info_minPerson')">-</button>
			<input type="number" value="1" min="1" id="de_sp_info_minPerson">
			<button type="button" onclick="increaseValue('de_sp_info_minPerson')">+</button>
			<br>
	최대수용인원 <button type="button"  onclick="decreaseValue('de_sp_info_maxPerson')">-</button>
			<input type="number" value="1" min="1"   id="de_sp_info_maxPerson">
			<button type="button" onclick="increaseValue('de_sp_info_maxPerson')">+</button>
			<br>
			
		  <input type="hidden" id="minValueInput" name = "de_sp_info_mintime">
         <input type="hidden" id="minPersonValueInput"  name="de_sp_info_minPerson" >
         <input type="hidden" id="maxPersonValueInput" name="de_sp_info_maxPerson"> 
			</td>
		</tr>
		<tr>
			<td rowspan="2" colspan="2" align="center">
				<input type="button" value="이전" onclick="location.href=${ pageContext.request.contextPath }/" >
			
				<input type="button" id="next" value="다음" onclick="javascript:checkInfo()">
			</td> 
		</tr>
	</table>
</form>
</body>
</html>



<style>

</style>































