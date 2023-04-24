package com.andriiv.in100gram.repository;

import com.andriiv.in100gram.entity.Post;
import com.andriiv.in100gram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Created by Roman Andriiv (24.04.2023 - 12:23)
*/
@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {
 Optional<Post> findAllByIdAndUser(Long postId, User user);

 List<Post> findAllByUserOrderByCreatedDateDesc(User user);
 List<Post> findAllByOrderByCreatedDateDesc();
}
