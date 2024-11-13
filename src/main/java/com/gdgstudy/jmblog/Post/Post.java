package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Post.Dto.PostCrateDto;
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
    //@Column(name = "post")
    Long id;
    String title;
    String content;
    int viewCount;
    int liked;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    @Builder
    public Post(String title, String content, int viewCount, int liked, Users users){
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.liked = liked;
        this.users = users;
    }

    public static Post of(PostCrateDto postCrateDto, Users users){
        return Post.builder()
                .title(postCrateDto.getTitle())
                .content(postCrateDto.getContent())
                .viewCount(0)
                .liked(0)
                .users(users)
                .build();

    }
}
