# CommunityExample

MVC2 패턴을 적용시킨 커뮤니티 사이트입니다.  
  
기술 스택  
Java, JSP, Spring, MySQL, JdbcTemplate, Mybatis  
Bootstrap, Javascript, jQuery, AJAX  
Github

***

# 목차
- ### 소개
- ### 메인화면
- ### 로그인
	- 소셜 로그인 API
- ### 계정찾기
	- 메일 전송
- ### 게시판 목록
	- RESTful API
- ### 게시판 내용
	- AJAX
	- DB모델링
	- SQL
	- DTO
- ### 쪽지
	- 파일 업/다운로드

***

# 소개

- ### 프로젝트 소개

추천수가 일정 수를 넘어선 글만 보여주는 BEST게시판과 RESTful 다중 게시판,  
AJAX를 이용한 비동기 추천과 게시판/게시물 북마크,  
첨부파일 업/다운로드, 회원간 쪽지 기능 등을 갖춘 커뮤니티 사이트입니다.

- ### 제가 맡은 역할

단독 개발입니다.

***

# 메인화면
![text](file%20repository/read%20me/main.png "main")
메인 화면 입니다.  
각종 게시판의 최신 글들을 DB로부터 가져옵니다.  
JdbcTemplate 으로 UNION 쿼리를 활용했습니다.  

***

# 로그인
![text](file%20repository/read%20me/login.png "login")
로그인 화면 입니다.  
소셜 로그인 API 기능과 쿠키 기능이 포함되어 있습니다.

# 소셜 로그인 API

네이버에 OAuth2.0방식으로 인증을 요청 합니다.  
인증을 마친 네이버로부터 프로필을 조회하여 받은 JSON을 파싱 하여 데이터로 활용합니다.

***

# 계정찾기
![text](file%20repository/read%20me/find%20account.png "find account")
계정 찾기 페이지입니다.  
가입시 입력한 고유한 메일 계정으로 변경된 비밀번호를 이메일 전송 합니다.

# 메일전송

비밀번호 분실시 무작위 난수로 비밀번호를 변경한 뒤, 해당 난수를 메일로 전송합니다.  
@EnableAsync 와 @Async 를 이용해 메일 전송이 비동기 로 이뤄지게 하여 트래픽에 대비 했습니다.

***

# 게시판 목록
![text](file%20repository/read%20me/board%20list.png "list")
게시판입니다.  
게시판은 최대한 Restful 하게 작성하여  
요청 주소와 방법에 따라 유연하게 응답합니다.

# RESTful

주소의 입력 값을 통해 서 게시판과 게시물을 동적으로 CRUD 합니다.  
다양한 요청 방식을 활용 해, 주소에서 불필요한 수식어를 제거 합니다.

***

# 게시판 내용
![text](file%20repository/read%20me/board%20content.png "content")
게시판 본문 페이지입니다.  
추천, 북마크 등의 기능은 AJAX 를 이용해 비동기로 이뤄집니다.  
파일 업/다운로드 기능이 포함되어 있습니다.  
게시글 관련 DTO는 테이블을 3개로 분리 해 3자 JOIN 을 활용했습니다.

# AJAX

추천, 북마크 등의 기능에 Javascript함수를 호출하여, 서버와 비동기 로 통신합니다.  
비동기 통신시 주고 받는 데이터는 JSON 을 활용합니다.  
비동기 통신이 끝난 후, 함수의 마무리 단계에서 해당 태그의 속성을 실시간으로 변경합니다.

# DB모델링

적은 컬럼의 컴팩트 한 테이블을 위해 테이블을 분리 후 외래 키로 연계 했습니다.  
테이블 컬럼과 DTO 필드를 1:1로 매칭 했습니다.  
유지보수를 고려 해 Map사용을 자제하고, DTO를 적극 활용 했습니다.

# SQL

JdbcTemplate 과 Mybatis 를 모두 활용했습니다.  
기본 CRUD 외에 FK설정, 3자 JOIN, UNION ALL, DISTINCT, SUM, COUNT등의 다양한 쿼리를 사용 했습니다.

# DTO

직렬화 를 이용해 DTO형상을 관리합니다.  
관련 테이블들을 FK로 연계 후 JOIN 쿼리를 통해 한번에 요청합니다.  
DTO에 각자 매핑 후 포함 관계를 이용 해 하나의 DTO 에 모아 받습니다.

***

# 쪽지
![text](file%20repository/read%20me/dm.png "dm")
쪽지 페이지 입니다.  
파일 업/다운로드 기능이 포함되어 있습니다.

# 파일 업/다운로드

사용자가 요청한 파일의 정보를 이용해, DB에서 해당 파일의 저장 정보를 확인합니다.  
입력스트림 으로 저장된 파일을 읽은 뒤,  
Response의 출력스트림 으로 파일을 작성 하여 사용자에게 응답 합니다.

