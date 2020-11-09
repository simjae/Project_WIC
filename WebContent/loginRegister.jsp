<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhnd0JK28anvf"
	crossorigin="anonymous" />
<link rel="stylesheet" href="resource/style/loginRegister-style.css" />
<title>Login and Register</title>

</head>

<body>
	<header>
		<%@ include file="/WEB-INF/views/common/Top.jsp" %>  
	</header>


	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="#">
				<div style="width: 100%;">
				<input type="email" id="id" placeholder="email@email.com" />
				<input type="button" id="check_btn" onclick="checkEmail()" value="Check" />
			</div>
            <input type="password" id="pwd" placeholder="Password" />
            <input type="text" id="name" placeholder="UserName" />
            <div style="width: 100%;">
					<input type="text" id="postcode" placeholder="postcode"> 
					<input type="button" id="postcode_btn" onclick="findAddress()"
						value="postcode" />
				</div>
				<input type="text" id="address" placeholder="address"> 
				<input type="text" id="detailAddr" placeholder="detail Address"> 
				<input type="file" id="fileName" accept="image/*">
				<button>Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="#">
				<h1>Sign in</h1>

				<input type="email" id="id" placeholder="email@email.com" /> 
				<input type="password" id="pwd" placeholder="Password" />

				<button>Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Create your Closet!</h1>
					<p>To share your unique style with others</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>
						Enter your personal details <br> and show us your style
					</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
	
			
			</div>
			
		</div>

		<!-- Bottom -->
		
		<%@ include file="/WEB-INF/views/common/Bottom.jsp" %>  
		
		
	
		
		
</body>

<script src="resource/javascript/loginRegister.js"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</html>