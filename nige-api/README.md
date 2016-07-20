### Stack overview ###

* Java 8 + Spring 4.1.1
* MySQL 5.7


### developer ###

* Genie Youn 

### API Docs ###

**Users** 
***회원가입***     
```
#!curl

curl -X POST /users
```

*Parameters*

| Element    | Optional   | Type  |   Description       |
| -----------|:-----------| ------|:--------------------|
|  userId    |    FALSE   | String| 사용자 아이디       |
| nightingale|    FALSE   | enum  | Nurse, Doctor, Norm |
|  name      |    TRUE    | String| 사용자 이름         |
|  password  |    FALSE   | String| 사용자 비밀번호     |
|  com       |    TRUE   | String| 사용자 소속          |

*Response*
```
#!json
*성공*
{
  "code": 100,
  "message": "성공적으로 수행했습니다.",
  "statusCode": 200
}
*실패*
{
  "code": 200,
  "message": "데이터베이스 커밋 실패",
  "statusCode": 500
}
```
***로그인***
```
#!curl

curl -X POST /users/login
```

*Parameters*

| Element    | Optional   | Type  |   Description       |
| -----------|:-----------| ------|:--------------------|
|  userId    |    FALSE   | String| 사용자 아이디       |
|  password  |    FALSE   | String| 사용자 비밀번호     |

*Response*
```
#!json
*성공*
{
  "code": 100,
  "message": "성공적으로 수행했습니다.",
  "statusCode": 200
}
*실패*
{
  "code": 300,
  "message": "패스워드 불일치",
  "statusCode": 500
}
*실패*
{
  "code": 301,
  "message": "가입되지 않은 사용자",
  "statusCode": 500
}
```
