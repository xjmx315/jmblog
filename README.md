![image](https://github.com/user-attachments/assets/294e6f5a-243e-420e-aba5-7b21a389a2df)

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
