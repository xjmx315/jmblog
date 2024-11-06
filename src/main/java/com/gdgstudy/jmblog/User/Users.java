package com.gdgstudy.jmblog.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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


}
