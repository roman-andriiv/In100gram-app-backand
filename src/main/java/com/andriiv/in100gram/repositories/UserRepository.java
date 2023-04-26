package com.andriiv.in100gram.repositories;

import com.andriiv.in100gram.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
*Created by Roman Andriiv (24.04.2023 - 12:11)
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long userId);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);
}
