<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.101.0">
<title>Headers · Bootstrap v5.2</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">





<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
@font-face {
	font-family: 'SUITE-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2')
		format('woff2');
	font-weight: 400;
	font-style: normal;
}

body {
	font-family: 'SUITE-Regular';
}

#profilesmall {
	border: 2px solid lightgray;
}
/* 더보기 */
/* Top left text */
.top-left {
	position: absolute;
	top: 8px;
	left: 16px;
}
/* 사진 */
@import
	url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap')
	;

/* .gowun-dodum-regular {
        } */
.mainContainer {
	position: relative;
	text-align: center;
	width: 100%; -
	-color: white;
	/* text-shadow: 0.5px 0.5px 0.5px black; */
}

* /
	.mainContainer img {
	width: 100%;
	vertical-align: middle;
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.header {
	text-align: center;
	margin-top: 100px;
}

.card-group {
	width: 1500px;
	margin: 0 auto;
	display: flex;
	flex-direction: row;
}

#car {
	margin: 5px;
	padding: 5px 45px;
}

#card {
	justify-content: center;
	padding: auto;
}

.pcard {
	text-align: center;
	margin: auto;
}

#cardImg {
	display: flex;
}

.card-img-top {
	display: flex;
	margin-right: 110px;
}
/* 안녕하세요 ㅇㅇ님 */
.pic3 {
	background-image: url("../resources/img/landmark3.png");
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;
}

.circle {
	position: absolute;
	width: 130px;
	height: 130px;
	border-radius: 100%;
	background-color: #white;
}

.log {
	position: absolute;
	width: 250px;
	height: 40px;
	background-color: #ddd;
	border-radius: 8px;
}

.logo {
	text-align: center;
	margin: auto;
	margin-top: 50px;
	margin-bottom: 100px;
}

.login-header li {
	list-style-type: none;
	float: left;
	border-right: 1px solid #ddd;
}

.login-header li:last-child {
	border: none;
}

.login-header a {
	font-weight: normal;
	font-size: smaller;
	text-decoration: none;
}

.login-header a:link, .login-header a:visited {
	color: gray;
}

#loginUnder a {
	font-weight: normal;
	font-size: smaller;
	text-decoration: none;
}

#loginUnder a:link, #loginUnder a:visited {
	color: gray;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>


<!-- Custom styles for this template -->
<link href="headers.css" rel="stylesheet">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="bootstrap" viewBox="0 0 118 94">
    <title>Bootstrap</title>
    <path fill-rule="evenodd" clip-rule="evenodd"
			d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"></path>
  </symbol>
  <symbol id="home" viewBox="0 0 16 16">
    <path
			d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z" />
  </symbol>
  <symbol id="speedometer2" viewBox="0 0 16 16">
    <path
			d="M8 4a.5.5 0 0 1 .5.5V6a.5.5 0 0 1-1 0V4.5A.5.5 0 0 1 8 4zM3.732 5.732a.5.5 0 0 1 .707 0l.915.914a.5.5 0 1 1-.708.708l-.914-.915a.5.5 0 0 1 0-.707zM2 10a.5.5 0 0 1 .5-.5h1.586a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 10zm9.5 0a.5.5 0 0 1 .5-.5h1.5a.5.5 0 0 1 0 1H12a.5.5 0 0 1-.5-.5zm.754-4.246a.389.389 0 0 0-.527-.02L7.547 9.31a.91.91 0 1 0 1.302 1.258l3.434-4.297a.389.389 0 0 0-.029-.518z" />
    <path fill-rule="evenodd"
			d="M0 10a8 8 0 1 1 15.547 2.661c-.442 1.253-1.845 1.602-2.932 1.25C11.309 13.488 9.475 13 8 13c-1.474 0-3.31.488-4.615.911-1.087.352-2.49.003-2.932-1.25A7.988 7.988 0 0 1 0 10zm8-7a7 7 0 0 0-6.603 9.329c.203.575.923.876 1.68.63C4.397 12.533 6.358 12 8 12s3.604.532 4.923.96c.757.245 1.477-.056 1.68-.631A7 7 0 0 0 8 3z" />
  </symbol>
  <symbol id="table" viewBox="0 0 16 16">
    <path
			d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z" />
  </symbol>
  <symbol id="people-circle" viewBox="0 0 16 16">
    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
    <path fill-rule="evenodd"
			d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
  </symbol>
  <symbol id="grid" viewBox="0 0 16 16">
    <path
			d="M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zM2.5 2a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zM1 10.5A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3z" />
  </symbol>
