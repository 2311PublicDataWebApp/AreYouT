<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
	<form action="/message/asksend.kh" id="sendForm" method="post">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-2 text-center offset-lg-5">
                    <h3>쪽지</h3>
                    <hr>
                </div>
                <div class="col-lg-5 text-right justify-content-end">
                    <button type="submit" class="btn btn-dark" onclick="submitForm()">쪽지 전송</button>
                </div>
            </div>
            <div>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-12 text-center">
                            <div class="text-container">
                                <b>제목</b>
                                <input type="text" placeholder="쪽지 제목을 적어주세요" style="width: 600px;"
                                name="askMessageTitle" id="title">
                                <b>날짜</b>
                                <span>
                                	<input type="date" id="nowDate" name="now-date" readonly>
                                </span>
                            </div>
                            <hr>
                            <div class="text-container">
                                <b>받는 이</b>
                                <input type="text" id="receive" name="askMessageReceive" value="admin" readonly>
                                <b>보내는 이</b>
                                <span>
                                    <input type="text" id="sender" name="askMessageSender" value="${memberId}" readonly>
                                </span>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="text-center">
                    <textarea cols="140" rows="30%" placeholder="내용을 적어주세요"
                    name="askMessageContent" id="content"></textarea>
                </div>
            </div>
        </div>
        </form>
        <script>
            function getTodayDate() {
                var today = new Date();

                var year = today.getFullYear();
                var month = (today.getMonth() + 1).toString().padStart(2, '0'); // 월은 0부터 시작하므로 1을 더하고 2자리로 패딩
                var day = today.getDate().toString().padStart(2, '0'); // 일은 1부터 시작하므로 2자리로 패딩

                var formattedDate = year + '-' + month + '-' + day;
                return formattedDate;
            }
        
            // 오늘 날짜를 입력 필드에 설정
            document.getElementById('nowDate').value = getTodayDate();
	        function submitForm() {
	            var form = document.getElementById("sendForm");
// 	            var formData = new FormData(form);
// 	            var title = document.getElementById("title").value;
// 	            var receive = document.getElementById("receive").value;
// 	            var content = document.getElementById("content").value;
	            
// 	            formData.append("askMessageTitle", title);
// 	            formData.append("askMessageReceive", receive);
// 	            formData.append("askMessageContent", content);
// 	            var xhr = new XMLHttpRequest();
// 	            xhr.open("POST", "/manager/message/askmessage.do", true);
// 	            xhr.onreadystatechange = function () {
// 	              if (xhr.readyState === XMLHttpRequest.DONE) {
// 	                if (xhr.status === 200) {
// 	                  // 요청이 성공적으로 처리됨
// 	                  console.log("전송 성공");
// 	                  window.close(); // 팝업 창 닫기 등 추가 동작 수행
// 	                } else {
// 	                  // 요청이 실패했거나 오류가 발생함
// 	                  console.error("전송 실패");
// 	                }
// 	              }
// 	            };
// 	            xhr.send(formData);
	           setTimeout(function() {
	        	   console.log("success!!");
	        	   window.close();
	           }, 2000);
// 	           axios.post("/manager/message/askmessage.do")
// 	           	.then(function(response) {
// 	           		console.log("success!!");
// 	           		window.close();
// 	           	})
// 	           	.catch(function(error) {
// 	           		console.error("failed!", error);
// 	           	})
          	}
        </script>
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	</body>
</html>