package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Post.Dto.PostFullDto;
import com.gdgstudy.jmblog._devCommon.CommonResponse;
import com.gdgstudy.jmblog._devCommon.DataResponse;
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
        List<Post> posts = postService.myPosts();
        return ResponseEntity.ok()
                .body(new DataResponse<List<Post>>(200, "your posts", posts));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<DataResponse<PostFullDto>> getPost(@PathVariable("Id") long id){
        PostFullDto postFullDto = postService.getPost(id);
        return ResponseEntity.ok()
                .body(new DataResponse<PostFullDto>(200, "post returned", postFullDto));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<CommonResponse> deletePost(@PathVariable("Id") long id){
        postService.deletePost(id);
        return ResponseEntity.ok()
                .body(new CommonResponse(200, "Post Deleted"));
    }

}
