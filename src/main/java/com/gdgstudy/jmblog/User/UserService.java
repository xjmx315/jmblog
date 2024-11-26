package com.gdgstudy.jmblog.User;

import com.gdgstudy.jmblog.User.Dto.UserCreateDto;
import com.gdgstudy.jmblog.User.Dto.UserSignInDto;
import com.gdgstudy.jmblog.User.Exceptions.NotFoundException;
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

    //유효성 체크 기능 만들어보기

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
        Users user_ = userRepository.findByName(userSignInDto.getUsername())
                .orElseThrow(() -> new NotFoundException(""));
        if (user_.isEmpty()){
            throw NotFoundException("");
        }
        Users user = user_.get();
        if (user.getPasswd().equals(userSignInDto.getPasswd())){
            httpSession.setAttribute("username", user.getName());
            return 0;
        }
        return -2;
    }

    public Optional<Users> getLoginUser() {
        Object tmp = httpSession.getAttribute("username");
        return userRepository.findByName((String)httpSession.getAttribute("username"));
    }
}