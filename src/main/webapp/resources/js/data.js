/*
자 : mouse, 축: cow, 인: tiger, 묘: rabbit, 진: dragon, 사: snake, 오: horse, 미: sheep, 원 : monkey, 유: chick, 술: dog, 해: pig
*/

const qnaList = [
  {
    q: '1. 오늘은 즐거운 기차여행날! 갑자기 외국인이 말을 걸어온다면?',
    a: [
      { answer: 'a. 두근두근 나도 드디어 외국인친구가?! 빨리 친해지고싶다', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','ESTJ', 'ESFJ', 'ESTP', 'ESFP'] },
      { answer: 'b. 아.. 너무 부담스러워 언제가지?', type: ['INTJ', 'INTP', 'INFJ', 'INFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP'] },
    ]
  },
  {
    q: '2. 오늘은 어느 장소로 가볼까? ',
    a: [
      { answer: 'a. 북적북적 사람이 많은 관광지', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','ESTJ', 'ESFJ', 'ESTP', 'ESFP'] },
      { answer: 'b. 일행끼리 조용히 즐길수있는 프라이빗한 장소', type: ['INTJ', 'INTP', 'INFJ', 'INFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP'] },
    ]
  },
  {
    q: '3. 아 배고파 식당에 들어갔다 자리가 없어 합석을 권유하는 주인의 말에 나는?',
    a: [
      { answer: 'a. 오히려좋아 같이 앉은 사람이랑 얘기하면서 먹으면 더 재밌겠다', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','ESTJ', 'ESFJ', 'ESTP', 'ESFP'] },
      { answer: 'b. 아.. 딴데 갈까? or 자리가 날때까지 기다리자..', type: ['INTJ', 'INTP', 'INFJ', 'INFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP'] },
    ]
  },
  {
    q: '4. 길을 잃었다! 어떻게 할까?',
    a: [
      { answer: 'a. 지나가는 사람한테 물어보면 바로 알수있겠지~" ', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','ESTJ', 'ESFJ', 'ESTP', 'ESFP' ] },
      { answer: 'b. 지도를 보고 내힘으로 길을 찾자" ', type: ['INTJ', 'INTP', 'INFJ', 'INFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP' ] },
    ]
  },
  {
    q: '5. 옷가게에 갔다! 직원이 그나라의 전통의상을 권하는데?',
    a: [
      { answer: 'a. 너무 좋아 이런경험 어디서 또 해보겠어 당장 입어', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','ESTJ', 'ESFJ', 'ESTP', 'ESFP' ] },
      { answer: 'b. 미쳤어? 절대 불가능  나는 그냥 구경만', type: ['INTJ', 'INTP', 'INFJ', 'INFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP']},
    ]
  },

  {
    q: '6. 피라미드를 보러갔다!',
    a: [
      { answer: 'a. 우와 저 시대에 저걸 어떻게 만든거지? 대박이다', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','INTJ', 'INTP', 'INFJ', 'INFP' ] },
      { answer: 'b. 오 피라미드네', type: ['ESTJ', 'ESFJ', 'ESTP', 'ESFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP' ] },
    ]
  },
  {
    q: '7. 디즈니랜드에 놀러왔다! 어 저기 미키마우스가 있네?',
    a: [
      { answer: 'a. 우와 미키마우스다! ', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','INTJ', 'INTP', 'INFJ', 'INFP' ] },
      { answer: 'b. 에구 더운데 인형탈 쓰고 고생하시네', type: ['ESTJ', 'ESFJ', 'ESTP', 'ESFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP' ] },
    ]
  },
  {
    q: '8. 친구가 나중에 달나라여행을 가자고 한다면?',
    a: [
      { answer: 'a. 좋아좋아 나중에 꼭 가기다 약속', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','INTJ', 'INTP', 'INFJ', 'INFP' ] },
      { answer: 'b. 뭔소리야 달나라는 무슨 달나라 우리 돈없어서 못갈걸?', type: ['ESTJ', 'ESFJ', 'ESTP', 'ESFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP' ] },
    ]
  },
  {
    q: '9. 내일은 즐거운 여행날! 밤에 잠에 들기전에 나는 ',
    a: [
      { answer: 'a. 여행지에서 운명의 상대를 만나는 상상을 한다', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','INTJ', 'INTP', 'INFJ', 'INFP'] },
      { answer: 'b. 내일 재밌겠다 쿨쿨', type: ['ESTJ', 'ESFJ', 'ESTP', 'ESFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP'] },
    ]
  },
  {
    q: '10. 농장에 놀러왔다! 동물에게 먹이주기체험을 하는데 동물이 내가 주는 먹이를 잘 받아먹는다',
    a: [
      { answer: 'a. 우와, 얘가 날 좋아하나봐?', type: ['ENTJ', 'ENTP', 'ENFJ', 'ENFP','INTJ', 'INTP', 'INFJ', 'INFP' ] },
      { answer: 'b. 에구.. 배고픈가보네', type: ['ESTJ', 'ESFJ', 'ESTP', 'ESFP', 'ISTJ', 'ISFJ', 'ISTP', 'ISFP' ] },
    ]
  },
  {
    q: '11. 친구가 바가지를 써서 구린물건을 비싸게 사왔다. ',
    a: [
      { answer: 'a. 너 그거 얼마에 샀어?(바가지썻네...)', type: ['ENTJ', 'ENTP','ESTJ','ESTP','INTJ', 'INTP','ISTJ','ISTP'] },
      { answer: 'b. ㅎㅎ..우와...예쁘다!', type: ['ENFJ', 'ENFP','INFJ', 'INFP','ISFJ','ISFP','ESFJ','ESFP' ] },
    ]
  },
  {
    q: '12. 여행 중 친구가 소매치기를 당했다',
    a: [
      { answer: 'a. 헐 어떡해ㅜㅜ 안다쳤어? 내 돈이라도 빌려줄게', type: ['ENFJ', 'ENFP','INFJ', 'INFP','ISFJ','ISFP','ESFJ','ESFP'] },
      { answer: 'b. 너 여권은 멀쩡해? 신고는 했어?', type: ['ENTJ', 'ENTP','ESTJ','ESTP','INTJ', 'INTP','ISTJ','ISTP'] },
    ]
  },
  {
    q: '13. 여행 중 친구가 배탈이 났다면 ',
    a: [
      { answer: 'a. 괜찮아? 어떡해ㅜㅜ 지금 병원갈까?', type: ['ENFJ', 'ENFP','INFJ', 'INFP','ISFJ','ISFP','ESFJ','ESFP' ] },
      { answer: 'b. 너 어제 뭐 먹었어?', type: ['ENTJ', 'ENTP','ESTJ','ESTP','INTJ', 'INTP','ISTJ','ISTP'] },
    ]
  },
  {
    q: '14. 친구가 계획을 너무 타이트하게 짜왔다',
    a: [
      { answer: 'a. 헉 열심히 짜왔네 고생했어 고마워ㅜㅜ', type: ['ENFJ', 'ENFP','INFJ', 'INFP','ISFJ','ISFP','ESFJ','ESFP' ] },
      { answer: 'b. 음 근데 이건 시간적으로 좀 힘들거같지않아?', type: ['ENTJ', 'ENTP','ESTJ','ESTP','INTJ', 'INTP','ISTJ','ISTP'] },
    ]
  },
  {
    q: '15. 친구가 "나 요즘 너무 힘들어서 여행다녀오려고ㅜㅜ"라고 카톡을 보낸다면?',
    a: [
      { answer: 'a. 많이 힘들어? 무슨일있어?', type: ['ENFJ', 'ENFP','INFJ', 'INFP','ISFJ','ISFP','ESFJ','ESFP'] },
      { answer: 'b. 오 어디 가려고?', type: ['ENTJ', 'ENTP','ESTJ','ESTP','INTJ', 'INTP','ISTJ','ISTP'] },
    ]
  },
  {
    q: '16. 힘든 비행시간을 끝내고 숙소에 도착했다',
    a: [
      { answer: 'a. 짐정리부터 해놓자', type: ['ENFJ','INFJ','ISFJ','ESFJ','ENTJ','ESTJ','INTJ','ISTJ'] },
      { answer: 'b. 당장 침대로', type: ['ENFP','INFP','ISFP','ESFP','ENTP','ESTP','INTP','ISTP'] },
    ]
  },
  {
    q: '17. 친구가 자꾸 계획에 없던 장소를 가고싶다고한다',
    a: [
      { answer: 'a. 싫어, 우리 계획대로 하자', type: ['ENFJ','INFJ','ISFJ','ESFJ','ENTJ','ESTJ','INTJ','ISTJ'] },
      { answer: 'b. 좋아! 이런게 여행이지 새로운곳으로 가보자', type: ['ENFP','INFP','ISFP','ESFP','ENTP','ESTP','INTP','ISTP'] },
    ]
  },
  {
    q: '18. 아 벌써 3일차 여행날 아침 오늘은 조금 피곤한데 늦잠자도될까?',
    a: [
      { answer: 'a. 미쳤어? 우리 그러면 오늘은 에펠탑 못봐', type: ['ENFJ','INFJ','ISFJ','ESFJ','ENTJ','ESTJ','INTJ','ISTJ'] },
      { answer: 'b. 헉 야나두 나도 너무 피곤했어..', type: ['ENFP','INFP','ISFP','ESFP','ENTP','ESTP','INTP','ISTP'] },
    ]
  },
  {
    q: '19. 여행경비는 한정적인데 예쁜물건을 발견했다면?',
    a: [
      { answer: 'a. 생각한 예산보다 초과될거같은데 사지말자', type: ['ENFJ','INFJ','ISFJ','ESFJ','ENTJ','ESTJ','INTJ','ISTJ'] },
      { answer: 'b. 아 일단 사고보자 너무 예쁘잖아 다신 못살수도있어', type: ['ENFP','INFP','ISFP','ESFP','ENTP','ESTP','INTP','ISTP'] },
    ]
  },
  {
    q: '20. 여행지에서 교통수단 어떻게 할까?',
    a: [
      { answer: 'a. 미리 예매해놓자 그게 마음이 편해', type: ['ENFJ','INFJ','ISFJ','ESFJ','ENTJ','ESTJ','INTJ','ISTJ'] },
      { answer: 'b. 현장에 가서 시간맞는거 아무거나 타면돼', type: ['ENFP','INFP','ISFP','ESFP','ENTP','ESTP','INTP','ISTP'] },
    ]
  }
]

const infoList = [
  {
    name: '뭐 식은 죽 먹기죠, 재능 만땅 &lt;ISTJ&gt;',
    desc: '',
    mbti: 'ISTJ'
  },
  {
    name: '난 너만 봐, 정직한 스타일의 &lt;ISTP&gt;',
    desc: '',
    mbti: 'ISTP'
  },
  {
    name: '야 사귀자, 사랑을 쟁취하는 &lt;ISFJ&gt;',
    desc: '',
    mbti: 'ISFJ'
  },
  {
    name: '이건 어때? 난 어때? 독특한 매력을 가진 &lt;ISFP&gt;',
    desc: '',
    mbti: 'ISFP'
  },
  {
    name: '결혼은 언제쯤 할까 신혼여행은 어디로?, 이상적인 상상의 소유자 &lt;INTJ&gt;',
    desc: '',
    mbti: 'INTJ'
  },
  {
    name: '기념일에 무슨 이벤트 할까, 이벤트 플래너 &lt;INTP&gt;',
    desc: '',
    mbti: 'INTP'
  },
  {
    name: '어 오늘 머리 바꿨네 잘 어울린다, 센스가 뛰어난 &lt;INFJ&gt;',
    desc: '',
    mbti: 'INFJ'
  },
  {
    name: '난 너랑 하는 것들 다 좋아, 순종적인 &lt;INFP&gt;',
    desc: '',
    mbti: 'INFP'
  },
  {
    name: '난 당신의 연예인, 끼가 넘치는 재주꾼 &lt;ESTJ&gt;',
    desc: '',
    mbti: 'ESTJ'
  },
  {
    name: '이건 이거고 저건 저거지 , 공과사 확실한 &lt;ESTP&gt;',
    desc: '',
    mbti: 'ESTP'
  },
  {
    name: '난 네가 좋아 너무 좋아, 애교만땅 &lt;ESFJ&gt;',
    desc: '',
    mbti: 'ESFJ'
  },
  {
    name: '산은 산이요 연애는 연애로다, 느긋하고 온순한 &lt;ESFP&gt;',
    desc: '',
    mbti: 'ESFP'
  },
  {
    name: '산은 산이요 연애는 연애로다, 느긋하고 온순한 &lt;ENTJ&gt;',
    desc: '',
    mbti: 'ENTJ'
  },
  {
    name: '산은 산이요 연애는 연애로다, 느긋하고 온순한 &lt;ENTP&gt;',
    desc: '',
    mbti: 'ENTP'
  },
  {
    name: '산은 산이요 연애는 연애로다, 느긋하고 온순한 &lt;ENFJ&gt;',
    desc: '',
    mbti: 'ENFJ'
  },
  {
    name: '산은 산이요 연애는 연애로다, 느긋하고 온순한 &lt;ENFP&gt;',
    desc: '',
    mbti: 'ENFP'
  },
]
