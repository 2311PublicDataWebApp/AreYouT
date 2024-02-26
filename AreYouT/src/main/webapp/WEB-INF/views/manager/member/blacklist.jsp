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