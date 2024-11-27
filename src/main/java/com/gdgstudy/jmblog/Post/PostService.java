package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Post.Dto.PostCrateDto;
import com.gdgstudy.jmblog.User.Exceptions.NoLoginUserException;
import com.gdgstudy.jmblog.User.UserService;
import com.gdgstudy.jmblog.User.Users;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    //TODO post.of를 할 때 직접적인 user 객체가 필요한가?
    @Transactional
    public void newPost(PostCrateDto postCrateDto) {
        Users user = userService.getLoginUser();
        Post post = Post.of(postCrateDto, user);
        postRepository.save(post);
    }

    public List<Post> myPosts() {
        Users user = userService.getLoginUser();
        List<Post> postList = postRepository.findByUsers(user);
        return postList;
    }
}
