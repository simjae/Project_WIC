
<%
/* 
@Project : WIC
@File name : UploadProductPage.jsp
@Date : 2020.11.07
@Author : 박선우
*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="resource/style/uploadProductPage-style.css">
	<link rel="stylesheet" href="resource/style/bootstrap-grid.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="resource/javascript/bootstrap.bundle.js"></script> 
	<script src="resource/javascript/uploadProductPage.js"></script>
</head>

<body>
<jsp:include page="/WEB-INF/views/common/Top.jsp"></jsp:include>
	<div class="container content my-4">
		<div class="row py-4">
			<h1 class="mx-auto py-4 ">Product</h1>
		</div>
		<form action="<%=request.getContextPath()%>/uploadProduct.Pd" enctype="multipart/form-data" method="post" id="upload">
			<div class="row">
				<div class="col-md-6">
					<div class="container">
						<div class="row ml-4">
							<h3 class="my-0">상품 이름 :</h3>
							&nbsp;<input class="col-sm-7" type="text" id="productName"
								name="productName">
						</div>
						<br>
						<div class="row ml-4">
							<h3 class="my-0">지역 :</h3>
							&nbsp;<input class="col-sm-8" type="text" id="location"
								name="location">
						</div>
						<br>
						<div class="row ml-4">
							<h3 class="my-0">가격 :</h3>
							&nbsp; <input class="col-sm-8" type="text" id="productPrice"
								name="productPrice">
						</div>
						<br>
						<div class="ml-4 mb-4">
							<h3>상품 설명을 해 주세요</h3>
							<textarea class="col-md-10" id="context" name="context"></textarea>
						</div>

					</div>
				</div>
				<div class="col-md-6">
				<input class="mx-auto" type="submit" id="submit" name="submit" value="UPLOAD">
				<input class="mx-auto" type="reset" id="reset" name="reset" value="CANCLE">
					<div class="col-md-10 mx-auto" id="drop">
						<div class="col-md-12 mx-auto mt-3" id="file_add">
						<p class="mt-4" style="text-align:center;"> Drag file Or Click to add files</p>
						
						</div>

						<input type="file" id="fileProfile" name="fileProfile" accept="image/*" multiple/>
						<div id="thumbnails" class="col-md-12 row mr-0 ml-0">
							
						</div>
					</div>
				</div>
				
			</div>
		</form>
	</div>
	<jsp:include page="WEB-INF/views/common/Bottom.jsp"></jsp:include>

</body>
<script type="text/javascript">
//이미지 클릭시 업로드창 실행


</script>

</html>