</svg>

	<main>
		<h1 class="visually-hidden">Headers examples</h1>

		<header class="p-3 mb-3 border-bottom">
			<div class="container">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
					<img src="/resources/img/LOGO1.png" width="200" height="200"
					role="img" class="logo">
				</a>
				<div
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">


					<ul
						class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
						<li><a href="/" class="nav-link px-2 link-secondary">홈</a></li>
						<li><a href="/notice/list.kh" class="nav-link px-2 link-dark">동행모집</a></li>
						<li><a href="/mbti/mbtitest.kh"
							class="nav-link px-2 link-dark">성향테스트</a></li>
						<li><a href="/mbti/matching.kh"
							class="nav-link px-2 link-dark">나의 짝꿍 찾기</a></li>
					</ul>

					<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search"
						action="/notice/search.kh" method="get" id="search">
						<select name="searchCondition" style="display: none;">
							<c:if test="${searchCondition eq 'all' }">selected</c:if>
							<option value="all"
								<c:if test="${searchCondition eq 'all' }"> selected</c:if>>전체</option>
						</select> <input type="search" class="form-control"
							placeholder="동행을 검색해보세요" name="searchKeyword" aria-label="Search"
							onkeypress="if( event.keyCode == 13 ){enterKey()}">
					</form>


					<c:if test="${memberId eq null }">
						<div class="login-header">
							<ul>
								<li><a href="/member/login.kh">로그인&nbsp&nbsp</a></li>
								<li><a href="/member/register.kh">&nbsp&nbsp회원가입</a></li>
							</ul>
						</div>
					</c:if>

					<c:if test="${memberId ne null }">
						<c:if test="${memberId eq 'admin' }">
							<div class="dropdown text-end">
								<a href="#"
									class="d-block link-dark text-decoration-none dropdown-toggle"
									data-bs-toggle="dropdown" aria-expanded="false"> <c:if
										test="${memberFileRename eq null }">
										<img id="profilesmall"
											src="../resources/muploadFiles/basic.png" width="40"
											height="40" class="rounded-circle">
									</c:if> <c:if test="${memberFileRename ne null }">
										<img id="profilesmall"
											src="../resources/muploadFiles/${memberFileRename }"
											width="40" height="40" class="rounded-circle">
									</c:if>
								</a>
								<ul class="dropdown-menu text-small">
									<li><a class="dropdown-item" href="/manager/member/list.kh">관리자페이지</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="/member/logout.kh">로그아웃</a></li>
								</ul>
							</div>
						</c:if>
						<c:if test="${memberId ne 'admin' }">
							<div class="dropdown text-end">
								<a href="#"
									class="d-block link-dark text-decoration-none dropdown-toggle"
									data-bs-toggle="dropdown" aria-expanded="false"> <c:if
										test="${memberFileRename eq null }">
										<img id="profilesmall"
											src="../resources/muploadFiles/basic.png" width="40"
											height="40" class="rounded-circle">
									</c:if> <c:if test="${memberFileRename ne null }">
										<img id="profilesmall"
											src="../resources/muploadFiles/${memberFileRename }"
											width="40" height="40" class="rounded-circle">
									</c:if>
								</a>
								<ul class="dropdown-menu text-small">
									<li><a class="dropdown-item" href="/member/mypage.kh">내정보</a></li>
									<li><a class="dropdown-item" href="/member/profile.kh">프로필</a></li>
									<li><a class="dropdown-item" href="/message/list.kh">쪽지함</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="/member/logout.kh">로그아웃</a></li>
								</ul>
							</div>
						</c:if>
					</c:if>
				</div>
			</div>
		</header>
		<c:if test="${memberId ne null }">
		
		<div class="container"
				style="width: 500px; margin-top: 100px; margin-bottom: 100px;">
				<main class="form-signin w-100 m-auto">
					<h1 style="text-align:center;">현재 로그인 중입니다.</h1>
					<br> <br>
					<button href="javascript:void(0);" onclick="goBack();"
						class="w-100 btn btn-lg btn-primary"
						style="margin-top: 30px; background-color: #5AD897; border: 0px;">
						이전으로 이동</button>
					<script type="text/javascript">
						function goBack() {
							history.back();
							// history.go(-1);
						}
					</script>
				</main>
	
			</div>
		</c:if>
		<c:if test="${memberId eq null }">
		
		
		<div class="container"
			style="width: 500px; margin-top: 100px; margin-bottom: 100px;">
			<main class="form-signin w-100 m-auto">
				<form id="frm" action="/member/register.kh" method="post">
					<fieldset>
						<img class="mb-4" src="/resources/img/LOGO1.png" width="80"
							height="80" role="img" class="footerLogo">
						<h1 class="h3 mb-3 fw-normal" style="font-weight:bolder">회원가입</h1>
						<br>
						<ul style="list-style-type: none; padding-left: 0;">
							<li>
							&nbsp아이디
								<div class="form-floating">
									<input type="text" class="form-control" name="memberId"
										id="memberId" placeholder="name@example.com"> <label
										for="floatingInput">4~12자리 영문자, 숫자 입력</label>
										
								</div>
							</li>
							<br>
							<li>
							&nbsp비밀번호
								<div class="form-floating">
									<input type="password" class="form-control" name="memberPw"
										id="memberPw" placeholder="Password"> <label
										for="floatingPassword">6~20자리 영문자, 숫자 입력</label>
								</div>
							</li>
							<br>
							<li>
							&nbsp비밀번호 확인
								<div class="form-floating">
									<input type="password" class="form-control" name="memberPwConfirm"
										id="memberPwConfirm" placeholder="Password"> <label
										for="floatingPassword">비밀번호 재입력</label>
								</div>
							</li>
							<br>
							<li>
							&nbsp이름
								<div class="form-floating">
									<input type="text" class="form-control" name="memberName"
										id="memberName" placeholder="이름"> <label
										for="floatingInput">2글자 이상 한글 입력</label>
								</div>
							</li>
							<br>
							<li>
							&nbsp닉네임
								<div class="form-floating">
									<input type="text" class="form-control" name="memberNickname"
										id="memberNickname" placeholder="닉네임"> <label
										for="floatingInput">2~10글자 닉네임 입력</label>
								</div>
							</li>
							<br>
							<li>
							&nbsp나이
								<div class="form-floating">
									<input type="text" class="form-control" name="memberAge"
										id="memberAge" placeholder="나이"> <label
										for="floatingInput">숫자 입력</label>
								</div>
							</li>
							<br>
							<li>
							&nbsp이메일
							<div class="form-floating">
									<input type="email" class="form-control" name="memberEmail"
										id="memberEmail" placeholder="이메일"> <label
										for="floatingInput">도메인 포함하여 이메일 입력</label>
								</div></li>
							<br>
							<li>
							&nbsp전화번호
							<div class="form-floating">
									<input type="text" class="form-control" name="memberPhone"
										id="memberPhone" placeholder="전화번호"> <label
										for="floatingInput">- 포함하여 전화번호 입력</label>
								</div></li>
							<br>
							<li>
							<label for="memberGender">&nbsp성별</label> <br>
							
							&nbsp남 <input
								type="radio" name="memberGender" id="memberGender" value="M">
								여 <input type="radio" name="memberGender" id="memberGender"
								value="F"></li>
						</ul>
					</fieldset>
					<br>
					<div>
					<input type="button" value="회원가입" onclick="checkValueAndSubmit()" style="width:475px; font-size: larger; margin-top:30px; color:white; background-color: #5AD897; height: 45px; border: 1px solid #DCE2E3; border-radius: 8px;">
						<!-- <button class="w-100 btn btn-lg btn-primary" type="submit"
							style="margin-top: 30px; background-color: #5AD897; border: 0px;">회원가입</button> -->
						<button class="w-100 btn btn-lg btn-primary" type="reset"
							style="margin-top: 30px; background-color: #5AD897; border: 0px;">초기화</button>
					</div>
					<p class="mt-5 mb-3 text-muted">&copy; areyout</p>
				</form>
			</main>
		</div>
		</c:if>
		<div class="container">
			<footer
				class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
				<div class="col mb-3"></div>
				<div class="col mb-3">
					<a href="/"
						class="d-flex align-items-center mb-3 link-dark text-decoration-none">
						<img src="/resources/img/LOGO1.png" width="80" height="80"
						role="img" class="footerLogo">
					</a>
					<p class="text-muted">&copy; 2024 Company, Inc</p>
				</div>

				<div class="col mb-3"></div>

				<div class="col mb-3">
					<h5>ⓒ주식회사 너티야</h5>
					<ul class="nav flex-column">
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">사업자등록번호: 123-45-67890</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">대표전화: 1234:5678</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">서울 중구 남대문로120</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">info@areyout.com</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">대표이사 동행</a></li>
					</ul>
				</div>
			</footer>
		</div>
	</main>

