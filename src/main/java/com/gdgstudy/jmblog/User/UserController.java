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
    public ResponseEntity<CommonResponse> signInUser(@RequestBody UserSignInDto userSignInDto){
        userService.signInUser(userSignInDto);
        return ResponseEntity.ok()
                .body(new CommonResponse(200, "login completed"));
    }

    //TODO: 무의마한 과정 줄이기
    @GetMapping("/me")
    public ResponseEntity<String> getLoginUser(){
        Users result = userService.getLoginUser();
        return ResponseEntity.ok()
                .body(result.toString());
    }

}
