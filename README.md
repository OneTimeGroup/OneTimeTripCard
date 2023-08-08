# OneTimeTripCard
![Argon Design System React by Creative Tim - Chrome 2023-08-05 17-11-33](https://github.com/OneTimeGroup/OneTimeTripCard/assets/89973303/c9c9787e-8cab-4915-b801-1258709028c9)

# 기술 스택
## Environment
<img alt="eclipse" src ="https://img.shields.io/badge/Eclipse-525C86.svg?&style=for-the-badge&logo=eclipseide&logoColor=white"/> <img alt="github" src ="https://img.shields.io/badge/github-181717.svg?&style=for-the-badge&logo=github&logoColor=white"/>
<img alt="git" src ="https://img.shields.io/badge/git-F05032.svg?&style=for-the-badge&logo=git&logoColor=white"/>

## Development
<img alt="Java" src ="https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=Java&logoColor=white"/> <img alt="JavaScript" src ="https://img.shields.io/badge/JavaScript-black.svg?&style=for-the-badge&logo=javascript&logoColor=FFFF33"/> <img alt="Spring Framework" src ="https://img.shields.io/badge/spring-6DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/> <img alt="Spring Boot" src ="https://img.shields.io/badge/spring%20boot-6DB33F.svg?&style=for-the-badge&logo=springboot&logoColor=white"/> <img alt="react" src ="https://img.shields.io/badge/react-61DAFB.svg?&style=for-the-badge&logo=react&logoColor=black"/> <img alt="oracle" src ="https://img.shields.io/badge/oracle-F80000.svg?&style=for-the-badge&logo=oracle&logoColor=white"/>

## Communication
<img alt="slack" src ="https://img.shields.io/badge/slack-4A154B.svg?&style=for-the-badge&logo=slack&logoColor=white"/>

# 팀 소개
|[박성진](https://github.com/ehopaak)|[손준범](https://github.com/junbeom-Son)|[이솔](https://github.com/leessol)|[전은정](https://github.com/e-7281998)|
|---|---|---|---|
|<img src="https://github.com/OneTimeGroup/OneTimeTripCard/assets/89973303/331e39cf-d004-4310-901a-f13f8c6e90f8" width="150" height="200">|<img src="https://github.com/OneTimeGroup/OneTimeTripCard/assets/89973303/af74cfa3-637d-4224-b98d-dcaa5a8bbcb6" width="150" height="200">|<img src="https://github.com/OneTimeGroup/OneTimeTripCard/assets/89973303/331f813e-46ec-4445-927c-de7aff5a772c" width="150" height="200">|<img src="https://github.com/OneTimeGroup/OneTimeTripCard/assets/89973303/caf1f71d-78cf-44ef-b7c3-34a819beb64e" width="150" height="200">|

# 프로젝트 소개 - [소개 피피티](https://drive.google.com/file/d/1G3BwKYgM8mg6acMkOHJ9n0UD0YM70fPl/view?usp=sharing)
One Time Trip Card는 한국을 관광하는 외국인 관광객들을 대상으로 발급해주는 일회용 여행 카드입니다.

해외 여행을 할 때 현금을 들고 다니느라 불편함을 겪는 분들이 많습니다. Master 카드나 Visa 카드와 같이 전 세계에서 통용되는 카드가 있지만, 
수수료 때문에 막상 여행 전에 환전하고 현금을 소지하고 여행하시는 분들도 많습니다.

현금 없는 버스, 배달 앱에서의 비대면 카드 결제, 카카오 택시 등 한국에서 점점 현금 사용이 줄어들고 있는 만큼, 
외국인 관광객들도 편하게 사용할 수 있는 카드를 제공해주기 위해 프로젝트를 진행하게 되었습니다.

신용도와 상관이 없어 카드사에서 리스크를 질 필요 없고, 구매 과정을 간편화 하기 위해 선불 카드 방식을 채택하였습니다.

### 기본 기능
* 카드 발급
* 금액 충전
* 잔액 환불
* 다른 카드로 금액 이동

### 모임 카드 기능
* 카드 발급
* 멤버 초대
* 멤버 내보내기
* 1/N 정산하기

### 카드 발급 방법
+ 온라인에서 미리 카드를 결제하고
+ 편의점, 대형 할인마트, 공항 등과 같이 접근성이 쉬운 곳에서 실물 카드를 구매해
+ 온라인에서 연동하는 방식을 사용하였습니다.

### 충전 방식
한국 수출입 은행에서 제공하는 환율 API를 Scheduler를 활용하여 개장 시간 동안 1분 단위의 환율을 업데이트합니다.
이를 활용해 본인의 국가에서 사용하는 화폐 단위에 맞게 온라인에서 간단하게 충전할 수 있습니다.

# API list
## User
### 회원가입
* url : /user/signUp
* method : post
* data : User user
* return : User(회원가입된 정보)

### 마이페이지 유저 정보
* url : /user/userInfoGet/{userid}
* method : get
* return : User(userid와 일치하는 User)

### 마이페이지 유저 업데이트
* url : /user/userInfoUpdate
* method : put
* data : User user(수정된 user)
* return : 업데이트 된 User

## UserCard
### 카드 구매
* url : /user-card/purchase
* method : post
* data : UserCard userCard
* return : UserCard(등록된 UserCard)

### 카드 구매 이력
* url : /user-card/history/{userId}
* method : get
* return : List UserCard (userId를 가진 User가 구매한 카드 목록)
  
### 카드 등록
* url : /user-card/register
* method : post
* data : map(userCard, cardNo, nickName, isDefault) 정보 포함
* return : 등록 성공 여부

### 카드 삭제(비 활성화)
* url : /user-card/delete/{userCardId}
* method : delete
* return : 카드 비 활성화 여부

### 잔액 이동(userCard to another userCard)
* url : /user-card/transfer/user-cards
* method : put
* data : map(from(보내는 userCard의 id), to(받는 userCard의 id)) 정보 포함
* return : 이동한 총 잔액

### 환불
* url : /user-card/refund/{userCardId}
* method : put
* return : 환불 금액

## Login
### Login
* url : /login
* method : post
* data : User user(로그인을 시도하는 user의 이메일, password)
* return : User user(로그인을 시도한 user)

### 회원가입
* url : /login/sign-up
* method : post
* data : User user(회원가입 정보 입력된 user)
* return : User user(회원가입 된 user)

### 이메일 찾기
* url : /login/find-email
* method : post
* data : User user(firstname, lastname, phone 정보로 만들어진 user)
* return : List String emails by 입력된 정보

### 비밀번호 찾기
* url : /login/find-password
* method : post
* data : User user(email, phone정보로 만들어진 user)
* return : User user

## 환율
### 충전 환율 정보 조회
* url : /exchange-rate/charge
* method : get
* param : String currencyName 통화 이름
* return : Double 충전 시 적용되는 환율

### 환불 환율 정보 조회
* url : /exchange-rate/return
* method : get  
* param : String currenctName 통화 이름  
* return : Double 환불 시 적용되는 환율  

## TravelWith(그룹 여행 카드)
### TravelWith 카드 등록
* url : /travel-with/register  
* method : post  
* data : map (managerId, nickName, List emails, isDefault) 포함  
* return : manager의 UserCard(email들로 구해진 유저들 각각 같은 카드가 등록 된다. return때 manager아이디만)  

### 유저별 TravelWith 카드 리스트 조회
* url : /travel-with/getAll/{userId}  
* method : get  
* return : List UserCard

### 같은 그룹에 있는 user 리스트 조회
* url : /travel-with/users/{travelWithId}
* method : get
* return : List User

### TravelWith 그룹 해제
* url : /travel-with/delete
* method : delete
* data : UserCard travelWithCard
* return : 해제 시도 유저 == 매니저 -> UserCard 해제된 카드
* return : 해제 시도 유저 != 매니저 -> null

### 멤버 내보내기
* url : /travel-with/expel
* method : delete
* data : map(email, travelWithId)
* return : UserCard (내보낸 User의 UserCard)

## 충전
### 충전
* url : /charge  
* method : post  
* data : Charge charge  
* return : Charge charge(충전된 정보)  

### 유저카드 별 충전 내역(월별)
* url : /charge/getHistory/{userCardId}  
* method : get  
* param : year, month  
* return : List Charge  

## 혜택
### 모든 혜택 조회
* url : /benefit/getAll  
* method : get  
* return : List Benefit  

## 등급
### 모든 등급 조회
* url : /grade/getAll  
* method : get  
* return : List Grade  

### 아이디 기반 등급 조회
* url : /grade/getGradeById/{gradeId}
* method : get
* return : Grade
