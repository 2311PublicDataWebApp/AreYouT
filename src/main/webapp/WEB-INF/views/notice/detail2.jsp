<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세</title>
		<link rel="stylesheet" href="../resources/css/main.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	</head>
	<body>
		<div class="card mb-3">
		  <img src="/resources/img/copy.png" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">${notice.noticeSubject }</h5>
		    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		    <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
		  </div>
		</div>
		<h1>공지사항 상세 조회</h1>
		<ul>
			<li>
				<label>제목</label>
				<span>${notice.noticeSubject }</span>
			</li>
			<li>
				<label>작성자</label>
				<span>${notice.noticeWriter }</span>
			</li>
			<li>
				<label>내용</label>
				<span>${notice.noticeContent }</span>
			</li>
			<li>
				<label>첨부파일</label>
				<img src="../resources/nuploadFiles/${notice.noticeFileRename }" '>
<%-- 				<span><a href="../resources/nuploadFiles/${notice.noticeFileRename }" download>${notice.noticeFilename }</a></span> --%>
			</li>
		</ul>
		<br><br>
		<div>
			<button type="button" onclick="showModifyPage();">수정하기</button>
			<button type="button" onclick="deleteNotice(${notice.noticeNo});">삭제하기</button>
			<button type="button" onclick="showNoticeList();">목록으로 이동하기</button>
		</div>
		<script type="text/javascript">
			function showModifyPage() {
				var noticeNo = "${notice.noticeNo }";
				location.href = "/notice/modify.kh?noticeNo=" + noticeNo;
			}
			
			function deleteNotice(noticeNo) {
				if (confirm("삭제하시겠습니까?")) {
					location.href = "/notice/delete.kh?noticeNo=" + noticeNo;
				}
			}
			
			function showNoticeList() {
				location.href = "/notice/list.kh";
			}
		</script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	</body>
</html>