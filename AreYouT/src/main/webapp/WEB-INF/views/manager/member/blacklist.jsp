<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>블랙리스트 관리</title>
    <link rel="stylesheet" href="../../../resources/css/bootstrap.css">
<style>
            body {
            text-align: left; /* 모든 텍스트를 왼쪽 정렬 */
            }
            #menu-container {
                background-color: #444; /* 회색과 검은색 사이의 색상 */
                color: white; /* 텍스트 색상 */
                height: 100vh;
                justify-content: center; /* 수평 가운데 정렬 */
                text-align: center;/*텍스트 수평 가운데 정렬*/
            }
            #menu-line{
                border-color: white; /* hr 요소의 색상을 흰색으로 지정 */
            }
            .sub-menu {
            display: none; /* 초기에 하위 메뉴 숨김 */
            }
            .menu-item {
             /* 메뉴 항목 텍스트를 왼쪽으로 이동 */
            text-align: left;
            }
            .menu-item a{
             /* 메뉴 항목 텍스트를 왼쪽으로 이동 */
            text-align: left;
            color: white;
            }
            #member-manager{
                margin: auto;
                text-align: center;
            }
            #search{
                margin: auto;
                justify-content: center;
            }
            table {
                border-collapse: collapse;
                border-spacing: 0;
            }
            .page-title {
                margin-bottom: 60px;
            }
            .page-title h3 {
                font-size: 28px;
                color: #333333;
                font-weight: 400;
                text-align: center;
            }

            #board-search .search-window {
                padding: 15px 0;
                background-color: #f9f7f9;
            }
            #board-search .search-window .search-wrap {
                position: relative;
            /*   padding-right: 124px; */
                margin: 0 auto;
                width: 80%;
                max-width: 564px;
            }
            #board-search .search-window .search-wrap input {
                height: 40px;
                width: 100%;
                font-size: 14px;
                padding: 7px 14px;
                border: 1px solid #ccc;
            }
            #board-search .search-window .search-wrap input:focus {
                border-color: #333;
                outline: 0;
                border-width: 1px;
            }
            #board-search .search-window .search-wrap .btn {
                position: absolute;
                right: 0;
                top: 0;
                bottom: 0;
                width: 108px;
                padding: 0;
                font-size: 16px;
            }

            .board-table {
                font-size: 13px;
                width: 100%;
                border-top: 1px solid #ccc;
                border-bottom: 1px solid #ccc;
            }

            .board-table a:hover {
                text-decoration: underline;
            }
            .board-table th {
                text-align: center;
            }

            .board-table .th-num {
                width: 100px;
                text-align: center;
            }

            .board-table .th-date {
                width: 200px;
            }

            .board-table th, .board-table td {
                padding: 14px 0;
            }

            .board-table tbody td {
                border-top: 1px solid #e7e7e7;
                text-align: center;
            }

            .board-table tbody th {
                padding-left: 28px;
                padding-right: 14px;
                border-top: 1px solid #e7e7e7;
                text-align: left;
            }

            .board-table tbody th p{
                display: none;
            }

            /* reset */

            * {
            list-style: none;
            text-decoration: none;
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            }
            .clearfix:after {
            content: '';
            display: block;
            clear: both;
            }
            .container {
            width: 1100px;
            margin: 0 auto;
            }
            .blind {
            position: absolute;
            overflow: hidden;
            clip: rect(0 0 0 0);
            margin: -1px;
            width: 1px;
            height: 1px;
            }
            /*헤더푸터*/
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

