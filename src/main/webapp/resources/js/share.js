const url = 'https://twelvelevetype.netlify.app/';
const title = '여행 mbti';

var art = document.querySelector('.art')

function checkImage() {
	if (art.hasChildNodes) {
		console.log("has");
		var artImage = art.firstChild.alt;
		return Number(artImage);
	} else {
		console.log("error");
		alert("구현중입니다.");
	}
	return error;
}

function sendKakaoLink(shareTitle, shareDescription, shareImageUrl) {
	Kakao.Link.sendDefault({
		objectType: 'feed',
		content: {
			title: shareTitle,
			description: shareDescription,
			imageUrl:
				shareImageUrl,
			link: {
				mobileWebUrl: 'https://twelvelevetype.netlify.app/',
				webUrl: 'https://twelvelevetype.netlify.app/',
			},
		},
		buttons: [
			{
				title: '나도 테스트 하러가기',
				link: {
					mobileWebUrl: 'https://twelvelevetype.netlify.app/',
					webUrl: 'https://twelvelevetype.netlify.app/',
				},
			},
		],
	});
}

function createDescription() {
	const imageNumber = checkImage();
	console.log(imageNumber);
	if (imageNumber === "error") {
		return 0;
	}
	var shareDescription;
	switch (imageNumber) {
		case 0:
			shareDescription = infoList[0].name;
			break;
		case 1:
			shareDescription = infoList[1].name;
			break;
		case 2:
			shareDescription = infoList[2].name;
			break;
		case 3:
			shareDescription = infoList[3].name;
			break;
		case 4:
			shareDescription = infoList[4].name;
			break;
		case 5:
			shareDescription = infoList[5].name;
			break;
		case 6:
			shareDescription = infoList[6].name;
			break;
		case 7:
			shareDescription = infoList[7].name;
			break;
		case 8:
			shareDescription = infoList[8].name;
			break;
		case 9:
			shareDescription = infoList[9].name;
			break;
		case 10:
			shareDescription = infoList[10].name;
			break;
		case 11:
			shareDescription = infoList[11].name;
			break;
		case 12:
			shareDescription = infoList[12].name;
			break;
		case 13:
			shareDescription = infoList[13].name;
			break;
		case 14:
			shareDescription = infoList[14].name;
			break;
		case 15:
			shareDescription = infoList[15].name;
			break;
	}
	var shareTitle = 'mbti 유형 테스트 결과'
	const shareImageUrl = url + '../resources/img/image-' + imageNumber + '.png';
	sendKakaoLink(shareTitle, shareDescription, shareImageUrl);
}

const copy = () => {
	const tmp = document.createElement('textarea');
	document.body.appendChild(tmp);
	tmp.value = url;
	tmp.select();
	document.execCommand('copy');
	document.body.removeChild(tmp);
}