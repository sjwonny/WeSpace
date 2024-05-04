<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
function insertCoupon() {
	   
	if (document.coupon.cpn_name.value == "") {
		alert("쿠폰이름을 입력하십시오!");
	} else if (document.coupon.cpn_price.value == "") {
		alert("할인가격을 입력하십시오!");
	} else if (document.coupon.cpn_miniper.value == "") {
		alert("최소사용시간조건을 입력하십시오!");
	} else if (document.coupon.cpn_cnt.value == "") {
		alert("쿠폰개수를 입력하십시오!");
	} else if(document.coupon.cpn_per.value == ""){
		alert("만료일을 입력하십시오!");
	} else if(document.coupon.cpn_type.value == ""){
		alert("쿠폰종류를 입력하십시오!");
	} else {
		alert("실행");
		document.coupon.submit();
	}
} 

</script>
<body>
<!-- 아마 관리자 쪽으로 갈 듯 -->
<div align = "center">
<form action="${pageContext.request.contextPath}/coupon/save" method="post" name="coupon">
    <table>
        <tr>
            <td><label for="cpn_name">쿠폰이름</label></td>
            <td><input type="text" name="cpn_name" id="cpn_name"><br>
            </td>
            
        </tr>
        <tr>
            <td><label for="cpn_price">할인 가격</label></td>
            <td><input type="text" name="cpn_price" id="cpn_price">
           </td>
        </tr>
        <tr>
            <td><label for="cpn_miniper">최소사용시간</label></td>
            <td><input type="text" name="cpn_miniper" id="cpn_miniper"></td>
        </tr>
        <tr>
            <td><label for="cpn_cnt">쿠폰개수</label></td>
            <td><input type="text" name="cpn_cnt" id="cpn_cnt"></td>
        </tr>
        <tr>
            <td><label for="cpn_per">만료일</label></td>
            <td><input type="date" name="cpn_per" id="cpn_per" ></td>
        </tr>
        <tr>
            <td><label>쿠폰 종류</label></td>
            <td>
                <label for="all">전체공간</label>
                <input type="radio" id="all" name="cpn_type" value="전체공간" checked>
                <label for="certain">특정공간</label>
                <input type="radio" id="certain" name="cpn_type" value="특정공간">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="button" id="coupon" value="쿠폰생성" onclick="javascript:insertCoupon()">
                <input type="button" id="resetButton" value="Reset" onclick="document.coupon.reset()">
            </td>
        </tr>
    </table>
    </form>
    </div>
</body>
</html>