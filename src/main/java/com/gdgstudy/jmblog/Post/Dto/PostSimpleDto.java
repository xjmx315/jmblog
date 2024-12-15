package com.gdgstudy.jmblog.Post.Dto;

import com.gdgstudy.jmblog.Post.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostSimpleDto {
    String title;
    int viewCount;
    int liked;
    Long id;

    @Builder
    public PostSimpleDto(String title, int viewCount, int liked, Long id){
        this.title = title;
        this.viewCount = viewCount;
        this.liked = liked;
        this.id = id;
    }

    public static PostSimpleDto of(Post post){
        return PostSimpleDto.builder()
                .title(post.getTitle())
                .viewCount(post.getViewCount())
                .liked(post.getLiked())
                .id(post.getId())
                .build();
    }
}
