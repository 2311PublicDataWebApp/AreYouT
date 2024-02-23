<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8" />
		<meta
			name="viewport"
			content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"
		/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge; IE=9" />

		<meta name="author" content="null null" />
		<meta name="keywords" content="여행 MBTI 검사" />
		<meta name="description" content="여행 MBTI 검사" />

		<!--sns share-->
		<meta property="og:type" content="website" />
		<meta property="og:title" content="여행 MBTI 검사" />
		<meta
			property="og:description"
			content="두근두근 나의 여행 MBTI는?"
		/>
		<meta property="og:image" content="img/share.png" />
		<meta property="og:url" content="https://twelvelevetype.netlify.app/" />

		<!--favicon-->
		<link rel="shortcut icon" type="text/css" href="img/favicon.ico" />
		<link rel="appel-touch-icon-precomposed" href="img/favicon.ico" />

		<title>두근두근 나의 여행 MBTI는?</title>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="/resources/css/default.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/layout.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/footer.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/animation.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/qna.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/calc.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/result.css" />
		<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
		<!-- js -->
		<!-- <script src="../resources/js/data.js"></script>
		<script src="../resources/js/end.js"></script>
		<script src="../resources/js/share.js"></script>
		<script src="../resources/js/start.js"></script> -->
		
		<script>
			Kakao.init('da972007084fda5f2c305cef966b2dd4');
			console.log(Kakao.isInitialized());
		</script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<!-- 스크롤 자동으로 맨 위로 올라가도록 -->
		<script>
			$(function () {
				$('html, body').animate({ scrollTop: 0 }, 'fast');
			});
		</script>

		<!--GA-->
		<!-- Global site tag (gtag.js) - Google Analytics -->
		<script async src="https://www.googletagmanager.com/gtag/js?id=G-YCJN4CFTVY"></script>
		<script>
// 			window.dataLayer = window.dataLayer || [];
// 			function gtag() {
// 				dataLayer.push(arguments);
// 			}
// 			gtag('js', new Date());

// 			gtag('config', 'G-YCJN4CFTVY');
<!-- 		</script> -->
<!-- 	</head> -->
<!-- 	<body> -->
<!-- 	<form action="/mbti/mbtitest.kh" method="get" enctype="multipart/form-data"> -->
<!-- 		<div id="wrap"> -->
<!-- 			<header id="header"></header> -->
<!-- 			<section id="main" class="container"> -->
<!-- 				<div id="titleBox"> -->
<!-- 					<h1 class="mainText"> -->
<!-- 						<p>두근두근 나의 여 행 MBTI는?</p> -->
<!-- 					</h1> -->
<!-- 					<h3 class="elevatorPitch"> -->
<!-- 						<p>여행중 만나는 상황에서 나는 어떻게 할것인가?</p> -->
<!-- 					</h3> -->
<!-- 					<div> -->
<!-- 						<img src="./img/main.png" class="main_img" /> -->
<!-- 					</div> -->
<!-- 					<span class="time_logo"></span> -->
<!-- 					<p>소요 시간 : 3분 내외</p> -->
<!-- 				</div> -->
<!-- 				<div class="start-wrap"> -->
<!-- 					<button class="start">시 작</button> -->
<!-- 				</div> -->
<!-- 				<div class="BottomAdd"> -->
<!-- 					<ins -->
<!-- 						class="kakao_ad_area" -->
<!-- 						style="display: none;" -->
<!-- 						data-ad-unit="DAN-ivudQXUBsbUuX0ec" -->
<!-- 						data-ad-width="320" -->
<!-- 						data-ad-height="100" -->
<!-- 					></ins> -->
<!-- 					<script -->
<!-- 						type="text/javascript" -->
<!-- 						src="//t1.daumcdn.net/kas/static/ba.min.js" -->
<!-- 						async -->
<!-- 					></script> -->
<!-- 				</div> -->
<!-- 			</section> -->

<!-- 			<section id="qna" class="container"> -->
<!-- 				<div class="status-bar"> -->
<!-- 					<div class="status"></div> -->
<!-- 				</div> -->
<!-- 				<div class="q box"></div> -->
<!-- 				<div class="answer"></div> -->
<!-- 			</section> -->

			<section id="result" class="container">
				<div id="score-box">
					<div class="p title"></div>
				</div>

				<div id="desc-box">
					<div class="art"></div>
					<div class="result title"></div>
					<div class="res desc"></div>
					<!-- 설명끝 -->
					<div style="padding-top: 20px; padding-bottom: 20px;">
						<ins
							class="kakao_ad_area"
							style="display: none;"
							data-ad-unit="DAN-AidHdpOeoPkU8L9l"
							data-ad-width="320"
							data-ad-height="50"
						></ins>
						<script
							type="text/javascript"
							src="//t1.daumcdn.net/kas/static/ba.min.js"
							async
						></script>
					</div>
					<!-- 이후에 추가할 것, 공유하기(혹은 복사), copyright에 대한 설명 등
					<div class="hash">#심리테스트 #연애테스트 #십이간지로 알아보는 연애 유형</div>

					<button class="btn Urlcopy" onclick="javascript:copy()">
						사이트 링크 복사하기
					</button>
					<button class="btn Kakao" onclick="javascript:createDescription()">
						카톡으로 결과 공유하기
					</button>
					<button
						class="btn Insta"
						onclick="window.open('https://www.instagram.com/wonny_sketch/')"
					>
						그림 작가 인스타 구경가기
					</button>
					https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_toggle_hide_show
					<button class="btn Copyr" onclick="showhide()">CopyRight</button>
					<div id="copyright" style="display: none;">
						<p>
							나를 알아보는 10가지 질문 by
							<a href="https://github.com/dev-dain/10-things-test">Dain Kim</a><br />
							Copyright (c) 2020 by Jaewon Lee (<a
								href="https://github.com/nani6765/ImpressionTest"
							>https://github.com/nani6765/ImpressionTest</a>)<br />
							이 사이트에 나오는 그림을 포함한 모든 컨텐츠의 상업적 이용을 금지합니다.
						</p>
					</div> -->
				</div>
				<div class="BottomAdd">
					<ins
						class="kakao_ad_area"
						style="display: none;"
						data-ad-unit="DAN-Awx8W8b0sjL4FCas"
						data-ad-width="320"
						data-ad-height="100"
					></ins>
					<script
						type="text/javascript"
						src="//t1.daumcdn.net/kas/static/ba.min.js"
						async
					></script>
				</div>
			</section>

			<footer id="footer">
				<div class="foot">
					<span class="highlight">null null</span>
					© 2024
					<p class="author">
						null null 너 t야?
					</p>
				</div>
			</footer>
		</div>
		<script src="/resources/js/data.js"></script>
		<script src="/resources/js/start.js"></script>
		<script src="/resources/js/end.js"></script>
		<script src="/resources/js/share.js"></script>
		</form>
	</body>
</html>