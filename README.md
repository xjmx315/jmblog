# Intro
안녕하세요. 재민 블로그 프로젝트 입니다. 
GDGoc 스터디 활동의 일환으로 스프링 개발 실습 목적으로 제작하였습니다.
읽어주셔서 감사합니다. 

#### email: hahapjm1234@gmail.com

# ERD
![image](https://github.com/user-attachments/assets/294e6f5a-243e-420e-aba5-7b21a389a2df)

# Request/Response Format
## Request
"./api" 로 시작하는 주소에서 api가 제공됩니다.

## Response
json 형태의 데이터가 제공됩니다. 기본적인 format을 따릅니다. 

```json
{
  "code": 200,
  "massage": "done.",
  "data": {}
}
```

# API
모든 api는
"./api"로 시작합니다. 
## 1. users
| URL          | Method | Request | Response |
|--------------|--------|---------|----------|
| /user/signUp | Post   |         | s        |
| /user/signIn | Post   |         |          |
| /user/me     | Get    |         |          |

### /user/signUp
*Request*
```json
{
  "name" : "jaemin",
  "email" : "jaemin@aa.com",
  "passwd" : "1234"
}
```
*Respons - 성공*
```json
{
    "code": 201,
    "msg": "user created"
}
```
*Respons - user name 중복*
```json
{
    "code": 202,
    "msg": "Duplicate Username"
}
```


### /user/signIn
*Request*
```json
{
    "username" : "jaemin",
    "passwd": "1234"
}
```
*Respons - 성공*
```json
{
    "code": 200,
    "msg": "login completed"
}
```
*Respons - 비밀번호 오류*
```json
{
    "code": 401,
    "msg": "This User Have Not Permission For"
}
```
*Respons - 없는 유저*
```json
{
    "code": 404,
    "msg": "User Not Found"
}
```

### /user/me
*Respons - 성공*
```json
{
    "code": 200,
    "msg": "jaemin2"
}
```

## 2. post
| URL             | Method | Request | Response |
|-----------------|--------|---------|----------|
| /post/new       | Post   |         | s        |
| /post/mine      | Get    |         |          |
| /post/{Id}      | Get    |         |          |
| /post/{Id}      | Delete |         |          |
| /post/like/{Id} | Get    |         |          |


### /post/new
*Request*
```json
{
    "title" : "TEST",
    "content" : "hello world!"
}
```

*Respons - 성공*
```json
{
    "code": 201,
    "msg": "Posted"
}
```

### /post/mine
*Respons - 성공*
```json
{
    "code": 200,
    "msg": "your posts",
    "data": [
        {
            "title": "TEST",
            "viewCount": 4,
            "liked": 0,
            "id": 1,
            "createdDate": "2025-03-06T15:45:27.408925"
        },
        {
            "title": "TEST2",
            "viewCount": 0,
            "liked": 0,
            "id": 2,
            "createdDate": "2025-03-06T15:46:59.348856"
        }
    ]
}

```

### /post/{id}
*(get)Respons - 성공*
```json
{
    "code": 200,
    "msg": "post returned",
    "data": {
        "title": "TEST",
        "content": "hello world!",
        "viewCount": 4,
        "liked": 0,
        "id": 1,
        "createdDate": "2025-03-06T15:45:27.408925"
    }
}
```
*(delete)Respons - 성공*
```json
{
    "code": 201,
    "msg": "Post Deleted"
}
```

### /like/{id}
*(get)Respons - 성공*
```json
{
    "code": 201,
    "msg": "like is turned to 1",
    "data": 1
}
```
