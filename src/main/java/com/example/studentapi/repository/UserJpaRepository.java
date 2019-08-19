package com.example.studentapi.repository;

import com.example.studentapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<User, String> {

    Optional<User> findByLogin(String login);

}
