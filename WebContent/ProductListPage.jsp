
<%
/* 
@Project : WIC
@File name : ProjcetListPage.jsp
@Date : 2020.11.07
@Author : 박선우
*/
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projcet WIC</title>
	<link rel="stylesheet" href="resource/style/bootstrap-grid.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="resource/javascript/bootstrap.bundle.js"></script>
	<link rel="stylesheet" href="resource/style/productListPage-style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
	
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/Top.jsp"></jsp:include>
	<div id="wrapper" class="my-4">
	<div class="col-md-9 mx-auto my-4">
		<form action="" id="search" name="search" method="get">
			<div class="inner-form row"> 
				<div class="col-md-9">
				<input class="col-md-12" type="text" id="searchbar" name="searchbar"
					placeholder="Type KeyWord's">
				</div>
				<div class="col-md-2">
				<button type="submit" id="submit">Search</button>
				</div>
			</div>
		</form>
	</div>
	
	<!-- prdList, filesList(JSTL) / test -->
	<c:set var="prdList" value="${requestScope.productList}"/>
	<c:set var="cartList" value="${requestScope.cartList}"/>
	
	<div class="col-md-9 mx-auto my-2" id="autoScroll">
		<div class="grid" id="grid">
			<c:forEach var="product" items="${prdList}"> 
			
				<div class="grid-item">
						<img src="upload/${product.files.files_name}">
					<div class="overlay"> 
						<a href="<%=request.getContextPath()%>/ProductDetailPage.Pd?prd_num=${product.prd_num}">
						<h3>${product.prd_title}</h3>
						</a>
						<p> ${product.prd_content}</p>
					<c:forEach var="cart" items="${cartList}">
						<c:if test="${product.prd_num != cart.prd_num}">
						
							<button class="far fa-heart like" id="like" value="${product.prd_num}"></button>
							<input type="text" value="off" name="check" id="check" hidden>
						
						</c:if>
					</c:forEach>
					<c:forEach var="cart" items="${cartList}">
						<c:if test="${product.prd_num == cart.prd_num}">
							<button class="fas fa-heart like" id="like" value="${product.prd_num}"></button>
							<input type="text" value="on" name="check" id="check" hidden >
						</c:if>
					</c:forEach>
						<button onclick="location.href='<%=request.getContextPath() %>/ProductDetailPage.Pd?prd_num=${product.prd_num}'">상세보기</button>
					</div>	
				</div>
			</c:forEach>
		</div>
	</div>
	
	<!-- 지금은 예시를 보여줄라고 이렇게 많이 해놓은거 사실상 한 세트만 보면 됨 -->
	<div class="col-md-9 mx-auto my-2" id="autoScroll">
		<div class="grid" id="grid">
			<div class="grid-item">
				<img src="resource/image/710cae15d1a6ea3efbedb8baf2319151-sticker.png">
				<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
				<img src="resource/image/IMG_0355.png">
				<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>		
			</div>
			<div class="grid-item">
			<img src="resource/image/IMG_0457.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
		</div>
	</div>
	</div>
	<jsp:include page="WEB-INF/views/common/Bottom.jsp"></jsp:include>
	
	
</body>
<script src="resource/javascript/masonry.pkgd.min.js"></script>

<script>
$('.grid').masonry({
	  // options
	  itemSelector:'.grid-item',
	  gutter : 15

	});
	
	
$('.like').on("click",function(){
		if($(this).hasClass('far')){
			$(this).removeClass('far');
			$(this).addClass('fas');
			$.ajax({ 
				url:'myCart.my',
				data : {
					prd_num:$(this).val(),
					check:$('#check').val()
						},
				type:"get",
				success:function(){
					$('#check').val("on");
				}
			});
			
		}else if($(this).hasClass('fas')){
			$(this).removeClass('fas');
			$(this).addClass('far');
			$.ajax({ 
				url:'myCart.my',
				data : {
					prd_num:$(this).val(),
					check:$('#check').val()
						},
				type:"get",
				success:function(){
					$('#check').val("off");
				}

			});
		}

	});
</script>
</html>