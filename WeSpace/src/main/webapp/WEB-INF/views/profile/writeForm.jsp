<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<style>
 .hidden{
      display: none;
   }
   
   
    #proList ul, .lfsty ul {
        list-style-type: none;
        padding: 0;
    }

    #proList ul>li, .lfsty ul>li {
        border: 1px solid #ccc;
        margin: 5px;
        padding: 10px;
        cursor: pointer;
        float:left;
    }
    
    
   .lfsty-span {
       display: block; 
        margin-bottom: 10px; /* 원하는 여백 크기로 조정하세요 */
    }
    
    
  /*  선택하면 색깔 바꾸기 */
    #proList li, .lfsty li{font-size:20px}
    .clear{clear:both}
     #proList li.on, .lfsty li.on{color:red}
    #proList li.in, .lfsty li.in{color:blue}
</style>
<script>

$(function () { //자기소개 1개 선택, 색깔 변경
    var maxSelection = 1;
    var selectedPCount = 0;
    
    $('li.profile-item').click(function(){
       if(selectedPCount < maxSelection || $(this).hasClass('in')) {
             // 선택한 항목이 최대 선택 가능한 항목 수보다 적거나 이미 선택된 경우
              $('li.profile-item.on').removeClass('on');
             $(this).toggleClass('on'); // 'on' 클래스를 추가 또는 제거
             selectedPCount = $('.in').length;  
        }
    });
});

$(function(){//라이프스타일 선택 색깔, 최대 선택 수
    var maxSelections = 3; // 최대 선택 가능한 항목 수
    var selectedCount = 0; // 현재 선택한 항목 수

    $('li.lfsty-item').click(function(){
        if (selectedCount < maxSelections || $(this).hasClass('on')) {
            // 선택한 항목이 최대 선택 가능한 항목 수보다 적거나 이미 선택된 경우
            $(this).toggleClass('on'); // 'on' 클래스를 추가 또는 제거
            selectedCount = $('.on').length; // 현재 선택한 항목 수 업데이트
        }
    });
});



   $(function(){ //-> 새로고침을 했을 때 실행되는 함수
      var options = document.querySelectorAll("option[class^=city]"); //"city" 클래스를 가진 모든 <option> 요소를 선택, 시/도 선택 안했을떄는 세부지역이 뜨지 않게 
      for(var i=0; i<options.length; i++){//선택된 모든 요소에 대해 반복
    	  options[i].className='city hidden'; //클래스를 city hidden으로 해서 옵션메뉴들 숨김.
      } 
   })

   function  citykindchange(e){//시/도 선택할 때 호출됨 //e는 선택한 값(시도명임) //컨트롤러로 값이 이동하는건 아님(뷰페이지에서만)
      const city = document.getElementsByClassName("city"); //세부지역 옵션 클래스명 : city (세부지역 선택한 값//city라는 클래스를 가진 모든 요소 가져옴)
      
      
        for(var i = 0; i < city.length; i++){ //세부지역 개수만큼 반복(모든 city요소에 대해 반복)
           
           if(city[i].id === e){ //현재 요소의 id(반복하고 있는 것들 중)가 선택한값(e)과 일치한다면
              console.log(city[i].id);
              city[i].className = 'city';   //요소의 클래스를 city로 변경  //그니까 시/도명에 맞는 세부지역은 보이게하고 나머지는 숨김  
           }else{ //일치하지 않는다면 
              city[i].className = 'city hidden'; //요소의 클래스를 city hidden으로 변경
           }
        }
   }

        
  
       
        function selectItem(v){ //자기소개 고른것(1개)
          var profile = document.getElementById("profile"); //id가 프로필인 요소가져옴
        if(profile.value != v){ //지금 선택한 애(v)가 서버로 넘겨질 애랑 같지 않다면(선택 안했었다면)
           profile.value = v; //서버로 넘겨질 애에 선택한 값 넣기
        }else{ //이미 선택을 했다면
           profile.value = ""; //서버로 넘겨질 애에 데이터 지우기(같은거 뽑으며 취소되는것)
        }
          
          console.log("매개변수는?: " + v); //선택한 애
          console.log("인풋 히든으로 넘기는 값은?: " + profile.value); //서버로 넘길 애
       } 
       
       
       
       
        
           
        var selectedItems = []; // 선택한 항목을 저장할 배열

        function selectLfsty(e) { //라이프스타일 선택값을 3개로 제한하고,선택 값을 누적으로 저장함
            var index = selectedItems.indexOf(e); // 이미 선택한 항목인지 확인
            
            var lifestyle = document.getElementById("lifestyle"); //서버로 넘어갈 애
            
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
            lifestyle.value = selectedItems.join(",");  //서버로 넘어갈 애한테 배열 값을 ,넣어서 문자열로 토스함 
        } 
       
     
        

      function insertCheck(f) {
        
      
               //get방식일때(그냥 참고만하기)
    /* var detaarea_no = document.getElementById("citykindy").value;
       var profile_no = document.getElementById("profile").value;
       var lfsty_no= document.getElementById("lifestyle").value;  */

       /* var dataarea_no = f.인풋태그name.value; */
       
       
      var url = "${pageContext.request.contextPath}/profile/write"; 
   /*  var url ="${pageContext.request.contextPath}/profile/write" +
       "?detaarea_no=" + detaarea_no +
       "&profile_no=" + profile_no +
       "&lfsty_no=" + lfsty_no;  */ 
      f.action = url; //여기에서 url을 정의해주면 폼태그 액션에 안써도 됨
      f.submit();
      } 
     
      

      
    </script>
