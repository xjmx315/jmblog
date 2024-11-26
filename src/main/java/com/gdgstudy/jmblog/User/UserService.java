package com.gdgstudy.jmblog.User;

import com.gdgstudy.jmblog.User.Dto.UserCreateDto;
import com.gdgstudy.jmblog.User.Dto.UserSignInDto;
import com.gdgstudy.jmblog.User.Exceptions.UserNameDuplicationException;
import com.gdgstudy.jmblog.User.Exceptions.UserNotFoundException;
import com.gdgstudy.jmblog.User.Exceptions.UserPermissionException;
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
    public void crateUser(UserCreateDto userCreateDto) {
        Optional<Users> user = userRepository.findByName(userCreateDto.getName());
        if (user.isEmpty()){
            userRepository.save(Users.of(userCreateDto));
        }
        else{
            throw new UserNameDuplicationException();
        }
    }

    public void signInUser(UserSignInDto userSignInDto) {
        Users user_ = userRepository.findByName(userSignInDto.getUsername())
                .orElseThrow(() -> new UserNotFoundException());
        if (user_.getPasswd().equals(userSignInDto.getPasswd())){
            httpSession.setAttribute("username", user_.getName());
        }
        else{
            throw new UserPermissionException();
        }
    }

    public Optional<Users> getLoginUser() {
        Object tmp = httpSession.getAttribute("username");
        return userRepository.findByName((String)httpSession.getAttribute("username"));
    }
}