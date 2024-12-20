package com.gdgstudy.jmblog._devCommon;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//https://velog.io/@nayoon-kim/SpringBoot-%EC%83%9D%EC%84%B1%EC%8B%9C%EA%B0%84%EC%88%98%EC%A0%95%EC%8B%9C%EA%B0%84-%EC%B9%BC%EB%9F%BC-%EC%9E%90%EB%8F%99%ED%99%94

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

}