</body>
<script>

function checkValueAndSubmit() {
	const userIdBox = document.getElementById("memberId");
	const idValue = userIdBox.value;
	const idRegEx = /^[a-zA-Z0-9]{4,12}$/;
	
	// idValue가 정규표현식에 적합하지 않으면
	if (idValue == "") {
		alert("아이디를 입력해주세요");
		userIdBox.focus();
		return; // return;을 해줘야 submit이 발동되지 않는다. (주의!)
	}
	else if (!idRegEx.test(idValue)) {
		alert("아이디는 영문자로 시작하고 영문자, 숫자로만 4~12글자만 입력해주세요.");
		userIdBox.focus();
		return; // return;을 해줘야 submit이 발동되지 않는다. (주의!)
	}
	
	const userPwBox = document.getElementById("memberPw");
	const pwValue = userPwBox.value;
	const userPwConfirmBox = document.getElementById("memberPwConfirm");
	const pw2Value = userPwConfirmBox.value;
	const pwRegEx = /^[a-zA-Z0-9]{6,20}$/;
	
	
	
	if (pwValue == "") {
		alert("비밀번호를 입력해주세요");
		userPwBox.focus();
		return;
	}
	else if (!pwRegEx.test(pwValue)) {
		alert("비밀번호는 영문자, 숫자로만 6~20글자만 입력해주세요.");
		userPwBox.focus();
		return;
	}
	else if(userPwBox.value != userPwConfirmBox.value) {
		alert("입력한 비밀번호를 다시 확인해주세요.")
		return;
	}
	
	
	const userNameBox = document.getElementById("memberName");
	const nameValue = userNameBox.value;
	const nameRegEx = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{2,}$/;
	
	if (nameValue == "") {
		alert("이름을 입력해주세요");
		userNameBox.focus();
		return;
	}
	else if (!nameRegEx.test(nameValue)) {
		alert("이름은 2글자 이상 한글로 입력해주세요.");
		userNameBox.focus();
		return;
	}
	
	const userNicknameBox = document.getElementById("memberNickname");
	const nicknameValue = userNicknameBox.value;
	const nicknameRegEx = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣a-zA-Z0-9]{2,10}$/;
	
	if (nicknameValue == "") {
		alert("닉네임을 입력해주세요");
		userNicknameBox.focus();
		return;
	}
	else if (!nicknameRegEx.test(nicknameValue)) {
		alert("닉네임은 2~10글자로 입력해주세요.");
		userNicknameBox.focus();
		return;
	}
	
	const userAgeBox = document.getElementById("memberAge");
	const ageValue = userAgeBox.value;
	const ageRegEx = /^[0-9]{1,3}$/;
	
	if (ageValue == "") {
		alert("나이를 입력해주세요");
		userAgeBox.focus();
		return;
	}
	else if (!ageRegEx.test(ageValue)) {
		alert("나이는 숫자로 입력해주세요.");
		userAgeBox.focus();
		return;
	}
	
	
	const userEmailBox = document.getElementById("memberEmail");
	const emailValue = userEmailBox.value;
	const emailRegEx = /^[a-zA-Z0-9]{4,20}@[a-zA-Z0-9]{2,20}\.[a-zA-Z0-9]{2,3}$/;
	
	
	if (emailValue == "") {
		alert("이메일을 입력해주세요");
		userEmailBox.focus();
		return;
	}
	else if (!emailRegEx.test(emailValue)) {
		alert("이메일은 도메인을 포함하여 정확히 입력해주세요.");
		userEmailBox.focus();
		return;
	}
	
	const userPhoneBox = document.getElementById("memberPhone");
	const phoneValue = userPhoneBox.value;
	const phoneRegEx = /^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$/;
	
	
	if (phoneValue == "") {
		alert("전화번호를 입력해주세요");
		userPhoneBox.focus();
		return;
	}
	else if (!phoneRegEx.test(phoneValue)) {
		alert("전화번호를 정확히 입력해주세요.");
		userPhoneBox.focus();
		return;
	}
	
	 var chkRadio = document.getElementsByName("memberGender");  //라디오 버튼 name 
	    var chk_cnt = 0; 
	    for(var i=0; i<chkRadio.length; i++){ 
	      if(chkRadio[i].checked == true) chk_cnt++; 
	    } 
	 
	    if(chk_cnt<1) { 
	      alert("성별을 체크하세요"); 
	      document.formname.chkRadio[0].focus(); 
	      return; 
	    } 
	
	const frm = document.getElementById("frm");
	frm.submit();
	
}


</script>
</html>

