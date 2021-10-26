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


####변경 사항     
1. pom.xml: Spring Boot Starter Dependencies 사용 
2. com.example.jpetstore.JpetstoreBootApplication: 시작 및 설정 클래스 
3. com.example.jpetstore.WebMvcConfig: Spring MVC 관련 설정 클래스
4. com.example.jpetstore.controller.SignonInterceptor: @Component 추가 (bean scan 대상)
5. com.example.jpetstore.controller.dao.mybatis.mapper.*: @Mapper 추가 (mapper scan 대상)
6. src/main/resources/{기존 properties, xml 설정 파일} 삭제
7. src/main/resources/application.properties: bean property 설정
8. src/main/webapp/{images, style, *.html}를 src/main/resources/static/ 으로 이동 
9. src/main/webapp/META-INF 삭제
10. src/main/webapp/WEB-INF/*.xml 삭제
11. src/main/webapp/WEB-INF/lib/ojdbc6.jar 삭제
 
####실행
* Eclise: com.example.jpetstore.JpetstoreBootApplication 선택 > Run As > Java Application  
* Maven: mvnw spring-boot:run
* http://localhost:8088/ 

####Oralce 대신 H2 in-memory database 이용 방법
* pom.xml에 com.h2database:h2 dependency 추가
* application.properties 파일의 spring.datasource.* 설정들을 H2 관련 값으로 변경
* src/main/resources/{schema.sql, data.sql} 파일 생성(DB schema 생성 및 초기 data load)
 
