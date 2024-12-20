package com.gdgstudy.jmblog.Post.Dto;

import com.gdgstudy.jmblog.Post.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostSimpleDto {
    String title;
    int viewCount;
    int liked;
    Long id;
    LocalDateTime createdDate;

    @Builder
    public PostSimpleDto(String title, int viewCount, int liked, Long id, LocalDateTime createdDate){
        this.title = title;
        this.viewCount = viewCount;
        this.liked = liked;
        this.id = id;
        this.createdDate = createdDate;
    }

    public static PostSimpleDto of(Post post){
        return PostSimpleDto.builder()
                .title(post.getTitle())
                .viewCount(post.getViewCount())
                .liked(post.getLiked())
                .id(post.getId())
                .createdDate(post.getCreatedDate())
                .build();
    }
}
