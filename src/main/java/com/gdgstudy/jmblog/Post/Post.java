package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.User.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;
    int viewCount;
    int liked;

    @ManyToOne
    private Users owner;

    @Builder
    public Post(String title, String content, int viewCount, int liked, Users owner){
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.liked = liked;
        this.owner = owner;
    }

    public static Post of(PostCrateDto postCrateDto, Users owner){
        return Post.builder()
                .title(postCrateDto.getTitle())
                .content(postCrateDto.getContent())
                .viewCount(0)
                .liked(0)
                .owner(owner)
                .build();

    }
}
