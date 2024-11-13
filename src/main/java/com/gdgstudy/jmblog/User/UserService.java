package com.gdgstudy.jmblog.User;

import com.gdgstudy.jmblog.User.Dto.UserCreateDto;
import com.gdgstudy.jmblog.User.Dto.UserSignInDto;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Transactional
    public boolean crateUser(UserCreateDto userCreateDto) {
        Optional<Users> user = userRepository.findByName(userCreateDto.getName());
        if (user.isEmpty()){
            userRepository.save(Users.of(userCreateDto));
            return true;
        }
        else{
            return false;
        }
    }

    public int signInUser(UserSignInDto userSignInDto) {
        Optional<Users> user_ = userRepository.findByName(userSignInDto.getUsername());
        if (user_.isEmpty()){
            return -1;
        }
        Users user = user_.get();
        if (user.getPasswd().equals(userSignInDto.getPasswd())){
            httpSession.setAttribute("username", user.getName());
            return 0;
        }
        return -2;
    }

    public Optional<Users> getLoginUser() {
        return userRepository.findByName((String)httpSession.getAttribute("username"));
    }
}
