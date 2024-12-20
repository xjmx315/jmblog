package com.gdgstudy.jmblog.Post.Dto;

import com.gdgstudy.jmblog.Post.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostFullDto {
    String title;
    String content;
    int viewCount;
    int liked;
    Long id;
    LocalDateTime createdDate;

    @Builder
    public PostFullDto(String title, String content, int viewCount, int liked, Long id, LocalDateTime createdDate){
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.liked = liked;
        this.id = id;
        this.createdDate = createdDate;
    }

    public static PostFullDto of(Post post){
        return PostFullDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .viewCount(post.getViewCount())
                .liked(post.getLiked())
                .id(post.getId())
                .createdDate(post.getCreatedDate())
                .build();
    }
}
