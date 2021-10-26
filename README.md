# Artsell (boot)
Artsell project based on Spring Boot 2.4
> Artsell application은 미술작품을 경매를 통해 거래할 수 있는 플랫폼입니다.
회원들은 자신의 작품을 경매에 올려 다른 회원들에게 판매할 수 있으며,
다른 회원들의 작품이나 관리자가 올린 작품 또한 경매를 통해 낙찰이 되면 구매가 가능합니다.
판매자가 카테고리에 작품을 등록할 때 경매가 시작되고 입력한 경매마감기한이 되면 경매는 자동
종료되며, 입찰한 회원이 없을 경우 유찰이 되어 판매자는 최소가의 30퍼센트가 인하된 가격과 현재
날짜 기준 7일 뒤의 마감기한으로 재등록을 하거나 등록했던 작품을 삭제할 수 있습니다.

> 경매 상품에 입찰한 회원이 있을 경우 최고가를 입찰한 회원에게 낙찰이 됩니다. 또한 낙찰이 된
회원은 낙찰을 포기할 수 있으며 이 때 후순위자가 존재한다면 후순위자에게 낙찰이 되지만, 
후순위자가 없다면 다시 유찰이 되어 앞서 기재한 과정( 가격 인하후 재등록 또는 삭제)을 실행합니다.
개요 및 특징
또한 판매자는 경매마감기한이 되기 전에 입찰된 가격을 낙찰하여 경매를 종료시킬 수
있습니다.

> 구매자는 구매를 원하는 작품의 경매에 참여하여 입찰을 할 수 있으며, 이전의 입찰한 회원의
입찰가보다 큰 값으로 재입찰을 할 수 있습니다.
낙찰성공한 구매자는 결제를 하여 회원가입에서 입력한 배송지 혹은 새로 입력한 배송지로
작품을 배송받거나 낙찰을 포기할 수 있습니다.

## 사용방법
> 로그인
> <img width="943" alt="login" src="https://user-images.githubusercontent.com/59862783/130056478-cd18a987-60b5-4213-a693-189ec142f3ee.png">
> * 회원에 한해서 서비스를 이용할 수 있기 때문에 메인 화면으로 가기 전 로그인 과정을 거친다.
------------

> 홈 화면
> <img width="945" alt="로그인후메인" src="https://user-images.githubusercontent.com/59862783/130251469-41f4ea01-ff88-4e95-9253-2549fe7af869.png">
> * 로그인 성공시 메인화면으로 이동하고, 카테고리 별 작품들을 볼 수 있고 제목이나 화가이름으로 작품 검색을 할 수 있다.
> * 홈 화면 상단에 위치한 마이페이지 항목을 통해 회원정보 수정 / 찜 목록 보기 / 등록한 작품 관리 등을 할 수 있다. 
------------

> 작품 경매 등록
> <img width="949" alt="작품등록" src="https://user-images.githubusercontent.com/59862783/130311905-c6f6da83-bca5-4d45-a81f-a7be089ed002.png">
> * 회원은 작품의 정보와 이미지 파일을 입력하여 경매를 시작할 수 있다.
------------

> 경매중인 작품 관리
> <img width="952" alt="작품관리" src="https://user-images.githubusercontent.com/59862783/130312017-9827c772-b1a4-4289-b462-7a538ed2bcb2.png">
> * 회원은 '내 작품 관리' 혹은 마이페이지 항목을 통해 경매중인 자신의 작품 목록들과 진행 상황을 알 수 있다.
------------

> 경매 참여 (입찰)
> <img width="948" alt="입찰" src="https://user-images.githubusercontent.com/59862783/130312073-6f597fde-5301-4f40-96a7-a9509b0a41fe.png">
> <img width="960" alt="입찰성공" src="https://user-images.githubusercontent.com/59862783/130312281-9dd43174-d877-4293-a6f6-70e101c14d1c.png">
> * 회원은 다른 회원들이 올린 작품 경매에 참여할 수 있다. 
> * 첫 입찰가는 작품을 등록한 사람의 경매 시작가보다 높아야 하며, 이후 입찰가는 현재의 최고가보다 높아야 한다.
------------

