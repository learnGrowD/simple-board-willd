# simple-board-willd

## 프로젝트 설명
스프링, 멀티 모듈을 통해 인증 및 게시판 구현

## 기능
1. 회원가입 기능 구현
2. 로그인 기능구현 (JWT token 발행)
3. 게시판 조회 (모두가 조회 가능)
4. 게시판 삭제 (어드민 계정만 삭제가능)
5. 게시판 업데이트 (게시글 작성자만 업데이트 가능)

## 개발환경
1. Server Framework: Spring Boot 2.7.9
2. Build Tool: Gradle, Groovy
3. Language: Java 11
4. Database Libray: JPA
5. Database Server: Mysql 8
6. IDEA: IntelliJ
7. API Client: insomnia
      
## 실행 방법
```
git clone ..
docker-compose up -d
```
http://localhost:8080 접속

## API
* 회원가입
  - 주소: http://localhost:8080/open-api/user/register
  - method: POST

* 로그인
  - 주소: http://localhost:8080/open-api/user/login
  - method: POST
  
* 게시판 생성
  - 주소: http://localhost:8080/api/board
  - method: POST
    
* 게시판 리스트 조회
  - 주소: http://localhost:8080/api/board/all
  - method: GET

* 게시판 조회
  - 주소: http://localhost:8080/api/board/{id}
  - method: GET
 
 * 게시판 업데이트
  - 주소: http://localhost:8080/api/board
  - method: PUT
    
 * 게시판 삭제
  - 주소: http://localhost:8080/api/board
  - method: DELETE
