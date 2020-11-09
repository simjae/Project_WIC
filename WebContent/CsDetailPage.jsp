<%
/* 
@Project : WIC
@File name : CsDetailPage.jsp
@Date : 2020.11.07
@Author : 정민찬
*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="resource/style/contact-us/bootstrap.min.css">  
    
    <!-- Font Awesome -->
    <link href="" rel="stylesheet"> 
    
    <!-- CUSTOM CSS -->
    <link href="resource/style/contact-us/style.css" rel="stylesheet">
    <link href="resource/style/top-bottom/top-style.css" rel="stylesheet">
</head>
<body>
	<!-- Header-->
		<jsp:include page="WEB-INF/views/common/Top.jsp"></jsp:include>
	<!-- /Header -->
    <section class="page-title">
	<!-- Container Start -->
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2 text-center">
				<!-- Title text -->
				<h3>Contact us check</h3>
			</div>
		</div>
	</div>
	<!-- Container End -->
</section>
<!-- page title -->

<!-- contact us start-->
<section class="section">
    <div class="container">
        <div class="row">
          <div class="contact-us-content p-4">
            <h1 class="pt-1">Hello, what's on your mind?</h1>
            <p class="pt-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla elit dolor, blandit vel euismod ac, lentesque et dolor. Ut id tempus ipsum.</p>
          </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                    <form action="#">
                        <fieldset class="p-4">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-lg-6 pt-2">
                                        NUMBER <input type="text" value="1번" class="form-control" readonly>
                                    </div>
                                    <div class="col-lg-6 py-2">
                                        WriteDate <input type="text" value="MM-DD_YYYY" class="form-control" readonly>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-lg-6 pt-2">
                                        ID <input type="email" value="minchan@naver.com" class="form-control" readonly>
                                    </div>
                                    <div class="col-lg-6 py-2">
                                      NAME <input type="text" value="minchan" class="form-control" readonly>
                                    </div>
                              </div>
                                <div class="row"></div>
                            </div>   
                              SUBJECT
                            <input type="text" value="불hjkhk량회원신고" class="form-control" readonly>
                            <textarea name="message" placeholder="Message *" class="border w-100 p-3 mt-3 mt-lg-4" readonly>dddddddddddddddd</textarea>
                            <div class="btn-grounp">
                              <a href="contact-us write.html"> 
                              <button type="button"  class="btn btn-primary mt-2 ">뒤로</button>
                              </a>
                              <a href="./contact-us-write.html"> 
                                <button type="button"  class="btn btn-primary mt-2 ">삭제</button>
                              </a>
                              <a href="">
                                <button type="button" class="btn btn-primary mt-2 float-right">수정</button>
                              </a> 
                            </div>
                        </fieldset>
                    </form>
            </div>
        </div>
    </div>
</section>
	<!-- bottom-->
		<jsp:include page="WEB-INF/views/common/Bottom.jsp"></jsp:include>
	<!-- /bottom -->
</body>
</html>