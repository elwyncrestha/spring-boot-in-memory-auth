package com.github.elwyncrestha.springbootinmemoryauth.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.elwyncrestha.springbootinmemoryauth.api.user.entity.User;

/**
 * @author Elvin Shrestha on 3/9/2020
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

}
