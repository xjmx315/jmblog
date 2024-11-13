package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Post.Dto.PostCrateDto;
import com.gdgstudy.jmblog.User.UserService;
import com.gdgstudy.jmblog.User.Users;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Transactional
    public int newPost(PostCrateDto postCrateDto) {
        Optional<Users> user = userService.getLoginUser();
        if (user.isEmpty()){
            return -1;
        }
        Post post = Post.of(postCrateDto, user.get());
        postRepository.save(post);
        return 0;
    }

    public String myPosts() {
        Optional<Users> user_ = userService.getLoginUser();
        if (user_.isEmpty()){
            return "로그인을 먼저 해주세요. ";
        }
        Users user = user_.get();
        return "아직 구현중인 기능입니다";
    }
}
