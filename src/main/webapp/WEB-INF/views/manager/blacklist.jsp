<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <h2>사이트 관리</h2>
                    <hr id="menu-line">
                    <ul class="list-unstyled">
                        <li class="menu-item"><a href="#">대쉬보드</a></li><br><br><br>
                        <li class="menu-item"><a href="#">회원 관리</a>
                            <ul class="sub-menu">
                                <li><a href="#">일반 회원 관리</a></li>
                                <li><a href="#">블랙리스트 관리</a></li>
                            </ul>
                        </li><br><br><br>
                        <li class="menu-item"><a href="#">여행신청 게시판 관리</a></li><hr id="menu-line"><br><br><br><br><br><br><br>
                        <li class="menu-item"><a href="#">쪽지 관리</a>
                            <ul class="sub-menu">
                                <li><a href="#">1대1 문의 쪽지함</a></li>
                                <li><a href="#">일반 쪽지 관리</a></li>
                            </ul>
                        </li><br>
                    </ul>
                </div>
                <div class="col-md-10" id="" style="display: flex; justify-content: center;">
                <div class="container mt-3" id="member-manager">
                    <h3>블랙리스트 관리</h3>
                    <hr>
                        <form class="form-inline" id="search">
                            <div class="input-group mr-sm-2">
                                <div class="input-group-prepend">
                                    <select class="custom-select">
                                        <option value="title" selected>이름</option>
                                        <option value="author">아이디</option>
                                        <option value="post-number">회원 번호</option>
                                    </select>
                                </div>
                                <input class="form-control" type="search" placeholder="검색어를 입력하세요" aria-label="Search">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-success" type="submit">검색</button>
                                </div>
                            </div>
                            <div class="ml-auto">
                                <button type="button" class="btn btn-dark">블랙 리스트 해제</button>
                                <button type="button" class="btn btn-danger">회원 탈퇴 처리</button>
                            </div>
                        </form>
                        <br>
                        <form action="" id="member-list">
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
                                            <th scope="col">회원번호</th>
                                            <th scope="col">mbti(성향)</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td>홍길동</td>
                                            <td>2018-04-04</td>
                                            <td>남</td>
                                            <td>khuser01</td>
                                            <td>khuser01@naver.com</td>
                                            <td>010-1111-2222</td>
                                            <td>1</td>
                                            <td>TTTT</td>
                                        </tr>
                        
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td>고길동</td>
                                            <td>2017-07-13</td>
                                            <td>남</td>
                                            <td>khuser02</td>
                                            <td>khuser02@naver.com</td>
                                            <td>010-1111-2223</td>
                                            <td>2</td>
                                            <td>FFFF</td>
                                        </tr>
                        
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td>김길동</td>
                                            <td>2017-07-13</td>
                                            <td>남</td>
                                            <td>khuser03</td>
                                            <td>khuser03@naver.com</td>
                                            <td>010-1111-2224</td>
                                            <td>3</td>
                                            <td>TTFF</td>
                                        </tr>
                                        </tbody>
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
    </script>
</body>
</html>