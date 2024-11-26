package com.gdgstudy.jmblog.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByName(String name); //메소드 이름을 기준으로 조회. JPA에서
}