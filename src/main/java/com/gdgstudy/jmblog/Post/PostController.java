package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Post.Dto.PostCrateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/new")
    public ResponseEntity<String> newPost(@RequestBody PostCrateDto postCrateDto){
        int result = postService.newPost(postCrateDto);
        if (result == 0) {
            return ResponseEntity.ok()
                    .body("post 완료");
        }
        return ResponseEntity.ok()
                .body("post 실패");
    }

    @GetMapping("/mine")
    public ResponseEntity<String> myPosts(){
        String result = postService.myPosts();
        return ResponseEntity.ok()
                .body(result);
    }
}