> 경매 참여 목록
> <img width="946" alt="내경매참여목록" src="https://user-images.githubusercontent.com/59862783/130312122-791d2821-328d-413f-9832-708865ce3d1d.png">
> * 회원은 '경매참여목록' 혹은 마이페이지 항목을 통해 경매에 참여한 작품에 대한 정보와 경매 상황을 확인할 수 있다.
> *경매 진행중 (경매참여중) / 경매 실패 / 경매 성공 (결제대기중)
------------

> 낙찰
> <img width="943" alt="낙찰배송정보" src="https://user-images.githubusercontent.com/59862783/130312311-15e6e559-0069-447f-9e3b-ddc24429b161.png">
> * 작품을 등록한 사람이 직접 낙찰을 하거나 경매 마감 기한이 되면 해당 작품은 최고가를 입찰한 회원에게 낙찰된다.
> * 구매자는 배송 정보를 입력하여 결제를 진행하거나 낙찰을 포기해 후순위자에게 작품을 넘길 수 있다.
------------

> 회원탈퇴
> * 회원은 낙찰에 성공해 결제 대기중인 작품과 , 자신의 작품이 낙찰되어 구매자의 결제를 대기중인 작품이 존재하지 않다면 회원 탈퇴가 가능하다.


## 구현 방법
------------
< web Application 개발 >
- Spring Boot를 이용하여 설정 코드를 최소화하고 비즈니스 로직 구현에 집중.

< view 구현 >
- Thymeleaf template engine을 이용해 html 뷰 구현.
( login.html , userRegister.html ) 
- Tiles layout templating framework를 이용해 반복되는 구성요소들을 레이아웃으로
정의하여, 페이지 레이아웃과 컨텐트를 분리한 jsp 뷰를 구현.
( 위의 두 개의 페이지를 제외한 나머지 페이지 )

< DB 구축 및 조작 기술>
- Oracle SQL Developer를 이용한 DB 구축.
- MyBatis를 이용하여 dao를 작성 후 Mapper XML에 sql문 작성하여 DB조작.
- 경매 유찰 시 item ID를 update할 때 trigger 사용
- item ID를 자동으로 생성하기 위해 sequence 생성 후 사용
- 
< 기능 구현 >
- task scheduler를 이용하여 상품 등록시 스케줄러 등록 후, db에 저장된 마감기한에
자동으로 낙찰될 수 있도록 구현.
- 서버가 끊기거나 재시작했을 때 스케줄러에 등록된 작업들을 복원하기 위해
CommandLineRunner 인터페이스를 구현하여 애플리케이션 구동 시점에 경매 마감이
되지 않은 상품들을 스케줄러에 등록해 주는 작업 실시.

- HandlerInterceptor 인터페이스를 구현한 LogInInterceptor 클래스를 이용하여 세션
소실시 사용자에게 재로그인을 요구하고 로그인을 하면 이전의 작업을 하던 곳으로
돌아가도록 구현.
- HandlerInterceptor 인터페이스를 구현한 AuctionInterceptor 클래스를 이용하여
사용자가 입찰하는 순간이나 상세페이지를 보고 있는 순간에 경매가 종료되었을 때
생기는 문제를 해결.
- Validator 인터페이스를 구현하여 AccountFormValidator, AuctionItemValidator, 
PaintRegiValidator class 등을 이용하여 해당하는 command 객체의 field값의 유효성을
검사함.
- API를 이용하여 회원의 주소정보를 편리하게 입력받을 수 있도록 구현.

### 시스템 구조 및 구성 요소
<img width="605" alt="시스템구성요소" src="https://user-images.githubusercontent.com/59862783/130314309-592a9d55-b694-47ec-8c1c-a338eadd2e78.PNG">
<img width="607" alt="시스템구성요소2" src="https://user-images.githubusercontent.com/59862783/130314318-70ebe852-2298-4324-9665-fcfab6053350.PNG">
