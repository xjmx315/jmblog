package com.gdgstudy.jmblog.Post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/echo")
    public ResponseEntity<String> postEcho(){
        return ResponseEntity.ok()
                .body("Hello");
    }
    @PostMapping("/")
    public ResponseEntity<String> newPost(@RequestBody PostCrateDto postCrateDto){
        int result = postService.newpost(postCrateDto);
        return ResponseEntity.ok()
                .body("post 완료");
    }

}
