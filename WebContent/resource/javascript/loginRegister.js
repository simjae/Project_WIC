/*Sign in&up 이동 버튼 */
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

/*우편번호 검색*/
function findAddress() {
	new daum.Postcode({
		oncomplete: function(data) {
		
			let addr = ''; // 주소
			let extraAddr = ''; // 상세주소

			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			if(data.userSelectedType === 'R'){
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가
				if(data.buildingName !== '' && data.apartment === 'Y'){
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열 생성
				if(extraAddr !== ''){
					extraAddr = ' (' + extraAddr + ')';
				}
				document.getElementById("detailAddr").value = extraAddr;
			
			} else {
				document.getElementById("detailAddr").value = '';
			}

			document.getElementById('postcode').value = data.zonecode;
			document.getElementById("address").value = addr;
			document.getElementById("detailAddr").focus();
		}
	}).open();
}

/*정규표현식*/
	let emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i //이메일 형식
	let pwdReg = /^[A-za-z0-9]{4,12}$/; //4~12자리 영문+숫자 조합 비밀번호 
	
	
	let userEmail = document.getElementById("id");
	let userPwd = document.getElementById("pwd");
	
	userEmail.addEventListener("focusout", checkEmail);
	userPwd.addEventListener("focusout", checkPwd);

	
	function checkAll(){
		let checkup = false;
		if(!(!userEmail.value=="" ||  userPwd.value=="")){
			checkup = true;
		}
		return checkup;
	}
	
	
	function checkEmail() {
		if (!emailReg.test(userEmail.value)) {
			alert("아이디는 이메일 형식입니다.");
			userEmail.value = "";
		} 
	}
	
	function checkPwd(){
		if(!( pwdReg.test(userPwd.value) && (userPwd.value.search(/[0-9]/)>-1) && (userPwd.value.search(/[a-zA-Z]/)>-1) )){
			alert("비밀번호는 영문,숫자 조합 4~12자리의 형식입니다.");
			userPwd.value = "";
		}
	}
	
	

	

	
	