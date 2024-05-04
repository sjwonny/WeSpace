<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${pageContext.request.contextPath }/ds/delete?seq=${vo.DE_SP_INFO_NO}';
	}
	
</script>


<body>
	
	<table class="infoTable" border="1">
		<tr>
			<th>${vo.de_sp_info_name}</th> 
		</tr>
		<tr>
			
		</tr>
		<tr>
			<td>${vo.DE_SP_INFO_img }</td>
			
		</tr>
	</table>
	<input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath }/ds/updateform?seq=${vo.DE_SP_INFO_NO }'">
	<input type="button" value="삭제" onclick="deleteAction()">
	
	
	
</body>
</html>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>