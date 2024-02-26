<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
            table a{
                color: black;
            }
        </style>
</head>
<body>
    <header></header>
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
                        <li class="menu-item"><a href="/manager/main.kh">대쉬보드</a></li><br><br><br>
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
                    <h3>여행신청 게시판 관리</h3>
                    <hr>
                    <div class="form-inline">
                        <form class="form-inline" id="search" action="/manager/notice/search.kh" method="get">
                            <div class="input-group-prepend">
                                    <select class="custom-select" name="searchCondition">
                                        <option value="title" selected>제목</option>
                                        <option value="content">내용</option>
                                        <option value="writer">작성자</option>
                                    </select>
                                </div>
                                <input class="form-control" type="search" placeholder="검색어를 입력하세요" aria-label="Search"
                                value="${pInfo.searchKeyword}" name="searchKeyword">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-success" type="submit">검색</button>
                            </div>
                        </form>
                            <div class="ml-auto form-inline">
                            	<form action="/manager/notice/delete.kh" method="post">
                            	<input type="hidden" id="check-delete-notice" name="check-delete-notice">
                                <button type="submit" class="btn btn-danger" onclick="getDeleteNotice();">게시글 삭제</button>
                            	</form>
                            </div>
                        </div>
                        <br>
                        <form action="/manager/notice/list.kh" method="get" id="member-list">
                            <div id="board-list">
                                <div class="container" id="board-list-container">
                                    <table class="board-table">
                                        <thead>
                                        <tr>
                                            <th scope="col">선택/해제</th>
                                            <th scope="col">작성자</th>
                                            <th scope="col">작성날짜</th>
                                            <th scope="col">제목</th>
                                            <th scope="col">게시글 번호</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${nmList}" var="notice" varStatus="i">
                                        <tr>
                                            <td><input type="checkbox" name="select-notice" value="${notice.noticeNo}"></td>
                                            <td>${notice.noticeWriter}</td>
                                            <td>${notice.noticeDate}</td>
                                            <td><a href="/manager/notice/detail.kh?noticeNo=${notice.noticeNo}">${notice.noticeSubject}</a></td>
                                            <td>${notice.noticeNo}</td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                        <tfoot>
                                        	<tr align="center">
                                        		<td colspan="5">
                                        	<c:if test="${pInfo.startNavi ne '1'}">
												<a href="/manager/notice/list.kh?page=${pInfo.startNavi - 1}">[이전]</a>
											</c:if>
											<c:forEach begin="${pInfo.startNavi}" end="${pInfo.endNavi}" var="p">
							               		<a href="/manager/notice/list.kh?page=${p}">${p}</a>
							            	</c:forEach>
							            	<c:if test="${pInfo.endNavi ne pInfo.naviTotalCount}">
												<a href="/manager/notice/list.kh?page=${pInfo.endNavi + 1}">[다음]</a>
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
    <footer></footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('li:has(ul)').click(function(e){
                $(this).children('ul').toggle();
                e.stopPropagation();
            });
        });
        
        function getDeleteNotice(){
    		// 체크된 input 요소 선택
    		var checkedCheckboxes = document.querySelectorAll('input[name="select-notice"]:checked');

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
    			alert("체크된 메세지가 없습니다.");
    		}
    		else{
    			document.getElementById('check-delete-notice').value = checkedValues.join(',');
    	    }
    	}
    </script>
</body>
</html>