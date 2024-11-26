package com.gdgstudy.jmblog.Comment;

import com.gdgstudy.jmblog.Comment.Dto.CommentCreateDto;
import com.gdgstudy.jmblog.Common.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(){
        commentService = new CommentService();
    }

    @PostMapping
    public ResponseEntity<CommonResponse> newComment(@RequestBody CommentCreateDto commentCreateDto){
        CommonResponse response = commentService.newComment(commentCreateDto);
        return ResponseEntity.ok()
                .body(response);
        }
    }
}
