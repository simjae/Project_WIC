<%
/* 
@Project : WIC
@File name : CsWritePage.jsp
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
                                    ID <input type="email" value="minchan@naver.com" class="form-control" readonly>
                                  </div>
                                  <div class="col-lg-6 py-2">
                                    NAME <input type="text" value="minchan" class="form-control" readonly>
                                  </div>
                                </div>    
                          </div>   
                            SUBJECT
                            <input type="text" placeholder="subject *" class="form-control" required>
                            <br>
                          <textarea name="message" id=""  placeholder="Message *" class="border w-100 p-3 mt-3 mt-lg-4"></textarea>
                          <div class="btn-grounp">
                              <button type="summit" class="btn btn-primary mt-2 float-right">작성하기</button>
                              <a href="minchan.html">
                              <imput type="button" class="btn btn-primary mt-2">뒤로가기</button>
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