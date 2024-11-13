package com.gdgstudy.jmblog.Post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public int newpost(PostCrateDto postCrateDto) {
        return 0;
    }
}
