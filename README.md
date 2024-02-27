# AreYouT
__팀명 - nullnull해요__  
팀 프로젝트  
![image](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/2c1ed8df-ddaa-47f5-b7b0-ff50527d38da)

## 목차
1. [프로젝트 소개](#프로젝트-소개)
2. [개발 기간](#개발-기간)
3. [멤버 구성 및 담당 기능](#멤버-구성-및-담당-기능)
4. [개발 환경](#개발-환경)
5. [사용 언어](#사용-언어)
6. [기술 스택](#기술-스택)
7. [주요 기능 및 상세](#주요-기능)
   - 회원 기능
   - 쪽지 기능
   - 관리자 기능
   - 성향 테스트
   - 동행 매칭하기
   - 동행 모집 게시판
9. [실행 화면](#실행-화면)

## 📂프로젝트 소개
너 T(rip mate)야? 웹 사이트는 mbti와 같은 성향을 고려하여 여행 동행자를 구하는 커뮤니티 사이트다.  

## 📅개발 기간
2024년 1월 15일 ~ 2024년 2월 23일

## 👥멤버 구성 및 담당 기능
![image](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/465a3a35-bbec-4047-ba17-0abb11ebc6e6)

## 💻개발 환경
<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=for-the-badge&logo=eclipse-ide&logoColor=white">
<img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-%23181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/SQL Developer-F80000?style=for-the-badge&logo=oracle&logoColor=white">

## 📑사용 언어
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/JavaScript-%23F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
<img src="https://img.shields.io/badge/HTML5-%23E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/CSS3-%231572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">

## 🛠기술 스택
<img src="https://img.shields.io/badge/Tomcat-%23F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black">
<img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
<img src="https://img.shields.io/badge/MyBatis-339933?style=for-the-badge&logo=mybatis&logoColor=white">  
<img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

## ⚙주요 기능

### 👦회원 기능
|기능|내용|
|------|---|
|회원가입|일반 회원은 기본적인 정보(아이디, 비밀번호, 이름, 닉네임, 나이, 성별, 이메일, 휴대폰번호)를 입력하여 회원가입을 진행합니다. 각 입력 정보마다 유효성 검사를 한 뒤 회원가입이 가능합니다.|
|로그인|회원가입을 한 회원은 아이디와 비밀번호를 이용하여 로그인을 할 수 있습니다. 로그인하면 헤더의 로그인/회원가입은 자신의 프로필 사진으로 변경됩니다.|
|아이디 찾기|자신의 이름과 이메일을 통해 아이디를 찾을 수 있습니다.|
|비밀번호 찾기|자신의 아이디와 이메일을 통해 비밀번호를 재설정 할 수 있습니다. 재설정 시에도 유효성을 검사합니다.|
|내정보|자신의 이름, 아이디, 비밀번호, 이메일, 휴대폰번호 조회하고 비밀번호, 이메일, 휴대폰 번호를 수정할 수 있습니다.|
|프로필|자신의 닉네임, 나이, 성별, MBTI, 프로필 사진을 조회하고 닉네임, MBTI, 프로필 사진을 수정할 수 있습니다.|
|회원탈퇴|회원 탈퇴 진행 시 비밀번호를 확인하고 비밀번호가 일치할 시 탈퇴 가능합니다. 탈퇴 즉시 모든 정보는 파기됩니다.|

### ✉쪽지 기능
|__기능__|__내용__|
|------|---|
|쪽지 전송| 회원은 쪽지 전송에 필요한 정보(제목, 받는 이, 내용)등의 정보를 보내 타 회원 혹은 운영자에게 쪽지를 전송할 수 있습니다.|
|쪽지 조회| 회원은 받은 쪽지를 조회하여 해당 쪽지의 정보(보낸 이, 받는 이, 전송날짜, 제목, 내용)등을 조회할 수 있습니다.|
|쪽지 삭제| 회원은 필요 없는 쪽지를 삭제하여 쪽지함을 관리할 수 있습니다.|
|검색| 쪽지를 검색하여 필요한 쪽지를 빠르게 찾아낼 수 있습니다.|

### 👑관리자 기능
|__기능__|__내용__|
|------|---|
|회원 관리|관리자는 사이트에 가입된 회원의 정보를 조회하고 삭제할 수 있으며 활동 정지등의 패널티를 부여할 수 있습니다.|
|블랙리스트|관리자는 활동 정지된 회원의 패널티를 해제할 수 있으며 아예 탈퇴처리를 시킬 수 있습니다.|
|쪽지 관리|관리자는 사이트 내에 전송된 모든 쪽지의 정보를 확인할 수 있으며 필요에 따라 쪽지를 삭제할 수 있습니다.|
|게시판 관리|관리자는 게시판의 게시물을 임의로 삭제하고 정보를 조회할 수 있습니다.
|1대1 문의쪽지함|관리자는 유저들의 건의사항이나 신고사항들을 쪽지로 받아볼 수 있으며 이에 따른 답변 메세지를 각 유저들에게 보낼 수 있습니다.|
|검색|각 관리 항목들은 모두 검색기능을 통해 필요한 정보들을 빠르게 찾아볼 수 있습니다.|

### 💓성향 테스트
|기능|내용|
|------|---|
|성향 테스트|총 20가지의 질문을 통해 성향을 테스트하여 결과를 보여줍니다.|

### 💞동행 매칭하기
|기능|내용|
|------|---|
|동행 매칭|회원은 자신의 MBTI와 동일한 다른 회원들과 매칭됩니다. 매칭된 동행에게 쪽지를 보낼 수 있습니다.|

### 🧑‍🤝‍🧑:동행 모집 게시판
|기능|내용|
|------|---|
|동행 모집|회원은 동행 모집 게시판에서 게시글을 생성, 수정, 삭제할 수 있습니다.|
|게시글 리스트 조회|회원은 동행 모집 게시글을 목록으로 조회할 수 있습니다.|
|상세 게시글 조회|목록에서 게시글을 클릭하면 상세 내용을 확인할 수 있습니다.|
|페이징 기능|게시글 리스트에서 9개씩 조회할 수 있습니다. 페이징 기능을 통해 페이지를 이동할 수 있습니다.|
|게시글 검색|검색 조건을 설정하고 검색 키워드를 통해 게시글 검색이 가능합니다.|

## 🖥실행 화면
### 메인 화면
1_1 메인화면
![메인](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/b7848407-c285-40e2-ab81-abc0148b1144)

1_2 쪽지함
![쪽지함](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/d10c6f23-6db8-4026-b2cd-605259cecde5)

### 로그인
2_1 로그인
![로그인](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/5b0aeab3-e22f-4d88-98bd-3bdc9411fd10)

2_2 회원가입
![회원가입](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/f28ec0cc-415a-4b8c-9c20-8404e6663544)

2_3 아이디 찾기
![아이디찾기](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/b05197bd-a8a4-47d2-b34e-57848d81a189)

2_4 비밀번호 찾기
![비밀번호 찾기](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/300cd093-1c04-4da7-9ee0-4c99298397f9)

### 마이페이지
3_1 내정보
![내정보](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/d03d4b79-dbb2-415e-b4a9-497949fc15b3)

3_2 프로필
![프로필](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/e3c430a2-a04c-4ac5-9f82-352fbcb6c527)

### 성향 테스트
4_1 성향 테스트
![성향테스트](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/6a829d92-7b49-4419-ae8b-962c3bc782bc)
![성향테스트 질문](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/f53e9fbb-3446-4e6c-a775-f0f57e269046)

4_2 성향 테스트 결과
![성향테스트결과](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/0db3ab73-3381-4418-99bf-3b107815ed5c)

### 동행 매칭하기
5_1 동행 모집 게시판
![게시판 목록](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/923fd1e2-3d84-43a6-81e7-4a571a2f8748)
5_2 게시글 수정
![게시판 수정](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/6cce9ffb-b9aa-4014-a269-83b214413a27)
5_3 게시글 조회
![게시판 조회](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/a5339831-4031-4012-9e2a-552047b49135)

### 여행 친구 추천
6_1 추천 화면
![나의 여행 짝꿍 찾기](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/91076c1d-d564-43ec-8b56-3e3921279f0b)

### 쪽지함
6_1 쪽지함 화면
![쪽지함](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/dc7740f3-f8c3-48a9-94ad-24e782c61287)

6_2 쪽지 전송
![쪽지보내기](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/911fcb64-2a9c-4cf6-b0f0-ced3aa336ba0)

### 관리자 페이지
7_1 일반 회원 관리
![image](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/f1db10f9-66d8-49fd-8536-68f670ac1680)

7_2 블랙리스트 회원 관리
![image](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/c171b769-609d-473f-9f1f-027cb8ceaf10)

7_3 게시판 관리
![image](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/9ddd910c-9bc2-46bc-aec6-5b15e0a10037)

7_4 쪽지 관리
![image](https://github.com/2311PublicDataWebApp/AreYouT/assets/152952078/a0dac40d-78cf-4060-81eb-a158b799096e)

  
