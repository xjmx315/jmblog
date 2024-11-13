package com.gdgstudy.jmblog.User;

import com.gdgstudy.jmblog.Post.Post;
import com.gdgstudy.jmblog.User.Dto.UserCreateDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;
    String passwd;
    String email;

    @OneToMany(mappedBy = "users")
    List<Post> posts;

    @Builder
    public Users(String name, String passwd, String email){
        this.name = name;
        this.passwd = passwd;
        this.email = email;
    }

    public static Users of(UserCreateDto userCreateDto){
        return Users.builder()
                .name(userCreateDto.getName())
                .passwd(userCreateDto.getPasswd())
                .email(userCreateDto.getEmail())
                .build();
    }

    public String toString(){
        return this.name + this.Id;
    }
}