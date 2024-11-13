package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.User.Users;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;
    int viewCount;
    int liked;

    @ManyToOne
    private Users user;
}
