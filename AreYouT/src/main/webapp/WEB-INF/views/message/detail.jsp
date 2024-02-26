<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>쪽지 조회</title>
        <link rel="stylesheet" href="../../../resources/css/bootstrap.css">
        <style>
            hr {
            background-color: #333;
            height: 2px; /* hr 높이 설정 */
            border: none; /* 테두리 제거 */
            }
            .text-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            }
            .text-container b {
            margin-right: 10px; /* 각 요소 사이의 간격 설정 */
            }
        </style>
	</head>
	<body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-2 text-center offset-lg-5">
                    <h3>쪽지</h3>
                    <hr>
                </div>
                <div class="col-lg-5 text-right justify-content-end">
                    <a href="/message/send.kh">
                        <button class="btn btn-dark">쪽지 답장</button>
                    </a>&nbsp;
                    <a href="/message/list.kh">
                        <button class="btn btn-dark">목록으로</button>
                    </a>
                </div>
            </div>
            <div>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-12 text-center">
                            <div class="text-container">
                                <b>제목</b>
                                <span>${message.messageTitle}</span>
                                <b>날짜</b>
                                <span>${message.sendDate}</span>
                            </div>
                            <hr>
                            <div class="text-container">
                                <b>받는 이</b>
                                <span>${message.messageReceive}</span>
                                <b>보내는 이</b>
                                <span>${message.messageSender}</span>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="text-center">
                    <textarea name="message-content" id="" cols="140" rows="30%" readonly>
                        ${message.messageContent}
                    </textarea>
                </div>
            </div>
        </div>
	</body>
</html>