</head>
<body>

   <div class="interest_box">
      <h4>
         😊내 관심지역을 알려주세요.(최대 3개)
      </h4>

      <form method="post" name ="update">
         <div class="sbox">
            <select id="citykindz"  name="detaarea_city"
               onchange="citykindchange(this.value)">
               <option value="">시/도</option>
               <c:forEach var="area" items="${dlist}">
                  <option value="${area.detaarea_city}">${area.detaarea_city}</option>
               </c:forEach>
            </select>
         </div>
         <span class="sbox">
            <select id="citykindy" name="detaarea_detail">
               <option value="">세부지역</option>
               <c:forEach var="all" items="${alist}">
                  <option class="city" id="${all.detaarea_city}" 
               value="${all.detaarea_no}">${all.detaarea_detail}
                  </option>
               </c:forEach>
         </select>
         
         <!-- 이건 아래에서 선택한 세부지역 명 뽑기 위해 우선 두기!! -->
         <c:forEach var="all" items="${alist}">
            <input type="hidden" value="${all.detaarea_detail }" id="${all.detaarea_no }">
         </c:forEach> 
          
               <input type="button" onclick="selectArea()" value="추가하기">
         </span>

         <div class="selectedarea" style="color:orange">
            <h3>🏕️선택된 지역🏕️</h3>
            <div class="my_area" id="arealist">
            
            </div>
            
            <!-- 선택한 지역 리스트 -->
            <input type="hidden" name="district" id="selectDist">
         </div>
         
         
         <script>
         var selectedValues = []; //배열 생성
         
         
            function selectArea(){//추가하기 버튼 누를 때 실행되는 함수임
               var s_area = document.getElementById("citykindy").value;   // 세부지역 시퀀스(cityKindy는 샐렉트의 아이디임)
               
                  var index = selectedValues.indexOf(s_area); //이미 선택한 항목인지 확인 //selectedVaues배열에서 s_area의 값을 찾아내어 그 인덱스를 index 변수에 할당하는 것.
                     
                     var selectDist = document.getElementById("selectDist"); //선택한 지역 리스트의 id
                     //selectedDist는 hidden input요소로서 서버로 전송할 데이터를 저장하는 역할을 함.(서버로 넘어갈 애)
                     if (index === -1) { //선택안했던 항목이라면 
                        if(selectedValues .length == 3){
                         alert("최대 3개만 선택 가능합니다.");
                         return;
                      }
                         // 배열에 추가
                         selectedValues .push(s_area);
                         
                     } else {
                        alert("중복된 지역입니다");
                        return;
                         // 이미 선택한 항목인 경우, 배열에서 제거 //할 필요없는게 그냥 배열에 추가가 안되게 돼있음.
                     }
                     console.log("지역 시퀀스는?: " + s_area); //선택한 애 
                     console.log("선택된 지역들?: " + selectedValues );//배열에 담긴애들
                     
                     // 선택한 항목을 쉼표로 구분하여 문자열로 변환하여 hidden input에 설정
                    selectDist.value = selectedValues .join(","); //서버로 전송하려고함
               
               var target = document.getElementById("arealist"); //넣을 구역(div태그의 id)
               
               var name = document.getElementById(s_area).value;//선택한 값(지역명) name에 대입 //질문 s_area라는 id를 가진게 없는데?
               // 선택한 이름 보여주기
               var span = document.createElement("span");
               span.innerText = name;
               span.id = "select" + s_area;//span아이디 설정해주기 
               
               // 선택한 이름 옆 x버튼
               var input = document.createElement("input");
               input.type="button";
               input.value="X";
               input.id="rm_button"+s_area; //삭제 버튼 아이디 설정해주기
               input.onclick = () => deleteArea(s_area); //삭제 버튼 클릭 시 deleteArea()함수 호출
               
               //생성한 span과 버튼 넣어주기
               target.appendChild(span); 
               target.appendChild(input);
            }
            
            function deleteArea(num){
               var remove = document.getElementById("select"+num);
               var btn = document.getElementById("rm_button"+num);
               
               for(let i = 0; i < selectedValues.length; i++) {
                   if(selectedValues[i] === num)  { //선택한 x버튼에 해당하는 지역이 배열속에 있다면
                      selectedValues.splice(i, 1); //배열에서 삭제
                     i--; //배열요소가 줄었기 때문에 인덱스 하나 줄여주는 것.
                   }
                 }
               
               
               remove.remove(); //span 지우기
               btn.remove(); //삭제버튼 지우기
               
               
            }
         </script>
         
         
         <div class="selectedprofile">
            <h4>😊나를 설명하는 프로필을 설정해보세요.(1개 선택)</h4>
         </div>
         <div id="proList">
            <ul>
               <c:forEach var="pro" items="${plist }">
                  <li class="profile-item" onclick="selectItem(${pro.profile_no})">${pro.profile_item }</li>
               </c:forEach>
            </ul> <input type="hidden" id="profile" name="profile_no"> <!-- 이거 value없어도 되나?//자바스크립트 코드보면 앎 -->
         </div> 
       <span class="lfsty-span" id="lfstyList">
         <Br><Br>
         <Br><Br>
         <div class="selectedlfsty" style="display: left">
            <h4>😊나의 라이프스타일 관심사를 설정해보세요.(최대3개)</h4>
          </div> 
          <div class="lfsty">
            <ul>
               <c:forEach var="lfsty" items="${llist}">
                  <li class="lfsty-item" onclick="selectLfsty(${lfsty.lfsty_no})">${lfsty.lfsty_item }</li>
               </c:forEach>
            </ul>
            </div>
           
            <input type="hidden" id="lifestyle" name="lfsty_no"><!-- 프로필과 동일 서버로 넘어갈 애 -->
            
         </span>
 
         <input type="button" id="update" value="저장" onclick="insertCheck(this.form)" class="btn btn-primary" style="width: 100% height: auto"  >
         
      </form>
   </div>
</body>

</html>