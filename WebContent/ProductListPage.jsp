
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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projcet WIC</title>
	<link rel="stylesheet" href="resource/style/bootstrap-grid.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="resource/javascript/bootstrap.bundle.js"></script>
	<link rel="stylesheet" href="resource/style/productListPage-style.css">
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
			<div class="grid-item">
			<img src="resource/image/IMG_0324.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
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
			<div class="grid-item">
			<img src="resource/image/IMG_0324.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/IMG_0260.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/EVA.gif">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/IMG_0261.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/IMG_0568.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/IMG_0260.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/EVA.gif">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/IMG_0261.jpeg">
			<div class="overlay"> 
					<h3>여기에 제목</h3>
					<p> 여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명여기에 설명 </p>
					<button id="like">좋아요</button>
				</div>	
			</div>
			<div class="grid-item">
			<img src="resource/image/IMG_0568.jpeg">
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
<script src="resource/javascript/infinite-scroll.pkgd.js"></script>
<script>
$('.grid').masonry({
	  // options
	  itemSelector:'.grid-item',
	  gutter : 15

	});



	
</script>
</html>