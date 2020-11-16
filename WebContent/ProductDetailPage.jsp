<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Product Detail</title>
	
	<!-- Bootstrap cdn -->
	<link rel="stylesheet" href="resource/style/productDetail.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<style>
	
	</style>
</head>

<body>
<!-- Top -->
<jsp:include page="WEB-INF/views/common/Top.jsp"></jsp:include>

<div class="mb-5"></div>
<div class="container">
	<div class="row">
		<div class="col-md-6 mb-5">
			<div id="imgCarousel" class="carousel slide" data-interval="false">
				 <ol class="carousel-indicators">
				    <li data-target="imgCarousel" data-slide-to="0" class="active"></li>
				    <li data-target="imgCarousel" data-slide-to="1"></li>
				    <li data-target="imgCarousel" data-slide-to="2"></li>
				    <li data-target="imgCarousel" data-slide-to="3"></li>
  				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="resource/image/prdDetail1.jpg" alt="">		
					</div>
					<div class="carousel-item">
						<img src="resource/image/prdDetail2.jpg" alt="">			
					</div>
					<div class="carousel-item">
						<img src="resource/image/prdDetail3.jpg" alt="">
					</div>
					<div class="carousel-item">
						<img src="resource/image/prdDetail4.jpg" alt="">
					</div>
					<a class="carousel-control-prev" href="#imgCarousel" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#imgCarousel" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>	
		</div>
		<div class="col-md-6 rightDiv">
			<div class="mb-4">
				<div class="d-flex justify-content-between">
					<img id="userPic" src="resource/image/user.png">
					<div class="mr-auto">
						채채니<br>
						<i id="heart" class="far fa-heart"></i><span id="cnt">100</span>
					</div>
					<!-- product 객체(JSTL) -->
					<c:set var="product" value="${requestScope.product}"></c:set>
					<button id="edit" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/ProductEditPage.Pd?prd_num=${product.prd_num}'">글수정</button>
				</div>
			</div>
			<div class="mb-3">
				<h3 id="title">${product.prd_title}</h3>
			</div>
			<div class="mb-2">
				<h5 id="price">${product.prd_price}<span id="location">서울시 강남구</span></h5>
			</div>
			<div class="mb-4 description">
				${product.prd_content}
			</div>
			<div class="mb-2 d-flex justify-content-between">
				<span class="prdReply">상품문의</span>
				<button id="ask" class="btn btn-primary">문의하기</button>
			</div>
			<div>
				<!-- 상품문의 테이블 -->
				<table class="table myTable">
					<thead class="thead-light">
						<tr>
							<th>No.</th>
							<th>글제목</th>
							<th>작성자</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var = "dto" items="${requestScope.chatRoomDTOs}"  >
						<tr>
							<td>${dto.ch_num}</td>
							<td><a href="#">${dto.ch_title}</a></td>
							<td>${dto.name}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<c:set var = "startPage" value = "${requestScope.startPage}"/>  
				<c:set var = "endPage" value = "${requestScope.endPage}"/>  
				<c:set var = "pageSize" value = "${requestScope.pageSize}"/>  
				<c:set var = "currentPage" value = "${requestScope.currentPage}"/>  
				<c:set var = "maxPage" value = "${requestScope.maxPage}"/>  
				<!-- Pagination -->
				<div class="">
					<nav aria-label="Page navigation">
						<ul class="pagination pagination-sm justify-content-center" style="margin-bottom: 0px;">
							<li class="page-item">
							<c:if test= "${cureentPage > 1}">
								<a class="page-link" href="#" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</c:if>
							</li>
							<c:forEach var = "i" begin = "${startPage}" end ="${endPage}" step = "1">
							<c:choose>
							<c:when test = "${currentPage == i}">
							<li class="page-item">
								<a class="page-link" >${i}</a>
							</li>
							</c:when>
							<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="#">${i}</a>
							</li>
							</c:otherwise>
							
							</c:choose>
							</c:forEach>	
							<c:if test= "${cureentPage < maxPage }">
							<li class="page-item">
								<a class="page-link" href="#" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="mb-5"></div>
<jsp:include page="WEB-INF/views/common/Bottom.jsp"></jsp:include>
</body>

</html>