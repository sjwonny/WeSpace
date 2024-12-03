<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
input[type="text"], textarea, input[type="button"], select {
    border-radius: 8px; /* 모서리를 둥글게 */
    border: 1px solid #B085F5; /* 보라색 테두리 */
    padding: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
    margin-left: 10px; /* 왼쪽 여백 추가 */
    margin-right: 10px; /* 오른쪽 여백 추가 */
}

input[type="text"]:focus, textarea:focus, input[type="button"]:hover, select:focus {
    border-color: #7E57C2; /* 포커스 시 보라색 강조 */
    box-shadow: 0 4px 8px rgba(126, 87, 194, 0.2);
    outline: none;
}

input[type="button"] {
    background-color: #B39DDB; /* 보라색 버튼 배경 */
    color: #FFFFFF; /* 버튼 텍스트 흰색 */
    cursor: pointer;
}

input[type="button"]:hover {
    background-color: #7E57C2; /* 버튼 호버 시 진한 보라색 */
}

.table th, .table td {
    padding: 10px;
    margin-left: 10px; /* 테이블 셀의 왼쪽 여백 추가 */
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-left: 10px; /* 전체 테이블 왼쪽 여백 */
    margin-right: 10px; /* 전체 테이블 오른쪽 여백 */
}

th, td {
    padding: 10px; /* 좌우 균일한 여백 */
    margin-left: 10px; /* 셀 왼쪽 여백 */
}

.devide1, .devide2 {
    width: 48%; /* 각각 절반의 크기 */
    display: inline-block; /* 나란히 배치 */
    vertical-align: top; /* 상단 정렬 */
}

.space-title {
    font-size: 24px; /* 폰트 크기 조정 */
    font-weight: bold;
}

.hidden {
    display: none;
}

/* ul {
    list-style-type: none;
    padding: 0;
} */

.uses_btn, .theme_btn {
    list-style-type: none;
    border: 1px solid #ccc;
    cursor: pointer;
    float: left;
    width: 200px;
    height: 30px;
    font-size: 15px;
    text-align: center;
    background-color: #FFFFFF;
    margin-left: 10px; /* 왼쪽 여백 추가 */
}

.lfsty-span {
    display: block;
    margin-bottom: 10px; /* 원하는 여백 크기로 조정 */
}

.uses_btn, .theme_btn {
    font-size: 20px;
}

.clear {
    clear: both;
}

.uses_btn.on, .theme_btn.on {
    color: blue;
    background-color: #CCE5FF;
}

.uses_btn.in, .theme_btn.on {
    color: red;
}

.ins1 {
    width: 700px;
    height: 30px;
    font-size: 15px;
}

.ins2 {
    width: 90px;
    height: 40px;
    font-size: 15px;
    text-align: center;
    background-color: #B39DDB;
}

.ins3 {
    width: 700px;
    height: 100px;
    font-size: 15px;
}

.btn1 {
    width: 200px;
    height: 30px;
    font-size: 15px;
    text-align: center;
}

.btn2 {
    width: 80px;
    height: 30px;
    font-size: 15px;
    text-align: center;
}

#uploaded-image {
    width: 300px;
    height: 300px;
    font-size: 13px;
    border-radius: 15px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 효과 */
    overflow: hidden;
}

.img1 {
    width: 200px;
    height: 200px;
    font-size: 13px;
}

.a {
    margin-top: 20px; /* 아래 버튼 여백 추가 */
    height: 70%;
}

.b {
    text-align: center;
    margin-left: 20px;
}

/* 네모칸 내부 텍스트 스타일링 */
.space_type input[type="text"],
td li.theme_btn {
    border: 1px solid #d1c4e9; /* 보라색 계열 테두리 */
    font-weight: bold; /* 텍스트 굵게 */
    padding: 10px 0px; /* 내부 여백 */
    border-radius: 8px; /* 둥근 모서리 */
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
    text-align: center; /* 텍스트 중앙 정렬 */
    margin: 0 2px;
}

