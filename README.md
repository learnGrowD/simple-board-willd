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
git clone git@github.com:learnGrowD/simple-board-willd.git
docker-compose up -d
```
http://localhost:8080 접속

## API
<details>
  <summary>회원가입</summary>
  <div markdown="1">
  POST http://localhost:8080/open-api/user/register

Request
```
{
	"name": String,
	"email": String,
	"password": String,
	"address": String,
	"user_type": Enum("ADMIN", "COMMON")
}
```
Response
```
{
	"result": {
		"result_code": Int,
		"result_message": String,
		"result_description": String
	},
	"body": {
		"id": Long?,
		"name": String?,
		"email": String?,
		"address": String?,
		"status": Enum?("REGISTERED", "UNREGISTERED"),
		"user_type": Enum?("ADMIN", "COMMON"),
		"registered_at": String?,
		"unregistered_at": String?,
		"last_login_at": String?
	}
}
```
  </div>
</details>


<details>
  <summary>로그인</summary>
  <div markdown="1">
  POST: http://localhost:8080/open-api/user/login

Request
```
{
	"email": String,
	"password": String
}
```
Response
```
{
	"result": {
		"result_code": Int,
		"result_message": String,
		"result_description": String
	},
	"body": {
		"access_token": String?,
		"access_token_expired_at": String?,
		"refresh_token": String?,
		"refresh_token_expired_at": Strin?
	}
}
```
  </div>
</details>

<details>
  <summary>게시판 생성</summary>
  <div markdown="1">
  POST http://localhost:8080/api/board

Request
```
{
	"board_name": String,
	"content": String?
}
```
Response
```
{
	"result": {
		"result_code": Int,
		"result_message": String,
		"result_description": String
	},
	"body": {
		"user_id": Long?,
		"board_id": Long?,
		"user_name": String?,
		"user_email": String?,
		"user_type": Enum?("ADMIN", "COMMON"),
		"user_status": Enum?("REGISTERED", "UNREGISTERED"),
		"board_name": String?,
		"board_content": String?,
		"board_status": Enum?("REGISTERED", "UNREGISTERED"),
		"posted_at": String?
	}
}
```
  </div>
</details>

<details>
  <summary>게시판 리스트 조회</summary>
  <div markdown="1">
  GET http://localhost:8080/api/board/all

Request
```
```
Response
```
{
	"result": {
		"result_code": Int,
		"result_message": String,
		"result_description": String
	},
	"body": [
		{
      		"user_id": Long?,
      		"board_id": Long?,
      		"user_name": String?,
      		"user_email": String?,
      		"user_type": Enum?("ADMIN", "COMMON"),
      		"user_status": Enum?("REGISTERED", "UNREGISTERED"),
      		"board_name": String?,
      		"board_content": String?,
      		"board_status": Enum?("REGISTERED", "UNREGISTERED"),
      		"posted_at": String?
		}
	]
}
```
  </div>
</details>

<details>
  <summary>게시판 조회</summary>
  <div markdown="1">
  GET http://localhost:8080/api/board/{id}

Request
```
```
Response
```
{
	"result": {
		"result_code": 200,
		"result_message": "성공",
		"result_description": "성공"
	},
	"body": {
		"user_id": Long?,
		"board_id": Long?,
		"user_name": String?,
		"user_email": String?,
		"user_type": Enum?("ADMIN", "COMMON"),
		"user_status": Enum?("REGISTERED", "UNREGISTERED"),
		"board_name": String?,
		"board_content": String?,
		"board_status": Enum?("REGISTERED", "UNREGISTERED"),
		"posted_at": String?
	}
}
```
  </div>
</details>


<details>
  <summary>게시판 업데이트</summary>
  <div markdown="1">
  PUT: http://localhost:8080/api/board

Request
```
{
	"board_id": Long,
	"board_name": String,
	"content": String?
}
```
Response
```
{
	"result": {
		"result_code": Int,
		"result_message": String,
		"result_description": String
	},
	"body": {
		"user_id": Long?,
		"board_id": Long?,
		"user_name": String?,
		"user_email": String?,
		"user_type": Enum?("ADMIN", "COMMON"),
		"user_status": Enum?("REGISTERED", "UNREGISTERED"),
		"board_name": String?,
		"board_content": String?,
		"board_status": Enum?("REGISTERED", "UNREGISTERED"),
		"posted_at": String?
	}
}
```
  </div>
</details>


<details>
  <summary>게시판 삭제</summary>
  <div markdown="1">
  DELETE: http://localhost:8080/api/board/{id}

Request
```
```
Response
```
{
	"result": {
		"result_code": Int,
		"result_message": String,
		"result_description": String
	},
	"body": {
		"user_id": Long?,
		"board_id": Long?,
		"user_name": String?,
		"user_email": String?,
		"user_type": Enum?("ADMIN", "COMMON"),
		"user_status": Enum?("REGISTERED", "UNREGISTERED"),
		"board_name": String?,
		"board_content": String?,
		"board_status": Enum?("REGISTERED", "UNREGISTERED"),
		"posted_at": String?
	}
}
```
  </div>
</details>

## ERROR Code
<details>
  <summary>Common Error Code</summary>
  <div markdown="1">
    [httpStatusCode, errorCode, errorDescription]
	  
```
    1. BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"),
    2. VALIDATION_EXCEPTION(400, 510, "Validation Exception"),
    3. NULL_POINT(400, 512, "Null point"),
    4. SERVER_ERROR(500, 500, "서버에러");  
```
  </div>
</details>

<details>
  <summary>Token Error</summary>
  <div markdown="1">
    [httpStatusCode, errorCode, errorDescription]    
    1. INVALID_TOKEN(400, 2000, "유효하지 않은 코드"),
    2. EXPIRED_TOKEN(400, 2001, "만료된 토큰"),
    3. TOKEN_EXCEPTION(400, 2002, "토큰 알수없는 에러"),
    4. AUTHORIZATION_TOKEN_NOT_FOUND(400, 2003, "인증 헤더 토큰 없음");
  </div>
</details>

<details>
  <summary>User Error Code</summary>
  <div markdown="1">
    [httpStatusCode, errorCode, errorDescription]   
    1. USER_NOT_FOUND(400, 1404, "아이디 또는 비밀번호가 일치하지 않습니다."),
    2. USER_UNAGEGISTERD(400, 1405, "해지된 사용자 입니다.");
  </div>
</details>

<details>
  <summary>Board Error Code</summary>
  <div markdown="1">
    [httpStatusCode, errorCode, errorDescription]     
    1. NO_DELETE_PERMISSION(400, 1504, "삭제 권한이 없습니다."),
    2. No_UPDATE_PERMISSION(400, 1505, "수정 권한이 없습니다.");
  </div>
</details>
