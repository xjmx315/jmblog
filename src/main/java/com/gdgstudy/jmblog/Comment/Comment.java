package com.gdgstudy.jmblog.Comment;

import com.gdgstudy.jmblog.Post.Post;
import com.gdgstudy.jmblog.User.Users;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;
    int liked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
}
