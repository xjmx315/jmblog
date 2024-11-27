package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Common.CommonResponse;
import com.gdgstudy.jmblog.Common.DataResponse;
import com.gdgstudy.jmblog.Post.Dto.PostCrateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/new")
    public ResponseEntity<CommonResponse> newPost(@RequestBody PostCrateDto postCrateDto){
        postService.newPost(postCrateDto);
        return ResponseEntity.ok()
                .body(new CommonResponse(201, "Posted"));
    }

    @GetMapping("/mine")
    public ResponseEntity<DataResponse<List<Post>>> myPosts(){
        List<Post> result = postService.myPosts();
        return ResponseEntity.ok()
                .body(new DataResponse<List<Post>>(200, "your posts", result));
    }
}