td li.uses_btn {
    border: 1px solid #d1c4e9; /* 보라색 계열 테두리 */
    font-weight: bold; /* 텍스트 굵게 */
    padding: 5px 0px; /* 내부 여백 */
    border-radius: 8px; /* 둥근 모서리 */
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
    text-align: center; /* 텍스트 중앙 정렬 */
    
}

/* 버튼 hover 효과 */
td li.uses_btn:hover,
td li.theme_btn:hover {
    background-color: #d1c4e9; /* 호버 시 진한 보라색 배경 */
    cursor: pointer; /* 마우스 포인터 변경 */
    transform: scale(1.05); /* 살짝 확대 */
}
</style>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<h2>공간 정보를 입력해주세요</h2>
<form action="${ pageContext.request.contextPath }/space_reg/insert" method="post" name = "insert" enctype="multipart/form-data" >
	<table>
		<tr>
			<td class="space-title">공간명*</td>
			<td>
				<input type="text" name = "space_info_name" autocomplete="off" class="ins1">
			</td>
		</tr>
		</table>
		<br>
		
		<div >
		<table style=" margin-left: -2px;">
		<thead >
		<tr><th><h3>공간유형*</h3></th>
		</tr>
		</thead>
				<tbody>
					<c:forEach var="tp" items="${type}">
						<tr>
							<c:choose>
								<c:when test="${tp.space_type_cat == 0 }">
									<th class="space_type"><input type="text" class="ins2"  readonly="readonly" value="${tp.space_type_name}"> <!--li태그 안쓰고 이렇게도 가능!-->
									</th>
								</c:when>
							</c:choose>
							<c:forEach var="us" items="${uses}">
								<c:choose>
									<c:when test="${tp.space_type_name == us.SPACE_TYPE_NAME}">
										<!-- 모임이면 모임의 용도,캠핑이면 캠핑의 용도 -->
										<td>
											<li class="uses_btn" onclick="selectUses('${us.SPACE_TYPE_NAME}',${us.SPACE_USES_NO})"> ${us.SPACE_USES_NAME}</li> <!-- 용도명 나열// 매개변수 2개-->
										</td>
										<input type="hidden" id="space_uses" name="space_uses_no">
										<!-- 이거 왜 넘기는걸까? 자바스크립트때문 -->
									</c:when>
								</c:choose>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<br>
		
		<div align="left">
		<table>
		<thead > 
		<tr><th><h3>공간테마</h3></th>
		</tr>
		</thead>
				<tbody>
					<c:forEach var="tp" items="${type}">
						<tr>
							<c:choose>
								<c:when test="${tp.space_type_cat == 1 }">
									<!-- 카테고리 1유형 -->
									<th class="space_type"><input type="text" class="ins2" readonly="readonly" value="${tp.space_type_name}">
									<!-- 유형3가지 나열 --></th>
								</c:when>
							</c:choose>
							<c:forEach var="th" items="${theme}">
								<c:choose>
									<c:when test="${tp.space_type_name == th.SPACE_TYPE_NAME}">
										<!-- 모임/파티면 모임/파티의 테마,공부/업무면 공부/업무의 테마 - -->
										<td>
											<li class="theme_btn" onclick="selectTheme(${th.SPACE_THEME_NO})">${th.SPACE_THEME_NAME}</li>
										</td>
										<input type="hidden" id="space_theme" name="space_theme_no">
									</c:when>
								</c:choose>

							</c:forEach>

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		</div>
		
		<br>
		<div class="a">
		<div style="width:100%; display:flex; justify-content:space-between;">
		<div class="devide1">
        <table> 	
		<tr>
			<th><h3>공간 한 줄 소개*</h3></th>
			<td><input type="text" class="ins1" name = "space_info_tip" placeholder="공간의 특장점을 한 문장으로 작성해 주세요."></td>
		</tr>
		
		
		<tr>
			<th><h3>공간소개*</h3></th>
            <td>  <textarea name="space_info_intrd" class="ins3" rows="9" cols="50" placeholder="게스트들에게 필요한 공간 정보를 상세하게 소개해주세요. 툴팁을 클릭해 작성 가이드를 확인할 수 있습니다."></textarea>		</td>
		</tr>
		<tr>
			<th><h3>공간태그*</h3>
			<td><input type="text" class="ins3" value = "" id = "space_tag" placeholder="게스트들이 선호할만한 주요 특징들을 키워드로 입력해주세요. (최대 10개)">
			<input type="button" class="btn2" onclick="insertItem('tag')" value="추가">
			</td>
		</tr>
		<tr>
		<th>
		<h6>추가한 태그</h6>
		</th>
		<td>
            <div id="taglist"> <!-- target이 됨 -->
            </div>
            <input type="hidden" name="space_tag_name" id="selectTag">
            </td>
		</tr>
		
		<tr>
			<th><h3>시설안내*</h3></th>
			<td><textarea  id = "space_guide"  class="ins3" rows="3" cols="50" placeholder="이용 가능한 시설에 대해 최대한 상세하게 입력해주세요. (최대 10개)"></textarea>	
			<input type="button" class="btn2" onclick="insertItem('guide')" value="추가">
			</td>
		</tr>
		
		<tr>
		<th>
		<h6>추가한 시설안내</h6>
		 </th>
		 <td>
            <div id="guidelist"> <!-- target -->
            </div>
            <input type="hidden" name="fclty_guide_content" id="selectGuide" >
           </td>
		</tr>
		
		<tr>
			<th><h3>예약 시 주의사항*</h3></th>
			<td><textarea  id = "space_note"  class="ins3" rows="8" cols="50" placeholder="게스트들이 예약 시 확인해야 하는 주의사항을 상세하게 입력해주세요. (최대 10개)"></textarea>
			<input type="button" class="btn2" onclick="insertItem('note')" value="추가">
			</td>
		</tr>
		
		<tr>
		<th>
		<h6>추가한 주의사항</h6>
            </th>
            <td>
            <div id="notelist"> <!-- target -->
            </div>
            <input type="hidden" name="rsrvt_notes_content" id="selectNote"></td>
		</tr>
		</table>
		</div>
		<div class="devide2">
        <table>
        
		<tr>
			<th><h3>대표이미지*</h3></th>
			<td>
		 <img id="uploaded-image" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif"  cursor:pointer"><br>
              <input type="file"   name="photo" id="photo" accept=".jpg, .jpeg, .png"  onchange="updateImage(this)">대표로 지정할 이미지 파일을 추가 해 주세요. (JPG, JPEG, PNG)
			</td>
		</tr>
		
		<tr>
			<th><h3>주소(위치)*</h3></th>
			
			<td>
			<input type="hidden" name = "space_info_adr">
			<input type="text" class="ins1" id="address_kakao" name="address" readonly placeholder="실제 서비스 되는 공간의 주소를 입력해 주세요">
			</td>
		</tr>	
		<tr>
			<td></td>
			<td><input type="text" class="ins1" name = "de_adr" placeholder="상세주소를 입력해 주세요"></td>
		</tr>
		<tr>
			<th><h3>위치정보팁</h3></th>
			<td><input type="text" class="ins1" name = "space_info_adrinfo" placeholder="ex) 역삼역 3번출구 도보 2분거리"></td>
		</tr>
		<tr>
			<th><h3>웹사이트</h3></th>
			<td><input type="text" class="ins1" name = "space_info_url" placeholder="웹사이트 URL을 입력해 주세요"></td>
		</tr>

	</table>
 </div> 
 </div>
         </div> 
         <div class="b">   
         					<input type="button" value="이전" onclick="javascript:history.back();">
				<input type="button" id ="insert" value="다음" onclick="javascript:checkJoin()">
		</div>