.login-header a:link, .login-header a{
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
#headerSearch{
	position: relative;
	left: 470px; 
}
#login-header{
	position: relative;
	left: 500px; 
}
#header-menu{
	position: relative;
	right: 100px;
}
</style>
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
		<header class="p-3 mb-3 border-bottom">
			<div class="container">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
					<img src="/resources/img/LOGO1.png" width="200" height="200"
					role="img" class="logo">
				</a>
				<div
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">


					<ul	id="header-menu"
						class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
						<li><a href="#" class="nav-link px-2 link-secondary">홈</a></li>
						<li><a href="#" class="nav-link px-2 link-dark">동행모집</a></li>
						<li><a href="#" class="nav-link px-2 link-dark">성향테스트</a></li>
						<li><a href="#" class="nav-link px-2 link-dark">나의 짝꿍 찾기</a></li>
					</ul>

					<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" id="headerSearch">
						<input type="search" class="form-control" placeholder="Search..."
							aria-label="Search">
					</form>


					<c:if test="${memberId eq null }">
						<div class="login-header" id="login-header">
							<ul>
								<li><a href="./user/login.html">로그인&nbsp</a></li>
								<li><a href="./user/register.html">&nbsp회원가입</a></li>
							</ul>
						</div>
					</c:if>

					<c:if test="${memberId ne null }">
						<div class="dropdown text-end">
							<a href="#"
								class="d-block link-dark text-decoration-none dropdown-toggle"
								data-bs-toggle="dropdown" aria-expanded="false"> <img
								src="https://github.com/mdo.png" alt="mdo" width="32"
								height="32" class="rounded-circle">
							</a>
							<ul class="dropdown-menu text-small">
								<li><a class="dropdown-item" href="#">New project...</a></li>
								<li><a class="dropdown-item" href="#">Settings</a></li>
								<li><a class="dropdown-item" href="#">Profile</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Sign out</a></li>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</header>
    <main>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2" id="menu-container">
                    <div class="btn-container">
                        <br><button type="button" class="btn btn-danger">로그아웃</button><br><br>
                    </div>
                    <a href="/"><button type="button" class="btn btn-info">메인으로</button></a>
                    <h2>사이트 관리</h2>
                    <hr id="menu-line">
                    <ul class="list-unstyled">
                        <li class="menu-item"><a href="#">대쉬보드</a></li><br><br><br>
                        <li class="menu-item"><a href="#">회원 관리</a>
                            <ul class="sub-menu">
                                <li><a href="/manager/member/list.kh">일반 회원 관리</a></li>
                                <li><a href="/manager/member/blacklist.kh">블랙리스트 관리</a></li>
                            </ul>
                        </li><br><br><br>
                        <li class="menu-item"><a href="/manager/notice/list.kh">여행신청 게시판 관리</a></li><hr id="menu-line"><br><br><br><br><br><br><br>
                        <li class="menu-item"><a href="#">쪽지 관리</a>
                            <ul class="sub-menu">
                                <li><a href="/manager/message/askmessage.kh">1대1 문의 쪽지함</a></li>
                                <li><a href="/manager/message/list.kh">일반 쪽지 관리</a></li>
                            </ul>
                        </li><br>
                    </ul>
                </div>
                <div class="col-md-10" id="" style="display: flex; justify-content: center;">
                <div class="container mt-3" id="member-manager">
                    <h3>블랙리스트 관리</h3>
                    <hr>
                            <div class="input-group mr-sm-2">
                                <div class="form-inline">
                                <form class="form-inline" id="search" action="/manager/member/blacksearch.kh" method="GET">
                                <div class="input-group-prepend">
	                                    <select class="custom-select" name=search-type>
	                                        <option value="name" selected>이름</option>
	                                        <option value="id">아이디</option>
	                                    </select>
	                                </div>
	                                <input class="form-control" type="search" placeholder="검색어를 입력하세요" aria-label="Search"
	                                value="${pInfo.searchKeyword}" name="search-keyword">
	                                <div class="input-group-append">
	                                    <button class="btn btn-outline-success" type="submit">검색</button>
	                                </div>
	                            </form>
                            </div>
                            <div class="ml-auto form-inline">
                                <form action="/manager/member/white.kh" method="post">
                            		<input type="hidden" id="check-white-members" name="check-white-members">
                             		<button type="submit" class="btn btn-dark" onclick="getWhiteMembers();">블랙 리스트 해제</button>
                            	</form>
                                &nbsp;
                                <form action="/manager/member/blackdelete.kh" method="post">
                             		<input type="hidden" id="check-delete-members" name="check-delete-members">
                             		<button type="submit" class="btn btn-danger" onclick="getDeleteMembers();">회원 탈퇴 처리</button>
                             	</form>
                            </div>
                        </div>
                        <br>
                        <form action="/manager/member/blacklist.kh" id="member-list" method="get">
                            <div id="board-list">
                                <div class="container" id="board-list-container">
                                    <table class="board-table">
                                        <thead>
                                        <tr>
                                            <th scope="col">선택/해제</th>
                                            <th scope="col">이름</th>
                                            <th scope="col">가입날짜</th>
                                            <th scope="col">성별</th>
                                            <th scope="col">아이디</th>
                                            <th scope="col">이메일</th>
                                            <th scope="col">전화번호</th>
                                            <th scope="col">mbti(성향)</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${mmList}" var="member" varStatus="i">
		                                        <tr>
		                                            <td><input type="checkbox" name="select-member" value="${member.memberId}"></td>
		                                            <td>${member.memberName}</td>
		                                            <td>${member.memberDate}</td>
		                                            <td>${member.memberGender}</td>
		                                            <td>${member.memberId}</td>
		                                            <td>${member.memberEmail}</td>
		                                            <td>${member.memberPhone}</td>
		                                            <td>${member.memberMbti}</td>
		                                        </tr>
	                                        </c:forEach>
                                        </tbody>
                                        <tfoot>
                                        	<tr align="center">
												<td colspan="7">
													<c:if test="${pInfo.startNavi ne '1'}">
														<a href="/manager/member/blacklist.kh?page=${pInfo.startNavi - 1}">[이전]</a>
													</c:if>
													<c:forEach begin="${pInfo.startNavi}" end="${pInfo.endNavi}" var="p">
							               				<a href="/manager/member/blacklist.kh?page=${p}">${p}</a>
							            			</c:forEach>
							            			<c:if test="${pInfo.endNavi ne pInfo.naviTotalCount}">
														<a href="/manager/member/blacklist.kh?page=${pInfo.endNavi + 1}">[다음]</a>
													</c:if>
												</td>
											</tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
    <div class="col mb-3"></div>
    <div class="col mb-3">
      <a href="/" class="d-flex align-items-center mb-3 link-dark text-decoration-none">
        <img src="/resources/img/LOGO1.png" width="80" height="80"
					role="img" class="footerLogo">
      </a>
      <p class="text-muted">&copy; 2024 Company, Inc</p>
    </div>

    <div class="col mb-3"></div>

    <div class="col mb-3">
      <h5>ⓒ주식회사 너티야</h5>
      <ul class="nav flex-column">
        <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">사업자등록번호: 123-45-67890</a></li>
        <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">대표전화: 1234:5678</a></li>
        <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">서울 중구 남대문로120</a></li>
        <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">info@areyout.com</a></li>
        <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">대표이사 동행</a></li>
      </ul>
    </div>
  </footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('li:has(ul)').click(function(e){
                $(this).children('ul').toggle();
                e.stopPropagation();
            });
        });
        function getDeleteMembers(){
    		// 체크된 input 요소 선택
    		var checkedCheckboxes = document.querySelectorAll('input[name="select-member"]:checked');

    		// 체크된 input 요소의 값을 저장할 배열
    		var checkedValues = [];

    		// 각 체크된 input 요소의 값을 배열에 추가
    		checkedCheckboxes.forEach(function(checkbox) {
    		    checkedValues.push(checkbox.value);
    		});

    		// 배열에 저장된 값 확인
    		console.log(checkedValues);
    		
    		//체크 된 회원 없을 시 오류 메세지 출력
    		if(checkedValues.length == 0){
    			alert("체크된 회원이 없습니다.");
    		}
    		else{
    			document.getElementById('check-delete-members').value = checkedValues.join(',');
    	    }
    	}
        function getWhiteMembers(){
    		// 체크된 input 요소 선택
    		var checkedCheckboxes = document.querySelectorAll('input[name="select-member"]:checked');

    		// 체크된 input 요소의 값을 저장할 배열
    		var checkedValues = [];

    		// 각 체크된 input 요소의 값을 배열에 추가
    		checkedCheckboxes.forEach(function(checkbox) {
    		    checkedValues.push(checkbox.value);
    		});

    		// 배열에 저장된 값 확인
    		console.log(checkedValues);
    		
    		//체크 된 회원 없을 시 오류 메세지 출력
    		if(checkedValues.length == 0){
    			alert("체크된 회원이 없습니다.");
    		}
    		else{
    			document.getElementById('check-white-members').value = checkedValues.join(',');
    	    }
    	}
    </script>
</body>
</html>