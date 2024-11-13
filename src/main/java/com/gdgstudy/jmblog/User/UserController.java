package com.gdgstudy.jmblog.User;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String> crateUser(@RequestBody UserCreateDto userCreateDto){
        if (userService.crateUser(userCreateDto)) {
            return ResponseEntity.ok()
                    .body("유저 생성 완료. ");
        }
        else{
            return ResponseEntity.ok()
                    .body("유저 생성 실패... ");
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> signInUser(@RequestBody UserSignInDto userSignInDto){
        int result = userService.signInUser(userSignInDto);
        if (result == 0){
            return ResponseEntity.ok()
                    .body("로그인 완료. ");
        }
        else if(result == -1){
            return ResponseEntity.ok()
                    .body("로그인 실패: 존재하지 않는 아이디 입니다. ");
        }
        else if (result == -2){
            return ResponseEntity.ok()
                    .body("로그인 실패: 비밀번호가 다릅니다. ");
        }
        else{
            return ResponseEntity.ok()
                    .body("로그인 실패: 알 수 없는 오류입니다. ");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<String> getLoginUser(){
        Optional<Users> result = userService.getLoginUser();
        if (result.isEmpty()){
            return ResponseEntity.ok()
                    .body("로그인된 유저가 없습니다. ");
        }
        return ResponseEntity.ok()
                .body(result.get().toString());
    }

}