</form>


        
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function checkJoin(){
	
	var j = document.insert;
	
	
	if(j.space_info_adrinfo.value == ""){
		alert("위치정보팁을 입력하십시오!");
	}else if(j.space_info_url.value == ""){
		alert("웹사이트를 입력하십시오!");
	}else{
		j.space_info_adr.value =  j.address.value + "_" + j.de_adr.value; //주소와 상세주소를 _로 연결해 input hidden name에 저장
		j.submit();
	}
}





function attachPhotos() { //사진 여러개 첨부
    var fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.multiple = true;
    fileInput.addEventListener('change', function(event) {
      var files = event.target.files;
      var imageCount = Math.min(files.length, 5); // 최대 4개의 사진만 처리
      
      for (var i = 0; i < imageCount; i++) {
        var file = files[i];
        var reader = new FileReader();
        reader.onload = createImageHandler(i);
        reader.readAsDataURL(file);
      }
    });
    
    fileInput.click();
  }

  function createImageHandler(index) { //위에 딸려나온것
    return function(event) {
      var imageUrl = event.target.result;
      var imgId = 'photo' + (index + 1);
      var imgElement = document.getElementById(imgId);
      imgElement.src = imageUrl;
    };
  }

window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=de_adr]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}





var insertItems = { //insertItems는 객체이며, 세 가지 속성(guide, tag, note)을 가짐.각 속성은 빈 배열을 값으로 가짐
	    guide: [], //시설안내
	    tag: [], //공간태그
	    note: [] //예약시 유의사항
	};

	function insertItem(type) {
	    var value = document.getElementById("space_" + type).value; 

	    var index = insertItems[type].indexOf(value); //이미 선택한 것인지 확인

	    var selectElement = document.getElementById("select" + type.charAt(0).toUpperCase() + type.slice(1)); //ex) type이 tag라면 selectTag로 하는 아이디를 가진 select 요소를 선택
	                                                                                                          

	    if (index === -1) { //선택 안됐던거라면
	        if (insertItems[type].length == 10) {
	            alert(type + "는 최대 10개만 선택 가능합니다.");
	            return;
	        }
	        insertItems[type].push(value); //배열에 입력한 태그(말고 다른 타입도) 추가
	    } else { //선택된거라면
	        alert("이미 추가된 " + type); //이미 추가된 태그 등등
	        return;
	    }
	    console.log("방금입력한 내용 : " + value);
	    console.log("입력된 " + type + "들 : " + insertItems[type]);

	    selectElement.value = insertItems[type].join(","); //이것도 배열 값을 쉼표 붙여서 문자열로 서버로 옮길 예정

	    var target = document.getElementById(type + "list");  //taglist, guidelist, notelist

	    var name = value;   //입력한 값 대입

	    //입력한 것 보여주기
	    var span = document.createElement("span");
	    span.innerText = name;
	    span.id = "select" + type.charAt(0).toUpperCase() + type.slice(1) + value; //ex)selectTag안녕

	    //옆 x버튼
	    var input = document.createElement("input");
	    input.type = "button";
	    input.value = "X";
	    input.id = "rm_button" + type.charAt(0).toUpperCase() + type.slice(1) + value;
	    input.onclick = () => deleteItem(type, value); //삭제 버튼 클릭 시 deleteItem()함수 호출

        //생성한 span과 버튼 넣어주기	    
	    target.appendChild(span); 
	    target.appendChild(input);
	}

	function deleteItem(type, value) { //매개변수 type,value
	    var remove = document.getElementById("select" + type.charAt(0).toUpperCase() + type.slice(1) + value);
	    var btn = document.getElementById("rm_button" + type.charAt(0).toUpperCase() + type.slice(1) + value);

	    for (let i = 0; i < insertItems[type].length; i++) {
	        if (insertItems[type][i] === value) { //선택한 x버튼에 해당하는 문구가 배열속에 있다면
	            insertItems[type].splice(i, 1); //배열에서 삭제
	            i--; //배열 요소가 줄었기 때문에 인덱스 하나 줄여주는 것.
	        }
	    }
	    remove.remove(); //span 지우기
	    btn.remove(); //삭제버튼 지우기
	}
