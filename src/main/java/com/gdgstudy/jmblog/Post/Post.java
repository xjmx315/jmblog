package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.Post.Dto.PostCrateDto;
import com.gdgstudy.jmblog.User.Users;
import com.gdgstudy.jmblog._devCommon.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Post extends BaseTimeEntity {
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
        this.viewCount = viewCount; //조회수 순 정렬을 위해서는 따로 나눠야 할 수 있음.
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

    public int addLike(){ //나중에 userId를 받으면 유저당 1번의 라이크만 하기도 가능할듯
        this.liked += 1;
        return this.liked;
    }

    public void addViewCount(){
        this.viewCount += 1;
    }
}
