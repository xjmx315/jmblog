package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Post.Dto.PostCrateDto;
import com.gdgstudy.jmblog.Post.Dto.PostFullDto;
import com.gdgstudy.jmblog.Post.Dto.PostSimpleDto;
import com.gdgstudy.jmblog.Post.Exceptions.PostNotFoundException;
import com.gdgstudy.jmblog.User.Exceptions.NoLoginUserException;
import com.gdgstudy.jmblog.User.UserService;
import com.gdgstudy.jmblog.User.Users;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<PostSimpleDto> myPosts() {
        Users user = userService.getLoginUser();
        List<Post> postRowList = postRepository.findByUsers(user);
        List<PostSimpleDto> postList = new ArrayList<PostSimpleDto>();
        for (Post p:postRowList){
            postList.add(PostSimpleDto.of(p));
        }
        return postList;
    }

    @Transactional
    public void deletePost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException());
        postRepository.delete(post);
    }

    @Transactional
    public PostFullDto getPost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException());
        PostFullDto postFullDto = PostFullDto.of(post);
        postRepository.save(post);
        return postFullDto;
    }//redis

    @Transactional
    public int likePost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException());
        int likeCount = post.addLike();
        postRepository.save(post);
        return likeCount;
    }
}
