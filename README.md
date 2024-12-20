# Intro
안녕하세요. 재민 블로그 프로젝트 입니다. 
GDGoc 스터디 활동의 일환으로 스프링 개발 실습 목적으로 만든 재민이의 첫 프로젝트!
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



(Post)
/user
(Request)

>
{
  "name" : "jaemin",
  "email" : "jaemin@aa.com",
  "passwd" : "1234"
}

(Respons)
>
"회원가입 성공"

>"회원가입 실패

/user/signIn
(Request)
>
>{
>  "name" : "jaemin",
>  "passwd" : "1234"
>}

(Reponse)
>"로그인 성공"
>"로그인 실패: 아이디가 존재하지 않습니다. "
>"로그인 실패: 비밀번호가 올바르지 않습니다. "


## 2. post
| URL             | Method | Request | Response |
|-----------------|--------|---------|----------|
| /post/new       | Post   |         | s        |
| /post/mine      | Get    |         |          |
| /post/{Id}      | Get    |         |          |
| /post/{Id}      | Delete |         |          |
| /post/like/{Id} | Get    |         |          |