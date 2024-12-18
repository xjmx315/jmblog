package com.gdgstudy.jmblog.Post;

import com.gdgstudy.jmblog.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUsers(Users user);
    Optional<Post> findById(Long id);
}
