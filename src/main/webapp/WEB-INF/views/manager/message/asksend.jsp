<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <button class="btn btn-dark">쪽지 전송</button>
                </div>
            </div>
            <div>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-12 text-center">
                            <div class="text-container">
                                <b>제목</b>
                                <input type="text" placeholder="쪽지 제목을 적어주세요" style="width: 600px;">
                                <b>날짜</b>
                                <span>2024.02.19</span>
                            </div>
                            <hr>
                            <div class="text-container">
                                <b>받는 이</b>
                                <input type="text" placeholder="받는 분의 아이디를 적어주세요" style="width: 300px;">
                                <b>보내는 이</b>
                                <span>관리자</span>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="text-center">
                    <textarea name="message-content" id="" cols="140" rows="30%" placeholder="내용을 적어주세요"></textarea>
                </div>
            </div>
        </div>
	</body>
</html>