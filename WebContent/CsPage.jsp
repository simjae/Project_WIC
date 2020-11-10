<%
/* 
@Project : WIC
@File name : CsPage.jsp
@Date : 2020.11.07
@Author : 정민찬
*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="resource/style/contact-us/bootstrap.min.css">

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
					<h3>Contact us - MAIN</h3>
				</div>
			</div>
		</div>
	</section>

	<!-- page title -->
	<section class="section">
		<div class="container">
			<h1 class="text-center">CONTACT-US-MAIN</h1>
			<br>
			<div class="row">
				<form>
					<select name="pageSize" class="form-control" onchange="submit()">
						
						<c:forEach var="i" begin="10" end="20" step="5">
							<c:choose>
								<c:when test="${pageSize == i}">
									<option value="${i}" selected>${i}</option>
								</c:when>
								<c:otherwise>
									<option value="${i}">${i}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</form>
			</div>
			<br>
			<div class="row">
				<table class="table table-striped table-responsive-md text-center">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일자</th>
							<th>조회수</th>
						</tr>
					</thead>
						<c:forEach var="csList" items="${requestScope.csList}">
							<tr class="table-tr">
								<td class="py-auto">${csList.cs_num}</td>
								<td> 
									<a href="<%= request.getContextPath()%>/BoardDetail.do?cs_num=${csList.cs_num}&currentPage=${currentPage}&pageSize=${pageSize}">${csList.cs_title}</a>
									</td>
								<td>${csList.ID}</td>
								<td>${csList.cs_date}</td>
								<td>${csList.cs_count}</td>
							</tr>
						</c:forEach>
				</table>
				
				<c:set var="currentPage" value="${requestScope.currentPage}"/>
				<c:set var="pageSize" value="${requestScope.pageSize}"/>			
				<c:set var="pageCount" value="${requestScope.pageCount}"/>
				<table class="table table-striped table-responsive-md text-center">
					<tr>
						<td>
							<c:if test="${currentPage>1}">
								<a href="<%= request.getContextPath()%>/BoardList.do?page=${currentPage-1}">이전</a>
							</c:if> 
							<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
								<c:choose>
									<c:when test="${currentPage==i}">${i}</c:when>
									<c:otherwise>
										<a
											href="<%= request.getContextPath()%>/BoardList.do?page=${i}"><b>${i}</b></a>
									</c:otherwise>
								</c:choose>
							</c:forEach> <c:if test="${currentPage<maxPage}">
								<a
									href="<%= request.getContextPath()%>/csPage.cs?currentPage=${currentPage+1}">다음</a>
							</c:if></td>
					</tr>
				</table>
			</div>
			<div class="btn-grounp">
				<a href="<%=request.getContextPath()%>/csWritePage.cs?currentPage=${currentPage}&pageSize=${pageSize}">
					<input type="button" value="글쓰기" class="btn btn-primary mt-2" style="align-right">
				</a>
			</div>
		</div>
	</section>
	<!-- bottom-->
	<jsp:include page="WEB-INF/views/common/Bottom.jsp"></jsp:include>
	<!-- /bottom -->
</body>
</html>