</script>
<script>

	$(function () { //테마 1개 선택, 색깔 변경
	    var maxSelection = 1;
	    var selectedPCount = 0;
	    var space_theme = document.getElementById("space_theme");
	    $('li.theme_btn').click(function(){
	       if(selectedPCount < maxSelection || $(this).hasClass('in')) {
	             // 선택한 항목이 최대 선택 가능한 항목 수보다 적거나 이미 선택된 경우
	             $('li.theme_btn.on').removeClass('on');
	             $(this).toggleClass('on'); // 'on' 클래스를 추가 또는 제거
	             selectedPCount = $('.in').length;
	        }
	             if(space_theme.value === ""){
	            	 $('li.theme_btn.on').removeClass('on');
	             }
	    });
	    
	    
	    // 다음 단계로 넘어가는 버튼 클릭 시의 이벤트 처리
         $('#insert').click(function() {
            var selectedCount = $('.uses_btn.on').length;
            if (selectedCount < 1) {
                alert('공간유형을 하나 이상을 선택해주세요.');
                return false; // 다음 단계로 진행되지 않도록 방지
            }
        });
	}); 
	$(function(){//라이프스타일 선택 색깔, 최대 선택 수
	    var selectedCount = 0; // 현재 선택한 항목 수

	    $('li.uses_btn').click(function(){
            // 선택한 항목이 최대 선택 가능한 항목 수보다 적거나 이미 선택된 경우
             $(this).toggleClass('on'); // 'on' 클래스를 추가 또는 제거
             selectedCount = $('.on').length;
	    });
	});
	
	
	
	
	
     // 용도 고르기 함수
     var selectedItems = [];// 선택한 항목을 저장할 배열

     function selectUses(space_type_name, space_uses_no) {
         var space_uses = document.getElementById("space_uses"); //선택된 요소
         var index = selectedItems.findIndex(item => item.space_uses_no.includes(space_uses_no));

         if (selectedItems.length === 0 || (index === -1 && selectedItems[0].space_type_name === space_type_name)) {
             // (선택한 항목이 없거나 선택된 항목의 space_type_name과 현재 선택한 항목의 space_type_name이 같은 경우 + 선택했던 값이 아닐때) 배열에 추가
             selectedItems.push({ space_type_name: space_type_name, space_uses_no: [space_uses_no] });
         } else if (index === -1) {
             // 다른 space_type_name을 선택한 경우, 배열 초기화 후 새로운 항목 추가
             selectedItems = [{ space_type_name: space_type_name, space_uses_no: [space_uses_no] }];
         } else {
             // 이미 선택한 항목인 경우, 배열에서 제거
             selectedItems.splice(index, 1);
         }

         space_uses.value = selectedItems.flatMap(item => item.space_uses_no).join(",");
         
        
         console.log("선택된 항목 문자열로 변환?: " + space_uses.value);
     }
     

 	function selectTheme(v){ //v: 클릭한 테마
 	
         var space_theme = document.getElementById("space_theme"); //서버로 보낼 애(선택된 애)(input hidden id임)
         
         if (space_theme.value != v) { //현재 클릭한 것이 아직 선택되지 않은 경우
             
             space_theme.value = v; //변수에 저장
             
         } else { //이미 선택했다면
             space_theme.value = ""; //변수 공백으로 초기화(삭제)
             
         } 
        console.log("선택한 값은?: " + space_theme.value); 
 	}
	
	    function updateImage(input) { 
	        var image = document.getElementById('uploaded-image');
	        if (input.files && input.files[0]) {
	          var reader = new FileReader();
	          reader.onload = function (e) {
	            image.src = e.target.result;
	          };
	          reader.readAsDataURL(input.files[0]);
	        }
	      }
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>











