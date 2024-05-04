<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<body>
<div class="brand">
	<div class="brand-title">
		<a href="${pageContext.request.contextPath }" ><img class="logo" src="${pageContext.request.contextPath}/resources/images/로그인로고.jpg"></a>
		<div id="title">예약하기</div>
	</div>
   
   	<hr>
   	<form action="${pageContext.request.contextPath }/product/insert?brand_idx=${brand.idx}" method="POST" enctype="multipart/form-data">
   		<input type="hidden" name="major_idx" id="major_idx" value="5000">
   		<input type="hidden" name="middle_idx" id="middle_idx" value="5000">
   		<input type="hidden" name="small_idx" id="small_idx" value="5000">
		<div class="brand-info">
			<div><span class="title">상품정보</span></div>
			<table>
				<tr>
					<th>
		 			예약자<span class="red">*</span>
					</th>
					<td class="info-td">
						<input type="text" class="form-control" name="name" required>
		 			<div class="con">
		 				
		 			</div>
					</td>
				</tr>
				<tr>
				<td></td>
				<td><span class="ex">※ 제품명 상품군 상품정보로 구성해주세요.</span></td>
				</tr>
				<tr>
					<th>브랜드<span class="red">*</span></th>
					<td>
						<div class="con">
							<div>
								
								<span>${brand.brand_name }</span>
							
							</div>
						</div>
					</td>
					</tr>
				<tr>
					<th>관리 카테고리</th>
					<td>
						<div class="con">
							<div>
								<span>대분류</span>
								<select class="form-select" id="majorSelect" onchange="Major()">
										<option value="5000" selected>카테고리를 선택하세요(필수)</option>
										<c:forEach var="mavo" items="${major }">
											<option value="${mavo.idx }">${mavo.name }</option>
										</c:forEach>
								</select>
							</div>
							<div id="middle">
								<span>중분류</span>
								<select class="form-select" id="middleSelect" onchange="Middle()">
										<option value="5000"selected>카테고리를 선택하세요(선택)</option>
										<c:forEach var="mavo" items="${major }">
											<c:forEach var="mivo" items="${mavo.mivo }">
												<option class="hidden" value="${mivo.major_idx }/${mivo.idx}">${mivo.name }</option>
											</c:forEach>
										</c:forEach>
								</select>
							</div>
							<div class="bbb">
								<span>소분류</span>
								<select class="form-select" id="smallSelect" onchange="Small()">
										<option value="5000" selected>카테고리를 선택하세요(선택)</option>
										<c:forEach var="mavo" items="${major }">
											<c:forEach var="mivo" items="${mavo.mivo }">
												<c:forEach var="smvo" items="${mivo.smvo }">
													<option class="hidden" value="${smvo.middle_idx }/${smvo.idx}">${smvo.name }</option>
												</c:forEach>
											</c:forEach>
										</c:forEach>
								</select>
							</div>
						</div>
					</td>
				</tr>
			</table>
			<hr>
			<div><span class="title">대표가격</span></div>
			<table>
				<tr>
					<th>
		 				정상가<span class="red">*</span>
					</th>
					<td class="info-td">
			 			<div class="con">
			 				<input type="number" class="form-control" name="price" required>
			 			</div>
					</td>
				</tr>
				<tr>
					<th>판매가(할인가)<span class="red">*</span></th>
					<td>
						<div class="con">
		 					<input type="number" class="form-control" name="sale" required>
		 				</div>
					</td>
				</tr>
				<tr>
					<th>배송비<span class="red">*</span></th>
					<td>
						<div class="con">
		 					<input type="number" class="form-control" name="delivery" required>
		 				</div>
					</td>
				</tr>
			</table>
			<hr>
		
			<div><span class="title">상품정보</span></div>
				<div class="summer">
					<textarea id="summernote" rows="500" cols="500" name="info"></textarea>
				</div>
				<hr>
				<div><span class="title">대표이미지</span></div>
				<div class="ff">
					<div class="input-group mb-3">
			  			<input type="file" class="form-control" id="inputGroupFile02" name="photo">
					</div>
				</div>
			<hr>
		<div class="mama">
			<button class="btn btn-info btn-lg" type="submit" onclick="category(${brand.idx})"><span id="white">상품등록하기</span></button>
		</div>
		</div>
   </form>
</div>
</body>