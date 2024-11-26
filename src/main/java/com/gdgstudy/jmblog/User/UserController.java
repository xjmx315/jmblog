package com.gdgstudy.jmblog.User;

import com.gdgstudy.jmblog.Common.CommonResponse;
import com.gdgstudy.jmblog.User.Dto.UserCreateDto;
import com.gdgstudy.jmblog.User.Dto.UserSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<CommonResponse> crateUser(@RequestBody UserCreateDto userCreateDto){
        userService.crateUser(userCreateDto);
        return ResponseEntity.ok()
                .body(new CommonResponse(201, "user created"));
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

    //TODO: 무의마한 과정 줄이기
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
