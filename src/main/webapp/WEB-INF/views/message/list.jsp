<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쪽지함</title>
    <link rel="stylesheet" href="../../../resources/css/bootstrap.css">
    <style>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10" id="" style="display: flex; justify-content: center;">
            <div class="container mt-3" id="member-manager">
                <h3>쪽지함</h3>
                <hr>
                    <form class="form-inline" id="search">
                        <div class="input-group mr-sm-2">
                            <div class="input-group-prepend">
                                <select class="custom-select">
                                    <option value="title" selected>제목</option>
                                    <option value="author">작성자</option>
                                    <option value="post-number">게시글 번호</option>
                                </select>
                            </div>
                            <input class="form-control" type="search" placeholder="검색어를 입력하세요" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-outline-success" type="submit">검색</button>
                            </div>
                        </div>
                        <div class="ml-auto">
                            <button type="button" class="btn btn-danger">쪽지 정보 삭제</button>
                        </div>
                    </form>
                    <br>
                    <form action="/message/list.kh" method="get" id="member-list">
                        <div id="board-list">
                            <div class="container" id="board-list-container">
                                <table class="board-table">
                                    <thead>
                                    <tr>
                                            <th scope="col">선택/해제</th>
                                            <th scope="col">보낸 이</th>
                                            <th scope="col">받는 이</th>
                                            <th scope="col">보낸 날짜</th>
                                            <th scope="col">제목</th>
                                            <th scope="col">쪽지 번호</th>
                                            <th scope="col">읽음 여부</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${mmList}" var="message" varStatus="i">
                                        	<tr>
                                            	<td><input type="checkbox" name="select-message" value="${message.messageNo}"></td>
                                            	<td>${message.messageSender}</td>
                                            	<td>${message.messageReceive}</td>
                                            	<td>${message.sendDate}</td>
                                            	<td>
                                            		<a href="javascript:void(0);" onclick="pop(${message.messageNo});">
                                            			${message.messageTitle}
                                            		</a>
                                            	</td>
                                            	<td>${message.messageNo}</td>
                                            	<td>${message.readYn}</td>
                                        	</tr>
                        				</c:forEach>
                                    </tbody>
                                    <tfoot>
                                        	<tr align="center">
                                        		<td colspan="5">
                                        	<c:if test="${pInfo.startNavi ne '1'}">
												<a href="/message/list.kh?page=${pInfo.startNavi - 1}">[이전]</a>
											</c:if>
											<c:forEach begin="${pInfo.startNavi}" end="${pInfo.endNavi}" var="p">
							               		<a href="/message/list.kh?page=${p}">${p}</a>
							            	</c:forEach>
							            	<c:if test="${pInfo.endNavi ne pInfo.naviTotalCount}">
												<a href="/message/list.kh?page=${pInfo.endNavi + 1}">[다음]</a>
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
</body>
</html>