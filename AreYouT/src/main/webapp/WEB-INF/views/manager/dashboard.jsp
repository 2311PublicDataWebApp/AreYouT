<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>관리 페이지 대쉬보드</title>
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
            table{
                text-align: center;
            }
            #table-div{
                border: 1px solid black;
            }
            #table-div table{
                margin-left: auto;
                margin-right: auto;
                border: 1px solid black;
            }
            #table-div table th,td{
                border: 1px solid black;
            }
            h5{
                text-align: center;
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
                    <div class="col-md-10" id="dash-board">
                        <div class="col-md-10">
                            <div class="row">
                                <!-- 왼쪽 영역 -->
                                <div class="col-md-6" id="left-column">
                                    <div id="table-div">
                                        <h5>게시판 관리</h5>
                                        <table>
                                            <tr>
                                                <th>이름</th>
                                                <th>가입날짜</th>
                                                <th>이메일</th>
                                                <th>전화번호</th>
                                                <th>회원번호</th>
                                            </tr>
                                            <tr>
                                                <td>일용자</td>
                                                <td>2020-02-02</td>
                                                <td>khuser01@naver.com</td>
                                                <td>010-1111-2222</td>
                                                <td>01</td>
                                            </tr>
                                        </table>
                                        <a href="#">더 보기</a>
                                    </div>
                                    <!-- 여기에 왼쪽 위의 내용 추가 -->
                                    <hr> <!-- 수직선 추가 -->
                                    <div id="table-div">
                                        <h5>일반쪽지 관리</h5>
                                        <table>
                                            <tr>
                                                <th>이름</th>
                                                <th>가입날짜</th>
                                                <th>이메일</th>
                                                <th>전화번호</th>
                                                <th>회원번호</th>
                                            </tr>
                                            <tr>
                                                <td>일용자</td>
                                                <td>2020-02-02</td>
                                                <td>khuser01@naver.com</td>
                                                <td>010-1111-2222</td>
                                                <td>01</td>
                                            </tr>
                                        </table>
                                        <a href="#">더 보기</a>
                                    </div>
                                    <!-- 여기에 왼쪽 아래의 내용 추가 -->
                                </div>
                                <!-- 오른쪽 영역 -->
                                <div class="col-md-6" id="right-column">
                                    <div id="table-div">
                                        <h5>일반회원 관리</h5>
                                        <table>
                                            <tr>
                                                <th>이름</th>
                                                <th>가입날짜</th>
                                                <th>이메일</th>
                                                <th>전화번호</th>
                                                <th>회원번호</th>
                                            </tr>
                                            <tr>
                                                <td>일용자</td>
                                                <td>2020-02-02</td>
                                                <td>khuser01@naver.com</td>
                                                <td>010-1111-2222</td>
                                                <td>01</td>
                                            </tr>
                                        </table>
                                        <a href="#">더 보기</a>
                                    </div>
                                    <!-- 여기에 오른쪽의 내용 추가 -->
                                </div>
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