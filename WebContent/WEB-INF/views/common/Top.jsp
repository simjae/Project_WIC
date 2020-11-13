<%
/* 
@Project : WIC
@File name : Top.jsp
@Date : 2020.11.10
@Author : 문지연
*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/18cfffd9e0.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="resource/style/top-style.css">
    <title>Document</title>
</head>
<body>
	<c:set var="id" value="${sessionScope.id }"/>
    <header>
    	<nav id="topNav">
        <ul>
            <li class="logo"><a href="<%=request.getContextPath()%>/mainPage.my">WIC</a></li>
            <div class="items">
            <c:choose >
            	<c:when test="${not empty id }">
	            	<c:if test="${id=='admin@admin.com'}">
	                <li><a href="<%=request.getContextPath()%>/mainPage.my">HOME</a></li>
	                <li><a href="<%=request.getContextPath()%>/myPage.my">MY CLOSET</a></li>
	                <li><a href="<%=request.getContextPath()%>/managePage.Mg">MANAGE</a></li>
	                <li><a href="<%=request.getContextPath()%>/ProductListPage.Pd">PRODUCT</a></li>

	                <li><a href="<%=request.getContextPath()%>/signOut.my">LOGOUT</a></li>
	                <li><a href="<%=request.getContextPath()%>/ProductUploadPage.Pd">UPLOAD</a></li> <!-- 삭제 -->

	                </c:if>
	                <c:if test="${id !='admin@admin.com' }">
	                <li><a href="<%=request.getContextPath()%>/mainPage.my">HOME</a></li>
	                <li><a href="<%=request.getContextPath()%>/myPage.my">MY CLOSET</a></li>
	                <li><a href="<%=request.getContextPath()%>/ProductListPage.Pd">PRODUCT</a></li>
	                <li><a href="<%=request.getContextPath()%>/signOut.my">LOGOUT</a></li>
	                </c:if>
	                </c:when>
                <c:otherwise>
                <li><a href="<%=request.getContextPath()%>/mainPage.my">HOME</a></li>
                <li><a href="<%=request.getContextPath()%>/ProductListPage.Pd">PRODUCT</a></li>
                <li><a href="<%=request.getContextPath()%>/signUpPage.my">SIGN IN/REGISTER</a></li>
                </c:otherwise>
            </c:choose>   
            </div>
            <li class="search-icon">
                <form action="#">
                    <input class="text" id="productName" type="text" name="search" required>      
                    <button id="btn-search" type="submit" class="fas fa-search"></button>
                </form>
            </li>
        </ul>
    </nav>
    </header>
</body>
</html> 